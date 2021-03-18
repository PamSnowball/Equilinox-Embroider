package snowball.embroider.util.requirement;

import java.util.List;

import snowball.embroider.util.component.IRequirement;

public class ReqMovement implements IRequirement {
	float target;

	public ReqMovement(float target) {
		this.target = target;
	}
	
	public void requirement(List<String> breed) {
		breed.add("MOVEMENT;" + target + ';');
	}
}
