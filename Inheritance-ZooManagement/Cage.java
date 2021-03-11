package zoo_files;

import java.util.ArrayList;

public class Cage {
	private final int MAX_CAP = 3;
	String type;
	private ArrayList<Animal> animals = new ArrayList<>();
	
	
	//setter
	void setType(String animalType){
		type = animalType;
	}
	//getters
	String getType(){
		return type;
		
	}
	int getCap(){
		return MAX_CAP;
	}
	
	int getCurrentCap(){
		return animals.size();
	}
	ArrayList<Animal> getAnimals(){
		return animals;
	}
	
	/**
	 * Adds animal to the cage
	 * @param animal to add
	 */
	public void addAnimal(Animal animal) {
		setType(animal.getAnimalName());
		animals.add(animal);
		
	}

	/**
	 * Displays all the animals present in a cage
	 */
	public void showAnimals() {
		System.out.println("ID\tName\tSound");
		for(Animal animal:animals){
			System.out.println(animal.getId()+"\t"+animal.getName()+"\t"+animal.getSound());
		}
		
	}
	

}