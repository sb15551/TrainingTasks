import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final String URL = "https://ru.wikipedia.org/wiki/Список_станций_Московского_метрополитена";
    public static final String SAVEFILE = "09_FilesAndNetwork/homework_9_5/src/main/resources/mapMSKMetro.json";

    public static void main(String[] args) {
        ParseMSKMetro.create(URL, SAVEFILE);
        Gson gson = new GsonBuilder().create();
        try {
            String json = Files.readString(Paths.get(SAVEFILE));
            JsonCreate jsonCreate = gson.fromJson(json, JsonCreate.class);
            jsonCreate.getStations().forEach((k, v) -> System.out.printf("На %s линии %d станций\n", k, v.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
