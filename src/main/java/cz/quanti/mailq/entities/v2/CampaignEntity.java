package cz.quanti.mailq.entities.v2;


import java.time.LocalDateTime;
import java.util.List;

public class CampaignEntity extends BaseEntity {

    private Long id;
    private String name;
    private LocalDateTime created;
    private LinkEntity company;
    private List<LinkEntity> newsletters;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LinkEntity getCompany() {
        return company;
    }

    public List<LinkEntity> getNewsletters() {
        return newsletters;
    }
}
