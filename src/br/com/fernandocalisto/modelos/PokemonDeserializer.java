package br.com.fernandocalisto.modelos;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.LinkedList;

public class PokemonDeserializer implements JsonDeserializer<Pokemon> {
    @Override
    public Pokemon deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject o = json.getAsJsonObject();

        String name = o.get("name").getAsString();
        int id = o.get("id").getAsInt();

        LinkedList<String> types = new LinkedList<>();
        JsonArray typesArray = o.getAsJsonArray("types");
        for (JsonElement e : typesArray) {
            String tipo = e.getAsJsonObject().getAsJsonObject("type").get("name").getAsString();
            types.add(tipo);
        }

        LinkedList<String> abilities = new LinkedList<>();
        JsonArray abilArray = o.getAsJsonArray("abilities");
        for (JsonElement e : abilArray) {
            String habilidade = e.getAsJsonObject().getAsJsonObject("ability").get("name").getAsString();
            abilities.add(habilidade);
        }

        String sprite = o.getAsJsonObject("sprites").get("front_default").getAsString();

        return new Pokemon(name, id, types, abilities, sprite);
    }
}
