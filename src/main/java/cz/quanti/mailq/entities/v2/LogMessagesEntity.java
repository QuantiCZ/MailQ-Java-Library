package cz.quanti.mailq.entities.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LogMessagesEntity extends BaseEntity implements Iterable<LogMessageEntity> {

    private List<LogMessageEntity> logMessages= new ArrayList<>();

    public LogMessagesEntity(List<LogMessageEntity> logMessages) {
        this.logMessages = logMessages;
    }

    @Override
    public Iterator<LogMessageEntity> iterator() {
        return logMessages.iterator();
    }

    @Override
    public void forEach(Consumer<? super LogMessageEntity> action) {
        logMessages.forEach(action);
    }

    @Override
    public Spliterator<LogMessageEntity> spliterator() {
        return logMessages.spliterator();
    }


}
