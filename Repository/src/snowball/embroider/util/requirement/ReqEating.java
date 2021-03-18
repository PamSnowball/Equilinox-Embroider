package snowball.embroider.util.requirement;

import java.util.List;

import snowball.embroider.enumerator.classification.IClassifier;
import snowball.embroider.util.component.IRequirement;

public class ReqEating implements IRequirement {
	IClassifier classification;

	public ReqEating(IClassifier classification) {
		this.classification = classification;
	}
	
	public void requirement(List<String> breed) {
		breed.add("EATING;" + classification + ';');
	}
}