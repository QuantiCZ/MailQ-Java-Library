package cz.quanti.mailq.entities.v2;


public class AttachmentEntity extends BaseEntity  {


    private String displayName;
    private String link;
    private String mimeType;
    private String source;

    public String getDisplayName() {
        return displayName;
    }

    public String getLink() {
        return link;
    }

    public String getMimeType() {
        return mimeType;
    }

    public AttachmentEntity setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public AttachmentEntity setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public AttachmentEntity setLink(String link) {
        this.link = link;
        return this;
    }

    public AttachmentEntity setSource(String source) {
        this.source = source;
        return this;
    }
}
