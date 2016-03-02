package model;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BloodStat {
	int id;
	int userId;
	Map<String, String> stats;
	/*	keys
	 * 	String lipoproteins;
		String triglycerides;
		String bloodCells;
		String glucose;
		String vitamin;
	 *  
	 *  values
	 *  Good
	 *  Bad
	 *  Dead
	 */
	
	public BloodStat() {
		this.id = 0;
		this.userId = 0;
		this.stats = new HashMap<String, String>();
		this.stats.put("lipoproteins", generateValue());
		this.stats.put("triglycerides", generateValue());
		this.stats.put("bloodCells", generateValue());
		this.stats.put("glucose", generateValue());
		this.stats.put("vitamin", generateValue());	
	}
	
	public BloodStat(int id, int userId, Map<String, String> stats){
		this.id = id;
		this.userId = userId;
		if (stats.size() != 5) {
			System.out.println("BloodStat: inappropriate number of stats");
			throw new InvalidParameterException();
		}
		this.stats = stats;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getUserId() {return userId;}
	public void setUserId(int userId) {this.userId = userId;}
	public Map<String, String> getStats() {return stats;}
	public void setStats(Map<String, String> stats) {this.stats = stats;}
	
	@Override
	public String toString() {
		String result = "Blood Stat\n";
		for (String key: stats.keySet()) {
			result += key + ": " + stats.get(key) + " mL\n";
		}
		return result;
	}
	
	public String generateValue() {
		List<String> values = Arrays.asList("Good",
				"Bad",
				"Dead");
		int random_index = (int) (Math.random() % values.size());
		return values.get(random_index);
	}
}