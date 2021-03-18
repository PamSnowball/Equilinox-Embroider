package snowball.embroider.component.special;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.util.Vector;
import snowball.utils.Utils;

public class Equip implements IComponent {
	Vector[] positions;
	
	public Equip(Vector[] equipingPositions) {
		this.positions = equipingPositions;
	}
	
	@Override
	public void load(List<String> loader) {
		if (positions != null) {
			List<String> perch = new ArrayList<>();
			
			perch.add("EQUIP;count;" + positions.length);
			
			for (Vector position : positions) perch.add("pos;" + position.toString() + ';');
			
			Utils.append(perch, loader);
		}
	}

	@Override
	public int getId() {
		return 24;
	}
}
