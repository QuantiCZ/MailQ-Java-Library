package cz.quanti.mailq.entities.v2;


public class SenderEmailEntity extends BaseEntity {

    private Long id;
    private String email;
    private LinkEntity company;

    public Long getId() {
        return id;
    }

    public LinkEntity getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }
}