package cz.quanti.mailq;


public class Response {

    private final String content;
    private final Integer httpCode;

    public Response(String content, Integer httpCode) {
        this.content = content;
        this.httpCode = httpCode;
    }

    public boolean isOk() {
        return 200 <= httpCode && httpCode < 300;
    }

    public boolean hasContent() {
        return content != null;
    }

    public boolean isError() {
        return 400 <= httpCode && httpCode < 600;
    }


    public String getContent() {
        return content;
    }

    public Integer getHttpCode() {
        return httpCode;
    }
}
