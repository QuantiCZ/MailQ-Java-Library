package cz.quanti.mailq.entities.v2;


import cz.quanti.mailq.entities.v2.enums.UnsubscribeAction;

import java.time.LocalDateTime;

public class UnsubscriberEntity extends BaseEntity {

    private String id;
    private String email;
    private LocalDateTime unsubscribed;
    private UnsubscribeAction action;
    private LinkEntity recipientList;
    private LinkEntity company;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getUnsubscribed() {
        return unsubscribed;
    }

    public UnsubscribeAction getAction() {
        return action;
    }

    public LinkEntity getRecipientList() {
        return recipientList;
    }

    public LinkEntity getCompany() {
        return company;
    }
}
