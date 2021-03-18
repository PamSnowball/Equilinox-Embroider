package snowball.embroider.component.special;

import java.util.List;

import snowball.embroider.component.utils.IComponent;

public class Percher implements IComponent {
	boolean die;
	
	public Percher(boolean removeOnRemoval) {
		this.die = removeOnRemoval;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add("PERCHER;dieWhenPerchRemoved;" + (die ? 1 : 0));	
	}

	@Override
	public int getId() {
		return 36;
	}
}
