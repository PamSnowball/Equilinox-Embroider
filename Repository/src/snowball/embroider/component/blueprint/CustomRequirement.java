package snowball.embroider.component.blueprint;

import java.util.List;
import java.util.Map;

import breedingTrees.ReqInfo;
import componentArchitecture.Requirement;
import instances.Entity;
import snowball.embroider.component.utils.IComponent;
import snowball.embroider.util.component.IRequirement;
import snowball.utils.Utils;
import utils.CSVReader;

public abstract class CustomRequirement implements Requirement, IRequirement {
	private Map<Object, Boolean> req;
	private Map<Boolean, String> labels;
	private List<Object> os;
	
	private boolean secret;

	private CSVReader reader;
	
	private String reqName;
	private String reqInfo;
	private String name;
	
	public CustomRequirement(CSVReader reader, String requirementName, String requirementInfo, IComponent comp, boolean isSecret,
			Map<Object, Boolean> requirements, List<Object> objectList, List<String> labels) {
		this.reqInfo = requirementInfo;
		this.reqName = requirementName;
		this.name = comp.getName();
		this.secret = isSecret;
		this.labels = BlueprintUtils.mapLabels(requirements, labels);
		this.reader = reader;
		this.os = objectList;
		
		if (requirements.size() >= labels.size()) {
			this.req = requirements;
		} else {
			Utils.print("There are less labels than objects in your custom component");
		}
	}
	
	@Override
	public void requirement(List<String> req) {
		BlueprintUtils.load(req, os, labels, name);
	}
	
	@Override
	public boolean isSecret() {
		return secret;
	}
			
	@Override
	public void getGuiInfo(List<ReqInfo> components) {
		components.add(new ReqInfo(reqName, reqInfo));
	}
			
	@Override
	public boolean check(Entity entity) {
		BlueprintUtils.readMap(os, req, reader);
		checkEntity(os);
		return false;
	}

	public abstract boolean checkEntity(List<Object> os);
}
