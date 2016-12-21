## Log message resources

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
