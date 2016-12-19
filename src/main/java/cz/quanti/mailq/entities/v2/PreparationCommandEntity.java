package cz.quanti.mailq.entities.v2;


public class PreparationCommandEntity extends BaseEntity {

    private Boolean start;
    private Boolean stop;

    public PreparationCommandEntity(Boolean start) {
        if (start) {
            this.start = true;
        }
        else {
            this.stop = true;
        }
        this.start = start;
    }


}
