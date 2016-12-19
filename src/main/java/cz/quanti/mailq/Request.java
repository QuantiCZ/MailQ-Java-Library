package cz.quanti.mailq;


import cz.quanti.mailq.di.annotations.BaseUrl;
import cz.quanti.mailq.entities.v2.BaseEntity;
import cz.quanti.mailq.entities.v2.EmailAddressEntity;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private final String path;
    private final String method;
    private final BaseEntity entity;
    private final Map<String,String> headers;
    private final Map<String,String> parameters;
    private final boolean companyRelated;

    private Request(String url, String method, BaseEntity entity, Map<String, String> headers, Map<String, String> parameters, boolean companyRelated) {
        this.path = url;
        this.method = method;
        this.headers = headers;
        this.parameters = parameters;
        this.entity = entity;
        this.companyRelated = companyRelated;
    }

    public static RequestBuilder builder(String method, String url) {
        return new RequestBuilder(method,url);
    }

    public static RequestBuilder builder(String method) {
        return builder(method,"");
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public boolean hasEntity() {
        return entity != null;
    }

    public BaseEntity getEntity() {
        return entity;
    }

    public boolean isCompanyRelated() {
        return companyRelated;
    }

    public static class RequestBuilder {

        private String path;
        private String method;
        private BaseEntity entity;
        private Map<String,String> headers = new HashMap<>();
        private Map<String,String> parameters = new HashMap<>();
        private Boolean companyRelated = true;



        public RequestBuilder(String method, String url) {
            this.method = method;
            this.path = url;
        }

        public RequestBuilder method(String method) {
            this.method = method;
            return this;
        }

        public RequestBuilder path(String url) {
            this.path = url;
            return this;
        }

        public RequestBuilder headers(Map<String,String> headers) {
            this.headers = headers;
            return this;
        }

        public RequestBuilder header(String name, String value) {
            if (this.headers == null) {
                this.headers = new HashMap<>();
            }
            this.headers.put(name,value);
            return this;
        }

        public RequestBuilder entity(BaseEntity entity) {
            this.entity = entity;
            return this;
        }

        public RequestBuilder companyRelated(boolean companyRelated) {
            this.companyRelated = companyRelated;
            return this;
        }


        public RequestBuilder parameters(Map<String,String> parameters) {
            this.parameters = parameters;
            return this;
        }

        public RequestBuilder parameter(String name, String value) {
            if (this.parameters == null) {
                this.parameters = new HashMap<>();
            }
            this.parameters.put(name,value);
            return this;
        }

        public Request build() {
            return new Request(path,method,entity,headers,parameters,companyRelated);
        }

    }
}
