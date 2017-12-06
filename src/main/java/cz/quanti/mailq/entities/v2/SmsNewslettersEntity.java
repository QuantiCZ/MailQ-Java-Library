package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SmsNewslettersEntity extends BaseEntity implements Iterable<SmsNewsletterEntity>  {

    private List<SmsNewsletterEntity> newsletters = new ArrayList<>();

    public SmsNewslettersEntity(List<SmsNewsletterEntity> newsletters) {
        this.newsletters = newsletters;
    }

    @Override
    public Iterator<SmsNewsletterEntity> iterator() {
        return newsletters.iterator();
    }

    @Override
    public void forEach(Consumer<? super SmsNewsletterEntity> action) {
        newsletters.forEach(action);
    }

    @Override
    public Spliterator<SmsNewsletterEntity> spliterator() {
        return newsletters.spliterator();
    }
}
