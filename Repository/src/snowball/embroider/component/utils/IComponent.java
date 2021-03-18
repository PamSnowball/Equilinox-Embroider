package snowball.embroider.component.utils;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.Ai.BaseAi;

public interface IComponent {
	public void load(List<String> loader);

	public int getId();

	public default String getName() {
		List<String> loader = new ArrayList<>(); load(loader);
		if (this.getClass().isAssignableFrom(BaseAi.class)) {
			return loader.get(0).split(";")[1].replaceAll("[^a-zA-Z ]", "").toUpperCase();
		}
		
		return loader.get(0).split(";")[0].replaceAll("[^a-zA-Z ]", "").toUpperCase();
	}
}
