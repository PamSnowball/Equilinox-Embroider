package snowball.embroider.component.utils;

import java.util.List;

public class SimpleComponent implements IComponent {
	String name;
	int id;
	
	public SimpleComponent(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add(name);
	}

	@Override
	public int getId() {
		return id;
	}
}
