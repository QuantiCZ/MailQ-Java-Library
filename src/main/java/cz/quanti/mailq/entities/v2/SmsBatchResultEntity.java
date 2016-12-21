package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SmsBatchResultEntity extends BaseEntity implements Iterable<SmsResultEntity>  {

    private List<SmsResultEntity> results = new ArrayList<>();

    public SmsBatchResultEntity(List<SmsResultEntity> results) {
        this.results = results;
    }

    @Override
    public Iterator<SmsResultEntity> iterator() {
        return results.iterator();
    }

    @Override
    public void forEach(Consumer<? super SmsResultEntity> action) {
        results.forEach(action);
    }

    @Override
    public Spliterator<SmsResultEntity> spliterator() {
        return results.spliterator();
    }
}

