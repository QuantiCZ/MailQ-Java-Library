package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class NewslettersEntity extends BaseEntity implements Iterable<NewsletterEntity>  {

    private List<NewsletterEntity> newsletters = new ArrayList<>();

    public NewslettersEntity(List<NewsletterEntity> newsletters) {
        this.newsletters = newsletters;
    }

    @Override
    public Iterator<NewsletterEntity> iterator() {
        return newsletters.iterator();
    }

    @Override
    public void forEach(Consumer<? super NewsletterEntity> action) {
        newsletters.forEach(action);
    }

    @Override
    public Spliterator<NewsletterEntity> spliterator() {
        return newsletters.spliterator();
    }
}
