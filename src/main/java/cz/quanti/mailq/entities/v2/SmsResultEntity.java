package cz.quanti.mailq.entities.v2;


public class SmsResultEntity {

    private String id;
    private String result;
    private String message;
    private Integer code;

    public String getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

}
