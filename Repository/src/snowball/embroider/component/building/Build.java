package snowball.embroider.component.building;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.utils.Utils;

public class Build implements IComponent {
	int points;
	int count;
	int done;
	
	public Build(int stageCount, int maxBuildPoints) {
		this.points = maxBuildPoints;
		this.done = maxBuildPoints;
		this.count = stageCount;
	}
	
	public Build(int stageCount, int maxBuildPoints, int fullyBuildAt) {
		this.points = maxBuildPoints;
		this.done = fullyBuildAt;
		this.count = stageCount;
	}
	
	@Override
	public void load(List<String> loader) {
		List<String> building = new ArrayList<>();
		
		building.add(Utils.value("BUILD", count, points));
		
		if (done != points) building.add(String.valueOf(done));
	}

	@Override
	public int getId() {
		return 41;
	}
}
