## SMS newsletter resources

### Get SMS newsletters

```java
for (SmsNewsletterEntity smsNewsletter : mailQ.getSmsNewsletters(Pagination.DEFAULT)) {
    System.out.println(smsNewsletter.getName());
}
```

### Get SMS newsletter

```java
SmsNewsletterEntity smsNewsletter = mailQ.getSmsNewsletter(1L);
System.out.println(smsNewsletter.getName());
```

### Create SMS newsletter

```java
SmsNewsletterEntity smsNewsletter = new SmsNewsletterEntity();
smsNewsletter
        .setCampaign("Winter sales")
        .setName("SMS news")
        .setText("Winter sales are coming. Your discount code is {{code}}")
        .setRecipientsListId(320L)
        .setFrom(LocalDateTime.now().plusHours(2))
        .setTo(LocalDateTime.now().plusDays(1));
smsNewsletter = mailQ.createSmsNewsletter(smsNewsletter);
System.out.println(smsNewsletter.getId());
```

### Update SMS newsletter

```java
SmsNewsletterEntity smsNewsletter = mailQ.getSmsNewsletter(1L);
System.out.println(smsNewsletter.getName());
```
### Delete SMS newsletter

```java
mailQ.deleteSmsNewsletter(1L);
```

### Start SMS newsletter

```java
mailQ.startSmsNewsletter(1L);
```

### Stop SMS newsletter

```java
mailQ.stopSmsNewsletter(1L);
```

### Send test SMS

This SMS will be **charged**!

```java
mailQ.sendTestSms(1L,"+420600700700");
```
