package cz.quanti.mailq;


public class Pagination {

    private Long limit;
    private Long offset;

    public Pagination(Long limit, Long offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }
}
