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
public class SmsNotificationResource extends BaseResource {

    @Inject
    private SmsNotificationResource(Connector connector) {
        super(connector);
    }

    public SmsNotificationsEntity getNotifications(Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/sms-notifications")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,SmsNotificationsEntity.class);
    }

    public SmsNotificationEntity createNotification(SmsNotificationEntity notification) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/sms-notifications").entity(notification).build();
        return this.getConnector().send(request,SmsNotificationEntity.class);
    }

    public SmsNotificationEntity getNotification(Long notificationId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/sms-notifications/"+notificationId).build();
        return this.getConnector().send(request,SmsNotificationEntity.class);
    }

    public void updateNotification(SmsNotificationEntity notification) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPut.METHOD_NAME,"/sms-notifications/"+notification.getId()).entity(notification).build();
        this.getConnector().send(request);
    }

    public void deleteNotification(Long notificationId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/sms-notifications/"+notificationId).build();
        this.getConnector().send(request);
    }

    public SmsNotificationDataEntity sendSmsNotification(Long notificationId, SmsNotificationDataEntity notification) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/sms-notifications/"+notificationId+"/data").entity(notification).build();
        return this.getConnector().send(request,SmsNotificationDataEntity.class);
    }

    public SmsBatchResultEntity sendSmsBatchNotification(Long notificationId, SmsNotificationBatchEntity notificationBatch) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/sms-notifications/"+notificationId+"/data").entity(notificationBatch).build();
        return this.getConnector().send(request,SmsBatchResultEntity.class);
    }

    public SmsNotificationDataEntity getNotificationData(Long notificationId, String notificationDataId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/sms-notifications/"+notificationId+"/data/"+notificationDataId).build();
        return this.getConnector().send(request,SmsNotificationDataEntity.class);
    }

}
