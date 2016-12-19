package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SenderEmailsEntity extends BaseEntity implements Iterable<SenderEmailEntity>  {

    private List<SenderEmailEntity> senderEmails = new ArrayList<>();

    public SenderEmailsEntity(List<SenderEmailEntity> senderEmails) {
        this.senderEmails = senderEmails;
    }

    @Override
    public Iterator<SenderEmailEntity> iterator() {
        return senderEmails.iterator();
    }

    @Override
    public void forEach(Consumer<? super SenderEmailEntity> action) {
        senderEmails.forEach(action);
    }

    @Override
    public Spliterator<SenderEmailEntity> spliterator() {
        return senderEmails.spliterator();
    }
}