package snowball.embroider.component.special;

import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.utils.Utils;

public class Sleep implements IComponent {
	float startMax;
	float startMin;
	float endMax;
	float endMin;
	
	public Sleep(float minimumStart, float maximumStart, float minimumEnding, float maximumEnding) {
		this.startMax = maximumStart;
		this.startMin = minimumStart;
		this.endMax = maximumEnding;
		this.endMin = minimumEnding;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add(Utils.value("SLEEP;startMin", startMin, "startMax", startMax, "endMin", endMin, "endMax", endMax));
	}

	@Override
	public int getId() {
		return 9;
	}
}
