## Notification resources

### Get notifications

```java
for(NotificationEntity notification : mailQ.getNotifications()) {
    System.out.println(notification.getName());
}
```

### Get notification

```java
NotificationEntity notification = mailQ.getNotification(1L);
System.out.println(notification.getName());
```

### Create notification

```java
NotificationEntity notification = new NotificationEntity();
notification.setName("Order confirmation")
        .setSubject("Order confirmation")
        .setSendAs("Company inc.")
        .setTemplate("tHa42Av5s6==")
        .setAppliedSenderEmail("robot@example.org")
        .setText("Your order is confirmed")
        .setCode("XS-12");
mailQ.createNotification(notification);
```

### Update notification

```java
NotificationEntity notification = mailQ.getNotification(1L);
notification.setName("Summer sale");
mailQ.updateNotification(notification);
```

### Delete notification

```java
mailQ.deleteNotification(1L);
```

### Send notification

```java
List<NotificationAttachmentEntity> attachments = new ArrayList<>();
NotificationAttachmentEntity attachment = new NotificationAttachmentEntity();
attachment.setSource("hUjA45ta==")
        .setMimeType("plain/text")
        .setLink("http://example.org")
        .setDisplayName("attachment.txt");
attachments.add(attachment);
NotificationDataEntity notificationData = new NotificationDataEntity();
notificationData.setRecipientEmail("john.doe@example.org")
        .setDateFrom(LocalDateTime.now())
        .setReplyToEmail("marketing@example.org")
        .setBcc("reports@example.org","reporting@example.org")
        .setCc("jill.doe@example.og")
        .setAttachments(attachments);
mailQ.sendNotificationEmail(264L,notificationData);
```
