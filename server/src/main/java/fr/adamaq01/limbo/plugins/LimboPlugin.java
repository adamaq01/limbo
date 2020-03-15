package fr.adamaq01.limbo.plugins;

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public class LimboPlugin {

    private String name;
    private String version;
    private String author;
    private Plugin plugin;

    public LimboPlugin(String name, String version, String author, Plugin plugin) {
        this.name = name;
        this.version = version;
        this.author = author;
        this.plugin = plugin;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public Plugin getPlugin() {
        return plugin;
    }
}
