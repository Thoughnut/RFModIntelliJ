package com.thoughnut.rfmod.tileentity;

import com.thoughnut.rfmod.item.ModItems;
import com.thoughnut.rfmod.util.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MeatGrinderTile extends TileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);


    public MeatGrinderTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public MeatGrinderTile(){
        this(ModTileEntitities.MEAT_GRINDER_TILE.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));

        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler(){
        return new ItemStackHandler(5) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot){
                    case 0: return stack.getItem() == Items.PORKCHOP;
                    case 1: return stack.getItem() == Items.BEEF;
                    case 2: return stack.getItem() == Items.MUTTON;
                    case 3: return stack.getItem() == Items.CHICKEN;
                    case 4: return stack.getItem() == ModItems.GROUND_BEEF.get();
                    default:
                        return false;
                }
            }
            //maximum of 1 item per slot
           // @Override
          //  public int getSlotLimit(int slot) {
       //         return 1;
       //     }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack)){
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    public void checkMeats(BlockPos pos, World worldIn){
        boolean hasPorkFirstSlot = this.itemHandler.getStackInSlot(0).getCount() >0
                && this.itemHandler.getStackInSlot(0).getItem() == Items.PORKCHOP;
        boolean hasBeefSecondSlot= this.itemHandler.getStackInSlot(1).getCount() >0
                && this.itemHandler.getStackInSlot(1).getItem() == Items.BEEF;
        boolean hasMuttonThirdSlot= this.itemHandler.getStackInSlot(2).getCount() >0
                && this.itemHandler.getStackInSlot(2).getItem() == Items.MUTTON;
        boolean hasChickenFourthSlot= this.itemHandler.getStackInSlot(3).getCount() >0
                && this.itemHandler.getStackInSlot(3).getItem() == Items.CHICKEN;

        if(hasChickenFourthSlot && hasMuttonThirdSlot && hasBeefSecondSlot && hasPorkFirstSlot && this.itemHandler.getStackInSlot(4).getCount()<64){
            this.itemHandler.getStackInSlot(0).shrink(1);
            this.itemHandler.getStackInSlot(1).shrink(1);
            this.itemHandler.getStackInSlot(2).shrink(1);
            this.itemHandler.getStackInSlot(3).shrink(1);


            if(this.itemHandler.getStackInSlot(4).getCount() >0){
                this.itemHandler.getStackInSlot(4).grow(1);
            }else{
                this.itemHandler.insertItem(4, new ItemStack(ModItems.GROUND_BEEF.get()), false);
            }
            if(!worldIn.isRemote()){
                worldIn.playSound(null, pos, ModSoundEvents.GRIND.get(), SoundCategory.BLOCKS,1,1);
            }

        }

    }
}
