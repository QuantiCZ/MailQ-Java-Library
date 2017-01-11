package cz.quanti.mailq.entities.v2;


public class ApiKeyEntity extends  BaseEntity {

    private Long id;
    private String apiKey;

    public Long getId() {
        return id;
    }

    public String getApiKey() {
        return apiKey;
    }
}
