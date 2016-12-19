package cz.quanti.mailq.entities.v2;


import java.util.List;

public class EmailAddressesEntity extends BaseEntity{

    private final List<EmailAddressEntity> addresses;

    public EmailAddressesEntity(List<EmailAddressEntity> addresses) {
        this.addresses = addresses;
    }

    public List<EmailAddressEntity> getAddresses() {
        return addresses;
    }
}
