package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SmsNotificationsEntity extends BaseEntity implements Iterable<SmsNotificationEntity>  {

    private List<SmsNotificationEntity> notifications = new ArrayList<>();

    public SmsNotificationsEntity(List<SmsNotificationEntity> newsletters) {
        this.notifications = newsletters;
    }

    @Override
    public Iterator<SmsNotificationEntity> iterator() {
        return notifications.iterator();
    }

    @Override
    public void forEach(Consumer<? super SmsNotificationEntity> action) {
        notifications.forEach(action);
    }

    @Override
    public Spliterator<SmsNotificationEntity> spliterator() {
        return notifications.spliterator();
    }
}
