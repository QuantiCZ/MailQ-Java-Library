package cz.quanti.mailq.resources.v2;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.LogMessageEntity;
import cz.quanti.mailq.entities.v2.LogMessagesEntity;
import cz.quanti.mailq.entities.v2.SenderEmailEntity;
import cz.quanti.mailq.entities.v2.SenderEmailsEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpGet;

@Singleton
public class SenderEmailResource extends BaseResource {

    @Inject
    private SenderEmailResource(Connector connector) {
        super(connector);
    }

    public SenderEmailsEntity getSenderEmails() throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/sender-emails").build();
        return this.getConnector().send(request,SenderEmailsEntity.class);
    }

    public SenderEmailEntity getSenderEmail(Long id) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/sender-emails/"+id).build();
        return this.getConnector().send(request,SenderEmailEntity.class);
    }

}
