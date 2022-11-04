package com.thoughnut.rfmod.entity.model;

// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thoughnut.rfmod.entity.custom.AdLooijEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class AdLooijModel <T extends AdLooijEntity> extends EntityModel<T> {
    private final ModelRenderer Beenl;
    private final ModelRenderer Beenr;
    private final ModelRenderer Arml;
    private final ModelRenderer Armr;
    private final ModelRenderer Hoofd;
    private final ModelRenderer bb_main;
    private final ModelRenderer Neus_r1;


    public AdLooijModel() {
        textureWidth = 48;
        textureHeight = 54;

        Beenl = new ModelRenderer(this);
        Beenl.setRotationPoint(-2.0F, 12.0F, 2.0F);
        Beenl.setTextureOffset(16, 32).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

        Beenr = new ModelRenderer(this);
        Beenr.setRotationPoint(3.0F, 12.0F, 2.0F);
        Beenr.setTextureOffset(32, 0).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

        Arml = new ModelRenderer(this);
        Arml.setRotationPoint(-4.0F, 2.0F, 2.0F);
        Arml.setTextureOffset(0, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        Armr = new ModelRenderer(this);
        Armr.setRotationPoint(4.0F, 2.0F, 2.0F);
        Armr.setTextureOffset(24, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        Hoofd = new ModelRenderer(this);
        Hoofd.setRotationPoint(0.0F, 0.0F, 0.0F);
        Hoofd.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 16).addBox(-4.0F, -24.0F, 0.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
        bb_main.setTextureOffset(30, 32).addBox(-4.0F, -18.0F, -1.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(12, 32).addBox(-3.0F, -23.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        bb_main.setTextureOffset(20, 16).addBox(1.0F, -23.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        bb_main.setTextureOffset(24, 0).addBox(3.0F, -31.0F, 1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-5.0F, -31.0F, 1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        Neus_r1 = new ModelRenderer(this);
        Neus_r1.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(Neus_r1, -0.2618F, 0.0F, 0.0F);
        Neus_r1.setTextureOffset(30, 39).addBox(-1.0F, -27.0F, -10.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);}

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Beenr.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Beenl.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Armr.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.Arml.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;

    }
    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Beenl.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Beenr.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Arml.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Armr.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Hoofd.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Neus_r1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;


    }
}