package snowball.embroider.component.data;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.util.component.Particle;
import snowball.utils.Utils;

public class Particles implements IComponent {
	Particle particle;
	
	float range;
	
	int[] stages = new int[] {};
	
	boolean material;
	
	public Particles(Particle particle, float particleRange, int[] stages, boolean takesMaterial) {
		if (stages != null) this.stages = stages;
		this.material = takesMaterial;
		this.range = particleRange;
		this.particle = particle;
	}

	public void load(List<String> component) {
		if (particle != null) { 
			List<String> particles = new ArrayList<>();
		
			particle.deathPrint(particles);
			
			particles.add(Utils.value(";range", range, "stages", stages.length));
			
			if (stages.length > 0) {
				for (int stage : stages) particles.add(stage + ";");
			} else {
				particles.add("0;");
			}
			
			particles.add(Utils.value("takesMaterial", material ? 1 : 0));
		
			Utils.append(particles, component);
		}
	}
	

	@Override
	public int getId() {
		return 30;
	}
}
