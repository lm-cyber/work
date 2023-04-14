package madeby.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import madeby.common.data.data_class.Worker;

import java.lang.reflect.Type;
import java.util.PriorityQueue;

public final class JsonParser {
    private JsonParser() {
    }

    public static PriorityQueue<Worker> toData(String json) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .setPrettyPrinting()
                .create();
        Type typeToken = new TypeToken<PriorityQueue<Worker>>() {
        }.getType();
        return gson.fromJson(json.trim(), typeToken);
    }

    public static String toJson(PriorityQueue<Worker> workers) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .setPrettyPrinting()
                .create();
        return gson.toJson(workers);
    }
}
