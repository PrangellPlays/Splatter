package dev.prangellplays.splatter.block.ink;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import dev.prangellplays.splatter.components.inkling.PlayerLimeInklingComponent;
import dev.prangellplays.splatter.init.SplatterBlocks;
import dev.prangellplays.splatter.init.SplatterComponents;
import dev.prangellplays.splatter.init.SplatterTags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LimeInkBlock extends MultifaceGrowthBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;
    protected static final Direction[] DIRECTIONS;
    private static final VoxelShape UP_SHAPE;
    private static final VoxelShape DOWN_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape NORTH_SHAPE;
    private static final Map<Direction, VoxelShape> SHAPES_FOR_DIRECTIONS;
    private final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public LimeInkBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(WATERLOGGED, false));
        this.SHAPES = this.getShapesForStates(LimeInkBlock::getShapeForState);
    }

    private static VoxelShape getShapeForState(BlockState state) {
        VoxelShape voxelShape = VoxelShapes.empty();
        Direction[] var2 = DIRECTIONS;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Direction direction = var2[var4];
            if (hasDirection(state, direction)) {
                voxelShape = VoxelShapes.union(voxelShape, (VoxelShape)SHAPES_FOR_DIRECTIONS.get(direction));
            }
        }

        return voxelShape.isEmpty() ? VoxelShapes.fullCube() : voxelShape;
    }

    public static boolean canBreak(BlockState blockState) {
        return blockState.isIn(SplatterTags.INK_REPLACEABLE_PLANTS);
    }

    public static boolean canGrowOn(BlockView world, Direction direction, BlockPos pos, BlockState state) {
        return Block.isFaceFullSquare(state.getSidesShape(world, pos), direction.getOpposite()) || Block.isFaceFullSquare(state.getCollisionShape(world, pos), direction.getOpposite()) || state.getBlock() instanceof DirtPathBlock || state.getBlock() instanceof FarmlandBlock || direction.equals(Direction.DOWN) && state.getFluidState().isEqualAndStill(Fluids.WATER) && world.getBlockState(pos.offset(Direction.UP)).isAir();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return (VoxelShape)this.SHAPES.get(state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{WATERLOGGED});
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.getStack().isOf(SplatterBlocks.LIME_INK.asItem()) || super.canReplace(state, context);
    }

    public @Nullable BlockState withDirection(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (!this.canGrowWithDirection(world, state, pos, direction)) {
            return null;
        } else {
            BlockState blockState;
            if (state.isOf(this)) {
                blockState = state;
            } else if (this.isWaterlogged() && state.getFluidState().isEqualAndStill(Fluids.WATER)) {
                blockState = (BlockState)this.getDefaultState().with(Properties.WATERLOGGED, true);
            } else {
                blockState = this.getDefaultState();
            }

            return (BlockState)blockState.with(getProperty(direction), true);
        }
    }

    private boolean isWaterlogged() {
        return this.stateManager.getProperties().contains(Properties.WATERLOGGED);
    }

    public boolean canGrowWithDirection(BlockView world, BlockState state, BlockPos pos, Direction direction) {
        if (!this.canHaveDirection(direction) || state.isOf(this) && hasDirection(state, direction)) {
            return false;
        } else {
            BlockPos blockPos = pos.offset(direction);
            return canGrowOn(world, direction, blockPos, world.getBlockState(blockPos));
        }
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        boolean bl = false;
        Direction[] var5 = DIRECTIONS;
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Direction direction = var5[var7];
            if (hasDirection(state, direction)) {
                BlockPos blockPos = pos.offset(direction);
                if (!canGrowOn(world, direction, blockPos, world.getBlockState(blockPos))) {
                    return false;
                }

                bl = true;
            }
        }

        return bl;
    }

    public LichenGrower getGrower() {
        return null;
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    public VoxelShape getCollisionShape(@NotNull BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if ((Boolean)state.get(getProperty(Direction.DOWN)) && context instanceof EntityShapeContext entityShapeContext) {
            Entity var7 = entityShapeContext.getEntity();
            if (var7 instanceof PlayerEntity player) {
                if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isInkling()) {
                    return DOWN_SHAPE;
                }
            }

            if (entityShapeContext.getEntity() != null && entityShapeContext.getEntity().getType().equals(EntityType.FALLING_BLOCK)) {
                return DOWN_SHAPE;
            }
        }

        return VoxelShapes.empty();
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        DIRECTIONS = Direction.values();
        UP_SHAPE = Block.createCuboidShape(0.0, 15.9, 0.0, 16.0, 16.0, 16.0);
        DOWN_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 0.1, 16.0);
        EAST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 0.1, 16.0, 16.0);
        WEST_SHAPE = Block.createCuboidShape(15.9, 0.0, 0.0, 16.0, 16.0, 16.0);
        SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 0.1);
        NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 15.9, 16.0, 16.0, 16.0);
        SHAPES_FOR_DIRECTIONS = (Map) Util.make(Maps.newEnumMap(Direction.class), (shapes) -> {
            shapes.put(Direction.NORTH, SOUTH_SHAPE);
            shapes.put(Direction.EAST, WEST_SHAPE);
            shapes.put(Direction.SOUTH, NORTH_SHAPE);
            shapes.put(Direction.WEST, EAST_SHAPE);
            shapes.put(Direction.UP, UP_SHAPE);
            shapes.put(Direction.DOWN, DOWN_SHAPE);
        });
    }
}