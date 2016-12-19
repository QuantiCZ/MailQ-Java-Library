package cz.quanti.mailq.entities.v2;


import cz.quanti.mailq.entities.v2.enums.NewsletterStatus;

import java.time.LocalDateTime;


public class SmsNewsletterEntity extends BaseEntity  {

    private Long id;
    private String name;
    private String code;
    private NewsletterStatus status;
    private String text;
    private LocalDateTime from;
    private LocalDateTime to;
    private Long recipientsListId;
    private String campaign;
    private LinkEntity company;

    private String csvUrl;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public NewsletterStatus getStatus() {
        return status;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public Long getRecipientsListId() {
        return recipientsListId;
    }

    public String getCampaign() {
        return campaign;
    }

    public LinkEntity getCompany() {
        return company;
    }

    public String getCsvUrl() {
        return csvUrl;
    }

    public String getText() {
        return text;
    }

    public SmsNewsletterEntity setName(String name) {
        this.name = name;
        return this;
    }

    public SmsNewsletterEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public SmsNewsletterEntity setFrom(LocalDateTime from) {
        this.from = from;
        return this;
    }

    public SmsNewsletterEntity setTo(LocalDateTime to) {
        this.to = to;
        return this;
    }

    public SmsNewsletterEntity setRecipientsListId(Long recipientsListId) {
        this.recipientsListId = recipientsListId;
        return this;
    }

    public SmsNewsletterEntity setCampaign(String campaign) {
        this.campaign = campaign;
        return this;
    }

    public SmsNewsletterEntity setCsvUrl(String csvUrl) {
        this.csvUrl = csvUrl;
        return this;
    }

    public SmsNewsletterEntity setText(String text) {
        this.text = text;
        return this;
    }
}
