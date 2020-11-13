package us.hemdgang.elcliento.modules;

import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import us.hemdgang.elcliento.utils.RenderUtils;

public class Tracers extends Module {
    public Tracers(){
        super("Tracers", Category.RENDER);
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
    public void onRenderWorldLast(RenderWorldLastEvent e){

        for(Entity entity : mc.world.loadedEntityList) {
            RenderUtils.drawLine3D((float)mc.getRenderManager().viewerPosX, (float)mc.getRenderManager().viewerPosY + mc.player.getEyeHeight() / 2, (float)mc.getRenderManager().viewerPosZ, (float)entity.posX, (float)entity.posY + entity.getEyeHeight() , (float)entity.posZ, 1, 3317416);
        }
    }


}
