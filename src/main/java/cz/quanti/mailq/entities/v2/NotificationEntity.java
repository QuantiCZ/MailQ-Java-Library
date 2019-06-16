package cz.quanti.mailq.entities.v2;


import cz.quanti.mailq.entities.v2.enums.NotificationStatus;

import java.util.Base64;

public class NotificationEntity extends BaseEntity {

    private Long id;
    private String name;
    private String code;
    private String subject;
    private String sendAs;
    private String appliedSenderEmail;
    private String text;
    private String template;
    private NotificationStatus status;
    private LinkEntity company;
    private String ampTemplate;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSubject() {
        return subject;
    }

    public String getSendAs() {
        return sendAs;
    }

    public String getAppliedSenderEmail() {
        return appliedSenderEmail;
    }

    public String getText() {
        return text;
    }

    public String getTemplate() {
        return template;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public LinkEntity getCompany() {
        return company;
    }

    public NotificationEntity setName(String name) {
        this.name = name;
        return this;
    }

    public NotificationEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public NotificationEntity setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public NotificationEntity setSendAs(String sendAs) {
        this.sendAs = sendAs;
        return this;
    }

    public NotificationEntity setAppliedSenderEmail(String appliedSenderEmail) {
        this.appliedSenderEmail = appliedSenderEmail;
        return this;
    }

    public NotificationEntity setText(String text) {
        this.text = text;
        return this;
    }

    public NotificationEntity setTemplate(String template) {
        this.template = template;
        return this;
    }

    public String getAmpTemplate() {
        return ampTemplate;
    }

    public NotificationEntity setAmpTemplate(String ampTemplate) {
        this.ampTemplate = ampTemplate;
        return this;
    }
}
