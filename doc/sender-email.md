## Sender email resource

### Get sender emails

```java
for (SenderEmailEntity senderEmailEntity : mailQ.getSenderEmails()) {
    System.out.println(senderEmailEntity.getEmail());
}
```

### Get sender email

```java
SenderEmailEntity senderEmailEntity = mailQ.getSenderEmail(1L);
System.out.println(senderEmailEntity.getEmail());
```
