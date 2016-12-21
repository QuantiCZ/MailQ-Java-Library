package cz.quanti.mailq.entities.v2;


import java.time.LocalDateTime;
import java.util.*;

public class RecipientsListEntryEntity extends BaseEntity {


    private String email;
    private Map<String,Object> data = new HashMap<>();

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

    public RecipientsListEntryEntity addData(String key, Object value) {
        this.data.put(key,value);
        return this;
    }


}
