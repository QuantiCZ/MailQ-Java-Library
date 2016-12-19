package cz.quanti.mailq.entities.v2;


public class TagEntity {

    private Long id;
    private String name;

    public TagEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
