package cz.quanti.mailq.resources.v2;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.CompanyEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpGet;

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


}
