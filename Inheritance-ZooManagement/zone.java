package zoo_files;

import java.util.ArrayList;

public class zone {
	private final int MAX_CAGE = 3;
	String category;
	boolean hasPark;
	boolean hasCanteen;
	private ArrayList<Cage> cages = new ArrayList<>();
	
	//setter
	void setCategory(String cat){
		category  = cat;
	}
	//getter
	String getCategory(){
		return category;
	}
	ArrayList<Cage> getCages(){
		return cages;
	}
	
	/**
	 * Adds animal in the existing cage or in new cage depending upon how much cage is full with respect to maximum capacity
	 * @param animal: animal object
	 * @return true if animal is successfully added else will assign new cage if cage is full
	 */
	boolean addAnimal(Animal animal){
		if(cages.size()==MAX_CAGE){
			return false;
		}
		boolean animalAdded = false;
		for(Cage cage:cages){
			if(cage.getCurrentCap()<cage.getCap() && cage.getType()==animal.getAnimalName()){
				cage.addAnimal(animal);
				animalAdded = true;
				break;
			}
		}
		if(!animalAdded){
			Cage cage = new Cage();
			cage.addAnimal(animal);
			cages.add(cage);
		}
		return true;
	}
	/**
	 * Display all the cages in a particular zone
	 */
	public void dispayCages() {
		int i=1;
		for(Cage cage:cages){
			System.out.println("*********CAGE "+i++ +" : "+cage.getType()+"*********");
			cage.showAnimals();
		}
		
	}
}