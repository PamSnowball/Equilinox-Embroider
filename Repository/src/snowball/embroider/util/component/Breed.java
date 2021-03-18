package snowball.embroider.util.component;

import java.util.ArrayList;
import java.util.List;

import snowball.utils.Utils;

public class Breed {
	int parentId = -1;
	int count;
	
	float maturity;
	float time;
	
	IRequirement[] requirements;
	
	public Breed(float breedMaturity, float averageBreedTime) {
		this.maturity = breedMaturity;
		this.time = averageBreedTime;
	}
	
	public Breed(float breedMaturity, float averageBreedTime, int parentId, int evolveLenght, IRequirement[] requirements) {
		this.maturity = breedMaturity;
		this.time = averageBreedTime;
		this.parentId = parentId;
		this.count = evolveLenght;
		this.requirements = requirements;	
	}
	
	public void breed(List<String> component) {
		List<String> breed = new ArrayList<>();
		
		breed.add(Utils.value("breedMat" + maturity + "breedTime" + time + "parentId" + parentId));
		if (parentId >= 0) {
			breed.add("time;" + count + ';');
			for (IRequirement requirement : requirements) {
				requirement.requirement(breed);
				breed.add(";");
			}
		}
		
		Utils.append(breed, component);
	}
}
