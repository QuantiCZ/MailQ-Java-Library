package cz.quanti.mailq.resources.v2;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.LogMessageEntity;
import cz.quanti.mailq.entities.v2.LogMessagesEntity;
import cz.quanti.mailq.entities.v2.UserEntity;
import cz.quanti.mailq.entities.v2.UsersEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpGet;

@Singleton
public class UserResource extends BaseResource {

    @Inject
    private UserResource(Connector connector) {
        super(connector);
    }

    public UsersEntity getUsers() throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/users").build();
        return this.getConnector().send(request,UsersEntity.class);
    }

    public UserEntity getUser(Long id) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/users/"+id).build();
        return this.getConnector().send(request,UserEntity.class);
    }

}
