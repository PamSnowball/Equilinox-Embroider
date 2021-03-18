package snowball.embroider.entity;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.enumerator.classification.BaseClassification;
import snowball.embroider.enumerator.classification.IClassifier;
import snowball.utils.Quantum;
import snowball.utils.Utils;

public class Entity implements IClassifier {
	protected String overrideName = null;
	
	private String print = this.getClass().getTypeName();
	private String entityName = print;
	private String classification;
	private String name;
	
	private Quantum enviro;
	
	private boolean aquatic;
	
	protected boolean alwaysVisible = false;
	protected boolean randomize = false;
	protected boolean hasCustomIcon;
	protected boolean material;
	protected boolean grows;
	
	protected float waterRequirement = -0.3F;
	protected float iconSize;
	protected float iconY;
	
	protected int mainStage = -1;
	private int growthStages = 1;
	private int id = 184;
	
	private List<IComponent> comps = new ArrayList<>();
	
	private List<Integer> ids = new ArrayList<>();
	
	protected List<String> components = new ArrayList<>();
	protected List<String> newEntity = new ArrayList<>();
	protected List<String> specials = new ArrayList<>();
	
	public Entity(int id, String name, IClassifier classification, float size, float swimmingHeight,
			boolean isAquatic, SpecialData special, IconData icon) {
		if (special != null) {
			if (special.getName() != null) overrideName = special.getName();
			if (special.getStage() > 0) mainStage = special.getStage();
			
			this.alwaysVisible = special.isVisible();
			this.randomize = special.isRandom();
		}
		
		if (icon != null) {
			if (icon.getSize() > 0.1F) iconSize = icon.getSize();
			if (icon.getY() > 0.1F) iconY = icon.getY();
			
			this.hasCustomIcon = icon.hasCustomIcon;
		}
		
		if (classification == null) classification = BaseClassification.PLANT;
		
		if (size <= 0.5F) size = 0.5F;
		if (name == null) name = "";
		if (id > 183) this.id = id;
		
		this.name = name;
		this.aquatic = isAquatic;
		
		firstLine(size);
		
		pastLines(classification.toString(), swimmingHeight);
	}
	
	public Entity(int id, String name, IClassifier classification, float size, float swimmingHeight, boolean isAquatic) {
		if (classification == null) classification = BaseClassification.PLANT;
		
		if (size <= 0.5F) size = 0.5F;
		if (name == null) name = "";
		if (id > 183) this.id = id;
		
		this.name = id + "_" + name;
		this.aquatic = isAquatic;
		
		firstLine(size);
		
		pastLines(classification.getClassification(), swimmingHeight);
	}
	
	public Entity(int id, String name, IClassifier classification, float size, boolean isAquatic) {
		if (classification == null) classification = BaseClassification.PLANT;
		
		if (size <= 0.5F) size = 0.5F;
		if (name == null) name = "";
		if (id > 183) this.id = id;
		
		this.name = id + "_" + name;
		this.aquatic = isAquatic;
		
		firstLine(size);
		
		pastLines(classification.getClassification(), -0.3F);
	}
	
	public static class IconData {
		private boolean hasCustomIcon;
		
		private float size;
		private float y;
		
		public IconData(float iconSize, float iconY) {
			this.hasCustomIcon = true;
			this.size = iconSize;
			this.y = iconY;
		}
		
		public boolean hasCustomIcon() {
			return hasCustomIcon;
		}
		
		public float getSize() {
			return size;
		}
		
		public float getY() {
			return y;
		}
	}
	
	public static class SpecialData {
		private boolean visible;
		private boolean random;
		
		private int stage;
		
		private String name;
		
		public SpecialData(String overrideName, int mainStage, boolean randomize, boolean alwaysVisible) {
			this.visible = alwaysVisible;
			this.name = overrideName;
			this.random = randomize;
			this.stage = mainStage;
		}
		
		public boolean isVisible() {
			return visible;
		}
		
		public int getStage() {
			return stage;
		}

		public boolean isRandom() {
			return random;
		}
		
		public String getName() {
			return name;
		}
	}
	
	protected final void firstLine(float size) {
		newEntity.add(Utils.value(size));
		
		newEntity.add("name;-1;");
		
		newEntity.add(Utils.value("id", mainStage));
		newEntity.add(Utils.value("randomize", randomize ? 1 : 0, "alwaysVis", alwaysVisible ? 1 : 0));
		
		if (hasCustomIcon) newEntity.add(Utils.value("size", iconSize, "y", iconY));
		if (overrideName != null) newEntity.add("overrideName;" + overrideName);
		
		newEntity.add("\n");
		
		System.out.println("First Line of " + getName());
		
		String entity = "Entity";
		
		if (print.contains(entity)) {
			int index = print.indexOf(entity);
			
			entityName = print.substring(index + entity.length());
		}
		
		System.out.println("Loaded " + entityName + " Super");
	}
	
	protected final void pastLines(String classification, float height) {
		newEntity.add(classification);
		newEntity.add("\n");
		
		newEntity.add(Utils.value(height <= 0 && aquatic ? 1 : 0, height >= 0 ? 1 : 0, height != 0 ? height : null));
		
		enviro = new Quantum(height <= 0 && aquatic, height >= 0);
		
		newEntity.add("\n");
		
		System.out.println("Past Lines of " + getName());
	}
	
	public List<String> load() {
		return newEntity;
	}
	
	public void setEntity(List<String> entity) {
		this.newEntity = entity;
	}
	
	public String getName() {
		return name;
	}
	
	protected final void componentLoader(IComponent component) {
		getAllComponents().add(component);
		component.load(components);
	}
	
	public List<String> loadComponents() {
		return components;
	}
	
	public void setComponents(List<String> components) {
		this.components = components;
	}

	public boolean hasGrowthStages() {
		return this.grows;
	}
	
	public void setGrows(boolean grows) {
		this.grows = grows;
	}
	
	public boolean hasMaterial() {
		return this.material;
	}
	
	public void setHasMaterial(boolean hasMaterial) {
		this.material = hasMaterial;
	}
	
	public int getGrowthStages() {
		return growthStages;
	}
	
	public void setGrowthStages(int growthStages) {
		if (growthStages >= 1) this.growthStages = growthStages;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getClassification() {
		return classification + id;
	}
	
	@Override
	public String toString() {
		return classification;
	}
	
	public static String getClassification(int id) {
		for (Entity entity : EntityLoader.ENTITIES) if (entity.getId() == id) return entity.getClassification();
		return null;
	}
	
	public List<Integer> getComponentIds() {
		return ids;
	}
	
	public List<IComponent> getAllComponents() {
		return comps;
	}
	
	public boolean getComponent(IComponent component) {
		for (IComponent comp : comps) if (comp.getId() == component.getId()) return true;
		return false;
	}
	
	public <T extends IComponent> boolean hasComponent(Class<T> clazz) {
		for (IComponent comp : comps) if (comp.getClass() == clazz) return true;
		return false;
	}
	
	public Quantum getEnviro() {
		return enviro;
	}

	public void setEnviro(Quantum enviro) {
		this.enviro = enviro;
	}
}
