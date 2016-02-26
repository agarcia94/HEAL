package model;

public class BloodStat {
	int userId;
	String lipoproteins;
	String triglycerides;
	String bloodCells;
	String glucose;
	String vitamin;
	
	public BloodStat(int userId, 
			String lipoproteins,
			String triglycerides,
			String bloodCells,
			String glucose,
			String vitamin){
		this.userId = userId;
		this.lipoproteins = lipoproteins;
		this.triglycerides = triglycerides;
		this.bloodCells = bloodCells;
		this.glucose = glucose;
		this.vitamin = vitamin;
	}
	
	@Override
	public String toString() {
		return "Lipoproteins: " + lipoproteins + "\n" + 
		"Triglycerides: " + triglycerides + "\n" +
		"Blood Cells: " + bloodCells + "\n" +
		"Glucose: " + glucose + "\n" +
		"Vitamin: " + vitamin + "\n";
	}
}
