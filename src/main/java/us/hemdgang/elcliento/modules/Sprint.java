package us.hemdgang.elcliento.modules;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint extends Module {

    public Sprint(){

        super("Sprint", Category.MOVEMENT);

    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister( this);
    }


    @SubscribeEvent
    public void onUpdate(final TickEvent.ClientTickEvent event) {
        if (mc.player == null) return;
        if (!mc.player.isSprinting()) {
            mc.player.setSprinting(true);
        }
    }
}
