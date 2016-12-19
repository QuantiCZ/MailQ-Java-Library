package cz.quanti.mailq.entities.v2;


import cz.quanti.mailq.entities.v2.enums.LogMessageType;

import java.time.LocalDateTime;

public class LogMessageEntity extends  BaseEntity {

    private Long id;
    private String title;
    private String text;
    private LogMessageType type;
    private LocalDateTime created;
    private LinkEntity company;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LogMessageType getType() {
        return type;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LinkEntity getCompany() {
        return company;
    }
}
