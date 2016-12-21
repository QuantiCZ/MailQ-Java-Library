package cz.quanti.mailq.entities.v2;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SmsNotificationDataEntity extends  BaseEntity {

    private String id;
    private String toNumber;
    private Map<String,Object> data = new HashMap<>();

    private String state;
    private LocalDateTime sendTimestamp;
    private String message;


    public String getId() {
        return id;
    }

    public String getToNumber() {
        return toNumber;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getState() {
        return state;
    }

    public LocalDateTime getSendTimestamp() {
        return sendTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public SmsNotificationDataEntity setId(String id) {
        this.id = id;
        return this;
    }

    public SmsNotificationDataEntity setToNumber(String toNumber) {
        this.toNumber = toNumber;
        return this;
    }

    public SmsNotificationDataEntity setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public SmsNotificationDataEntity addData(String key, Object value) {
        this.data.put(key,value);
        return this;
    }
}
