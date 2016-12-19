package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.NotificationDataEntity;
import cz.quanti.mailq.entities.v2.NotificationEntity;
import cz.quanti.mailq.entities.v2.NotificationsDataEntity;
import cz.quanti.mailq.entities.v2.NotificationsEntity;

import java.lang.reflect.Type;
import java.util.List;


public class NotificationsDataEntitySerializer implements JsonDeserializer<NotificationsDataEntity> {

    private Gson gson;

    public NotificationsDataEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public NotificationsDataEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<NotificationDataEntity> notificationsData = gson.fromJson(jsonElement, new TypeToken<List<NotificationDataEntity>>(){}.getType());
        return new NotificationsDataEntity(notificationsData);
    }
}
