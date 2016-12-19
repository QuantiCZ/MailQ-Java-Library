package cz.quanti.mailq.entities.v2;


public class EmailAddressEntity extends BaseEntity{

    private String email;

    public EmailAddressEntity(String email) {
        this.email = email;
    }
}
