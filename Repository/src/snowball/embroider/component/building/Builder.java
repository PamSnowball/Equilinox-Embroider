package snowball.embroider.component.building;

import java.util.ArrayList;
import java.util.List;

import resourceManagement.BlueprintRepository;
import snowball.embroider.component.utils.IComponent;
import snowball.embroider.entity.Entity;
import snowball.utils.Utils;

public class Builder implements IComponent {
	boolean perch;
	
	float early = 0;
	float time;
	float age;
	
	int index;
	int speed;
	
	public Builder(int buildingModelIndex, int buildSpeed, boolean needsPerch, float buildingTime, float buildAgeFactor, float earlyBuildTime) {
		this.index = buildingModelIndex;
		this.early = earlyBuildTime;
		this.age = buildAgeFactor;
		this.time = buildingTime;
		this.speed = buildSpeed;
		this.perch = needsPerch;
	}
	
	public Builder(int buildingModelIndex, int buildSpeed, boolean needsPerch, float buildingTime, float buildAgeFactor) {
		this.index = buildingModelIndex;
		if (speed > 0) this.speed = buildSpeed;
		if (time > 0) this.time = buildingTime;
		if (age > 0) this.age = buildAgeFactor;
		this.perch = needsPerch;
	}
	
	@Override
	public void load(List<String> loader) {
		boolean isBuilding = BlueprintRepository.getBlueprint(index).getClassification().getKey().startsWith("es");
		boolean isCustomBuilding = Entity.getClassification(index).startsWith("es");
		
		if (isBuilding || isCustomBuilding) {
			List<String> builder = new ArrayList<>();
			
			builder.add(Utils.value("BUILDER;buildModel", index, "buildPoints", speed, "needsPerch"));
			builder.add(Utils.value(perch ? 1 : 0, "buildTime", time, "buildAge", age));
			
			if (early != 0) builder.add("buildStartTime;" + early);
		}
	}

	@Override
	public int getId() {
		return 21;
	}
}
