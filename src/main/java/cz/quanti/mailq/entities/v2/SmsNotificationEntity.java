package cz.quanti.mailq.entities.v2;


import cz.quanti.mailq.entities.v2.enums.NotificationStatus;

public class SmsNotificationEntity extends BaseEntity {

    private Long id;
    private String name;
    private String code;
    private String template;
    private NotificationStatus status;
    private LinkEntity company;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public LinkEntity getCompany() {
        return company;
    }

    public String getTemplate() {
        return template;
    }

    public SmsNotificationEntity setName(String name) {
        this.name = name;
        return this;
    }

    public SmsNotificationEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public SmsNotificationEntity setTemplate(String template) {
        this.template = template;
        return this;
    }
}
