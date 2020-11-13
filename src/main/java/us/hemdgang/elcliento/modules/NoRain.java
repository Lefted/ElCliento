package us.hemdgang.elcliento.modules;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoRain extends Module {

    public NoRain(){

        super("NoRain", Category.WORLD);

    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if (mc.world != null) {
            if (mc.world.isRaining()) mc.world.setRainStrength(0.0f);
            if (mc.world.isThundering()) mc.world.setThunderStrength(0.0f);
        }
    }


}
