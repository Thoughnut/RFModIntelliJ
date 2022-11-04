package com.thoughnut.rfmod.block.custom;

import com.thoughnut.rfmod.container.MeatGrinderContainer;
import com.thoughnut.rfmod.tileentity.MeatGrinderTile;
import com.thoughnut.rfmod.tileentity.ModTileEntitities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.io.Console;
import java.util.Arrays;
import java.util.stream.Stream;

public class AdLooijGrinderBlock extends HorizontalBlock {

    public AdLooijGrinderBlock(Properties builder) {
        super(builder);
    }

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(5, 0, 5, 11, 8, 16),
            Block.makeCuboidShape(7, 5, 1, 9, 7, 5),
            Block.makeCuboidShape(6, 4, 0, 10, 8, 1),
            Block.makeCuboidShape(7, 7, 2, 9, 14, 4),
            Block.makeCuboidShape(4, 14, 0, 12, 15, 13),
            Block.makeCuboidShape(4, 15, 0, 5, 16, 13),
            Block.makeCuboidShape(11, 15, 0, 12, 16, 13),
            Block.makeCuboidShape(5, 15, 0, 11, 16, 1),
            Block.makeCuboidShape(5, 15, 12, 11, 16, 13),
            Block.makeCuboidShape(4, 4, 7, 5, 6, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(5, 0, 5, 16, 8, 11),
            Block.makeCuboidShape(1, 5, 7, 5, 7, 9),
            Block.makeCuboidShape(0, 4, 6, 1, 8, 10),
            Block.makeCuboidShape(2, 7, 7, 4, 14, 9),
            Block.makeCuboidShape(0, 14, 4, 13, 15, 12),
            Block.makeCuboidShape(0, 15, 11, 13, 16, 12),
            Block.makeCuboidShape(0, 15, 4, 13, 16, 5),
            Block.makeCuboidShape(0, 15, 5, 1, 16, 11),
            Block.makeCuboidShape(12, 15, 5, 13, 16, 11),
            Block.makeCuboidShape(7, 4, 11, 9, 6, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_E =Stream.of(
            Block.makeCuboidShape(0, 0, 5, 11, 8, 11),
            Block.makeCuboidShape(11, 5, 7, 15, 7, 9),
            Block.makeCuboidShape(15, 4, 6, 16, 8, 10),
            Block.makeCuboidShape(12, 7, 7, 14, 14, 9),
            Block.makeCuboidShape(3, 14, 4, 16, 15, 12),
            Block.makeCuboidShape(3, 15, 4, 16, 16, 5),
            Block.makeCuboidShape(3, 15, 11, 16, 16, 12),
            Block.makeCuboidShape(15, 15, 5, 16, 16, 11),
            Block.makeCuboidShape(3, 15, 5, 4, 16, 11),
            Block.makeCuboidShape(7, 4, 4, 9, 6, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_S =Stream.of(
            Block.makeCuboidShape(5, 0, 0, 11, 8, 11),
            Block.makeCuboidShape(7, 5, 11, 9, 7, 15),
            Block.makeCuboidShape(6, 4, 15, 10, 8, 16),
            Block.makeCuboidShape(7, 7, 12, 9, 14, 14),
            Block.makeCuboidShape(4, 14, 3, 12, 15, 16),
            Block.makeCuboidShape(11, 15, 3, 12, 16, 16),
            Block.makeCuboidShape(4, 15, 3, 5, 16, 16),
            Block.makeCuboidShape(5, 15, 15, 11, 16, 16),
            Block.makeCuboidShape(5, 15, 3, 11, 16, 4),
            Block.makeCuboidShape(11, 4, 7, 12, 6, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get( HORIZONTAL_FACING)){
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;

        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        return true;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()){
            TileEntity tileEntity = worldIn.getTileEntity(pos);

            if(!player.isCrouching()){
                if(tileEntity instanceof MeatGrinderTile){
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn,pos);

                    NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileEntity.getPos());
                }else{
                    throw new IllegalStateException("Container provider missing");
                }
            }else{
                if(tileEntity instanceof MeatGrinderTile){
                    ((MeatGrinderTile)tileEntity).checkMeats(pos, worldIn);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.rfmod.meat_grinder");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new MeatGrinderContainer(i, worldIn,pos,playerInventory,playerEntity);
            }
        };
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntitities.MEAT_GRINDER_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
