package snowball.embroider.component;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.ModelConverter;
import snowball.embroider.component.utils.IComponent;
import snowball.embroider.entity.Entity;
import snowball.embroider.enumerator.EnumColours;
import snowball.embroider.util.Vector;
import snowball.utils.Utils;

public class Material implements IComponent {
	boolean hasSecond;
	
	Vector[] colours;

	int[] prices;
	
	boolean hasMaterial;
	
	Entity entity;
	
	public Material(Entity entity, boolean hasSecondNatural, Vector[] colours, int[] prices) {
		this.hasSecond = hasSecondNatural;
		if (colours != null) this.colours = colours;
		if (prices != null) this.prices = prices;
		if (entity != null) this.entity = entity;
	}
	
	@Override
	public void load(List<String> component) {
		if (prices.length == 0 || colours.length == 0 || entity != null) {
			List<String> colour = new ArrayList<>();
		
			if (prices.length < colours.length) {
				Utils.print("Entity " + ModelConverter.getCurrentlyConvertingEntity().getName() + " has more colors than prices");	
			} else {
				if (prices.length > colours.length) {
					Utils.print("Entity " + ModelConverter.getCurrentlyConvertingEntity().getName() + " has more colors than prices");
				}
				
				entity.setHasMaterial(true);
				
				colour.add(Utils.value("MATERIAL;second", hasSecond ? 1 : 0, "count" + colours.length));
				for (int i = 0; i < colours.length; i++) {
					colour.add(EnumColours.checkForColour(colours[i]) + ";" + prices[i] + ";");
				}
			}
		
			Utils.append(colour, component);
		}
	}
	
	@Override
	public int getId() {
		return 47;
	}
}
