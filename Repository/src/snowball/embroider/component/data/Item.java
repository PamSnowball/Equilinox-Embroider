package snowball.embroider.component.data;

import java.util.List;

import snowball.embroider.component.utils.IComponent;

public class Item implements IComponent {
	float time;
	
	public Item(float decayTime) {
		this.time = decayTime;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add("ITEM;decayTime;" + time);
	}

	@Override
	public int getId() {
		return 45;
	}
}
