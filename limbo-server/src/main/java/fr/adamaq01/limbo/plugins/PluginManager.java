package fr.adamaq01.limbo.plugins;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.toml.TomlParser;
import fr.adamaq01.limbo.Limbo;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

// TODO Plugin inter-dependencies management

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public class PluginManager {

    private Limbo limbo;
    private Map<String, LimboPlugin> plugins;

    public PluginManager(Limbo limbo) {
        this.limbo = limbo;
        this.plugins = new HashMap<>();
    }

    public void loadPlugins() throws Exception {
        File file = new File("plugins/");
        file.mkdirs();
        for (File pluginFile : file.listFiles()) {
            if (!pluginFile.isFile() || !pluginFile.getPath().endsWith(".jar")) return;
            URL url = pluginFile.toURI().toURL();
            loadPlugin(url);
        }
    }

    private void loadPlugin(URL file) throws Exception {
        URLClassLoader cl = URLClassLoader.newInstance(new URL[] {file});

        InputStream inputStream = cl.getResourceAsStream("plugin.toml");
        if (inputStream == null) {
            // plugin.toml not found, ignore
            return;
        }
        TomlParser tomlParser = new TomlParser();
        CommentedConfig config = tomlParser.parse(new InputStreamReader(inputStream));
        String name = config.get("name");
        String version = config.get("version");
        String mainClassPath = config.get("class");
        String author = config.get("author");

        if (this.plugins.containsKey(name)) {
            // Plugin already loaded
            throw new RuntimeException(String.format("Plugins %s already loaded !", name));
        }

        Class<?> mainClass = cl.loadClass(mainClassPath);
        if (!Plugin.class.isAssignableFrom(mainClass)) {
            // Main class is not assignable to Plugin
            throw new RuntimeException(String.format("Main class of plugin %s not assignable to a Plugin class", name));
        }

        LimboPlugin limboPlugin = new LimboPlugin(name, version, author, ((Class<Plugin>) mainClass).newInstance());
        this.plugins.put(name, limboPlugin);

        limboPlugin.getPlugin().onEnable(this.limbo);
    }

    public void disablePlugins() {
        for (LimboPlugin value : this.plugins.values()) {
            value.getPlugin().onDisable();
        }
    }

    public Map<String, LimboPlugin> getPlugins() {
        return plugins;
    }
}
