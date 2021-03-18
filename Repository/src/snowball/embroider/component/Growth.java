package snowball.embroider.component;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.entity.Entity;
import snowball.utils.Utils;

public class Growth implements IComponent {
	public boolean isDynamic = false;
	
	public float time = 0;

	public int stages;
	public int sub;
	
	public Growth(Entity entity, float averageGrowthTime, int modelStages, int subStages) {
		this.time = averageGrowthTime;
		this.stages = modelStages;
		this.sub = subStages;
		entity.setGrows(true);
		entity.setGrowthStages(stages);
	}
	
	public Growth(Entity entity, float averageGrowthTime, int modelStages) {
		entity.setGrows(true);
		this.isDynamic = true;
		this.time = averageGrowthTime;
		this.stages = modelStages;
	}
	
	public void load(List<String> component) {
		List<String> grow = new ArrayList<>();
		
		grow.add(Utils.value("GROWTH;dynamic", isDynamic ? 1 : 0, "growthTime", time, "modelStages", stages));
		if (isDynamic) grow.add("subStages;" + sub);
		
		Utils.append(grow, component);
	}
	
	@Override
	public int getId() {
		return 42;
	}
}
