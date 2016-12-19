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
public class NewsletterResource extends BaseResource {

    @Inject
    private NewsletterResource(Connector connector) {
        super(connector);
    }

    public NewslettersEntity getNewsletters(Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/newsletters")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,NewslettersEntity.class);
    }

    public NewsletterEntity createNewsletter(NewsletterEntity newsletter) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/newsletters").entity(newsletter).build();
        return this.getConnector().send(request,NewsletterEntity.class);
    }

    public TagsEntity getTags() throws InvalidRequestException, ApiException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/newsletters/tags").build();
        return this.getConnector().send(request,TagsEntity.class);
    }

    public NewsletterEntity getNewsletterByCode(String code) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/newsletters").parameter("code",code).build();
        return this.getConnector().send(request,NewsletterEntity.class);
    }

    public NewsletterEntity getNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/newsletters/"+newsletterId).build();
        return this.getConnector().send(request,NewsletterEntity.class);
    }

    public void updateNewsletter(NewsletterEntity newsletter) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPut.METHOD_NAME,"/newsletters/"+newsletter.getId()).entity(newsletter).build();
        this.getConnector().send(request);
    }

    public void deleteNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/newsletters/"+newsletterId).build();
        this.getConnector().send(request);
    }

    public void startNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        PreparationCommandEntity preparationCommand = new PreparationCommandEntity(true);
        Request request = Request.builder(HttpPut.METHOD_NAME,"/newsletters/"+newsletterId+"/preparation").entity(preparationCommand).build();
        this.getConnector().send(request);
    }

    public void stopNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        PreparationCommandEntity preparationCommand = new PreparationCommandEntity(false);
        Request request = Request.builder(HttpPut.METHOD_NAME,"/newsletters/"+newsletterId+"/preparation").entity(preparationCommand).build();
        this.getConnector().send(request);
    }

    public void sendTestEmail(Long newsletterId, String email) throws ApiException, InvalidRequestException {
        EmailAddressEntity emailAddress = new EmailAddressEntity(email);
        Request request = Request.builder(HttpPost.METHOD_NAME,"/newsletters/"+newsletterId+"/test-email").entity(emailAddress).build();
        this.getConnector().send(request);
    }

}
