package snowball.embroider.component;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.enumerator.EnumEat;
import snowball.embroider.util.component.IDeath;
import snowball.utils.Utils;

public class Food implements IComponent {
	boolean hasDeath = false;
	boolean isShare = false;
	
	EnumEat[] eat = { EnumEat.WHOLE };
	
	IDeath[] death;
	
	int[] foodName;
	int[] foodPoints;
	
	int portions;
	
	public Food(EnumEat[] eat, int[] foodName, int[] foodPoints) {
		this.eat = eat;
		this.foodName = foodName;
		this.foodPoints = foodPoints;
	}
	
	public Food(IDeath[] death, EnumEat[] eat, int[] foodName, int[] foodPoints) {
		this.hasDeath = true;
		this.death = death;
		this.eat = eat;
		this.foodName = foodName;
		this.foodPoints = foodPoints;
	}

	public Food(IDeath[] death, EnumEat[] eat, int[] foodName, int[] foodPoints, int portions) {
		this.hasDeath = true;
		this.isShare = true;
		this.death = death;
		this.eat = eat;
		this.foodName = foodName;
		this.foodPoints = foodPoints;
		this.portions = portions;
	}
		
	public void load(List<String> component) {
		List<String> food = new ArrayList<>();
		
		food.add(Utils.value("FOOD", eat.length));
		for (int i = 0; i < eat.length; i++)  {
			food.add(Utils.value(foodName, foodPoints, eat[i].name())); //GameText
			if (hasDeath && (eat[i].name().equals("WHOLE") || eat[i].name().equals("ROOT_VEG"))) {
				death[i].death(food);
				food.add(";");
			}
		
			else if (isShare && eat[i].name().equals("TO_SHARE")) food.add(portions + ";");
		}
		
		Utils.append(food, component);
	}
	
	@Override
	public int getId() {
		return 32;
	}
}
