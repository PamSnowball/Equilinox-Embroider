package snowball.embroider.component.food;

import java.util.List;

import resourceManagement.BlueprintRepository;
import snowball.embroider.component.utils.IComponent;
import snowball.embroider.entity.Entity;
import snowball.utils.Utils;

public class FruitFall implements IComponent {
	float height;
	float radius;
	float time;
	
	int index;
	
	public FruitFall(int fruitModelIndex, float averageFruitTime, float spawnHeight, float spawnRadius) {
		if (averageFruitTime > 0) this.time = averageFruitTime;
		this.index = fruitModelIndex;
		this.height = spawnHeight;
		this.radius = spawnRadius;
	}
	
	@Override
	public void load(List<String> loader) {
		boolean isFruit = BlueprintRepository.getBlueprint(index).getClassification().getKey().startsWith("ef");
		boolean isCustomFruit = Entity.getClassification(index).startsWith("ef");
		
		if (isFruit || isCustomFruit) {
			loader.add(Utils.value("FRUIT_FALL;fruitID", index, "spawnTime", time, "spawnHeight", height, "spawnRadius", radius));
		}
	}
	
	@Override
	public int getId() {
		return 28;
	}
}
