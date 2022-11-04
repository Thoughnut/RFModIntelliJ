package com.thoughnut.rfmod.entity.custom;

import com.thoughnut.rfmod.util.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class AdLooijEntity extends SpiderEntity {
    public AdLooijEntity(EntityType<? extends SpiderEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 15.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D)
                .createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal( 0, new NearestAttackableTargetGoal<>( this, PlayerEntity.class, true ) );
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.TARGET_DRY_BABY));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 10 + this.world.rand.nextInt(20);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSoundEvents.AD_STIK_1.get();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSoundEvents.AD_STIK_2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return ModSoundEvents.LOOIJ.get();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn)
    {
        this.playSound(SoundEvents.ENTITY_HOGLIN_STEP, 0.10F, 0.5F);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (!super.attackEntityAsMob(entityIn)) {
            return false;
        } else {
            if (entityIn instanceof LivingEntity) {
                ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200,3));
                ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200));
                ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.NAUSEA, 400));
                ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200));
                ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 200, 2));
            }
            return true;
        }
    }

}
