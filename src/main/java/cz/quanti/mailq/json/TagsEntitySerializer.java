package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.TagEntity;
import cz.quanti.mailq.entities.v2.TagsEntity;
import cz.quanti.mailq.entities.v2.UnsubscriberEntity;
import cz.quanti.mailq.entities.v2.UnsubscribersEntity;

import java.lang.reflect.Type;
import java.util.List;


public class TagsEntitySerializer implements JsonDeserializer<TagsEntity> {

    private Gson gson;

    public TagsEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public TagsEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<TagEntity> tags = gson.fromJson(jsonElement, new TypeToken<List<TagEntity>>(){}.getType());
        return new TagsEntity(tags);
    }
}
