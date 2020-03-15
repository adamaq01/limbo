package fr.adamaq01.limbo;

import fr.adamaq01.limbo.players.Player;
import fr.adamaq01.limbo.plugins.Plugin;
import fr.adamaq01.limbo.worlds.World;

import java.util.Collection;
import java.util.UUID;

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public interface Limbo {

    int getPort();

    World getWorld();

    Collection<Player> getPlayers();

    Player getPlayer(UUID uuid);

    Player getPlayer(String name);

    Collection<Plugin> getPlugins();

    Plugin getPlugin(String name);
}
