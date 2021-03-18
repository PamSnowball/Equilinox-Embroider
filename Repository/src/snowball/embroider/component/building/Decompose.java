package snowball.embroider.component.building;

import java.util.List;

import snowball.embroider.component.utils.IComponent;

public class Decompose implements IComponent {
	float loss;
	
	public Decompose(float timesPerLoss) {
		this.loss = timesPerLoss;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add("DECOMPOSE;timePerLoss;" + loss);
	}

	@Override
	public int getId() {
		return 39;
	}
}
