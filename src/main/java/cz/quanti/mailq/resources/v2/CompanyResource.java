package cz.quanti.mailq.resources.v2;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.ApiKeyEntity;
import cz.quanti.mailq.entities.v2.CompanyEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;

@Singleton
public class CompanyResource extends BaseResource {

    @Inject
    private CompanyResource(Connector connector) {
        super(connector);
    }

    public CompanyEntity getCompany() throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME).build();
        return this.getConnector().send(request,CompanyEntity.class);
    }

    public String regenerateApiKey() throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPut.METHOD_NAME).build();
        ApiKeyEntity apiKeyEntity = this.getConnector().send(request,ApiKeyEntity.class);
        return apiKeyEntity.getApiKey();
    }


}
