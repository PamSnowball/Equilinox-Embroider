package snowball.embroider.component.hunt;

import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.utils.Utils;

public class Fight implements IComponent {
	boolean revenge;

	EnumAttack attack;
	
	float range;
	float pause;
	
	int damage;
	
	public Fight(int attackDamage, boolean doesRevenge, EnumAttack attackAnimation, float biteRange, float pauseTime) {
		this.attack = attackAnimation;
		this.damage = attackDamage;
		this.revenge = doesRevenge;
		this.range = biteRange;
		this.pause = pauseTime;
	}
	
	@Override
	public void load(List<String> loader) {
		loader.add(Utils.value("FIGHT;damage", damage, "revenge", revenge ? 1 : 0, "anim", attack.getId(), "biteRange", range, "pause", pause));
	}

	@Override
	public int getId() {
		return 8;
	}
}
