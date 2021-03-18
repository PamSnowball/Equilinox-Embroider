package snowball.embroider.component.unique;

import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.util.Vector;

public class FlyTrap implements IComponent {
	Vector position;
	
	public FlyTrap(Vector flyPosition) {
		this.position = flyPosition;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add("FLY_TRAP;pos;" + position.toString());
	}

	@Override
	public int getId() {
		return 33;
	}
}
