package snowball.embroider.component.food;

import java.util.List;

import snowball.embroider.component.utils.IComponent;

public class Decay implements IComponent {
	float time;
	
	public Decay(float lifeTime) {
		this.time = lifeTime;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add("DECAY;" + time);
	}

	@Override
	public int getId() {
		return 48;
	}
}
