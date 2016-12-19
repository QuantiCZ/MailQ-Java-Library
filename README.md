# MailQ-Java-Library

This is library for connection to mailing system [MailQ](http://mailq.cz/). It is meaningful only if you are our client. Otherwise you will not be able to connect. If are our client and you do not have access to system you can contact our support department.

There is also [PHP implementation](https://github.com/QuantiCZ/MailQ-PHP-Library).

## Dependencies

- [**Guice**](https://github.com/google/guice) - DI system
- [**GSON**](https://github.com/google/gson) - JSON serialization and deserialization
- [**Apache HTTP common**](https://hc.apache.org/) - HTTP client
- [**Log4j**](http://logging.apache.org/log4j/2.x/) - logging

## Usage

There is really simple facade interface named MailQ. Every resource is hidden behind it. So you are supposed to use only MailQ and several entities. You have to provide only three informations when constructing MailQ object.

- API URL - there are several instances of MailQ. Everyone has own testing instances, so you have to provide URL to API it may look like this `https://mailq-test.quanti.cz/api/v2`. Always you secure HTTP protocol!
- company ID - When new client is add to MailQ system, system will assign new ID. This is unique identifier of your company within system.
- API Key - This is token which you can check in administration GUI. Combinantion of this key and company ID provides you access to resources.

```java
MailQ mailQ = new MailQ("https://mailq-test.quanti.cz/api/v2",1,"edda240d3e48d775d534d896c3efadd64ddce02576cf28bb3e4f76cc7e8b6c53");
```
### Campaigns resources

#### Get Campaigns

```java
for (CampaignEntity campaign : mailQ.getCampaings(Pagination.DEFAULT)) {
    System.out.println(campaign.getName());
}
```

#### Get campaign
```java
CampaignEntity campaign = mailQ.getCampaing(1L);
System.out.println(campaign.getName());
```

### Company resources

#### Get Company

```java
CompanyEntity company = mailQ.getCompany();
System.out.println(company.getName());
```

### Unsubscriber resource

### Unsubscribe e-mails

```java
Set<String> emails = new HashSet<>();
emails.add("john.doe@example.org");
emails.add("jill.doe@example.org");
mailQ.unsubscribe(emails);
```

or

```java
mailQ.unsubscribe("john.doe@example.org","jill.doe@example.org");
```

### Get unsubscribers

```java
LocalDateTime from = LocalDateTime.now().minusDays(10);
for (UnsubscriberEntity unsubscriber : mailQ.getUnsubscribers(from,Pagination.DEFAULT)) {
    System.out.println(unsubscriber.getEmail());
}
```

### Get unsubscriber

```java
for (UnsubscriberEntity unsubscriber : mailQ.getUnsubscriber("john.doe@example.org")) {
    System.out.println(unsubscriber.getEmail());
}
```

### Delete unsubscriber

```java
mailQ.deleteUnsubscriber("john.doe@example.org");
```

## Log message resource

### Get log messages

```java
for (LogMessageEntity logMessage : mailQ.getLogMessages(Pagination.DEFAULT)) {
    System.out.println(logMessage.getText());
}
```

### Get log message

```java
LogMessageEntity logMessage = mailQ.getLogMessage(1L);
System.out.println(logMessage.getId());
```

## Newsletter resource

### Get newsletters

```java
for (NewsletterEntity newsletter: mailQ.getNewsletters(Pagination.DEFAULT)) {
    System.out.println(newsletter.getName());
}
```

### Create newsletter

Sender e-mail has to be created. See resource Sender email.

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
mailQ.createNewsletter(newsletter);
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
