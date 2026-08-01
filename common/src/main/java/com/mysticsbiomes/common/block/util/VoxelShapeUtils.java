package com.mysticsbiomes.common.block.util;

import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.BiFunction;
import java.util.function.Function;

public class VoxelShapeUtils {

    public static Function<Direction, VoxelShape> createShapeRotator(VoxelShape shape) {
        BiFunction<Direction, Integer, VoxelShape> rotator = createShapeRotator(new VoxelShape[]{shape});
        return (direction) -> rotator.apply(direction, 0);
    }

    public static BiFunction<Direction, Integer, VoxelShape> createShapeRotator(VoxelShape[] shapes) {
        return Util.memoize((direction, index) -> {
            VoxelShape shape = shapes[index];

            if (direction == Direction.NORTH) {
                return shape;
            }

            VoxelShape rotated = Shapes.empty();
            for (AABB box : shape.toAabbs()) {
                AABB rotatedBox = switch (direction) {
                    case EAST -> new AABB(1 - box.maxZ, box.minY, box.minX, 1 - box.minZ, box.maxY, box.maxX);
                    case SOUTH -> new AABB(1 - box.maxX, box.minY, 1 - box.maxZ, 1 - box.minX, box.maxY, 1 - box.minZ);
                    case WEST -> new AABB(box.minZ, box.minY, 1 - box.maxX, box.maxZ, box.maxY, 1 - box.minX);
                    default -> box;
                };

                rotated = Shapes.or(rotated, Shapes.create(rotatedBox));
            }

            return rotated.optimize();
        });
    }

}