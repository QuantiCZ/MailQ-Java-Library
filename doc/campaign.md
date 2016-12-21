### Campaign resources

#### Get campaigns

```java
for (CampaignEntity campaign : mailQ.getCampaigns(Pagination.DEFAULT)) {
    System.out.println(campaign.getName());
}
```

#### Get campaign
```java
CampaignEntity campaign = mailQ.getCampaign(1L);
System.out.println(campaign.getName());
```
