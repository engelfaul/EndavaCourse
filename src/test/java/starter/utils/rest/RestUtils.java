package starter.utils.rest;

import com.google.gson.Gson;

import java.util.Map;

public class RestUtils {

    public static Map convertJsonMap(String body){
        final Gson gson = new Gson();
        return gson.fromJson(body, Map.class);
    }
}
