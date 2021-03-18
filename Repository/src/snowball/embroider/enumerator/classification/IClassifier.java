package snowball.embroider.enumerator.classification;

public interface IClassifier {
	String getClassification();
	
	public default int getId() {
		return Integer.parseInt(this.getClassification().replace("[\\D]", ""));
	}
	
	public default String getType() {
		return this.getClassification().replace("[0-9]", "");
	}
}
