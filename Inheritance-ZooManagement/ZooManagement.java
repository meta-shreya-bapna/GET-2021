package zoo_files;
import java.util.ArrayList;
import java.util.Scanner;

public class ZooManagement {
	static ArrayList<zone> zones = new ArrayList<>();
	static int animalId = 0;
	
	/**
	 * @param animal: takes animal Object and add the animal to its type of zone
	 * @param sc: takes the scanner object
	 */
	public static void addAnimal(Animal animal,Scanner sc){
		System.out.println("Enter "+animal.getAnimalName()+" name");
		animal.setName(sc.next());
		System.out.println("Enter "+animal.getAnimalName()+" age");
		animal.setAge(sc.nextDouble());
		System.out.println("Enter "+animal.getAnimalName()+" weight");
		animal.setWeight(sc.nextDouble());
		animal.setId(animalId++);
		boolean success = false;
		for(zone zone:zones){
			if(zone.getCategory()==animal.getType()){
				success = zone.addAnimal(animal);	
			}
		}
		if(!success){
			zone newZone = new zone();
			newZone.setCategory(animal.getType());
			newZone.addAnimal(animal);
			zones.add(newZone);
		}
	}
	/**
	 * Method to display all the zones in the zoo
	 * @param sc: Takes scanner object
	*/
	//display all the zones in the zoo
	public static void displayZoo(Scanner sc){
		if(zones.size()==0){
			System.out.println("\nZoo is empty\n");
			return;
		}
		int i=1;
		for(zone zone:zones){
			System.out.println("##########ZONE "+ i++ +" : "+zone.getCategory().toUpperCase()+"###########");
			zone.dispayCages();
			System.out.println();
		}
		System.out.println("\n\n");
		System.out.print("Remove dead Animal(Y/N) :");
		char choice = sc.next().toCharArray()[0];
		if(choice=='y'||choice=='Y'){
			System.out.println("Enter Dead Animal ID");
			int deadId = sc.nextInt();
			removeAnimal(deadId);
		}
	}
	
	/**
	 * Method to remove dead animal from the input
	 * @param deadId: animal id as input
	 */
	private static void removeAnimal(int deadId) {
		boolean success = false;
		for(zone zone:zones){
			ArrayList<Cage> cages = zone.getCages();
			for(Cage cage:cages){
				ArrayList<Animal> animals = cage.getAnimals();
				for(Animal animal:animals){
					if(animal.getId()==deadId){
						success = animals.remove(animal);
						break;
					}
					
				}
				if(success){
					if(cage.getCurrentCap()==0){
						cages.remove(cage);
					}
					break;
				}
			}
			if(success){
				if(zone.getCages().size()==0){
					zones.remove(zone);
				}
				break;
			}
		}
		
	}

	//main method
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("In a zone of particular category maximum cage limit: 3");
		System.out.println("In a cage maximum animal limit: 3\n");
		
		while(true){

			System.out.println("1.Add MAMMAL type animal");
			System.out.println("2.Add BIRD type animal");
			System.out.println("3.Add REPTILE type animal");
			System.out.println("4.Display zoo");
			System.out.println("5.Exit");
			int option = sc.nextInt();
			int choice;
			switch(option){
			case 1:
				System.out.println("Choose animal:");
				System.out.println("1.Lion\n"+"2.Monkey\n"+"3.Cow\n");
				choice = sc.nextInt();
				if(choice==1)
				{
					Animal lion = new Lion();
					addAnimal(lion,sc);
				}
				else if(choice==2)
				{
					Animal monkey = new Monkey();
					addAnimal(monkey,sc);
				}
				else if(choice==3)
				{
					Animal cow = new Cow();
					addAnimal(cow,sc);
				}
				else
				{
					System.out.println("invalid choice!");
				}
				break;

			case 2:
				System.out.println("Choose animal:");
				System.out.println("1.Parrot\n"+"2.Owl\n"+"3.Crane\n");
				choice = sc.nextInt();
				if(choice==1)
				{
					Animal parrot = new Parrot();
					addAnimal(parrot,sc);
				}
				else if(choice==2)
				{
					Animal owl = new Owl();
					addAnimal(owl,sc);
				}
				else if(choice==3)
				{
					Animal crane = new Crane();
					addAnimal(crane,sc);
				}
				else
				{
					System.out.println("invalid choice!");
				}
				break;
			
			case 3:
				System.out.println("Choose animal:");
				System.out.println("1.Snake\n"+"2.Turtle\n"+"3.Lizard\n");
				choice = sc.nextInt();
				if(choice==1)
				{
					Animal snake = new Snake();
					addAnimal(snake,sc);
				}
				else if(choice==2)
				{
					Animal turtle = new Turtle();
					addAnimal(turtle,sc);
				}
				else if(choice==3)
				{
					Animal lizard = new Lizard();
					addAnimal(lizard,sc);
				}
				else
				{
					System.out.println("invalid choice!");
				}
				break;
			
			case 4:
				displayZoo(sc);
				break;
			
			default:
				return;
			}
		}
	}
}