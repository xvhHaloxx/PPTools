package halo.pp.tools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PPTools implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("pptools");

	// MOD ID

	public static final String modid = "pptools";

	// PP ITEM

	public static final Item PP = new Item(new Item.Settings().group(ItemGroup.MATERIALS).food(PPFood.PP).group(ItemGroup.FOOD).group(CustomCreativeTabs.PPTAB));

	// RAW PP ITEM

	public static final Item RAW_PP = new Item(new Item.Settings().group(ItemGroup.MATERIALS).group(CustomCreativeTabs.PPTAB));

	// CUM BLOCK

	public static final Block CUM_BLOCK = new Block(FabricBlockSettings.of(Material.SOIL).strength(0.2F, 0.2F)
		.sounds(BlockSoundGroup.SLIME).breakByTool(FabricToolTags.SHOVELS));

	// PP ORE ITEM

	public static final Block DICK_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3, 9)
		.sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));

	// PP ARMOR

	public static final ArmorMaterial DICK_ARMOR = new Armor();

	// PP ORE

	public static ConfiguredFeature<?, ?> DICK_ORE_END = Feature.ORE
    .configure(new OreFeatureConfig(
      new BlockMatchRuleTest(Blocks.END_STONE), // Base block is end stone in The End biomes
      PPTools.DICK_ORE.getDefaultState(),
      3))
    .range(new RangeDecoratorConfig(
      UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(38))))
    .spreadHorizontally()
    .repeat(4);


	@Override
	public void onInitialize() {

		// REGISTERS ITEMS
		
		Registry.register(Registry.ITEM, new Identifier("pptools", "pp"), PP);
		Registry.register(Registry.ITEM, new Identifier("pptools", "raw_pp"), RAW_PP);
		Registry.register(Registry.BLOCK, new Identifier("pptools", "cum_block"), CUM_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("pptools", "dick_ore"), DICK_ORE);

		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_pickaxe"), new PickaxeBase(new Tools()));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_axe"), new AxeBase(new Tools()));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_sword"), new SwordBase(new Tools()));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_hoe"), new HoeBase(new Tools()));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_shovel"), new ShovelBase(new Tools()));

		// REGISTERS BLOCKS

		Registry.register(Registry.ITEM, new Identifier("pptools", "cum_block"), new BlockItem(CUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).group(CustomCreativeTabs.PPTAB)));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_ore"), new BlockItem(DICK_ORE, new Item.Settings().group(ItemGroup.MATERIALS).group(CustomCreativeTabs.PPTAB)));

		// REGISTERS ARMOR

		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_helmet"), new BaseArmor(DICK_ARMOR, EquipmentSlot.HEAD));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_chestplate"), new BaseArmor(DICK_ARMOR, EquipmentSlot.CHEST));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_leggings"), new BaseArmor(DICK_ARMOR, EquipmentSlot.LEGS));
		Registry.register(Registry.ITEM, new Identifier("pptools", "dick_boots"), new BaseArmor(DICK_ARMOR, EquipmentSlot.FEET));

		// SPAWNS PP ORE IN END

		RegistryKey<ConfiguredFeature<?, ?>> dickOreEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
        	new Identifier("pptools", "dick_ore"));
    	Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, dickOreEnd.getValue(), DICK_ORE_END);
    	BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, dickOreEnd);
	}
}
