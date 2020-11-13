package us.hemdgang.elcliento.modules;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import us.hemdgang.elcliento.ElCliento;

public class Chams extends Module{
    public Chams() {
        super("Chams", Category.RENDER);
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
    public void onRenderLivingPre(RenderLivingEvent.Pre<? extends EntityLivingBase> event) {
        GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset(1.0F, -2000000);

    }

    @SubscribeEvent
    public void onRenderLivingPost(RenderLivingEvent.Post<? extends EntityLivingBase> event) {
        GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.doPolygonOffset(1.0F, 2000000);
        GlStateManager.disablePolygonOffset();
    }

}
