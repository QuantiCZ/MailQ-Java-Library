### Unsubscriber resources

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
