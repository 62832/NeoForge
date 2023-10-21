package net.minecraftforge.network.simple;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

/**
 * An abstraction for network packets.
 *
 * @see SimpleChannel#simpleMessageBuilder(Class, int)
 */
public interface SimpleMessage {
    /**
     * Encodes this message to the {@code buffer}.
     *
     * @see MessageFunctions.MessageEncoder
     */
    void encode(FriendlyByteBuf buffer);

    /**
     * Called on the server/client thread, in order to handle this packet. Accessing game state is safe here.
     *
     * @param context the network context
     */
    default void handleMainThread(NetworkEvent.Context context) {
    }

    /**
     * Called on the network thread, in order to handle this packet. Accessing game state is <strong>not</strong> safe here,
     * as the server is usually not thread-safe.
     * <b>Seriously, do NOT access the game state in this method.</b>
     *
     * @param context the network context
     */
    default void handleNetworkThread(NetworkEvent.Context context) {
    }
}
