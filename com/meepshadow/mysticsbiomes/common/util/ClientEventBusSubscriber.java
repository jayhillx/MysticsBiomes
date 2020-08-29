package com.meepshadow.mysticsbiomes.common.util;

import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import com.meepshadow.mysticsbiomes.init.ModBlock;
import com.meepshadow.mysticsbiomes.common.util.library.DataUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MysticsBiomes.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        //Plants
        RenderTypeLookup.setRenderLayer(ModBlock.LAVENDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.PASSION_ROSE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.FLOWERING_VINES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.STRAWBERRY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SWEET_STRAWBERRY_BUSH.get(), RenderType.getCutout());
        //Doors
        RenderTypeLookup.setRenderLayer(ModBlock.DANDELION_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.EVERGREEN_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SEAFOAM_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.TROPICAL_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.STRAWBERRY_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SWEET_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.LAVENDER_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.WISP_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.FROSTED_DOOR.get(), RenderType.getCutout());
        //Trapdoors
        RenderTypeLookup.setRenderLayer(ModBlock.DANDELION_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.EVERGREEN_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SEAFOAM_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.TROPICAL_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.STRAWBERRY_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SWEET_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.LAVENDER_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.WISP_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.FROSTED_TRAPDOOR.get(), RenderType.getCutout());
        //Saplings
        RenderTypeLookup.setRenderLayer(ModBlock.DANDELION_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.EVERGREEN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SEAFOAM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.TROPICAL_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.STRAWBERRY_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SWEET_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.LAVENDER_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.WISP_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.FROSTED_SAPLING.get(), RenderType.getCutout());
    }

    public static void registerFlammables() {
        DataUtils.registerFlammable(ModBlock.STRAWBERRY_BLOSSOMS.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.SWEET_BLOSSOMS.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.WISP_BLOSSOMS.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.LAVENDER_BLOSSOMS.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.FROSTED_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.TROPICAL_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.SEAFOAM_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.EVERGREEN_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.DANDELION_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlock.STRIPPED_STRAWBERRY_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.STRAWBERRY_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRAWBERRY_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRAWBERRY_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRAWBERRY_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRAWBERRY_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_SWEET_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.SWEET_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SWEET_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SWEET_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SWEET_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SWEET_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_WISP_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.WISP_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.WISP_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.WISP_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.WISP_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.WISP_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_LAVENDER_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.LAVENDER_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.LAVENDER_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.LAVENDER_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.LAVENDER_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.LAVENDER_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_FROSTED_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.FROSTED_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.FROSTED_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.FROSTED_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.FROSTED_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.FROSTED_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_TROPICAL_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.TROPICAL_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.TROPICAL_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.TROPICAL_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.TROPICAL_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.TROPICAL_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_SEAFOAM_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.SEAFOAM_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SEAFOAM_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SEAFOAM_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SEAFOAM_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.SEAFOAM_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_EVERGREEN_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.EVERGREEN_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.EVERGREEN_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.EVERGREEN_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.EVERGREEN_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.EVERGREEN_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.STRIPPED_DANDELION_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlock.DANDELION_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.DANDELION_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.DANDELION_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.DANDELION_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.DANDELION_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlock.LAVENDER.get(), 60, 100);
        DataUtils.registerFlammable(ModBlock.PASSION_ROSE.get(), 60, 100);
        DataUtils.registerFlammable(ModBlock.FLOWERING_VINES.get(), 60, 100);
        DataUtils.registerFlammable(ModBlock.STRAWBERRY_BUSH.get(), 60, 100);
        DataUtils.registerFlammable(ModBlock.SWEET_STRAWBERRY_BUSH.get(), 60, 100);
    }
}
