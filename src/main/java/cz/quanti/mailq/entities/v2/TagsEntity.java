package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TagsEntity extends BaseEntity implements Iterable<TagEntity>  {

    private List<TagEntity> tags= new ArrayList<>();

    public TagsEntity(List<TagEntity> tags) {
        this.tags = tags;
    }

    public TagsEntity(String... tags) {
        this.tags = new ArrayList<>();
        for (String tag: tags) {
            this.tags.add(new TagEntity(tag));
        }
    }

    @Override
    public Iterator<TagEntity> iterator() {
        return tags.iterator();
    }

    @Override
    public void forEach(Consumer<? super TagEntity> action) {
        tags.forEach(action);
    }

    @Override
    public Spliterator<TagEntity> spliterator() {
        return tags.spliterator();
    }
}
