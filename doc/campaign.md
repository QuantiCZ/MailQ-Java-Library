### Campaign resources

#### Get campaigns

```java
for (CampaignEntity campaign : mailQ.getCampaigns()) {
    System.out.println(campaign.getName());
}
```

#### Get campaign
```java
CampaignEntity campaign = mailQ.getCampaign(1L);
System.out.println(campaign.getName());
```
