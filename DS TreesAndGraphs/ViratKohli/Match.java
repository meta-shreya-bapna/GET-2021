import java.util.ArrayList;
import java.util.List;

/**
 * Implement class Match such that-
 * A cricket team is playing against Virat Kohli and we want him to score as low as possible. 
 * Virat scores max runs on the bowler who has minimum balls left to bowl.
 */
public class Match {
	private int totalBowl;
	private List<Bowler> bowlers = new ArrayList<Bowler>();

	/**
	 * To add bowlers
	 * @param bowl
	 * @param name
	 */
	public void addBowler(int bowl, String name) {
		bowlers.add(new Bowler(bowl, name));
	}

	/**
	 * To calculate total bowl bowlers need to perform equal to the no. of balls of Virat Kohli
	 */
	public void totalBowl(int vBowl) {
//		for (Bowler bowler : bowlers) {
//			totalBowl += bowler.getBowl();
//		}
		totalBowl=vBowl;
	}

	/**
	 * Order of bowlers with balls to make virat's score as low as possible
	 * @return list of Bowler's order such that virat scores are minimum
	 */
	public List<Bowler> viratMinimumRun() {
		List<Bowler> bowlerOrder = new ArrayList<Bowler>();
		while (totalBowl != 0) {

			//provides index from list of bowlers which have maximum balls
			int bowlerIndex = getMaxBowlBolwer();
			String bowler = bowlers.get(bowlerIndex).getBowler();
			int orderSize = bowlerOrder.size();
			if (orderSize == 0) {
				bowlerOrder.add(new Bowler(1, bowler));
			} 
			else if (!bowler.equals(bowlerOrder.get(orderSize - 1).getBowler()))// checks if bowler on previous bowl is same or not
			{
				bowlerOrder.add(new Bowler(1, bowler));
			} 
			else {
				bowlerOrder.get(bowlerOrder.size() - 1).setBowl(bowlerOrder.get(bowlerOrder.size() - 1).getBowl() + 1);
			}
			bowlers.get(bowlerIndex).setBowl(bowlers.get(bowlerIndex).getBowl() - 1);
			totalBowl--;
		}
		return bowlerOrder;
	}

	/**
	 * To get the index of bowler who have maximum balls
	 * @return index of bowler in list bowlers
	 */
	private int getMaxBowlBolwer() {
		int numberOfBowlers = bowlers.size();
		if (bowlers.size() == 0) {
			System.out.println("No bowlers left");
		}

		int maxBowls = bowlers.get(0).getBowl();
		int index = 0;
		for (int i = 0; i < numberOfBowlers; i++) {
			int bowls = bowlers.get(i).getBowl();
			if (bowls > maxBowls) {
				maxBowls = bowls;
				index = i;
			}
		}
		return index;
	}
	
	//main method
	public static void main(String[] args)
	{
		Match match = new Match();
		match.addBowler(8, "rohit");
		match.addBowler(3, "hardik");
		match.addBowler(1, "Dhawan");
		
		match.totalBowl(9);//virat's total no. of balls
		List<Bowler> names = match.viratMinimumRun();
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i).getBowler()+" : "+names.get(i).getBowl());
		}
	}
	
}