package fr.adamaq01.limbo.players;

import fr.adamaq01.limbo.protocols.Protocol;
import org.joml.Vector3d;

import java.util.UUID;

/**
 * @author Adamaq01 (Adam THIBERT)
 */
public interface Player {

    UUID getUUID();

    String getName();

    Vector3d getPosition();

    Protocol getProtocol();
}
