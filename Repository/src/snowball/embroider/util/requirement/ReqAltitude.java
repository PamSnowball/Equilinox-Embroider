package snowball.embroider.util.requirement;

import java.util.List;

import snowball.embroider.util.component.IRequirement;
import snowball.utils.Utils;

public class ReqAltitude implements IRequirement {
	int min;
	int max;
	
	public ReqAltitude(int minimumAltitude, int maximumAltitude) {
		this.min = minimumAltitude;
		this.max = maximumAltitude;
	}
	
	@Override
	public void requirement(List<String> req) {
		req.add(Utils.value("LIFE;type;2;enviroType;3;min", min, "max", max));
	}
}
