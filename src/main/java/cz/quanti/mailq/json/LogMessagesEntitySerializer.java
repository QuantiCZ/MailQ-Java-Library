package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.LogMessageEntity;
import cz.quanti.mailq.entities.v2.LogMessagesEntity;
import cz.quanti.mailq.entities.v2.UnsubscriberEntity;
import cz.quanti.mailq.entities.v2.UnsubscribersEntity;

import java.lang.reflect.Type;
import java.util.List;


public class LogMessagesEntitySerializer implements JsonDeserializer<LogMessagesEntity> {

    private Gson gson;

    public LogMessagesEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public LogMessagesEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<LogMessageEntity> logMessages = gson.fromJson(jsonElement, new TypeToken<List<LogMessageEntity>>(){}.getType());
        return new LogMessagesEntity(logMessages);
    }
}
