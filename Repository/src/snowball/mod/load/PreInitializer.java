package snowball.mod.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiComponent.AiProgramType;
import snowball.embroider.component.blueprint.CustomAi;
import snowball.embroider.component.blueprint.Comp;
import snowball.embroider.entity.Entity;
import snowball.embroider.enumerator.classification.IClassifier;
import snowball.mod.Mod;

public class PreInitializer {
	public static void incrementCount(int i) { i++; }
	public static int componentCount = 52;
	
	private List<String> mods = new ArrayList<>();
	
	private static Map<List<Entity>, Mod> map = new HashMap<>();
	
	public static int id = 2000;
	
	public PreInitializer(List<Mod> mods) {
		for(Mod mod : mods) this.mods.add(mod.getModInfo().id());
	}
	
	public void setEntities(List<Entity> entities, Mod mod) {
		Embroider.addEntities(entities, mod); incrementCount(id);
	}
	
	public <T extends Enum<T> & IClassifier> void setCustomClassifications(Class<T> classifier) {
		Embroider.addClassification(classifier);
	}
	
	public void setCustomAi(List<CustomAi> ais) {
		incrementCount(componentCount); ais.forEach(AiProgramType.customAis::add);
	}
	
	public void setCustomComponents(List<Comp> components) {
		Embroider.setComponents(components);
	}
	
	public static List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<>();
		map.keySet().forEach(entities::addAll); 
		return entities;
	}
	
	public static Mod getModFromEntity(List<Entity> entities) {
		for (Map.Entry<List<Entity>, Mod> entry : map.entrySet()) if (entry.getKey().equals(entities)) return entry.getValue();
		return null;
	}
	
	public static Mod getModFromEntity(Entity entities) {
		for (Map.Entry<List<Entity>, Mod> entry : map.entrySet()) for (Entity e : entry.getKey()) if (e.equals(entities)) return entry.getValue();
		return null;
	}
	
	public static List<Mod> getMods() {
		List<Mod> mods = new ArrayList<>();
		map.values().forEach(mods::add);
		return mods;
	}

	public boolean isModPresent(String id) {
		return mods.contains(id);
	}
}
