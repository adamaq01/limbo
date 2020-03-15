package fr.adamaq01.limbo;

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public class Program {

    public static void main(String[] args) {
        LimboServer limboServer = new LimboServer(25565);
        Runtime.getRuntime().addShutdownHook(new Thread(limboServer::stop));
        try {
            limboServer.start();
        } catch (Exception e) {
            System.out.println("FATAL ERROR"); // TODO
        }
    }
}
