package cz.quanti.mailq.entities.v2;


public class PhoneNumberEntity extends BaseEntity{

    private String toNumber;

    public PhoneNumberEntity(String toNumber) {
        this.toNumber = toNumber;
    }


}
