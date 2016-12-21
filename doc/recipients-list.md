## Recipients list resources

### Get recipients lists

```java
for (RecipientsListEntity recipientsList : mailQ.getRecipientsLists()) {
    System.out.println(recipientsList.getName());
}
```

### Get recipient lists by email

This will list all recipients list which contains given e-mail address.

```java
for (RecipientsListEntity recipientsList : mailQ.getRecipientsListsByEmail("john.doe@example.org")) {
    System.out.println(recipientsList.getName());
}
```

### Get recipients list

```java
RecipientsListEntity recipientsList = mailQ.getRecipientsList(1L);
System.out.println(recipientsList.getName());
```

### Create recipients list

```java
RecipientsListEntity recipientsList = new RecipientsListEntity();
recipientsList.setName("Customer list")
        .setDescription("Eshop customers")
        .setVariables("gender","name")
        .setFormVisible(false);
recipientsList = mailQ.createRecipientsList(recipientsList);
System.out.println(recipientsList.getId());
```

### Delete empty recipients list

```java
mailQ.deleteRecipientsList(1L);
```

### Delete recipients list

**Be careful!**
This will delete recipients list even if it contains entries

```java
mailQ.deleteRecipientsList(1L,true);
```

### Create recipients

```java
List<RecipientsListEntryEntity> recipientsListEntryEntityList = new ArrayList<>();
RecipientsListEntryEntity recipientsListEntry = new RecipientsListEntryEntity();
recipientsListEntry
        .setEmail("john.doe@example.org")
        .addData("gender","male")
        .addData("name", "John");
recipientsListEntryEntityList.add(recipientsListEntry);
recipientsListEntry = new RecipientsListEntryEntity();
recipientsListEntry
        .setEmail("jill.doe@example.org")
        .addData("gender","female")
        .addData("name", "Jill");
recipientsListEntryEntityList.add(recipientsListEntry);
mailQ.addRecipientsToList(324L,recipientsListEntryEntityList);
```

### Get recipients in recipients list

```java
for (RecipientsListEntryEntity entry : mailQ.getRecipientsFromList(1L)) {
    System.out.println(entry.getEmail());
}
```

### Create or update recipient

```java
RecipientsListEntryEntity recipientsListEntry = new RecipientsListEntryEntity();
recipientsListEntry
        .setEmail("john.doe@example.org")
        .addData("gender","male")
        .addData("name", "John");
mailQ.updateRecipientFromList(324L,recipientsListEntry);
```

### Delete recipient from list

```java
mailQ.deleteRecipientFromList(1L,"john.doe@example.org");
```

### Get recipients list unsubscribers

```java
for (UnsubscriberEntity unsubscriber : mailQ.getUnsubscribers(1L)) {
    System.out.println(unsubscriber.getEmail());
}
```

### Add unsubscribers to recipients list

```java
mailQ.unsubscribe(1L,"john.doe@example.org","jill.doe@example.org");
```

### Get unsubscriber from recipients list

```java
UnsubscriberEntity unsubscriber = mailQ.getUnsubscriber(324L,"john.doe@example.org");
System.out.println(unsubscriber.getEmail());
```

### Delete unsubscriber

```java
mailQ.deleteUnsubscriber(1L,"john.doe@example.org");
```
