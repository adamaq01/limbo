package fr.adamaq01.limbo;

import fr.adamaq01.limbo.players.Player;
import fr.adamaq01.limbo.plugins.LimboPlugin;
import fr.adamaq01.limbo.plugins.Plugin;
import fr.adamaq01.limbo.plugins.PluginManager;
import fr.adamaq01.limbo.worlds.World;
import fr.adamaq01.ozao.net.server.Server;
import fr.adamaq01.ozao.net.server.backend.tcp.TCPServer;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public class LimboServer implements Limbo {

    private int port;
    private PluginManager pluginManager;
    private Server server;

    public LimboServer(int port) {
        this.port = port;
        this.pluginManager = new PluginManager(this);
        this.server = new TCPServer(null);
    }

    public void start() throws Exception {
        this.pluginManager.loadPlugins();

        this.server.bind(this.port);
    }

    public void stop() {
        this.pluginManager.disablePlugins();

        this.server.close();
    }

    public Server getServer() {
        return server;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public Collection<Player> getPlayers() {
        return null;
    }

    @Override
    public Player getPlayer(UUID uuid) {
        return null;
    }

    @Override
    public Player getPlayer(String name) {
        return null;
    }

    @Override
    public Collection<Plugin> getPlugins() {
        return pluginManager.getPlugins().values().stream().map(LimboPlugin::getPlugin).collect(Collectors.toList());
    }

    @Override
    public Plugin getPlugin(String name) {
        return pluginManager.getPlugins().get(name).getPlugin();
    }
}
