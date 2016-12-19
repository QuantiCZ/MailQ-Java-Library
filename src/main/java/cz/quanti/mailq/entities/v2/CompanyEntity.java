package cz.quanti.mailq.entities.v2;


import java.util.List;

public class CompanyEntity extends  BaseEntity {

    private Long id;
    private String name;
    private String apiKey;
    private String defaultSendAs;
    private String defaultSenderEmail;
    private List<LinkEntity> users;
    private List<LinkEntity> senderEmails;
    private List<LinkEntity> recipientLists;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getDefaultSendAs() {
        return defaultSendAs;
    }

    public String getDefaultSenderEmail() {
        return defaultSenderEmail;
    }

    public List<LinkEntity> getUsers() {
        return users;
    }

    public List<LinkEntity> getSenderEmails() {
        return senderEmails;
    }

    public List<LinkEntity> getRecipientLists() {
        return recipientLists;
    }
}
