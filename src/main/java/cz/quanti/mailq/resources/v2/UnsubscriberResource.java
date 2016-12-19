package cz.quanti.mailq.resources.v2;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Pagination;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.EmailAddressEntity;
import cz.quanti.mailq.entities.v2.EmailAddressesEntity;
import cz.quanti.mailq.entities.v2.UnsubscribersEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Singleton
public class UnsubscriberResource extends BaseResource {

    @Inject
    private UnsubscriberResource(Connector connector) {
        super(connector);
    }

    public UnsubscribersEntity getUnsubscribers(LocalDateTime from,Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/unsubscribers/")
                .parameter("from",from.format(DateTimeFormatter.ISO_DATE_TIME))
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request, UnsubscribersEntity.class);
    }

    public UnsubscribersEntity getUnsubscriber(String email) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/unsubscribers/"+email).build();
        return this.getConnector().send(request, UnsubscribersEntity.class);
    }

    public void unsubscribe(Set<String> emails) throws ApiException, InvalidRequestException {
        List<EmailAddressEntity> listOfAddresses = new ArrayList<>();
        emails.forEach((String email) -> listOfAddresses.add(new EmailAddressEntity(email)));
        EmailAddressesEntity addresses = new EmailAddressesEntity(listOfAddresses);
        Request request = Request.builder(HttpPost.METHOD_NAME,"/unsubscribers/").entity(addresses).build();
        this.getConnector().send(request);
    }

    public UnsubscribersEntity unsubscribe(String email) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/unsubscribers/"+email).build();
        return this.getConnector().send(request, UnsubscribersEntity.class);
    }

    public void deleteUnsubscribe(String email) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/unsubscribers/"+email).build();
        this.getConnector().send(request);
    }

}
