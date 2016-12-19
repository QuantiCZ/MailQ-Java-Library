package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.SenderEmailEntity;
import cz.quanti.mailq.entities.v2.SenderEmailsEntity;
import cz.quanti.mailq.entities.v2.UnsubscriberEntity;
import cz.quanti.mailq.entities.v2.UnsubscribersEntity;

import java.lang.reflect.Type;
import java.util.List;


public class SenderEmailsEntitySerializer implements JsonDeserializer<SenderEmailsEntity> {

    private Gson gson;

    public SenderEmailsEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public SenderEmailsEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<SenderEmailEntity> unsubscribers = gson.fromJson(jsonElement, new TypeToken<List<SenderEmailEntity>>(){}.getType());
        return new SenderEmailsEntity(unsubscribers);
    }
}
