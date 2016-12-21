package cz.quanti.mailq.entities.v2;


import cz.quanti.mailq.entities.v2.enums.SmsResult;

public class SmsResultEntity {

    private String id;
    private SmsResult result;
    private String message;
    private Integer code;

    public String getId() {
        return id;
    }

    public SmsResult getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public boolean isOk() {
        return SmsResult.SUCCESS.equals(this.result);
    }

}
