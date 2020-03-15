package fr.adamaq01.limbo.plugins;

import fr.adamaq01.limbo.Limbo;

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public interface Plugin {

    void onEnable(Limbo limbo);

    void onDisable();
}
