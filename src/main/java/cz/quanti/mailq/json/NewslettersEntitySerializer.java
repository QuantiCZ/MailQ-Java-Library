package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.CampaignEntity;
import cz.quanti.mailq.entities.v2.CampaignsEntity;
import cz.quanti.mailq.entities.v2.NewsletterEntity;
import cz.quanti.mailq.entities.v2.NewslettersEntity;

import java.lang.reflect.Type;
import java.util.List;


public class NewslettersEntitySerializer implements JsonDeserializer<NewslettersEntity> {

    private Gson gson;

    public NewslettersEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public NewslettersEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<NewsletterEntity> newsletters = gson.fromJson(jsonElement, new TypeToken<List<NewsletterEntity>>(){}.getType());
        return new NewslettersEntity(newsletters);
    }
}
