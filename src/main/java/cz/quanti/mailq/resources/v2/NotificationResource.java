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
public class NotificationResource extends BaseResource {

    @Inject
    private NotificationResource(Connector connector) {
        super(connector);
    }

    public NotificationsEntity getNotifications(Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/notifications")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,NotificationsEntity.class);
    }

    public NotificationEntity createNotification(NotificationEntity notification) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/notifications").entity(notification).build();
        return this.getConnector().send(request,NotificationEntity.class);
    }

    public NotificationEntity getNotification(Long notificationId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/notifications/"+notificationId).build();
        return this.getConnector().send(request,NotificationEntity.class);
    }

    public void updateNotification(NotificationEntity notification) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPut.METHOD_NAME,"/notifications/"+notification.getId()).entity(notification).build();
        this.getConnector().send(request);
    }

    public void deleteNotification(Long notificationId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpDelete.METHOD_NAME,"/notifications/"+notificationId).build();
        this.getConnector().send(request);
    }

    public NotificationDataEntity sendNotification(Long notificationId, NotificationDataEntity notification) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpPost.METHOD_NAME,"/notifications/"+notificationId+"/data").entity(notification).build();
        return this.getConnector().send(request,NotificationDataEntity.class);
    }

    public NotificationsDataEntity getNotificationsData(Long notificationId, String email, Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/notifications/"+notificationId+"/history/"+email)
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request,NotificationsDataEntity.class);
    }

    public NotificationDataEntity getNotificationData(Long notificationId, String notificationDataId) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/notifications/"+notificationId+"/data/"+notificationDataId).build();
        return this.getConnector().send(request,NotificationDataEntity.class);
    }

}
