package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.NotificationEntity;
import cz.quanti.mailq.entities.v2.NotificationsEntity;
import cz.quanti.mailq.entities.v2.SmsNotificationEntity;
import cz.quanti.mailq.entities.v2.SmsNotificationsEntity;

import java.lang.reflect.Type;
import java.util.List;


public class SmsNotificationsEntitySerializer implements JsonDeserializer<SmsNotificationsEntity> {

    private Gson gson;

    public SmsNotificationsEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public SmsNotificationsEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<SmsNotificationEntity> notifications = gson.fromJson(jsonElement, new TypeToken<List<SmsNotificationEntity>>(){}.getType());
        return new SmsNotificationsEntity(notifications);
    }
}
