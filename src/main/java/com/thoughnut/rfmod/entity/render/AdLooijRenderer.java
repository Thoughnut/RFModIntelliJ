package com.thoughnut.rfmod.entity.render;

import com.thoughnut.rfmod.RFMod;
import com.thoughnut.rfmod.entity.custom.AdLooijEntity;
import com.thoughnut.rfmod.entity.model.AdLooijModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AdLooijRenderer extends MobRenderer<AdLooijEntity, AdLooijModel<AdLooijEntity>> {

    protected static final ResourceLocation TEXTURE= new ResourceLocation(RFMod.MOD_ID, "textures/entity/ad_looij.png");

    public AdLooijRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new AdLooijModel<>(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(AdLooijEntity entity) {
        return TEXTURE;
    }
}
