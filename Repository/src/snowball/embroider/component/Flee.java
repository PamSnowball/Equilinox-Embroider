package snowball.embroider.component;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.entity.Entity;
import snowball.embroider.enumerator.classification.IClassifier;
import snowball.utils.Utils;

public class Flee implements IComponent {
	String classification;
	
	float range;
	
	Entity entity;
	
	public Flee(Entity entity, float safeRange, IClassifier hidingClassification) {
		this.classification = hidingClassification.getClassification();
		this.range = safeRange;
		this.entity = entity;
	}
	
	public Flee(Entity entity, float safeRange) {
		this.range = safeRange;
		this.entity = entity;
	}
	
	@Override
	public void load(List<String> component) {
		List<String> flee = new ArrayList<>();
		
		flee.add(Utils.value("FLEE;"));
		
		if (entity.hasComponent(Ai.TortoiseAi.class)) flee.add("TURTLE;"); 
		else if (entity.hasComponent(Ai.MeerkatAi.class)) flee.add("MERKAT;"); 
		else flee.add("safeRange;");
		
		flee.add(Utils.value(range, "land", entity.getEnviro().getUpSpin() ? 1 : 0, "swim", entity.getEnviro().getDownSpin() ? 1 : 0));
	}	
	
	@Override
	public int getId() {
		return 19;
	}
}
