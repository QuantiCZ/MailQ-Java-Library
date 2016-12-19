package cz.quanti.mailq.entities.v2;


import java.util.List;

public class SmsBatchResultEntity extends BaseEntity {


    private List<SmsResultEntity> results;

    public List<SmsResultEntity> getResults() {
        return results;
    }
}
