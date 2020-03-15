package fr.adamaq01.limbo.test;

import fr.adamaq01.limbo.Limbo;
import fr.adamaq01.limbo.plugins.Plugin;

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public class TestPlugin implements Plugin {

    public TestPlugin() {
        System.out.println("Initialized Test Plugin");
    }

    @Override
    public void onEnable(Limbo limbo) {
        System.out.println("Enabled Test Plugin");
    }

    @Override
    public void onDisable() {
        System.out.println("Disabled Test Plugin");
    }
}
