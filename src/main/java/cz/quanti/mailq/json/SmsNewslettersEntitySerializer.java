package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.NewsletterEntity;
import cz.quanti.mailq.entities.v2.NewslettersEntity;
import cz.quanti.mailq.entities.v2.SmsNewsletterEntity;
import cz.quanti.mailq.entities.v2.SmsNewslettersEntity;

import java.lang.reflect.Type;
import java.util.List;


public class SmsNewslettersEntitySerializer implements JsonDeserializer<SmsNewslettersEntity> {

    private Gson gson;

    public SmsNewslettersEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public SmsNewslettersEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<SmsNewsletterEntity> newsletters = gson.fromJson(jsonElement, new TypeToken<List<SmsNewsletterEntity>>(){}.getType());
        return new SmsNewslettersEntity(newsletters);
    }
}
