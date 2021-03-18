package snowball.embroider.component.blueprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiComponent.Ai;
import aiComponent.AiProgramBlueprint;
import componentArchitecture.ComponentBundle;
import snowball.embroider.component.Ai.BaseAi;
import utils.CSVReader;

public abstract class CustomAi extends BaseAi implements AiProgramBlueprint {
	protected Map<Object, Boolean> map = new HashMap<>();
	private List<Object> objects = new ArrayList<>();
	
	public CustomAi(String name) {
		super(name);
		this.map = this.setMap();
	}
	
	@Override
	public Ai createInstance(ComponentBundle bundle) {
		return this.getInstance();
	}
	
	public abstract Map<Object, Boolean> setMap();
	
	public abstract Ai getInstance();

	@Override
	public void loadSettings(CSVReader reader) {
		BlueprintUtils.readMap(objects, map, reader);
	}
}
