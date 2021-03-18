package snowball.embroider.util.requirement;

import java.util.List;

import snowball.embroider.enumerator.EnumColours;
import snowball.embroider.enumerator.classification.IClassifier;
import snowball.embroider.util.component.IRequirement;
import snowball.utils.Utils;

public class ReqNearbyColoredSpecies implements IRequirement {
	IClassifier classification;
	EnumColours colour;
		
	public ReqNearbyColoredSpecies(IClassifier nearbySpecieClassification, EnumColours entityColour) {
		this.classification = nearbySpecieClassification;
		this.colour = entityColour;
	}
		
	@Override
	public void requirement(List<String> req) {
		req.add(Utils.value("LIFE;type;2;enviroType;0;specie", classification, "colour", colour.name()));
	}
}
