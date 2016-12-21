## Newsletter resources

### Get newsletters

```java
for (NewsletterEntity newsletter: mailQ.getNewsletters()) {
    System.out.println(newsletter.getName());
}
```

### Create newsletter

Sender e-mail has to be created. See resource [Sender email](#).

```java
List<AttachmentEntity> attachments = new ArrayList<>();
AttachmentEntity attachmentEntity = new AttachmentEntity();
attachmentEntity.setDisplayName("attachment.jpg")
        .setLink("http://example.org/1.jpg")
        .setMimeType("image/jpeg")
        .setSource("LzlqLzRBQ==");
attachments.add(attachmentEntity);
NewsletterEntity newsletter = new NewsletterEntity();
newsletter.setCampaign("Winter sales")
        .setName("Example newsletter")
        .setSubject("20% sale")
        .setCode("XY-123")
        .setRecipientsListId(1L)
        .setSendAs("Company inc.")
        .setSenderEmail("newsletter@example.org")
        .setTemplateUrl("http://example.org/newsletter.html")
        .setUnsubscribeTemplateUrl("http://example.org/unsubscribe.html")
        .setAutomaticTime(false)
        .setFrom(LocalDateTime.now().plusHours(5))
        .setTo(LocalDateTime.now().plusYears(1))
        .setTags("winter","sale")
        .setAttachments(attachments);
newsletter = mailQ.createNewsletter(newsletter);
System.out.println(newsletter.getId());
```

### Get newsletters tag

```java
for (TagEntity tag : mailQ.getNewslettersTags()) {
    System.out.println(tag.getName());
}
```

### Get newsletter

```java
NewsletterEntity newsletter = mailQ.getNewsletter(1L);
System.out.println(newsletter.getName());
```

### Get newsletter by code

```java
NewsletterEntity newsletter = mailQ.getNewsletterByCode("test");
System.out.println(newsletter.getName());
```

### Update newsletter

```java
NewsletterEntity newsletter = mailQ.getNewsletter(1L);
newsletter.setName("Summer sale");
mailQ.updateNewsletter(newsletter);
```

### Delete newsletter

```java
mailQ.deleteNewsletter(1L);
```

### Start newsletter

```java
mailQ.startNewsletter(1L);
```

### Stop newsletter

```java
mailQ.stopNewsletter(1L);
```

### Send test e-mail

```java
mailQ.sendTestEmail(1L,"john.doe@example.org")
```
