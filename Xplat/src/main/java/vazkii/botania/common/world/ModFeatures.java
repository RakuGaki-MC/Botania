/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.common.world;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.BiConsumer;

import static vazkii.botania.common.lib.ResourceLocationHelper.prefix;

public class ModFeatures {
	public static final ResourceKey<PlacedFeature> MYSTICAL_FLOWERS_ID = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, prefix("mystical_flowers"));
	public static final ResourceKey<PlacedFeature> MYSTICAL_MUSHROOMS_ID = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, prefix("mystical_mushrooms"));
	public static Holder<PlacedFeature> mysticalFlowersPlaced = null;

	/* todo 1.19 tags
	public static final Set<Biome.BiomeCategory> TYPE_BLACKLIST = ImmutableSet.of(
			Biome.BiomeCategory.NETHER,
			Biome.BiomeCategory.THEEND,
			Biome.BiomeCategory.ICY,
			Biome.BiomeCategory.MUSHROOM
	);
	*/

	public static void registerFeatures(BiConsumer<Feature<?>, ResourceLocation> r) {
		var flowersId = MYSTICAL_FLOWERS_ID.location();
		var flowers = new MysticalFlowerFeature();
		r.accept(flowers, flowersId);

		var configuredFlowers = FeatureUtils.register(flowersId.toString(), flowers, new MysticalFlowerConfig(6, 2, 2, 16, 0.05));

		mysticalFlowersPlaced = PlacementUtils.register(flowersId.toString(), configuredFlowers);
		SkyblockChunkGenerator.init();
	}

}
