package resourceManagement;

import blueprints.Blueprint;
import components.NamesLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.FileUtils;
import utils.MyFile;

public class BlueprintRepository {
	private static final MyFile ENTITY_FOLDER = new MyFile(FileUtils.RES_FOLDER, "entities");
  
	private static Map<Integer, Blueprint> blueprints = new HashMap<>();
  
	public static Blueprint getBlueprint(int id) {
		return blueprints.get(Integer.valueOf(id));
	}
  
	public static Map<List<String>, File> customEntities;
  
	public static void loadAllBlueprints(boolean backgroundLoad) {
		NamesLoader.loadUpNames();
		loadNewBlueprint("1_Sheep", backgroundLoad);
		loadNewBlueprint("2_Oak", backgroundLoad);
		loadNewBlueprint("3_BerryBush", backgroundLoad);
		loadNewBlueprint("4_JuniperTree", backgroundLoad);
		loadNewBlueprint("5_Acer", backgroundLoad);
		loadNewBlueprint("6_Rocks", backgroundLoad);
		loadNewBlueprint("7_Heather", backgroundLoad);
		loadNewBlueprint("8_Chicken", backgroundLoad);
		loadNewBlueprint("9_Pebbles", backgroundLoad);
		loadNewBlueprint("10_Fern", backgroundLoad);
		loadNewBlueprint("11_Wheat", backgroundLoad);
		loadNewBlueprint("12_Tortoise", backgroundLoad);
		loadNewBlueprint("13_Kelp", backgroundLoad);
		loadNewBlueprint("14_Trout", backgroundLoad);
		loadNewBlueprint("15_Herring", backgroundLoad);
		loadNewBlueprint("16_Lilly", backgroundLoad);
		loadNewBlueprint("17_Seaweed", backgroundLoad);
		loadNewBlueprint("18_Cactus", backgroundLoad);
		loadNewBlueprint("19_PricklyPear", backgroundLoad);
		loadNewBlueprint("20_Grass", backgroundLoad);
		loadNewBlueprint("21_Yucca", backgroundLoad);
		loadNewBlueprint("23_Pike", backgroundLoad);
		loadNewBlueprint("25_BirchTree", backgroundLoad);
		loadNewBlueprint("26_PinkTree", backgroundLoad);
		loadNewBlueprint("27_PalmTree", backgroundLoad);
		loadNewBlueprint("28_TallTree", backgroundLoad);
		loadNewBlueprint("30_CherryTree", backgroundLoad);
		loadNewBlueprint("31_Mushroom", backgroundLoad);
		loadNewBlueprint("32_AppleTree", backgroundLoad);
		loadNewBlueprint("33_Apple", backgroundLoad);
		loadNewBlueprint("35_JungleRocks", backgroundLoad);
		loadNewBlueprint("36_JunglePlant", backgroundLoad);
		loadNewBlueprint("37_VineTree", backgroundLoad);
		loadNewBlueprint("38_Frog", backgroundLoad);
		loadNewBlueprint("39_JungleMushroom", backgroundLoad);
		loadNewBlueprint("40_Coconut", backgroundLoad);
		loadNewBlueprint("41_Rabbit", backgroundLoad);
		loadNewBlueprint("42_RedTree", backgroundLoad);
		loadNewBlueprint("43_BananaTree", backgroundLoad);
		loadNewBlueprint("44_Banana", backgroundLoad);
		loadNewBlueprint("45_Carrot", backgroundLoad);
		loadNewBlueprint("46_UmbrellaTree", backgroundLoad);
		loadNewBlueprint("47_OrangeTree", backgroundLoad);
		loadNewBlueprint("48_Orange", backgroundLoad);
		loadNewBlueprint("49_Squirrel", backgroundLoad);
		loadNewBlueprint("50_Boar", backgroundLoad);
		loadNewBlueprint("51_PotatoPlant", backgroundLoad);
		loadNewBlueprint("52_GuineaPig", backgroundLoad);
		loadNewBlueprint("53_Potato", backgroundLoad);
		loadNewBlueprint("54_LargeTree", backgroundLoad);
		loadNewBlueprint("55_Butterfly", backgroundLoad);
		loadNewBlueprint("56_Bee", backgroundLoad);
		loadNewBlueprint("57_Hive", backgroundLoad);
		loadNewBlueprint("58_SwampTree", backgroundLoad);
		loadNewBlueprint("59_RedMushroom", backgroundLoad);
		loadNewBlueprint("60_LongGrass", backgroundLoad);
		loadNewBlueprint("62_TomatoPlant", backgroundLoad);
		loadNewBlueprint("63_Toucan", backgroundLoad);
		loadNewBlueprint("64_Sparrow", backgroundLoad);
		loadNewBlueprint("65_Duck", backgroundLoad);
		loadNewBlueprint("66_Eucalyptus", backgroundLoad);
		loadNewBlueprint("67_SpiralTree", backgroundLoad);
		loadNewBlueprint("68_Nest", backgroundLoad);
		loadNewBlueprint("69_SpindleTree", backgroundLoad);
		loadNewBlueprint("70_Bamboo", backgroundLoad);
		loadNewBlueprint("71_BlueberryBush", backgroundLoad);
		loadNewBlueprint("72_Wolf", backgroundLoad);
		loadNewBlueprint("73_DesertHare", backgroundLoad);
		loadNewBlueprint("74_Toad", backgroundLoad);
		loadNewBlueprint("75_Lizard", backgroundLoad);
		loadNewBlueprint("76_ClownFish", backgroundLoad);
		loadNewBlueprint("78_Bear", backgroundLoad);
		loadNewBlueprint("79_Warthog", backgroundLoad);
		loadNewBlueprint("80_Tulip", backgroundLoad);
		loadNewBlueprint("81_ForestTree", backgroundLoad);
		loadNewBlueprint("83_TallFir", backgroundLoad);
		loadNewBlueprint("84_Fox", backgroundLoad);
		loadNewBlueprint("85_Camel", backgroundLoad);
		loadNewBlueprint("89_Beaver", backgroundLoad);
		loadNewBlueprint("92_Goat", backgroundLoad);
		loadNewBlueprint("94_MangoTree", backgroundLoad);
		loadNewBlueprint("99_Deer", backgroundLoad);
		loadNewBlueprint("100_Twig", backgroundLoad);
		loadNewBlueprint("101_Bark", backgroundLoad);
		loadNewBlueprint("102_Den", backgroundLoad);
		loadNewBlueprint("103_SnapDragon", backgroundLoad);
		loadNewBlueprint("104_Meat", backgroundLoad);
		loadNewBlueprint("105_WildMint", backgroundLoad);
		loadNewBlueprint("106_Sage", backgroundLoad);
		loadNewBlueprint("107_Oregano", backgroundLoad);
		loadNewBlueprint("108_Rosemary", backgroundLoad);
		loadNewBlueprint("109_FlowerTree", backgroundLoad);
		loadNewBlueprint("110_Willow", backgroundLoad);
		loadNewBlueprint("111_BigFlower", backgroundLoad);
		loadNewBlueprint("112_ElmTree", backgroundLoad);
		loadNewBlueprint("113_BirchTree3", backgroundLoad);
		loadNewBlueprint("114_Daisy", backgroundLoad);
		loadNewBlueprint("115_Buttercup", backgroundLoad);
		loadNewBlueprint("116_Poppy", backgroundLoad);
		loadNewBlueprint("117_TropicalFlower", backgroundLoad);
		loadNewBlueprint("118_Bluebell", backgroundLoad);
		loadNewBlueprint("119_ButtonMushroom", backgroundLoad);
		loadNewBlueprint("120_SmallCactus", backgroundLoad);
		loadNewBlueprint("121_GiantCactus", backgroundLoad);
		loadNewBlueprint("122_DesertTree", backgroundLoad);
		loadNewBlueprint("123_JungleGrass", backgroundLoad);
		loadNewBlueprint("124_SmallJungleTree", backgroundLoad);
		loadNewBlueprint("125_TallJungleTree", backgroundLoad);
		loadNewBlueprint("126_SpecialMushroom", backgroundLoad);
		loadNewBlueprint("127_LushFlower", backgroundLoad);
		loadNewBlueprint("128_FloweryGrass", backgroundLoad);
		loadNewBlueprint("129_TropicalPlant", backgroundLoad);
		loadNewBlueprint("130_LeafyPlant", backgroundLoad);
		loadNewBlueprint("131_PineTree", backgroundLoad);
		loadNewBlueprint("132_FirTree", backgroundLoad);
		loadNewBlueprint("133_HollyBush", backgroundLoad);
		loadNewBlueprint("135_RedMaple", backgroundLoad);
		loadNewBlueprint("136_TropicalSeaweed", backgroundLoad);
		loadNewBlueprint("137_NutTree", backgroundLoad);
		loadNewBlueprint("138_Nut", backgroundLoad);
		loadNewBlueprint("139_BirdMeat", backgroundLoad);
		loadNewBlueprint("140_SmallMeat", backgroundLoad);
		loadNewBlueprint("141_Mango", backgroundLoad);
		loadNewBlueprint("142_Turnip", backgroundLoad);
		loadNewBlueprint("143_Bullrush", backgroundLoad);
		loadNewBlueprint("144_SwampFlower", backgroundLoad);
		loadNewBlueprint("145_Peacock", backgroundLoad);
		loadNewBlueprint("146_DeadTree", backgroundLoad);
		loadNewBlueprint("148_Barley", backgroundLoad);
		loadNewBlueprint("149_LushGrass", backgroundLoad);
		loadNewBlueprint("150_PerfectTree", backgroundLoad);
		loadNewBlueprint("151_Rose", backgroundLoad);
		loadNewBlueprint("152_Lily", backgroundLoad);
		loadNewBlueprint("153_SunFlower", backgroundLoad);
		loadNewBlueprint("154_Pansies", backgroundLoad);
		loadNewBlueprint("155_FloppyTree", backgroundLoad);
		loadNewBlueprint("156_NewTree", backgroundLoad);
		loadNewBlueprint("157_Healbloom", backgroundLoad);
		loadNewBlueprint("158_Seed", backgroundLoad);
		loadNewBlueprint("159_WitchWood", backgroundLoad);
		loadNewBlueprint("160_WitchWoodFruit", backgroundLoad);
		loadNewBlueprint("161_Dove", backgroundLoad);
		loadNewBlueprint("162_Stones", backgroundLoad);
		loadNewBlueprint("163_Boulders", backgroundLoad);
		loadNewBlueprint("164_Spit", backgroundLoad);
		loadNewBlueprint("165_Coral", backgroundLoad);
		loadNewBlueprint("166_Shell", backgroundLoad);
		loadNewBlueprint("167_Salmon", backgroundLoad);
		loadNewBlueprint("168_AngelFish", backgroundLoad);
		loadNewBlueprint("169_NeonFish", backgroundLoad);
		loadNewBlueprint("170_RoyalGramma", backgroundLoad);
		loadNewBlueprint("171_Eagle", backgroundLoad);
		loadNewBlueprint("172_JellyFish", backgroundLoad);
		loadNewBlueprint("173_MoonBush", backgroundLoad);
		loadNewBlueprint("174_EagleNest", backgroundLoad);
		loadNewBlueprint("175_Fly", backgroundLoad);
		loadNewBlueprint("176_CarnivorePlant", backgroundLoad);
		loadNewBlueprint("177_Tongue", backgroundLoad);
		loadNewBlueprint("178_Meerkat", backgroundLoad);
		loadNewBlueprint("179_Burrow", backgroundLoad);
		loadNewBlueprint("180_DesertGrass", backgroundLoad);
		loadNewBlueprint("181_DesertRock", backgroundLoad);
		loadNewBlueprint("182_Marigolds", backgroundLoad);
		loadNewBlueprint("183_Dolphin", backgroundLoad);
		loadNewBlueprint("134_SnowRocks", backgroundLoad);
		loadNewBlueprint("1000", backgroundLoad);
		loadNewBlueprint("1001", backgroundLoad);
		loadNewBlueprint("1002", backgroundLoad);
		loadNewBlueprint("1003", backgroundLoad);
		
		customEntities.keySet().forEach(strings -> strings.forEach(string -> loadCustomBlueprint(customEntities.get(strings), string)));
	}
  
	public static List<Blueprint> getAllBlueprints() {
		List<Blueprint> list = new ArrayList<>();
		for (Blueprint b : blueprints.values())
			list.add(b); 
		return list;
	}
  
	private static void loadNewBlueprint(String name, boolean loadInBackground) {
		int id = Integer.parseInt(name.split("_")[0]);
		MyFile blueprintFile = new MyFile(ENTITY_FOLDER, String.valueOf(String.valueOf(name)) + ".txt");
		Blueprint blueprint = Blueprint.load(id, blueprintFile, loadInBackground);
		blueprints.put(Integer.valueOf(id), blueprint);
	}
	
	private static void loadCustomBlueprint(File file, String name) {
		int id = Integer.parseInt(name.split("_")[0]);
		MyFile blueprintFile = new MyFile(file, name + ".txt");
		Blueprint blueprint = Blueprint.load(id, blueprintFile, false);
		blueprints.put(Integer.valueOf(id), blueprint);
	}
}
