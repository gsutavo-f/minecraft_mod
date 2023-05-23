package net.gutopzera.impizzamod.worldgen;

import net.gutopzera.impizzamod.ImpizzaMod;
import net.gutopzera.impizzamod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PAU_BRASIL_KEY = registerKey("pau_brasil");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        final int BASE_HEIGHT = 4;
        final int HEIGHT_RAND_A = 3;
        final int HEIGHT_RAND_B = 2;
        final int MIN_HEIGHT_FOR_LEAVES = 3;
        final IntProvider BEND_LENGTH = ConstantInt.of(1);

        final IntProvider RADIUS = ConstantInt.of(5);
        final IntProvider OFFSET = ConstantInt.of(0);
        final IntProvider FOLIAGE_HEIGHT = ConstantInt.of(5);
        final int LEAF_PLACEMENT_ATEMPTS = 256;
//        register(context, PAU_BRASIL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                BlockStateProvider.simple(ModBlocks.PAU_BRASIL_LOG.get()),
//                new StraightTrunkPlacer(4, 5, 3),
//                BlockStateProvider.simple(ModBlocks.PAU_BRASIL_LEAVES.get()),
//                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
//                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, PAU_BRASIL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PAU_BRASIL_LOG.get()),
                new ForkingTrunkPlacer(BASE_HEIGHT, HEIGHT_RAND_A, HEIGHT_RAND_B),
                BlockStateProvider.simple(ModBlocks.PAU_BRASIL_LEAVES.get()),
                new RandomSpreadFoliagePlacer(RADIUS, OFFSET, FOLIAGE_HEIGHT, LEAF_PLACEMENT_ATEMPTS),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ImpizzaMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
