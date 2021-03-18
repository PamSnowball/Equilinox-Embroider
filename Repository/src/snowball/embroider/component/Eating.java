package snowball.embroider.component;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.enumerator.EnumAnimation;
import snowball.embroider.enumerator.EnumEat;
import snowball.utils.Utils;

public class Eating implements IComponent {
	EnumAnimation[] anims;
	EnumEat[] eats;
	
	float radius = 1;
	float hunger = 1;
	
	int maxHunger = 1;
	
	String[] preyes;
	
	public Eating(int maxHunger, float hunger, float radius, EnumAnimation[] anims, String[] preyes, EnumEat[] eats) {
		if (maxHunger > 0) this.maxHunger = maxHunger;
		if (hunger > 0) this.hunger = hunger;
		if (radius > 0) this.radius = radius;
		this.anims = anims;
		this.preyes = preyes;
		this.eats = eats;
	}
	
	@Override
	public void load(List<String> component) {
		if (anims != null || preyes != null || eats != null) {
			List<String> eat = new ArrayList<>();
		
			eat.add(Utils.value("maxHunger", maxHunger, "hungerPerHour", hunger, "eatRadius", radius));
			eat.add(Utils.value("eatAnims", anims.length));
			for (EnumAnimation anim : anims) eat.add(anim.getId() + ";");
			eat.add(Utils.value("dietOptionCount", preyes.length));
			for (int i = 0; i < preyes.length; i++) eat.add(Utils.value(preyes[i], eats[i], anims[i]));
			
			Utils.append(eat, component);
		}
	}
	
	@Override
	public int getId() {
		return 20;
	}
}
