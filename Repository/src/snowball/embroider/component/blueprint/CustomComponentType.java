package snowball.embroider.component.blueprint;

import componentArchitecture.ComponentType;

public class CustomComponentType extends ComponentType {
	public Comp loader;
	public boolean isDynamic;
	public boolean active;
	
	public CustomComponentType(Comp loader, boolean dynamic, boolean active) {
		this.isDynamic = dynamic;
		this.active = active;
		this.loader = loader;
	}
}
