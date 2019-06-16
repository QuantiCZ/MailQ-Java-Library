package cz.quanti.mailq.entities.v2;


import cz.quanti.mailq.entities.v2.enums.NewsletterStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsletterEntity extends BaseEntity  {

    private Long id;
    private String name;
    private String code;
    private String subject;
    private String sendAs;
    private String senderEmail;
    private NewsletterStatus status;
    private LocalDateTime from;
    private LocalDateTime to;
    private Boolean automaticTime;
    private Long recipientsListId;
    private String campaign;
    private List<TagEntity> tags;
    private LinkEntity company;

    private String templateUrl;
    private String unsubscribeTemplateUrl;
    private String csvUrl;
    private String ampTemplate;
    private String ampTemplateUrl;

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

    public String getSenderEmail() {
        return senderEmail;
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

    public Boolean getAutomaticTime() {
        return automaticTime;
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

    public String getAmpTemplate() {
        return ampTemplate;
    }

    public String getAmpTemplateUrl() {
        return ampTemplateUrl;
    }

    public NewsletterEntity setName(String name) {
        this.name = name;
        return this;
    }

    public NewsletterEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public NewsletterEntity setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public NewsletterEntity setSendAs(String sendAs) {
        this.sendAs = sendAs;
        return this;
    }

    public NewsletterEntity setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
        return this;
    }

    public NewsletterEntity setFrom(LocalDateTime from) {
        this.from = from;
        return this;
    }

    public NewsletterEntity setTo(LocalDateTime to) {
        this.to = to;
        return this;
    }

    public NewsletterEntity setAutomaticTime(Boolean automaticTime) {
        this.automaticTime = automaticTime;
        return this;
    }

    public NewsletterEntity setRecipientsListId(Long recipientsListId) {
        this.recipientsListId = recipientsListId;
        return this;
    }

    public NewsletterEntity setCampaign(String campaign) {
        this.campaign = campaign;
        return this;
    }

    public NewsletterEntity setTags(List<String> tags) {
        this.tags = new ArrayList<>();
        for (String tag: tags) {
            this.tags.add(new TagEntity(tag));
        }
        return this;
    }

    public NewsletterEntity setTags(String... tags) {
        this.tags = new ArrayList<>();
        for (String tag: tags) {
            this.tags.add(new TagEntity(tag));
        }
        return this;
    }

    public NewsletterEntity setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
        return this;
    }

    public NewsletterEntity setUnsubscribeTemplateUrl(String unsubscribeTemplateUrl) {
        this.unsubscribeTemplateUrl = unsubscribeTemplateUrl;
        return this;
    }

    public NewsletterEntity setCsvUrl(String csvUrl) {
        this.csvUrl = csvUrl;
        return this;
    }

    public NewsletterEntity setAmpTemplate(String ampTemplate) {
        this.ampTemplate = ampTemplate;
        return this;
    }

    public NewsletterEntity setAmpTemplateUrl(String ampTemplateUrl) {
        this.ampTemplateUrl = ampTemplateUrl;
        return this;
    }
}
