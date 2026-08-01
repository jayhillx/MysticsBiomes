package api.mystanica.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.ConfigFormat;
import com.electronwill.nightconfig.core.UnmodifiableConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.electronwill.nightconfig.toml.TomlFormat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ConfigBuilder implements UnmodifiableConfig {
    protected final CommentedConfig config;
    protected final Path path;

    protected ConfigBuilder(Path path) {
        this.path = path;
        this.config = TomlFormat.instance().createConfig();
        if (Files.exists(path)) {
            this.loadFile();
        }
        this.load();
        this.save();
    }

    public abstract void load();

    protected void loadFile() {
        CommentedConfig loaded = TomlFormat.instance().createParser().parse(readToml());
        this.config.putAll(loaded);
    }

    protected String readToml() {
        try {
            return Files.readString(this.path);
        } catch (Exception ignored) {
            return "";
        }
    }

    public void save() {
        TomlFormat.instance().createWriter().write(this.config, this.path, WritingMode.REPLACE);
    }

    protected <T> T get(String path, T defaultValue) {
        if (!this.config.contains(path)) {
            this.config.set(path, defaultValue);
            return defaultValue;
        }

        return this.config.get(path);
    }

    protected void set(String path, Object value) {
        this.config.set(path, value);
    }

    protected void section(String name) {
        if (!this.config.contains(name)) {
            this.config.add(name, TomlFormat.instance().createConfig());
        }
    }

    @Override
    public <T> T getRaw(List<String> path) {
        return this.config.getRaw(path);
    }

    @Override
    public boolean contains(List<String> path) {
        return this.config.contains(path);
    }

    @Override
    public int size() {
        return this.config.size();
    }

    @Override
    public Map<String, Object> valueMap() {
        return this.config.valueMap();
    }

    @Override
    public Set<? extends Entry> entrySet() {
        return this.config.entrySet();
    }

    @Override
    public ConfigFormat<?> configFormat() {
        return this.config.configFormat();
    }

}