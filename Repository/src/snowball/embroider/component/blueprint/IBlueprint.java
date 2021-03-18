package snowball.embroider.component.blueprint;

import java.util.List;
import java.util.Map;

import speciesInformation.SpeciesInfoLine;
import speciesInformation.SpeciesInfoType;

public interface IBlueprint {
	void loadInfo(Map<SpeciesInfoType, List<SpeciesInfoLine>> info, List<Object> list);
}
