package snowball.embroider.component.unique;

import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.utils.Utils;

public class Hive implements IComponent {
	int honey;
	int count;
	int start;
	
	public Hive(int maxHoney, int startStage, int stageCount) {
		this.count = stageCount;
		this.start = startStage;
		this.honey = maxHoney;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add(Utils.value("HIVE", honey, start, count));
	}

	@Override
	public int getId() {
		return 44;
	}
}
