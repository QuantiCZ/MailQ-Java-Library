package cz.quanti.mailq.resources.v2;


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

@Singleton
public class SmsNewsletterResource extends BaseResource {

    @Inject
    private SmsNewsletterResource(Connector connector) {
        super(connector);
    }

    public SmsNewslettersEntity getNewsletters(Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/sms-newsletters")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,SmsNewslettersEntity.class);
    }

    public SmsNewsletterEntity createNewsletter(SmsNewsletterEntity newsletter) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/sms-newsletters").entity(newsletter).build();
        return this.getConnector().send(request,SmsNewsletterEntity.class);
    }

    public SmsNewsletterEntity getNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/sms-newsletters/"+newsletterId).build();
        return this.getConnector().send(request,SmsNewsletterEntity.class);
    }

    public void updateNewsletter(SmsNewsletterEntity newsletter) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPut.METHOD_NAME,"/sms-newsletters/"+newsletter.getId()).entity(newsletter).build();
        this.getConnector().send(request);
    }

    public void deleteNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/sms-newsletters/"+newsletterId).build();
        this.getConnector().send(request);
    }

    public void startNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        PreparationCommandEntity preparationCommand = new PreparationCommandEntity(true);
        Request request = Request.builder(HttpPut.METHOD_NAME,"/sms-newsletters/"+newsletterId+"/preparation").entity(preparationCommand).build();
        this.getConnector().send(request);
    }

    public void stopNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        PreparationCommandEntity preparationCommand = new PreparationCommandEntity(false);
        Request request = Request.builder(HttpPut.METHOD_NAME,"/sms-newsletters/"+newsletterId+"/preparation").entity(preparationCommand).build();
        this.getConnector().send(request);
    }

    public void sendTestSms(Long newsletterId, String number) throws ApiException, InvalidRequestException {
        PhoneNumberEntity phoneNumber = new PhoneNumberEntity(number);
        Request request = Request.builder(HttpPost.METHOD_NAME,"/sms-newsletters/"+newsletterId+"/test-sms").entity(phoneNumber).build();
        this.getConnector().send(request);
    }

}
