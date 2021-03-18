package snowball.embroider.component.blueprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blueprints.Blueprint;
import componentArchitecture.ComponentLoader;
import componentArchitecture.Requirement;
import snowball.embroider.component.utils.IComponent;
import snowball.mod.load.PreInitializer;
import snowball.utils.Utils;
import utils.CSVReader;

public abstract class Comp implements IComponent, ComponentLoader {
	private CustomComponentType type;
	
	private CustomRequirement requirement;
	private CustomComponent comp;
	
	private boolean dynamic;
	private boolean active;
	
	private Map<Boolean, String> labels = new HashMap<>();
	private Map<Object, Boolean> map = new HashMap<>();
	
	private List<Object> os = new ArrayList<>();
	
	private String name;
	
	public Comp(Map<Object, Boolean> map, List<String> labels, CustomComponentType type,
			CustomComponent comp, CustomRequirement requirement) {
		if (requirement != null && comp != null && type != null) {
			this.requirement = requirement;
			this.comp = comp;
			
			this.dynamic = type.isDynamic;
			this.active = type.isActive();
			this.name = type.toString();
			this.type = type;
		}
		
		this.labels = BlueprintUtils.mapLabels(map, labels);
		
		if (map.size() >= labels.size()) {
			this.map = map;
		} else {
			Utils.print("There are less labels than objects in your custom component");
		}
	}
	
	@Override
	public final void load(List<String> loader) {
		if (os != null && name != null) BlueprintUtils.load(loader, os, labels, name);
	}

	@Override
	public final int getId() {
		return PreInitializer.componentCount;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public boolean isDynamic() {
		return dynamic;
	}
	
	@Override
	public Requirement loadRequirement(CSVReader reader) {
		return requirement;
	}
	
	@Override
	public CustomComponentBlueprint load(CSVReader reader, Blueprint blueprint) {
		if (map != null) BlueprintUtils.readMap(os, map, reader);
		if (os != null && type != null && comp != null) {
			return new CustomComponentBlueprint(os, type, comp);
		}
		
		return null;
	}

	public CustomComponentType getType() {
		return type;
	}
}
