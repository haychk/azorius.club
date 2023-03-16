package me.hk.azorius.features.modules.text;

import me.hk.azorius.event.events.PacketEvent;
import me.hk.azorius.features.modules.Module;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiPopLag extends Module {
    public AntiPopLag() {
        super("AntiPopLag", "Block unicode chars to prevent game lag.", Category.Text, false, false);
    }

    @SubscribeEvent
    public void onPacketReceive(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketChat) {
            String text = ((SPacketChat) event.getPacket()).getChatComponent().getUnformattedText();
            if (text.contains("\u0B01") || text.contains("\u0201") || text.contains("\u2701")) {
                event.setCanceled(true);
            }
        }
    }
}
