package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.common.block.ChrysalisBlock;
import com.mysticsbiomes.common.block.entity.ChrysalisBlockEntity;
import com.mysticsbiomes.common.entity.ai.FoodHelper;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class Caterpillar extends Animal {
    private static final EntityDataAccessor<Boolean> DATA_CLIMBING_ID = SynchedEntityData.defineId(Caterpillar.class, EntityDataSerializers.BOOLEAN);
    private static final int ticksTillAgeUp = Math.abs(-24000);
    private int age;
    private int ticksSinceLastEaten;
    public Butterfly.Type butterflyType = Butterfly.Type.MONARCH;

    public Caterpillar(EntityType<? extends Caterpillar> entity, Level level) {
        super(entity, level);
        this.moveControl = new MoveControl(this);
        this.setMaxUpStep(0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CreateChrysalisGoal(this));
        this.goalSelector.addGoal(2, new TemptGoal(this, 0.4D, this.food().asIngredient(), false));
        this.goalSelector.addGoal(3, new EatGardenCropsGoal(this, 0.6D, 8));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.4D));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_CLIMBING_ID, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.butterflyType.getSerializedName());
        tag.putInt("TicksSinceEaten", this.ticksSinceLastEaten);
        tag.putInt("Age", this.age);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.butterflyType = Butterfly.Type.byName(tag.getString("Type"));
        this.ticksSinceLastEaten = tag.getInt("TicksSinceEaten");
        this.age = tag.getInt("Age");
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance instance, MobSpawnType spawnType, SpawnGroupData data, CompoundTag tag) {
        if (this.butterflyType == null) {
            this.butterflyType = Butterfly.Type.byId(this.random.nextInt(3));
        }

        return super.finalizeSpawn(level, instance, spawnType, data, tag);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {
            this.setClimbing(this.horizontalCollision);

            if (this.isClimbing() && !this.onGround() && this.getDeltaMovement().y < 0) {
                this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0, 1));
            }
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            this.setAge(++this.age + 1);

            ++this.ticksSinceLastEaten;
        }
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WallClimberNavigation(this, level);
    }

    @Override
    protected void checkFallDamage(double amount, boolean immune, BlockState state, BlockPos pos) {
    }

    @Override
    public boolean onClimbable() {
        BlockState state = this.level().getBlockState((this.blockPosition()));
        return this.isClimbing()
                && !state.is(BlockTags.WALLS)
                && !state.is(BlockTags.FENCES)
                && !state.is(BlockTags.FENCE_GATES);
    }

    public boolean isClimbing() {
        return this.entityData.get(DATA_CLIMBING_ID);
    }

    public void setClimbing(boolean climbing) {
        this.entityData.set(DATA_CLIMBING_ID, climbing);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int amount) {
        this.age = amount;
    }

    private boolean isReadyToAgeUp() {
        return this.age > ticksTillAgeUp;
    }

    private boolean isHungry() {
        return this.ticksSinceLastEaten > 2400; /// every 2 minutes
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return this.food().test(stack);
    }

    private FoodHelper food() {
        return new FoodHelper().tags(ItemTags.FLOWERS).items(Items.SWEET_BERRIES, Items.GLOW_BERRIES, Items.APPLE, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE, Items.CHORUS_FRUIT, Items.MELON_SLICE, Items.CARROT, Items.GOLDEN_CARROT, Items.POTATO, Items.BEETROOT);
    }

    private static class EatGardenCropsGoal extends MoveToBlockGoal {
        private final Caterpillar caterpillar;
        private final Level level;
        private int ticksEating;

        public EatGardenCropsGoal(Caterpillar mob, double speed, int searchRange) {
            super(mob, speed, searchRange, searchRange);
            this.caterpillar = mob;
            this.level = mob.level();
        }

        @Override
        public boolean canUse() {
            if (!this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                return false;
            } else {
                return super.canUse() && this.caterpillar.isHungry();
            }
        }

        @Override
        public void tick() {
            super.tick();

            if (!this.isReachedTarget()) {
                this.caterpillar.getLookControl().setLookAt((double)this.blockPos.getX() + 0.5, (this.blockPos.getY() + 1), (double)this.blockPos.getZ() + 0.5, 10.0F, (float)this.caterpillar.getMaxHeadXRot());
            } else {
                BlockPos pos = this.blockPos.above();
                BlockState state = this.level.getBlockState(pos);
                if (state.getBlock() instanceof CropBlock crop && crop.isMaxAge(state)) {
                    if (this.caterpillar.tickCount % 25 == 0) {
                        for (int i = 0; i < 3; ++i) {
                            Vec3 eyePos = this.caterpillar.getEyePosition();
                            ((ServerLevel)this.level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, crop.getStateForAge(crop.getMaxAge())), eyePos.x, eyePos.y, eyePos.z, 50, this.caterpillar.getBbWidth() / 4.0F, this.caterpillar.getBbHeight() / 4.0F, this.caterpillar.getBbWidth() / 4.0F, 0.05D);
                        }
                        this.level.playSound(null, this.caterpillar.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.AMBIENT, 0.7F, 0.9F + this.level.random.nextFloat() * 0.2F);
                    }

                    ++this.ticksEating;
                    if (this.ticksEating > 100) {
                        this.level.removeBlock(pos, false);
                        this.level.gameEvent(this.caterpillar, GameEvent.BLOCK_DESTROY, pos);
                        this.caterpillar.ticksSinceLastEaten = 0;
                        this.ticksEating = 0;
                    }
                }
            }
        }

        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            BlockState state = level.getBlockState(pos);
            if (state.is(Blocks.FARMLAND)) {
                state = level.getBlockState(pos.above());
                return state.getBlock() instanceof CropBlock crop && crop.isMaxAge(state);
            }

            return false;
        }
    }

    private static class CreateChrysalisGoal extends MoveToBlockGoal {
        private final Caterpillar caterpillar;
        private BlockPos pos = BlockPos.ZERO;
        private Direction direction = Direction.NORTH;

        public CreateChrysalisGoal(Caterpillar mob) {
            super(mob, 0.5D, 16, 16);
            this.caterpillar = mob;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.caterpillar.isReadyToAgeUp();
        }

        @Override
        public void tick() {
            super.tick();
            Level level = this.caterpillar.level();
            this.caterpillar.getLookControl().setLookAt(this.pos.getX() + 0.5D, this.pos.getY() + 1, this.pos.getZ() + 0.5D, 10.0F, this.caterpillar.getMaxHeadXRot());

            BlockPos pos = this.blockPos;
            if (this.isValidTarget(level, pos)) {
                if (this.isReachedTarget()) {
                    level.setBlockAndUpdate(pos, MysticBlocks.CHRYSALIS.get().defaultBlockState().setValue(ChrysalisBlock.FACING, this.direction.getOpposite()));
                    level.playSound(null, this.caterpillar.blockPosition(), SoundEvents.AZALEA_LEAVES_PLACE, SoundSource.BLOCKS, 0.7F, 0.9F + level.random.nextFloat() * 0.2F);

                    if (level.getBlockEntity(pos) instanceof ChrysalisBlockEntity entity) {
                        entity.addInhabitant(this.caterpillar);
                    }
                }
            }
        }

        @Override
        protected BlockPos getMoveToTarget() {
            return this.pos.above();
        }

        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            if (level.getBlockState(pos).isAir()) {
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    if (level.getBlockState(pos.relative(direction)).is(BlockTags.LOGS) && level.getBlockState(pos.relative(direction).below()).is(BlockTags.LOGS)) {
                        this.pos = pos.relative(direction);
                        this.direction = direction;
                        return true;
                    }
                }

                return false;
            }

            return false;
        }

        @Override
        protected void moveMobToBlock() {
            this.caterpillar.getNavigation().moveTo(this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D, this.speedModifier);
        }
    }

}