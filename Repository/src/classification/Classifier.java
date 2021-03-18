package classification;

import java.util.ArrayList;
import java.util.List;

import languages.GameText;

public class Classifier {
	private static boolean hasNode = false;
	
	private static Classification node = null;
	
	protected static final Classification ALL_SPECIES = setUpClassificationHierarchy();
	
	public static Classification getClassification(String key) {
		return ALL_SPECIES.getClassification(key);
	}
	
	public static Classification getAllClassification() {
		return ALL_SPECIES;
	}
	
	public static Classification getPlantClassification() {
		return ALL_SPECIES.getClassification("p");
	}
	
	public static Classification getAnimalClassification() {
		return ALL_SPECIES.getClassification("a");
	}
	
	public static List<String> customClassifications = new ArrayList<>();
	
	@SuppressWarnings("unused")
	private static Classification setUpClassificationHierarchy() {
		Classification allSpecies = Classification.createHeadNode();
		Classification plants = allSpecies.createChild('p', GameText.getText(806));
		Classification animals = allSpecies.createChild('a', GameText.getText(807));
		Classification nonLiving = allSpecies.createChild('e', GameText.getText(808));
		Classification tree = plants.createChild('t', GameText.getText(809));
		Classification forestTrees = tree.createChild('f', GameText.getText(810), true);
		Classification grassTree = tree.createChild('g', GameText.getText(811), true);
		Classification woodlandTree = tree.createChild('w', GameText.getText(812), true);
		Classification lushTree = tree.createChild('l', GameText.getText(813), true);
		Classification desertTree = tree.createChild('d', GameText.getText(814), true);
		Classification snowTree = tree.createChild('m', GameText.getText(815), true);
		Classification swampTree = tree.createChild('s', GameText.getText(816), true);
		Classification jungleTree = tree.createChild('j', GameText.getText(817), true);
		Classification tropicalTree = tree.createChild('t', GameText.getText(818), true);
		Classification bushes = plants.createChild('b', GameText.getText(819));
		Classification cacti = plants.createChild('c', GameText.getText(820));
		Classification smallPlants = plants.createChild('n', GameText.getText(821));
		Classification waterPlants = smallPlants.createChild('w', GameText.getText(822));
		Classification grasses = smallPlants.createChild('g', GameText.getText(823));
		Classification rootVeg = smallPlants.createChild('v', GameText.getText(824));
		Classification veg = smallPlants.createChild('p', GameText.getText(825));
		Classification ferns = smallPlants.createChild('x', GameText.getText(826));
		Classification flowers = smallPlants.createChild('f', GameText.getText(827));
		Classification herbs = smallPlants.createChild('h', GameText.getText(828));
		Classification mushrooms = smallPlants.createChild('m', GameText.getText(829));
		Classification fruitBushes = bushes.createChild('f', GameText.getText(830));
		Classification leafyBushes = bushes.createChild('l', GameText.getText(831));
		Classification rocks = nonLiving.createChild('r', GameText.getText(832));
		Classification stones = rocks.createChild('s', GameText.getText(833));
		Classification largeRocks = rocks.createChild('l', GameText.getText(834));
		Classification other = nonLiving.createChild('o', GameText.getText(835));
		Classification clouds = nonLiving.createChild('c', GameText.getText(836));
		Classification fruits = nonLiving.createChild('f', GameText.getText(837));
		Classification vegetables = nonLiving.createChild('v', GameText.getText(838));
		Classification nuts = nonLiving.createChild('n', GameText.getText(839));
		Classification meat = nonLiving.createChild('m', GameText.getText(840));
		Classification structure = nonLiving.createChild('s', GameText.getText(841));
		Classification fish = animals.createChild('f', GameText.getText(842));
		Classification smallFish = fish.createChild('s', GameText.getText(843));
		Classification crustacean = fish.createChild('c', GameText.getText(1197));
		Classification bigFish = fish.createChild('b', GameText.getText(844));
		Classification weirdFish = fish.createChild('w', GameText.getText(1153));
		Classification herbivore = animals.createChild('h', GameText.getText(845));
		Classification birds = animals.createChild('b', GameText.getText(846));
		Classification smallBirds = birds.createChild('s', GameText.getText(847));
		Classification birdsOfPrey = birds.createChild('p', GameText.getText(848));
		Classification carnivores = animals.createChild('c', GameText.getText(849));
		Classification smallCarnivores = carnivores.createChild('s', GameText.getText(850));
		Classification largeCarnivores = carnivores.createChild('l', GameText.getText(851));
		Classification insects = animals.createChild('i', GameText.getText(852));
		Classification reptiles = animals.createChild('r', GameText.getText(853));
		Classification largeHerbivores = herbivore.createChild('l', GameText.getText(854));
		Classification mediumHerbivores = herbivore.createChild('m', GameText.getText(855));
		Classification smallHerbivores = herbivore.createChild('s', GameText.getText(856));
		loadCustomClassifications(allSpecies);
		
		return allSpecies;
	}
	
	static void loadCustomClassifications(Classification allSpecies) {
		for (String customClassification : customClassifications) {
			String[] classifications = customClassification.split(";");
			
			char[] classification = classifications[0].replaceAll("[^a-zA-Z]", "").toCharArray();
			String text = classifications[1];
			
			if (classification != null && text != null) {
				loadComparable(classification, text, allSpecies);
			}
			
			hasNode = false;
		}
	}
	
	private static void loadComparable(char[] classification, String text, Classification allSpecies) {
		int i = classification.length;
		
		compareChildren(allSpecies, classification[0], 0); i--;
		
		if (hasNode && i > 0) {
			hasNode = false;
			compareChildren(node, classification[1], 1); i--;
			
			if (!hasNode && i == 0) node.createChild(classification[1], text);
			if (hasNode && i > 0) {
				hasNode = false;
				compareChildren(node, classification[2], 2); i--;
				
				if (!hasNode && i == 0) node.createChild(classification[2], text);
			}
		} else if (!hasNode && i == 0) {
			allSpecies.createChild(classification[0], text);
		}
	}

	static void compareChildren(Classification classification, char comparable, int i) {
		for (Classification c : classification.getChildren()) if (c.getKey().charAt(i) == comparable) {
			hasNode = true;
			node = c;
		}
	}
}
