
/**
 * Implementation of Bowler Class where we describe about properties of bowler
 */
public class Bowler {
	int bowl;
	String name;
	
	public Bowler(int bowl, String name){
		if(bowl == 0) {
			System.out.println("Bowler not allowed with zero bowl");
			System.exit(1);
		}
		
		if(name == null) {
			System.out.println("Bowler name can't be null");
			System.exit(1);
		}
		this.bowl = bowl;
		this.name = name;
	}
	
	/*****************Setters & Getters******************/
	/**
	 * Method sets number of balls of bowler
	 * @param bowl
	 */
	public void setBowl(int bowl) {
		if(bowl >= 0) {
			this.bowl = bowl;
		}
	}
	
	/**
	 * @return number of balls of bowler
	 */
	public int getBowl() {
		return bowl;
	}
	
	/**
	 * @return name of bowler
	 */
	public String getBowler() {
		return name;
	}
}
