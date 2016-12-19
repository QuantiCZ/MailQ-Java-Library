package cz.quanti.mailq.entities.v2;


import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

public class RecipientsListsEntity  extends BaseEntity implements Iterable<RecipientsListEntity>  {

    private List<RecipientsListEntity> recipientsLists = new ArrayList<>();

    public RecipientsListsEntity(List<RecipientsListEntity> recipientsLists) {
        this.recipientsLists = recipientsLists;
    }

    @Override
    public Iterator<RecipientsListEntity> iterator() {
        return recipientsLists.iterator();
    }

    @Override
    public void forEach(Consumer<? super RecipientsListEntity> action) {
        recipientsLists.forEach(action);
    }

    @Override
    public Spliterator<RecipientsListEntity> spliterator() {
        return recipientsLists.spliterator();
    }
}