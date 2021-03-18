package snowball.embroider.component.special;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.util.Vector;
import snowball.utils.Utils;

public class Perch implements IComponent {
	Vector[] slots;
	
	public Perch(Vector[] perchingPositions) {
		this.slots = perchingPositions;
	}
	
	@Override
	public void load(List<String> loader) {
		if (slots != null) {
			List<String> perch = new ArrayList<>();
			
			perch.add(Utils.value("PERCH", slots.length));
			
			for (Vector slot : slots) perch.add(slot.toString() + ';');
			
			Utils.append(perch, loader);
		}
	}
	
	@Override
	public int getId() {
		return 25;
	}
}
