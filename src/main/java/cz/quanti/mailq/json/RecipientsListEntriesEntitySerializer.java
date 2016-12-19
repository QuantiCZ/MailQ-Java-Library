package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.RecipientsListEntity;
import cz.quanti.mailq.entities.v2.RecipientsListEntriesEntity;
import cz.quanti.mailq.entities.v2.RecipientsListEntryEntity;
import cz.quanti.mailq.entities.v2.RecipientsListsEntity;

import java.lang.reflect.Type;
import java.util.List;


public class RecipientsListEntriesEntitySerializer implements JsonDeserializer<RecipientsListEntriesEntity>, JsonSerializer<RecipientsListEntriesEntity> {

    private Gson gson;

    public RecipientsListEntriesEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public RecipientsListEntriesEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<RecipientsListEntryEntity> recipientsLists = gson.fromJson(jsonElement, new TypeToken<List<RecipientsListEntryEntity>>(){}.getType());
        return new RecipientsListEntriesEntity(recipientsLists);
    }

    @Override
    public JsonElement serialize(RecipientsListEntriesEntity recipientsListEntriesEntity, Type type, JsonSerializationContext jsonSerializationContext) {
        return gson.toJsonTree(recipientsListEntriesEntity.getRecipientsListEntries());
    }
}
