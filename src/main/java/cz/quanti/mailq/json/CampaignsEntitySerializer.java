package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.CampaignEntity;
import cz.quanti.mailq.entities.v2.CampaignsEntity;

import java.lang.reflect.Type;
import java.util.List;


public class CampaignsEntitySerializer implements JsonDeserializer<CampaignsEntity> {

    private Gson gson;

    public CampaignsEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public CampaignsEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<CampaignEntity> campaigns = gson.fromJson(jsonElement, new TypeToken<List<CampaignEntity>>(){}.getType());
        return new CampaignsEntity(campaigns);
    }
}
