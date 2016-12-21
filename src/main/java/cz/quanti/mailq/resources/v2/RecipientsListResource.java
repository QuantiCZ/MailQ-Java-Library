package cz.quanti.mailq.resources.v2;


import com.google.common.primitives.Booleans;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Pagination;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.*;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Singleton
public class RecipientsListResource extends BaseResource {

    @Inject
    private RecipientsListResource(Connector connector) {
        super(connector);
    }

    public RecipientsListsEntity getRecipientsLists(Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/recipients-lists")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,RecipientsListsEntity.class);
    }

    public RecipientsListsEntity getRecipientsListsByEmail(String email, Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/recipients-lists")
                .parameter("email",email)
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,RecipientsListsEntity.class);
    }

    public RecipientsListEntity createRecipientsList(RecipientsListEntity recipientsList) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/recipients-lists").entity(recipientsList)
                .build();
        return this.getConnector().send(request,RecipientsListEntity.class);
    }

    public RecipientsListEntity getRecipientsList(Long recipientsListId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/recipients-lists/"+recipientsListId)
                .build();
        return this.getConnector().send(request,RecipientsListEntity.class);
    }

    public void deleteRecipientsList(Long recipientsListId, Boolean complete) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/recipients-lists/"+recipientsListId)
                .parameter("complete",complete.toString())
                .build();
        this.getConnector().send(request);
    }

    public void addRecipientsToList(Long recipientsListId, RecipientsListEntriesEntity recipientsListEntries, Boolean validate) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/recipients")
                .parameter("dont-validate", Boolean.toString(!validate))
                .entity(recipientsListEntries)
                .build();
        this.getConnector().send(request);
    }

    public RecipientsListEntriesEntity getRecipientsFromList(Long recipientsListId, Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/recipients")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,RecipientsListEntriesEntity.class);
    }

    public void updateRecipientFromList(Long recipientsListId,RecipientsListEntryEntity recipientsListEntry, Boolean validate) throws ApiException, InvalidRequestException {
        String email = recipientsListEntry.getEmail();
        recipientsListEntry.setEmail(null);
        Request request = Request.builder(HttpPut.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/recipients/"+email)
                .parameter("dont-validate",Boolean.toString(!validate))
                .entity(recipientsListEntry)
                .build();
        this.getConnector().send(request);
    }

    public void deleteRecipientFromList(Long recipientsListId, String email) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/recipients/"+email)
                .build();
        this.getConnector().send(request);
    }

    public UnsubscribersEntity getUnsubscribers(Long recipientsListId, Pagination pagination)  throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/unsubscribers")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,UnsubscribersEntity.class);
    }

    public UnsubscriberEntity getUnsunscriber(Long recipientsListId, String email)  throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/unsubscribers/"+email)
                .build();
        return this.getConnector().send(request,UnsubscriberEntity.class);
    }

    public void unsubscribe(Long recipientsListId,Set<String> emails) throws ApiException, InvalidRequestException {
        List<EmailAddressEntity> listOfAddresses = new ArrayList<>();
        emails.forEach((String email) -> listOfAddresses.add(new EmailAddressEntity(email)));
        EmailAddressesEntity addresses = new EmailAddressesEntity(listOfAddresses);
        Request request = Request.builder(HttpPost.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/unsubscribers/").entity(addresses).build();
        this.getConnector().send(request);
    }

    public void unsubscribe(Long recipientsListId,String email) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPut.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/unsubscribers/"+email).build();
        this.getConnector().send(request);
    }

    public void deleteUnsubscriber(Long recipientsListId,String email) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/recipients-lists/"+recipientsListId+"/unsubscribers/"+email).build();
        this.getConnector().send(request);
    }



}
