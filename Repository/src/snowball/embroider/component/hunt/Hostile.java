package snowball.embroider.component.hunt;

import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.enumerator.classification.IClassifier;
import snowball.utils.Utils;

public class Hostile implements IComponent {
	boolean notify;
	
	IClassifier enemy;
	
	float time;
	
	@Override
	public void load(List<String> loader) {
		loader.add(Utils.value("HOSTILE;time", time, "enemy", enemy.getClassification(), "notifyPrey", notify ? 1 : 0));
	}

	@Override
	public int getId() {
		return 1;
	}
}
