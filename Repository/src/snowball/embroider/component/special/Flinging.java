package snowball.embroider.component.special;

import java.util.List;

import snowball.embroider.component.utils.IComponent;

public class Flinging implements IComponent {
	float max;
	float min;
	
	public Flinging(float minimumTime, float maximumTime) {
		this.max = maximumTime;
		this.min = minimumTime;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add("FLINGING;minTime;" + min + ";maxTime;" + max);
	}
	
	@Override
	public int getId() {
		return 22;
	}
}
