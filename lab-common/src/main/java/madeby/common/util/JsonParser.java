package madeby.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import madeby.common.data.data_class.Vehicle;

import java.lang.reflect.Type;
import java.util.ArrayList;

public final class JsonParser {
    private JsonParser() {
    }

    public static ArrayList<Vehicle> toData(String json) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .setPrettyPrinting()
                .create();
        Type typeToken = new TypeToken<ArrayList<Vehicle>>() {
        }.getType();
        return gson.fromJson(json.trim(), typeToken);
    }

    public static String toJson(ArrayList<Vehicle> vehicles) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .setPrettyPrinting()
                .create();
        return gson.toJson(vehicles);
    }
}
