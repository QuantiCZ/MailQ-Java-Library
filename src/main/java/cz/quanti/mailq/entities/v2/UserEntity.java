package cz.quanti.mailq.entities.v2;


import java.util.List;

public class UserEntity extends BaseEntity{

    private Long id;
    private String username;
    private String forename;
    private String surname;
    private String phone;
    private String email;
    private String position;
    private String testEmail;
    private List<LinkEntity> companies;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getTestEmail() {
        return testEmail;
    }

    public List<LinkEntity> getCompanies() {
        return companies;
    }
}
