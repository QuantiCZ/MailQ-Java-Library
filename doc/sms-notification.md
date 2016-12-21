## SMS notification resource

### Get SMS notifications

```java
for (SmsNotificationEntity smsNotification : mailQ.getSmsNotifications(Pagination.DEFAULT)) {
    System.out.println(smsNotification.getName());
}
```

### Get SMS notification

```java
SmsNotificationEntity smsNotification = mailQ.getSmsNotification(40L);
System.out.println(smsNotification.getName());
```

### Create SMS notification

```java
SmsNotificationEntity smsNotification = new SmsNotificationEntity();
smsNotification.setName("Winter sale")
        .setTemplate("Winter sale is coming. Your discount code is {{code}}")
        .setCode("XS-12");
mailQ.createSmsNotification(smsNotification);
```

### Update SMS notification

```java
SmsNotificationEntity smsNotification = mailQ.getSmsNotification(40L);
smsNotification.setName("Summer sale");
mailQ.updateSmsNotification(smsNotification);
```

### Delete SMS notification

```java
mailQ.deleteSmsNotification(1L);
```

### Start SMS newsletter

```java
mailQ.startSmsNewsletter(1L);
```

### Stop SMS newsletter

```java
mailQ.stopSmsNewsletter(1L);
```

### Send SMS notification

```java
SmsNotificationDataEntity smsNotificationData = new SmsNotificationDataEntity();
String code = "XS-12";
Map<String,Object> data = new HashMap<>();
data.put("code",code);
smsNotificationData
        .setToNumber("+420700600600")
        .setData(data);
mailQ.sendSmsNotification(40L,smsNotificationData);
```

### Send SMS batch notification

Always check result. This resource will not throw exception if sending of some SMS fails.

```java
SmsNotificationBatchEntity batch = new SmsNotificationBatchEntity();
List<SmsNotificationDataEntity> notifications = new ArrayList<>();
SmsNotificationDataEntity smsNotificationData = new SmsNotificationDataEntity();
smsNotificationData
        .setId("1")
        .setToNumber("+420700600600")
        .addData("code","XS-12");
notifications.add(smsNotificationData);
smsNotificationData = new SmsNotificationDataEntity();
smsNotificationData
        .setId("2")
        .setToNumber("+420700600601")
        .addData("code","XS-14");
notifications.add(smsNotificationData);
batch.setBatch(notifications);
for (SmsResultEntity smsResult : mailQ.sendSmsBatchNotification(40L,batch)) {
    System.out.println(smsResult.isOk());
}
```

### Get SMS data

```java
mailQ.getSmsNotificationData(1L,"3F2504E0-4F89-41D3-9A0C-0305E82C3301");
```
