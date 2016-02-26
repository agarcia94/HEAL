package model;

//by Raymond Wu

public class BloodProfile {
	int userID;
	
	//In string
	String lipoproteins;
	String triglycerides;
	String bloodCells;
	String glucose;
	String vitamin;
	
	//In integer 
	int lipo;
	int tri;
	int rbc;
	int glu;
	int vit;
	
	
	
	
	public BloodProfile(int userID,int lipo, int tri, int rbc, int glucose, int vitamin)
	{
		this.userID = userID; 
		this.lipoproteins = this.generateLipo(lipo);
		this.triglycerides = this.generateTri(tri);
		this.bloodCells = this.generateRBC(rbc);
		this.glucose = this.generateGlucose(glucose);
		this.vitamin = this.generateVitamin(vitamin);
		
		this.lipo = lipo;
		this.tri = tri;
		this.rbc = rbc;
		this.glu = glucose;
		this.vit = vitamin;

	}
	

	private String generateLipo(int lipo)
	{
		if (lipo < 14 )
		{
			return "Blood Lipoprotein Levels: Normal ( "+ Integer.toString(lipo) + " mg/dL )\n";
		}
		else if (lipo >= 14 && lipo <= 30)
		{
			return "Blood Lipoprotein Levels: Borderline Risk ( " + Integer.toString(lipo) + " mg/dL )\n";
		}
		else if(lipo>30 && lipo<=50)
		{
			return "Blood Lipoprotein Levels: High Risk ( " + Integer.toString(lipo) + " mg/dL )\n";
		}
		else
		{
			return "Blood Lipoprotein Levels: Very High Risk ( " + Integer.toString(lipo) + " mg/dL )\n";
		}
	}
	
	private String generateTri(int tri)
	{
		if (tri < 200)
		{
			return "Blood Triglyceride Levels: Normal ( " + Integer.toString(tri)+ " mg/dL )\n";
		}
		else if (tri>=200 && tri <= 399)
		{
			return "Blood Triglyceride Levels: Borderline Risk ( " + Integer.toString(tri)+ "mg/dL )\n";
		}
		else if (tri >= 400 && tri <= 450)
		{
			return "Blood Triglyceride Levels: High Risk ( " + Integer.toString(tri)+ "mg/dL )\n";
		}
		else
		{
			return "Blood Triglyceride Levels: Very High Risk ( " + Integer.toString(tri) + "mg/dL )\n";
		}
	}
	
	private String generateRBC(int rbc)
	{
		if (rbc < 4)
		{
			return "Red Blood Cell Count: Low ( " + Integer.toString(rbc) + " cells/mcL)\n";
		}
		else if (rbc >=4 && rbc <= 6)
		{
			return "Red Blood Cell Count: Normal ( " + Integer.toString(rbc) + " cells/mcL)\n";
		}
		else
		{
			return "Red Blood Cell Count: High ( " + Integer.toString(rbc) + " cells/mcL)\n";
		}
	}
	
	private String generateGlucose(int glucose)
	{
		if (glucose < 100) 
		{
			return "Blood Glucose Level: Low ( " + Integer.toString(glucose) + " mg/dL)\n";
		}
		else if (glucose>=100 && glucose<=125)
		{
			return "Blood Glucose Level: Normal ( " + Integer.toString(glucose) + " mg/dL)\n";
		}
		else if (glucose >= 126 && glucose <= 199)
		{
			return "Blood Glucose Level: High ( " + Integer.toString(glucose) + " mg/dL)\n";
		}
		else
		{
			return "Blood Glucose Level: Diabetic ( " + Integer.toString(glucose) + " mg/dL)\n";
		}
	}
	
	private String generateVitamin(int vitamin)
	{
		if (vitamin>= 0 && vitamin <= 41)
		{
			return "Vitamin D Saturation in Blood: Low ( "+ Integer.toString(vitamin) + " ng/dL)";
		}
		else if (vitamin>41 && vitamin<= 149)
		{
			return "Vitamin D Saturation in Blood: Normal ( " + Integer.toString(vitamin) + " ng/dL)";
		}
		else
		{
			return "Vitamin D Saturation in Blood: Toxic ( " + Integer.toString(vitamin) + " ng/dL)";
		}
	}

	
	//getters and setters
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getLipoproteins() {
		return lipoproteins;
	}

	public void setLipoproteins(String lipoproteins) {
		this.lipoproteins = lipoproteins;
	}

	public String getTriglycerides() {
		return triglycerides;
	}

	public void setTriglycerides(String triglycerides) {
		this.triglycerides = triglycerides;
	}

	public String getBloodCells() {
		return bloodCells;
	}

	public void setBloodCells(String bloodCells) {
		this.bloodCells = bloodCells;
	}

	public String getGlucose() {
		return glucose;
	}

	public void setGlucose(String glucose) {
		this.glucose = glucose;
	}

	public String getVitamin() {
		return vitamin;
	}

	public void setVitamin(String vitamin) {
		this.vitamin = vitamin;
	}

	public int getLipo() {
		return lipo;
	}

	public void setLipo(int lipo) {
		this.lipo = lipo;
	}

	public int getTri() {
		return tri;
	}

	public void setTri(int tri) {
		this.tri = tri;
	}

	public int getRbc() {
		return rbc;
	}

	public void setRbc(int rbc) {
		this.rbc = rbc;
	}

	public int getGlu() {
		return glu;
	}

	public void setGlu(int glu) {
		this.glu = glu;
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}
	
}