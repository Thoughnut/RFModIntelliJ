package com.thoughnut.rfmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class AdLooijFornuisBlock extends HorizontalBlock {

    public AdLooijFornuisBlock(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 1, 16, 12, 16),
            Block.makeCuboidShape(0, 12, 1, 1, 14, 2),
            Block.makeCuboidShape(15, 12, 1, 16, 14, 2),
            Block.makeCuboidShape(15, 12, 15, 16, 14, 16),
            Block.makeCuboidShape(0, 12, 15, 1, 14, 16),
            Block.makeCuboidShape(0, 13, 2, 1, 14, 15),
            Block.makeCuboidShape(15, 13, 2, 16, 14, 15),
            Block.makeCuboidShape(1, 13, 1, 15, 14, 2),
            Block.makeCuboidShape(1, 14, 8, 15, 15, 9),
            Block.makeCuboidShape(7, 14, 2, 9, 15, 8),
            Block.makeCuboidShape(7, 14, 9, 9, 15, 15),
            Block.makeCuboidShape(0, 11, 0, 16, 12, 1),
            Block.makeCuboidShape(1, 6, 0, 15, 7, 1),
            Block.makeCuboidShape(1, 13, 15, 15, 14, 16),
            Block.makeCuboidShape(2, 8, 0, 4, 10, 1),
            Block.makeCuboidShape(12, 8, 0, 14, 10, 1),
            Block.makeCuboidShape(9, 8, 0, 11, 10, 1),
            Block.makeCuboidShape(5, 8, 0, 7, 10, 1),
            Block.makeCuboidShape(7, 13, 2, 9, 14, 3),
            Block.makeCuboidShape(7, 13, 14, 9, 14, 15),
            Block.makeCuboidShape(0, 14, 4, 2, 15, 6),
            Block.makeCuboidShape(14, 14, 4, 16, 15, 6),
            Block.makeCuboidShape(11, 14, 1, 13, 15, 3),
            Block.makeCuboidShape(11, 14, 14, 13, 15, 16),
            Block.makeCuboidShape(14, 14, 11, 16, 15, 13),
            Block.makeCuboidShape(0, 14, 11, 2, 15, 13),
            Block.makeCuboidShape(3, 14, 14, 5, 15, 16),
            Block.makeCuboidShape(3, 14, 1, 5, 15, 3),
            Block.makeCuboidShape(3, 14, 7, 5, 15, 8),
            Block.makeCuboidShape(3, 14, 9, 5, 15, 10),
            Block.makeCuboidShape(11, 14, 7, 13, 15, 8),
            Block.makeCuboidShape(11, 14, 9, 13, 15, 10),
            Block.makeCuboidShape(6, 14, 4, 7, 15, 6),
            Block.makeCuboidShape(9, 14, 4, 10, 15, 6),
            Block.makeCuboidShape(6, 14, 11, 7, 15, 13),
            Block.makeCuboidShape(9, 14, 11, 10, 15, 13),
            Block.makeCuboidShape(1, 13, 8, 2, 14, 9),
            Block.makeCuboidShape(14, 13, 8, 15, 14, 9),
            Block.makeCuboidShape(2, 12, 4, 6, 13, 6),
            Block.makeCuboidShape(3, 13, 4, 5, 14, 6),
            Block.makeCuboidShape(3, 12, 10, 5, 13, 11),
            Block.makeCuboidShape(3, 12, 13, 5, 13, 14),
            Block.makeCuboidShape(2, 12, 11, 6, 13, 13),
            Block.makeCuboidShape(3, 13, 11, 5, 14, 13),
            Block.makeCuboidShape(11, 12, 10, 13, 13, 11),
            Block.makeCuboidShape(11, 12, 13, 13, 13, 14),
            Block.makeCuboidShape(10, 12, 11, 14, 13, 13),
            Block.makeCuboidShape(11, 13, 11, 13, 14, 13),
            Block.makeCuboidShape(11, 12, 3, 13, 13, 4),
            Block.makeCuboidShape(11, 12, 6, 13, 13, 7),
            Block.makeCuboidShape(10, 12, 4, 14, 13, 6),
            Block.makeCuboidShape(11, 13, 4, 13, 14, 6),
            Block.makeCuboidShape(3, 12, 6, 5, 13, 7),
            Block.makeCuboidShape(3, 12, 3, 5, 13, 4)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 0, 0, 16, 12, 16),
            Block.makeCuboidShape(1, 12, 15, 2, 14, 16),
            Block.makeCuboidShape(1, 12, 0, 2, 14, 1),
            Block.makeCuboidShape(15, 12, 0, 16, 14, 1),
            Block.makeCuboidShape(15, 12, 15, 16, 14, 16),
            Block.makeCuboidShape(2, 13, 15, 15, 14, 16),
            Block.makeCuboidShape(2, 13, 0, 15, 14, 1),
            Block.makeCuboidShape(1, 13, 1, 2, 14, 15),
            Block.makeCuboidShape(8, 14, 1, 9, 15, 15),
            Block.makeCuboidShape(2, 14, 7, 8, 15, 9),
            Block.makeCuboidShape(9, 14, 7, 15, 15, 9),
            Block.makeCuboidShape(0, 11, 0, 1, 12, 16),
            Block.makeCuboidShape(0, 6, 1, 1, 7, 15),
            Block.makeCuboidShape(15, 13, 1, 16, 14, 15),
            Block.makeCuboidShape(0, 8, 12, 1, 10, 14),
            Block.makeCuboidShape(0, 8, 2, 1, 10, 4),
            Block.makeCuboidShape(0, 8, 5, 1, 10, 7),
            Block.makeCuboidShape(0, 8, 9, 1, 10, 11),
            Block.makeCuboidShape(2, 13, 7, 3, 14, 9),
            Block.makeCuboidShape(14, 13, 7, 15, 14, 9),
            Block.makeCuboidShape(4, 14, 14, 6, 15, 16),
            Block.makeCuboidShape(4, 14, 0, 6, 15, 2),
            Block.makeCuboidShape(1, 14, 3, 3, 15, 5),
            Block.makeCuboidShape(14, 14, 3, 16, 15, 5),
            Block.makeCuboidShape(11, 14, 0, 13, 15, 2),
            Block.makeCuboidShape(11, 14, 14, 13, 15, 16),
            Block.makeCuboidShape(14, 14, 11, 16, 15, 13),
            Block.makeCuboidShape(1, 14, 11, 3, 15, 13),
            Block.makeCuboidShape(7, 14, 11, 8, 15, 13),
            Block.makeCuboidShape(9, 14, 11, 10, 15, 13),
            Block.makeCuboidShape(7, 14, 3, 8, 15, 5),
            Block.makeCuboidShape(9, 14, 3, 10, 15, 5),
            Block.makeCuboidShape(4, 14, 9, 6, 15, 10),
            Block.makeCuboidShape(4, 14, 6, 6, 15, 7),
            Block.makeCuboidShape(11, 14, 9, 13, 15, 10),
            Block.makeCuboidShape(11, 14, 6, 13, 15, 7),
            Block.makeCuboidShape(8, 13, 14, 9, 14, 15),
            Block.makeCuboidShape(8, 13, 1, 9, 14, 2),
            Block.makeCuboidShape(4, 12, 10, 6, 13, 14),
            Block.makeCuboidShape(4, 13, 11, 6, 14, 13),
            Block.makeCuboidShape(10, 12, 11, 11, 13, 13),
            Block.makeCuboidShape(13, 12, 11, 14, 13, 13),
            Block.makeCuboidShape(11, 12, 10, 13, 13, 14),
            Block.makeCuboidShape(11, 13, 11, 13, 14, 13),
            Block.makeCuboidShape(10, 12, 3, 11, 13, 5),
            Block.makeCuboidShape(13, 12, 3, 14, 13, 5),
            Block.makeCuboidShape(11, 12, 2, 13, 13, 6),
            Block.makeCuboidShape(11, 13, 3, 13, 14, 5),
            Block.makeCuboidShape(3, 12, 3, 4, 13, 5),
            Block.makeCuboidShape(6, 12, 3, 7, 13, 5),
            Block.makeCuboidShape(4, 12, 2, 6, 13, 6),
            Block.makeCuboidShape(4, 13, 3, 6, 14, 5),
            Block.makeCuboidShape(6, 12, 11, 7, 13, 13),
            Block.makeCuboidShape(3, 12, 11, 4, 13, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_E =Stream.of(
            Block.makeCuboidShape(0, 0, 0, 15, 12, 16),
            Block.makeCuboidShape(14, 12, 0, 15, 14, 1),
            Block.makeCuboidShape(14, 12, 15, 15, 14, 16),
            Block.makeCuboidShape(0, 12, 15, 1, 14, 16),
            Block.makeCuboidShape(0, 12, 0, 1, 14, 1),
            Block.makeCuboidShape(1, 13, 0, 14, 14, 1),
            Block.makeCuboidShape(1, 13, 15, 14, 14, 16),
            Block.makeCuboidShape(14, 13, 1, 15, 14, 15),
            Block.makeCuboidShape(7, 14, 1, 8, 15, 15),
            Block.makeCuboidShape(8, 14, 7, 14, 15, 9),
            Block.makeCuboidShape(1, 14, 7, 7, 15, 9),
            Block.makeCuboidShape(15, 11, 0, 16, 12, 16),
            Block.makeCuboidShape(15, 6, 1, 16, 7, 15),
            Block.makeCuboidShape(0, 13, 1, 1, 14, 15),
            Block.makeCuboidShape(15, 8, 2, 16, 10, 4),
            Block.makeCuboidShape(15, 8, 12, 16, 10, 14),
            Block.makeCuboidShape(15, 8, 9, 16, 10, 11),
            Block.makeCuboidShape(15, 8, 5, 16, 10, 7),
            Block.makeCuboidShape(13, 13, 7, 14, 14, 9),
            Block.makeCuboidShape(1, 13, 7, 2, 14, 9),
            Block.makeCuboidShape(10, 14, 0, 12, 15, 2),
            Block.makeCuboidShape(10, 14, 14, 12, 15, 16),
            Block.makeCuboidShape(13, 14, 11, 15, 15, 13),
            Block.makeCuboidShape(0, 14, 11, 2, 15, 13),
            Block.makeCuboidShape(3, 14, 14, 5, 15, 16),
            Block.makeCuboidShape(3, 14, 0, 5, 15, 2),
            Block.makeCuboidShape(0, 14, 3, 2, 15, 5),
            Block.makeCuboidShape(13, 14, 3, 15, 15, 5),
            Block.makeCuboidShape(8, 14, 3, 9, 15, 5),
            Block.makeCuboidShape(6, 14, 3, 7, 15, 5),
            Block.makeCuboidShape(8, 14, 11, 9, 15, 13),
            Block.makeCuboidShape(6, 14, 11, 7, 15, 13),
            Block.makeCuboidShape(10, 14, 6, 12, 15, 7),
            Block.makeCuboidShape(10, 14, 9, 12, 15, 10),
            Block.makeCuboidShape(3, 14, 6, 5, 15, 7),
            Block.makeCuboidShape(3, 14, 9, 5, 15, 10),
            Block.makeCuboidShape(7, 13, 1, 8, 14, 2),
            Block.makeCuboidShape(7, 13, 14, 8, 14, 15),
            Block.makeCuboidShape(10, 12, 2, 12, 13, 6),
            Block.makeCuboidShape(10, 13, 3, 12, 14, 5),
            Block.makeCuboidShape(5, 12, 3, 6, 13, 5),
            Block.makeCuboidShape(2, 12, 3, 3, 13, 5),
            Block.makeCuboidShape(3, 12, 2, 5, 13, 6),
            Block.makeCuboidShape(3, 13, 3, 5, 14, 5),
            Block.makeCuboidShape(5, 12, 11, 6, 13, 13),
            Block.makeCuboidShape(2, 12, 11, 3, 13, 13),
            Block.makeCuboidShape(3, 12, 10, 5, 13, 14),
            Block.makeCuboidShape(3, 13, 11, 5, 14, 13),
            Block.makeCuboidShape(12, 12, 11, 13, 13, 13),
            Block.makeCuboidShape(9, 12, 11, 10, 13, 13),
            Block.makeCuboidShape(10, 12, 10, 12, 13, 14),
            Block.makeCuboidShape(10, 13, 11, 12, 14, 13),
            Block.makeCuboidShape(9, 12, 3, 10, 13, 5),
            Block.makeCuboidShape(12, 12, 3, 13, 13, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_S =Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 12, 15),
            Block.makeCuboidShape(15, 12, 14, 16, 14, 15),
            Block.makeCuboidShape(0, 12, 14, 1, 14, 15),
            Block.makeCuboidShape(0, 12, 0, 1, 14, 1),
            Block.makeCuboidShape(15, 12, 0, 16, 14, 1),
            Block.makeCuboidShape(15, 13, 1, 16, 14, 14),
            Block.makeCuboidShape(0, 13, 1, 1, 14, 14),
            Block.makeCuboidShape(1, 13, 14, 15, 14, 15),
            Block.makeCuboidShape(1, 14, 7, 15, 15, 8),
            Block.makeCuboidShape(7, 14, 8, 9, 15, 14),
            Block.makeCuboidShape(7, 14, 1, 9, 15, 7),
            Block.makeCuboidShape(0, 11, 15, 16, 12, 16),
            Block.makeCuboidShape(1, 6, 15, 15, 7, 16),
            Block.makeCuboidShape(1, 13, 0, 15, 14, 1),
            Block.makeCuboidShape(12, 8, 15, 14, 10, 16),
            Block.makeCuboidShape(2, 8, 15, 4, 10, 16),
            Block.makeCuboidShape(5, 8, 15, 7, 10, 16),
            Block.makeCuboidShape(9, 8, 15, 11, 10, 16),
            Block.makeCuboidShape(7, 13, 13, 9, 14, 14),
            Block.makeCuboidShape(7, 13, 1, 9, 14, 2),
            Block.makeCuboidShape(14, 14, 10, 16, 15, 12),
            Block.makeCuboidShape(0, 14, 10, 2, 15, 12),
            Block.makeCuboidShape(3, 14, 13, 5, 15, 15),
            Block.makeCuboidShape(3, 14, 0, 5, 15, 2),
            Block.makeCuboidShape(0, 14, 3, 2, 15, 5),
            Block.makeCuboidShape(14, 14, 3, 16, 15, 5),
            Block.makeCuboidShape(11, 14, 0, 13, 15, 2),
            Block.makeCuboidShape(11, 14, 13, 13, 15, 15),
            Block.makeCuboidShape(11, 14, 8, 13, 15, 9),
            Block.makeCuboidShape(11, 14, 6, 13, 15, 7),
            Block.makeCuboidShape(3, 14, 8, 5, 15, 9),
            Block.makeCuboidShape(3, 14, 6, 5, 15, 7),
            Block.makeCuboidShape(9, 14, 10, 10, 15, 12),
            Block.makeCuboidShape(6, 14, 10, 7, 15, 12),
            Block.makeCuboidShape(9, 14, 3, 10, 15, 5),
            Block.makeCuboidShape(6, 14, 3, 7, 15, 5),
            Block.makeCuboidShape(14, 13, 7, 15, 14, 8),
            Block.makeCuboidShape(1, 13, 7, 2, 14, 8),
            Block.makeCuboidShape(10, 12, 10, 14, 13, 12),
            Block.makeCuboidShape(11, 13, 10, 13, 14, 12),
            Block.makeCuboidShape(11, 12, 5, 13, 13, 6),
            Block.makeCuboidShape(11, 12, 2, 13, 13, 3),
            Block.makeCuboidShape(10, 12, 3, 14, 13, 5),
            Block.makeCuboidShape(11, 13, 3, 13, 14, 5),
            Block.makeCuboidShape(3, 12, 5, 5, 13, 6),
            Block.makeCuboidShape(3, 12, 2, 5, 13, 3),
            Block.makeCuboidShape(2, 12, 3, 6, 13, 5),
            Block.makeCuboidShape(3, 13, 3, 5, 14, 5),
            Block.makeCuboidShape(3, 12, 12, 5, 13, 13),
            Block.makeCuboidShape(3, 12, 9, 5, 13, 10),
            Block.makeCuboidShape(2, 12, 10, 6, 13, 12),
            Block.makeCuboidShape(3, 13, 10, 5, 14, 12),
            Block.makeCuboidShape(11, 12, 9, 13, 13, 10),
            Block.makeCuboidShape(11, 12, 12, 13, 13, 13)
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
}
