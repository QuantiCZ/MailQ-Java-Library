package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.RecipientsListEntity;
import cz.quanti.mailq.entities.v2.RecipientsListsEntity;
import cz.quanti.mailq.entities.v2.SmsNotificationEntity;
import cz.quanti.mailq.entities.v2.SmsNotificationsEntity;

import java.lang.reflect.Type;
import java.util.List;


public class RecipientsListsEntitySerializer implements JsonDeserializer<RecipientsListsEntity> {

    private Gson gson;

    public RecipientsListsEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public RecipientsListsEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<RecipientsListEntity> recipientsLists = gson.fromJson(jsonElement, new TypeToken<List<RecipientsListEntity>>(){}.getType());
        return new RecipientsListsEntity(recipientsLists);
    }
}
