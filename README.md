# MailQ-Java-Library

This is the library for connection to the mailing system [MailQ](http://mailq.cz/?lang=ENG). It is meaningful only if you are Quanti client. Otherwise you will not be able to connect. If you are Quanti client and you do not have access to the system, you can contact our support department at [support@mailq.cz](support@mailq.cz). Library communicates with MaiLQ via REST API. Documentation of REST API is [here](http://docs.newmailing.apiary.io/).

There is also [PHP implementation](https://github.com/QuantiCZ/MailQ-PHP-Library).

## Dependencies

- [**Guice**](https://github.com/google/guice) - DI system
- [**GSON**](https://github.com/google/gson) - JSON serialization and deserialization
- [**Apache HTTP common**](https://hc.apache.org/) - HTTP client
- [**Log4j**](http://logging.apache.org/log4j/2.x/) - logging


## Usage

There is really simple facade interface named MailQ. Every resource is hidden behind it. So you are supposed to use only MailQ and several entities. You have to provide only three informations when constructing MailQ object.

- API URL - There are several instances of the MailQ. Everyone has own testing instances, so you have to provide the URL to the API. It may look like this `https://mailq-test.quanti.cz/api/v2`. Always you secure HTTP protocol!
- company ID - After adding new client to the MailQ, the system will assign a new ID. This is always an unique identifier of your company within the system.
- API Key - This is an unique token which you can check in the administration GUI. The combination of this key and company ID provides you the access to resources.

```java
MailQ mailQ = new MailQ("https://mailq-test.quanti.cz/api/v2",1,"edda240d3e48d775d534d896c3efadd64ddce02576cf28bb3e4f76cc7e8b6c53");
```

**Resources**

- [Campaign resource](./doc/campaign.md)
- [Company resource](./doc/company.md)
- [Log Message resource](./doc/log-message.md)
- [Newsletter resource](./doc/newsletter.md)
- [Notification resource](./doc/notification.md)
- [Recipients list resource](./doc/recipients-list.md)
- [Sender email resource](./doc/sender-email.md)
- [SMS newsletter resource](./doc/sms-newsletter.md)
- [SMS notification resource](./doc/sms-notification.md)
- [Unsubscriber resource](./doc/unsubscriber.md)
- [User resource](./doc/user.md)
- [Validator resource](./doc/validator.md)
