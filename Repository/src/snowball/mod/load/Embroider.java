package snowball.mod.load;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import classification.Classifier;
import componentArchitecture.ComponentType;
import resourceManagement.BlueprintRepository;
import snowball.embroider.component.blueprint.Comp;
import snowball.embroider.entity.Entity;
import snowball.embroider.enumerator.classification.IClassifier;
import snowball.mod.Mod;
import snowball.utils.Utils;

public class Embroider {
	static void addEntities(List<Entity> entities, Mod mod) {
		List<String> names = new ArrayList<>();
		
		entities.forEach(entity -> names.add(PreInitializer.id + '_' + entity.getName()));
		for(Entity entity : entities) names.add(entity.getName());
		
		File file = new File(Utils.directory + "mods/" + Mod.parseFile(mod).getName().toLowerCase() + "/res/entities/");
		
		BlueprintRepository.customEntities.put(names, file);
	}
	
	public static <T extends Enum<T> & IClassifier> void addClassification(Class<T> classifier) {
		Method[] methods = classifier.getDeclaredMethods();
		T[] constants = classifier.getEnumConstants();
		
		for (Method method : methods) if (method.getName().equals("toString")) {
			List<String> classifications = toString(constants);
			
			for (String classification : classifications) Classifier.customClassifications.add(classification);
		}
	}
	
	private static <T extends Enum<T> & IClassifier> List<String> toString(T[] constants) {
		List<String> classifications = new ArrayList<>();
		
		for (T constant : constants) {
			String classification = constant.name().toLowerCase();
			String[] names = classification.split("_");
			
			StringBuilder builder = new StringBuilder();
			for (String name : names) {
				name = name.toLowerCase();
				String first = String.valueOf(name.charAt(0)).toUpperCase();
				
				if (builder.toString().equals("")) {
					builder.append(' ' + first + name.substring(1));
				} else {
					builder.append(first + name.substring(1));
				}
			}
			
			classifications.add(constant.getType() + ';' + classification);
		}

		return classifications;
	}

	public static void setComponents(List<Comp> comps) {
		comps.forEach(comp -> new ComponentType(comp.getType(), comp, comp.isDynamic(), comp.isActive()));
	}
}
