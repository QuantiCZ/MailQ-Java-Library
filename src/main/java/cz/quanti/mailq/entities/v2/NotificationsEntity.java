package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class NotificationsEntity extends BaseEntity implements Iterable<NotificationEntity>  {

    private List<NotificationEntity> notifications = new ArrayList<>();

    public NotificationsEntity(List<NotificationEntity> notifications) {
        this.notifications = notifications;
    }

    @Override
    public Iterator<NotificationEntity> iterator() {
        return notifications.iterator();
    }

    @Override
    public void forEach(Consumer<? super NotificationEntity> action) {
        notifications.forEach(action);
    }

    @Override
    public Spliterator<NotificationEntity> spliterator() {
        return notifications.spliterator();
    }
}
