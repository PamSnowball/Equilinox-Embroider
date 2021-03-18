package snowball.embroider.component.food;

import java.util.ArrayList;
import java.util.List;

import resourceManagement.BlueprintRepository;
import snowball.embroider.component.utils.IComponent;
import snowball.embroider.entity.Entity;
import snowball.utils.Utils;

public class Fruiter implements IComponent {
	float time = 5.0F;
	
	int count = 0;
	int index;
	
	public Fruiter(int fruitModelIndex, int stageCount) {
		this.index = fruitModelIndex;
		this.count = stageCount;
	}
	
	public Fruiter(int fruitModelIndex, int stageCount, float fruitTime) {
		if (stageCount > -1) this.count = stageCount;
		this.index = fruitModelIndex;
		this.time = fruitTime;
	}
	
	public void load(List<String> component) {
		boolean isFruit = BlueprintRepository.getBlueprint(index).getClassification().getKey().startsWith("ef");
		boolean isCustomFruit = Entity.getClassification(index).startsWith("ef");
		
		if (isFruit || isCustomFruit) {
			List<String> fruit = new ArrayList<>();
			
			fruit.add(Utils.value("FRUITER;modelStage", index, "stageCount", count));
			if (time != 5.0F) fruit.add("time;" + time);
			
			Utils.append(fruit, component);
		}
	}

	@Override
	public int getId() {
		return 37;
	}
}
