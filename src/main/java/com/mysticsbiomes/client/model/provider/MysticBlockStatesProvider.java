package com.mysticsbiomes.client.model.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.MysticCandleCakeBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MysticBlockStatesProvider extends BlockStateProvider {

    public MysticBlockStatesProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, MysticsBiomes.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        MysticCandleCakeBlock.getMysticCandleCakes().forEach((block -> {
            MysticCandleCakeBlock cakeBlock = (MysticCandleCakeBlock)block;

            this.getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(state.getValue(BlockStateProperties.LIT) ? builder(cakeBlock, true) : builder(cakeBlock, false)).build());
        }));
    }

    private BlockModelBuilder builder(MysticCandleCakeBlock block, boolean lit) {
        String suffix = lit ? "_lit" : "";
        return this.models().withExistingParent(blockTexture(block).getPath() + suffix, "block/template_cake_with_candle").texture("bottom", blockTexture(block.getCake()) + "_bottom").texture("candle", blockTexture(block.getCandle()) + suffix).texture("particle", blockTexture(block.getCake()) + "_side").texture("side", blockTexture(block.getCake()) + "_side").texture("top", blockTexture(block.getCake()) + "_top");
    }

}