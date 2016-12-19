package cz.quanti.mailq.exceptions;

/**
 * This exception is thrown where API returns HTTP code 4xx or 5xx.
 */
public class ApiException extends Exception{

    private Integer httpCode;


    public ApiException(Integer httpCode, Integer code, String message) {
        super(httpCode+" - "+code+" - "+message);
        this.httpCode = httpCode;
    }

    public ApiException(Integer httpCode, String message) {
        super(httpCode+" - "+message);
        this.httpCode = httpCode;
    }

    public ApiException(Integer httpCode) {
        super();
        this.httpCode = httpCode;
    }

    public Integer getHttpCode() {
        return httpCode;
    }
}
