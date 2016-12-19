package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.NewsletterEntity;
import cz.quanti.mailq.entities.v2.NewslettersEntity;
import cz.quanti.mailq.entities.v2.NotificationEntity;
import cz.quanti.mailq.entities.v2.NotificationsEntity;

import java.lang.reflect.Type;
import java.util.List;


public class NotificationsEntitySerializer implements JsonDeserializer<NotificationsEntity> {

    private Gson gson;

    public NotificationsEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public NotificationsEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<NotificationEntity> notifications = gson.fromJson(jsonElement, new TypeToken<List<NotificationEntity>>(){}.getType());
        return new NotificationsEntity(notifications);
    }
}
