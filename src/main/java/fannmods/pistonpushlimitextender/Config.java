package fannmods.pistonpushlimitextender;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
    public static int PushLimit = 12;
    public static int Default = 12;
    public static int MaxRange = 512;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = Paths.get("config", "pistonpushlimit.json");

    public static void load() {
        try {
            if (Files.exists(CONFIG_PATH)) {
                try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                    ConfigData data = GSON.fromJson(reader, ConfigData.class);
                    if (data != null && data.PushLimit >= 0 && data.Default >= 0 && data.MaxRange >= 0) {
                        PushLimit = data.PushLimit;
                        Default = data.Default;
                        MaxRange = data.MaxRange;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("[PistonPushLimit] Failed to load config: " + e.getMessage());
        }
    }

    public static void save() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
                GSON.toJson(new ConfigData(PushLimit, Default, MaxRange), writer);
            }
        } catch (IOException e) {
            System.err.println("[PistonPushLimit] Failed to save config: " + e.getMessage());
        }
    }

    private static class ConfigData {
        int PushLimit;
        int Default;
        int MaxRange;

        ConfigData(int PushLimit, int Default, int MaxRange) {
            this.PushLimit = PushLimit;
            this.Default = Default;
            this.MaxRange = MaxRange;
        }
    }
}