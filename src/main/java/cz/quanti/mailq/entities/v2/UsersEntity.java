package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class UsersEntity extends BaseEntity implements Iterable<UserEntity> {

    private List<UserEntity> users = new ArrayList<>();

    public UsersEntity(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public Iterator<UserEntity> iterator() {
        return users.iterator();
    }

    @Override
    public void forEach(Consumer<? super UserEntity> action) {
        users.forEach(action);
    }

    @Override
    public Spliterator<UserEntity> spliterator() {
        return users.spliterator();
    }


}

