package cz.quanti.mailq.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.quanti.mailq.entities.v2.CampaignEntity;
import cz.quanti.mailq.entities.v2.CampaignsEntity;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;


public class LocalDateTimeSerializer implements JsonDeserializer<LocalDateTime>, JsonSerializer<LocalDateTime> {


    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String dateTime = jsonElement.getAsString();
        if (Character.isDigit(dateTime.charAt(0))) {
            if (dateTime.contains("+")) {
                return LocalDateTime.parse(jsonElement.getAsString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }
            else {
                return LocalDateTime.parse(jsonElement.getAsString(), DateTimeFormatter.ISO_DATE_TIME);
            }
        }
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss 'CET' yyyy");
            DateTimeFormatter enFormatter = formatter.withLocale(Locale.ENGLISH);
            return  LocalDateTime.parse(jsonElement.getAsString(), enFormatter);
        }
    }

    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
