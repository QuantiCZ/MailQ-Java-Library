package cz.quanti.mailq.entities.v2;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RecipientsListEntity extends BaseEntity {

    private Long id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Integer recipients;
    private Integer unsubscribers;
    private Boolean formVisible;
    private Set<String> variables;
    private LinkEntity company;

    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public Integer getRecipients() {
        return recipients;
    }

    public Integer getUnsubscribers() {
        return unsubscribers;
    }

    public Boolean getFormVisible() {
        return formVisible;
    }

    public Set<String> getVariables() {
        return variables;
    }

    public LinkEntity getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public RecipientsListEntity setName(String name) {
        this.name = name;
        return this;
    }

    public RecipientsListEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public RecipientsListEntity setVariables(Set<String> variables) {
        this.variables = variables;
        return this;
    }

    public RecipientsListEntity setVariables(String... variables) {
        this.variables = new HashSet<>(Arrays.asList(variables));
        return this;
    }

    public RecipientsListEntity setFormVisible(Boolean formVisible) {
        this.formVisible = formVisible;
        return this;
    }
}
