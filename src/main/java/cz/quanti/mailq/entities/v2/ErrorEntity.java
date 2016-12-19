package cz.quanti.mailq.entities.v2;


public class ErrorEntity {

    private ErrorBodyEntity error;

    public String getMessage() {
        if (error != null) {
            return error.getMessage();
        }
        return null;
    }

    public Integer getCode() {
        if (error != null) {
            return error.getCode();
        }
        return null;
    }
}
