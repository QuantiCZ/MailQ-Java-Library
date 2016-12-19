package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.CampaignEntity;
import cz.quanti.mailq.entities.v2.CampaignsEntity;
import cz.quanti.mailq.entities.v2.UnsubscriberEntity;
import cz.quanti.mailq.entities.v2.UnsubscribersEntity;

import java.lang.reflect.Type;
import java.util.List;


public class UnsubscribersEntitySerializer implements JsonDeserializer<UnsubscribersEntity> {

    private Gson gson;

    public UnsubscribersEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public UnsubscribersEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<UnsubscriberEntity> unsubscribers = gson.fromJson(jsonElement, new TypeToken<List<UnsubscriberEntity>>(){}.getType());
        return new UnsubscribersEntity(unsubscribers);
    }
}
