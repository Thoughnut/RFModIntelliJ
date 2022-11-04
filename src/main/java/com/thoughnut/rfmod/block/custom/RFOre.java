package com.thoughnut.rfmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class RFOre extends Block {
    private LivingEntity ingniter;
    public RFOre(Properties properties) {
        super(properties);
    }


    @Override
    public void onPlayerDestroy(IWorld world, BlockPos pos, BlockState state) {
        if(!world.isRemote()){
            Minecraft.getInstance().player.sendChatMessage("Hartelijke dank voor deze mooie wens!");
        }
        super.onPlayerDestroy(world, pos, state);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        LightOnFire(entityIn, 3);

        if (!worldIn.isRemote) {
            worldIn.createExplosion(new TNTEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), ingniter), pos.getX(), pos.getY(), pos.getZ(), 9F, Explosion.Mode.BREAK);
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }



    public static void LightOnFire(Entity entityIn, int seconds){

        entityIn.setFire(seconds);
    }
}
