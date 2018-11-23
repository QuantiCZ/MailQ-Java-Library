package cz.quanti.mailq.resources.v2;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.UserEntity;
import cz.quanti.mailq.entities.v2.UsersEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

@Singleton
public class ValidatorResource extends BaseResource {

    @Inject
    private ValidatorResource(Connector connector) {
        super(connector);
    }

    public void validate(String email) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/validator/email/"+email)
                .companyRelated(false)
                .build();
        this.getConnector().send(request);
    }

    public void validate(String email, int timeout) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/validator/email/"+email)
                .companyRelated(false)
                .timeout(timeout)
                .build();
        this.getConnector().send(request);
    }


}
