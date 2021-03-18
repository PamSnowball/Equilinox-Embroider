package snowball.embroider.util.requirement;

import java.util.List;

import snowball.embroider.util.component.IRequirement;
import snowball.utils.Utils;

public class ReqSatisfaction implements IRequirement {
	float satisfaction;
	
	public ReqSatisfaction(float satisfaction) {
		this.satisfaction = satisfaction;
	}
	
	@Override
	public void requirement(List<String> req) {
		req.add(Utils.value("LIFE;type;2;enviroType;2;satisfaction", satisfaction));	
	}
}
