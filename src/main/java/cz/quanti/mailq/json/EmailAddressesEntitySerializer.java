package cz.quanti.mailq.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import cz.quanti.mailq.entities.v2.EmailAddressesEntity;

import java.lang.reflect.Type;


public class EmailAddressesEntitySerializer implements JsonSerializer<EmailAddressesEntity> {

    private Gson gson;

    public EmailAddressesEntitySerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public JsonElement serialize(EmailAddressesEntity emailAddressesEntity, Type type, JsonSerializationContext jsonSerializationContext) {
        return gson.toJsonTree(emailAddressesEntity.getAddresses());
    }
}
