package cz.quanti.mailq;


import com.google.gson.Gson;
import com.google.inject.Inject;
import cz.quanti.mailq.di.annotations.ApiKey;
import cz.quanti.mailq.di.annotations.BaseUrl;
import cz.quanti.mailq.di.annotations.CompanyId;
import cz.quanti.mailq.entities.v2.BaseEntity;
import cz.quanti.mailq.entities.v2.EmptyResponse;
import cz.quanti.mailq.entities.v2.ErrorEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;


public class Connector {

    private String baseUrl;
    private String apiKey;
    private Integer companyId;
    private Gson gson;



    @Inject
    private Connector(@BaseUrl String baseUrl, @CompanyId Integer companyId, @ApiKey String apiKey, Gson gson) {
        this.baseUrl = baseUrl;
        this.companyId = companyId;
        this.apiKey = apiKey;
        this.gson = gson;
    }

    private ResponseHandler<Response> responseHandler = response -> {
        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        return new Response(entity != null ? EntityUtils.toString(entity) : null,status);
    };

    public EmptyResponse send(Request request) throws ApiException, InvalidRequestException {
        return this.send(request,EmptyResponse.class);
    }

    public<T extends BaseEntity> T send(Request request, Class<T> responseType) throws ApiException, InvalidRequestException {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            URI uri = createUrl(request);
            HttpUriRequest httpRequest = createHttpUriRequest(request,uri.toString());
            Response response = httpclient.execute(httpRequest, responseHandler);
            if (response.isOk()) {
                if (response.hasContent()) {
                    return gson.fromJson(response.getContent(),responseType);
                }
                else {
                    return responseType.newInstance();
                }
            }
            else {
                ErrorEntity error = gson.fromJson(response.getContent(),ErrorEntity.class);
                if (error != null) {
                    throw new ApiException(response.getHttpCode(),error.getCode(),error.getMessage());
                }
                else {
                    throw new ApiException(response.getHttpCode(),response.getContent());
                }

            }
        }
        catch (InvalidRequestException | ApiException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw new ApiException(-1,ex.getMessage());
        }
    }

    private URI createUrl(Request request) throws InvalidRequestException {
        try {
            URIBuilder builder = new URIBuilder();
            String url = request.isCompanyRelated() ? baseUrl+"/companies/"+companyId : baseUrl;
            URI tempURI = new URL(url).toURI();
            builder.setScheme(tempURI.getScheme()).setHost(tempURI.getHost()).setPort(tempURI.getPort()).setPath(tempURI.getPath()+request.getPath());
            Map<String,String> parameters = request.getParameters();
            for (String queryKey: parameters.keySet()) {
                builder.setParameter(queryKey,parameters.get(queryKey));
            }
            return builder.build();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new InvalidRequestException();
        }
    }

    private HttpUriRequest createHttpUriRequest(Request request, String url) {
        HttpUriRequest httpRequest = null;
        switch (request.getMethod()) {
            case HttpGet.METHOD_NAME: {
                httpRequest = new HttpGet(url);
                break;
            }
            case HttpPost.METHOD_NAME: {
                HttpPost post = new HttpPost(url);
                if (request.hasEntity()) {
                    String json = gson.toJson(request.getEntity());
                    Charset utf8Charset = Charset.forName("UTF-8");
                    post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
                    post.setHeader("Content-Type", ContentType.create("application/json",utf8Charset).toString());
                }
                httpRequest = post;
                break;
            }
            case HttpPut.METHOD_NAME: {
                HttpPut put = new HttpPut(url);
                if (request.hasEntity()) {
                    String json = gson.toJson(request.getEntity());
                    put.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
                    put.setHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType());
                }
                httpRequest = put;
                break;
            }
            case HttpDelete.METHOD_NAME: {
                httpRequest = new HttpDelete(url);

                break;
            }
        }
        for (String headerName: request.getHeaders().keySet()) {
            httpRequest.addHeader(headerName,request.getHeaders().get(headerName));
        }
        httpRequest.setHeader("X-Api-Key",apiKey);
        return httpRequest;
    }



}