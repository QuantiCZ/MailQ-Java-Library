package cz.quanti.mailq.entities.v2;

import cz.quanti.mailq.entities.v2.enums.NewsletterStatus;
import java.util.ArrayList;
import java.util.List;

public class PreparedNewsletterEntity extends BaseEntity{
    
    private Long id;
    private String name;
    private String code;
    private String subject;
    private String sendAs;
    private String senderEmail;
    private NewsletterStatus status;
    private String campaign;
    private List<TagEntity> tags;
    private LinkEntity company;
    private String templateUrl;
    private String unsubscribeTemplateUrl;
    private String text;

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

    public List<TagEntity> getTags() {
        return tags;
    }

    public String getTemplateUrl() {
        return templateUrl;
    }

    public String getUnsubscribeTemplateUrl() {
        return unsubscribeTemplateUrl;
    }

    public String getText() {
        return text;
    }

    public String getCampaign() {
        return campaign;
    }

    public LinkEntity getCompany() {
        return company;
    }

    public PreparedNewsletterEntity setName(String name) {
        this.name = name;
        return this;
    }

    public PreparedNewsletterEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public PreparedNewsletterEntity setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public PreparedNewsletterEntity setSendAs(String sendAs) {
        this.sendAs = sendAs;
        return this;
    }

    public PreparedNewsletterEntity setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
        return this;
    }

    public PreparedNewsletterEntity setCampaign(String campaign) {
        this.campaign = campaign;
        return this;
    }

    public PreparedNewsletterEntity setTags(List<String> tags) {
        this.tags = new ArrayList<>();
        for (String tag: tags) {
            this.tags.add(new TagEntity(tag));
        }
        return this;
    }

    public PreparedNewsletterEntity setTags(String... tags) {
        this.tags = new ArrayList<>();
        for (String tag: tags) {
            this.tags.add(new TagEntity(tag));
        }
        return this;
    }

    public PreparedNewsletterEntity setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
        return this;
    }

    public PreparedNewsletterEntity setUnsubscribeTemplateUrl(String unsubscribeTemplateUrl) {
        this.unsubscribeTemplateUrl = unsubscribeTemplateUrl;
        return this;
    }

    public PreparedNewsletterEntity setText(String text) {
        this.text = text;
        return this;
    }
    
    

}
