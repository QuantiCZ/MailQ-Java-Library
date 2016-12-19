package cz.quanti.mailq.entities.v2;


import java.util.*;
import java.util.function.Consumer;

public class RecipientsListEntriesEntity extends BaseEntity implements Iterable<RecipientsListEntryEntity>  {

    private List<RecipientsListEntryEntity> recipientsListEntries = new ArrayList<>();

    public RecipientsListEntriesEntity(List<RecipientsListEntryEntity> recipientsListEntries) {
        this.recipientsListEntries = recipientsListEntries;
    }

    public List<RecipientsListEntryEntity> getRecipientsListEntries() {
        return recipientsListEntries;
    }

    @Override
    public Iterator<RecipientsListEntryEntity> iterator() {
        return recipientsListEntries.iterator();
    }

    @Override
    public void forEach(Consumer<? super RecipientsListEntryEntity> action) {
        recipientsListEntries.forEach(action);
    }

    @Override
    public Spliterator<RecipientsListEntryEntity> spliterator() {
        return recipientsListEntries.spliterator();
    }
}