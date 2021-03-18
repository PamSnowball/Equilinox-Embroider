package snowball.embroider.component.hunt;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.enumerator.classification.IClassifier;
import snowball.utils.Utils;

public class Hunt implements IComponent {
	boolean young;
	boolean old;
	
	IClassifier[] classifications;
	
	int range = 9;
	
	public Hunt(int range, IClassifier[] classifications, boolean huntsYoung, boolean huntsOld) {
		this.classifications = classifications;
		if (range > 0) this.range = range;
		this.young = huntsYoung;
		this.old = huntsOld;
	}
	
	@Override
	public void load(List<String> loader) {
		List<String> hunt = new ArrayList<>();
		
		hunt.add(Utils.value("HUNT;range", range, "count", classifications.length, "prey"));
	
		for (IClassifier classification : classifications) hunt.add(classification.getClassification());
	
		hunt.add((young ? 1 : 0) + ";" + (old ? 1 : 0));
	}

	@Override
	public int getId() {
		return 6;
	}
}
