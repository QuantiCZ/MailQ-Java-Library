package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.SmsNotificationEntity;
import cz.quanti.mailq.entities.v2.SmsNotificationsEntity;
import cz.quanti.mailq.entities.v2.UserEntity;
import cz.quanti.mailq.entities.v2.UsersEntity;

import java.lang.reflect.Type;
import java.util.List;


public class UsersEntitySerializer implements JsonDeserializer<UsersEntity> {

    private Gson gson;

    public UsersEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public UsersEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<UserEntity> users = gson.fromJson(jsonElement, new TypeToken<List<UserEntity>>(){}.getType());
        return new UsersEntity(users);
    }
}
