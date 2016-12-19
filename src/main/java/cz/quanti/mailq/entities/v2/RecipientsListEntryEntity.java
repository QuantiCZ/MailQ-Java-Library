package cz.quanti.mailq.entities.v2;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RecipientsListEntryEntity extends BaseEntity {


    private String email;
    private Map<String,Object> data;

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public RecipientsListEntryEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public RecipientsListEntryEntity setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }


}
