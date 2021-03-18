package snowball.embroider.util.requirement;

import java.util.List;

import snowball.embroider.enumerator.EnumColours;
import snowball.embroider.util.component.IRequirement;

public class ReqMaterial implements IRequirement {
	EnumColours colour;
	
	public ReqMaterial(EnumColours colour) {
		this.colour = colour;
	}
	
	public void requirement(List<String> component) {
		component.add("MATERIAL;col;" + colour);
	}
}
