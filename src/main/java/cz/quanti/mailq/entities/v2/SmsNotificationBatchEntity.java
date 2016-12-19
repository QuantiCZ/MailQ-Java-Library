package cz.quanti.mailq.entities.v2;


import java.util.List;

public class SmsNotificationBatchEntity extends BaseEntity{

    private List<SmsNotificationDataEntity> batch;

    public void setBatch(List<SmsNotificationDataEntity> batch) {
        this.batch = batch;
    }
}
