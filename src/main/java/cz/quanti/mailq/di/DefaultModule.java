package cz.quanti.mailq.di;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import cz.quanti.mailq.json.RecipientsListsEntitySerializer;
import cz.quanti.mailq.di.annotations.ApiKey;
import cz.quanti.mailq.di.annotations.BaseUrl;
import cz.quanti.mailq.di.annotations.CompanyId;
import cz.quanti.mailq.entities.v2.*;
import cz.quanti.mailq.json.*;

import java.time.LocalDateTime;

public class DefaultModule extends AbstractModule {

    private String baseUrl;
    private String apiKey;
    private Integer companyId;

    public DefaultModule(String baseUrl, Integer companyId, String apiKey) {
        this.baseUrl = baseUrl;
        this.companyId = companyId;
        this.apiKey = apiKey;
    }

    @Override
    protected void configure() {
        bind(Integer.class).annotatedWith(CompanyId.class).toInstance(companyId);
        bind(String.class).annotatedWith(BaseUrl.class).toInstance(baseUrl);
        bind(String.class).annotatedWith(ApiKey.class).toInstance(apiKey);
    }


    @Provides
    Gson provideGson() {
        Gson temporaryGson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .create();
        return new GsonBuilder()
                .registerTypeAdapter(CampaignsEntity.class, new CampaignsEntitySerializer(temporaryGson))
                .registerTypeAdapter(UnsubscribersEntity.class, new UnsubscribersEntitySerializer(temporaryGson))
                .registerTypeAdapter(NewslettersEntity.class, new NewslettersEntitySerializer(temporaryGson))
                .registerTypeAdapter(NotificationsEntity.class, new NotificationsEntitySerializer(temporaryGson))
                .registerTypeAdapter(NotificationsDataEntity.class, new NotificationsDataEntitySerializer(temporaryGson))
                .registerTypeAdapter(SmsNewslettersEntity.class, new SmsNewslettersEntitySerializer(temporaryGson))
                .registerTypeAdapter(SmsNotificationsEntity.class, new SmsNotificationsEntitySerializer(temporaryGson))
                .registerTypeAdapter(RecipientsListsEntity.class, new RecipientsListsEntitySerializer(temporaryGson))
                .registerTypeAdapter(LogMessagesEntity.class, new LogMessagesEntitySerializer(temporaryGson))
                .registerTypeAdapter(RecipientsListEntriesEntity.class, new RecipientsListEntriesEntitySerializer(temporaryGson))
                .registerTypeAdapter(EmailAddressesEntity.class, new EmailAddressesEntitySerializer(temporaryGson))
                .registerTypeAdapter(TagsEntity.class, new TagsEntitySerializer(temporaryGson))
                .registerTypeAdapter(SenderEmailsEntity.class, new SenderEmailsEntitySerializer(temporaryGson))
                .registerTypeAdapter(UsersEntity.class, new UsersEntitySerializer(temporaryGson))
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .create();
    }
}
