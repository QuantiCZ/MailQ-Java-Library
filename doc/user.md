## User resource

### Get users

```java
for (UserEntity user : mailQ.getUsers()) {
    System.out.println(user.getEmail());
}
```

### Get user

```java
UserEntity user = mailQ.getUser(1L);
System.out.println(user.getEmail());
```
