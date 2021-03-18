package snowball.embroider.util.requirement;

import java.util.List;

import snowball.embroider.enumerator.classification.IClassifier;
import snowball.embroider.util.component.IRequirement;
import snowball.utils.Utils;

public class ReqNearbySpecies implements IRequirement {
	IClassifier classification;
		
	int count;
		
	public ReqNearbySpecies(IClassifier nearbySpecieClassification, int entityCount) {
		this.classification = nearbySpecieClassification;
		this.count = entityCount;
	}
		
	@Override
	public void requirement(List<String> req) {
		req.add(Utils.value("LIFE;type;2;enviroType;0;specie", classification, "count", count));
	}
}