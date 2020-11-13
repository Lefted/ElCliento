package us.hemdgang.elcliento.modules;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import us.hemdgang.elcliento.utils.RenderUtils;

public class ESP extends Module {
    public ESP() {
        super("ESP", Category.RENDER);
    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @SubscribeEvent
    public void onWorldRenderLast(RenderWorldLastEvent e){

        for(Entity entity : mc.world.loadedEntityList) {
            if(!(entity instanceof EntityPlayerSP)) {
                RenderUtils.drawFlledCube(new AxisAlignedBB( entity.posX - entity.width / 2,  entity.posY,  entity.posZ - entity.width / 2,
                        entity.posX - entity.width / 2 + entity.width,  entity.posY + entity.height,  entity.posZ - entity.width / 2 + entity.width), 3317416);

                RenderUtils.drawOutlineBox((float) entity.posX - entity.width / 2, (float) entity.posY, (float) entity.posZ - entity.width / 2, entity.width, entity.height, entity.width, 1, 3317416);
            }
        }
    }

}
