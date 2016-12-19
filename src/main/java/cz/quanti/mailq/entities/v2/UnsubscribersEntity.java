package cz.quanti.mailq.entities.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class UnsubscribersEntity extends BaseEntity implements Iterable<UnsubscriberEntity> {

    private List<UnsubscriberEntity> unsubscribers= new ArrayList<>();

    public UnsubscribersEntity(List<UnsubscriberEntity> unsubscribers) {
        this.unsubscribers = unsubscribers;
    }

    @Override
    public Iterator<UnsubscriberEntity> iterator() {
        return unsubscribers.iterator();
    }

    @Override
    public void forEach(Consumer<? super UnsubscriberEntity> action) {
        unsubscribers.forEach(action);
    }

    @Override
    public Spliterator<UnsubscriberEntity> spliterator() {
        return unsubscribers.spliterator();
    }


}
