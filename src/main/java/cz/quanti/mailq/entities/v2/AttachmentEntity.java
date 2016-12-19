package cz.quanti.mailq.entities.v2;


public class AttachmentEntity extends BaseEntity  {


    private String displayName;
    private String link;
    private String mimeType;

    public String getDisplayName() {
        return displayName;
    }

    public String getLink() {
        return link;
    }

    public String getMimeType() {
        return mimeType;
    }
}
