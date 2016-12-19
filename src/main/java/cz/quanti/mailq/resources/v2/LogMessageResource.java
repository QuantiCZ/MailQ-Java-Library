package cz.quanti.mailq.resources.v2;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Pagination;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.CompanyEntity;
import cz.quanti.mailq.entities.v2.LogMessageEntity;
import cz.quanti.mailq.entities.v2.LogMessagesEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpGet;

@Singleton
public class LogMessageResource extends BaseResource {

    @Inject
    private LogMessageResource(Connector connector) {
        super(connector);
    }

    public LogMessagesEntity getLogMessages(Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/log-messages")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,LogMessagesEntity.class);
    }

    public LogMessageEntity getLogMessage(Long id) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/log-messages/"+id).build();
        return this.getConnector().send(request,LogMessageEntity.class);
    }

}
