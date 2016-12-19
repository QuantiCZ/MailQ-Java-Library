package cz.quanti.mailq.entities.v2;


import java.util.*;
import java.util.function.Consumer;

public class NotificationsDataEntity extends BaseEntity implements Iterable<NotificationDataEntity> {

    private List<NotificationDataEntity> notifications = new ArrayList<>();

    public NotificationsDataEntity(List<NotificationDataEntity> notifications) {
        this.notifications = notifications;
    }

    @Override
    public Iterator<NotificationDataEntity> iterator() {
        return notifications.iterator();
    }

    @Override
    public void forEach(Consumer<? super NotificationDataEntity> action) {
        notifications.forEach(action);
    }

    @Override
    public Spliterator<NotificationDataEntity> spliterator() {
        return notifications.spliterator();
    }

}