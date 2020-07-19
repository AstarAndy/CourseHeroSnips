package com.homework.animal.rescue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the manager class for the animal rescue,
 * training, and providing qualified animals to various
 * agencies that require them
 * @author Student's name
 *
 */
public class Driver {
	
	// These two lists are the inventory for the training
	// business.  Once contains a list of dogs and the 
	// other a list of Monkeys
	List<Dog> dogInventory = new ArrayList<>();
	List<Monkey> monkeyInventory = new ArrayList<>();

	public static void main(String[] args) {
		
		Driver driver = new Driver();
				
		// Method to process request for a rescue animal (see method requestServiceAnimal
		// Method(s) to update information on existing animals (see method request updateServiceAnimal)
		// Method to display matrix of animals based on location and status/training phase (You have to implement this)
		// Method to add animals (see createDog or createMonkey)
		driver.createDog();
		driver.createMonkey();
		// Method to out process animals for the farm or in-service placement (You have to implement this
		// Method to display in-service animals (see: displayServiceAnimals method)
		driver.displayServiceAnimals();
		// Process reports from in-service agencies reporting death/retirement (Not sure as to the details of this.  You will need to implement)

	}
	
	/**
	 * This method will create a new dog animal.
	 * REPLACE the code below as needed to actually
	 * capture the data values needed to create a dog
	 * @return
	 */
	public Dog createDog() {
		
		Dog newDog = new Dog();
		
		// TODO: Alter the logic to get the actual dog data from user input or a file
		
		newDog.setName("Sparky");
		newDog.setType(AnimalType.DOG);
		newDog.setGender("Male");
		newDog.setAge(3);
		newDog.setWeight((float)2.2);
		newDog.setAcquisitionDate(LocalDate.now());
		newDog.setStatusDate(LocalDate.now());
		newDog.setAcquisitionSource("Private Owner");
		newDog.setReserved(false);
		newDog.setTrainingLocation("Valley Hights");
		newDog.setTrainingStart(LocalDate.now());
		newDog.setTrainingStatus("New");
		newDog.setInServiceCountry("USA");
		newDog.setInServiceCity("Philadelphia");
		newDog.setInServiceAgency("Service Dog Training");
		newDog.setInServicePOC("William Jones");
		newDog.setInServiceEmail("william@ServiceDogTraining.com");
		newDog.setInServicePhone("6122437634");
		newDog.setInServicePostalAddress("123 East Avenue");
		newDog.setBreed(DogBreed.ENGLISH_SPRINGER_SPANIEL);
		
		dogInventory.add(newDog);
				
		return newDog;
		
	}

	/**
	 * This method will create a new monkey animal.
	 * REPLACE the code below as needed to actually
	 * capture the data values needed to create a monkey
	 * @return
	 */
	public Monkey createMonkey() {
		
		Monkey newMonkey = new Monkey();
		
		// TODO: Alter the logic to get the actual dog data from user input or a file
		
		newMonkey.setName("Sparky");
		newMonkey.setType(AnimalType.MONKEY);
		newMonkey.setGender("Male");
		newMonkey.setAge(3);
		newMonkey.setWeight((float)2.2);
		newMonkey.setAcquisitionDate(LocalDate.now());
		newMonkey.setStatusDate(LocalDate.now());
		newMonkey.setAcquisitionSource("Private Owner");
		newMonkey.setReserved(false);
		newMonkey.setTrainingLocation("Valley Hights");
		newMonkey.setTrainingStart(LocalDate.now());
		newMonkey.setTrainingStatus("New");
		newMonkey.setInServiceCountry("USA");
		newMonkey.setInServiceCity("Philadelphia");
		newMonkey.setInServiceAgency("Service Dog Training");
		newMonkey.setInServicePOC("William Jones");
		newMonkey.setInServiceEmail("william@ServiceDogTraining.com");
		newMonkey.setInServicePhone("6122437634");
		newMonkey.setInServicePostalAddress("123 East Avenue");
		newMonkey.setSpecies(MonkeySpecies.MARMOSET);
		newMonkey.setTailLength(24);
		newMonkey.setHeight(5);
		newMonkey.setBodyLength(21);
		newMonkey.setTorsoSize(12);
		newMonkey.setSkullSize(3);
		newMonkey.setNeckSize(3);
		
		monkeyInventory.add(newMonkey);
				
		return newMonkey;
		
	}
	
	/**
	 * Use this method to
	 * 1. Ask if they want a monkey or dog
	 * 2. List the dogs or monkeys
	 * 3. Ask them which one they want
	 * 4. Get that animal from monkey or dog inventory
	 * 		and update their status
	 */
	public void requestServiceAnimal() {
		
	}

	/**
	 * Use this method to
	 * 1. Ask if they want to update a monkey or dog
	 * 2. List the dogs or monkeys
	 * 3. Ask them which one they want
	 * 4. Get that animal from monkey or dog inventory
	 * 		and update their status
	 */
	public void updateServiceAnimal() {
		
	}
	
	/**
	 * This method will loop thru both animal inventories
	 * and display a list of those animals that are in service
	 */
	public void displayServiceAnimals() {
		
		List<Monkey> inServiceMonkeyList = monkeyInventory
											.stream()
											.filter(thisMonkey -> {
												return (thisMonkey.getInServiceCountry() != null);
											})
											.collect(Collectors.toList());
		
		List<Dog> inServiceDogList = dogInventory
				.stream()
				.filter(thisDog -> {
					return (thisDog.getInServiceCountry() != null);
				})
				.collect(Collectors.toList());
		
		System.out.println("Monkey In-Service Report");
		inServiceMonkeyList.forEach(System.out::println);
		
		System.out.println("\nDog In-Service Report");
		inServiceDogList.forEach(System.out::println);

		
	}

	
	
}



/**
 * This is the base class for all the animals in the
 * program.  Also, this class is defined as abstract because
 * we don't want to be able to create this generic animal class, rather,
 * we want sub class, animal specific, class to be created.
 * @author Student's name
 *
 */
abstract class RescueAnimal {

	// Instance variables

	protected String name;
	protected AnimalType type;
	protected String gender;
	protected int age;
	protected float weight;
	protected LocalDate acquisitionDate;
	protected LocalDate statusDate;
	protected String acquisitionSource;
	protected Boolean reserved;
	protected String trainingLocation;
	protected LocalDate trainingStart;
	protected LocalDate trainingEnd;
	protected String trainingStatus;
	protected String inServiceCountry;
	protected String inServiceCity;
	protected String inServiceAgency;
	protected String inServicePOC;
	protected String inServiceEmail;
	protected String inServicePhone;
	protected String inServicePostalAddress;
	
	/**
	 * Default constructor
	 */
	protected RescueAnimal() {
		super();
	}
	/**
	 * This constructor can be used to create AND initialize the fields of
	 * the RescueAnimal
	 */
	protected RescueAnimal(String name, AnimalType type, String gender, int age, float weight,
			LocalDate acquisitionDate, LocalDate statusDate, String acquisitionSource, Boolean reserved,
			String trainingLocation, LocalDate trainingStart, LocalDate trainingEnd, String trainingStatus,
			String inServiceCountry, String inServiceCity, String inServiceAgency, String inServicePOC,
			String inServiceEmail, String inServicePhone, String inServicePostalAddress) {
		super();
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.acquisitionDate = acquisitionDate;
		this.statusDate = statusDate;
		this.acquisitionSource = acquisitionSource;
		this.reserved = reserved;
		this.trainingLocation = trainingLocation;
		this.trainingStart = trainingStart;
		this.trainingEnd = trainingEnd;
		this.trainingStatus = trainingStatus;
		this.inServiceCountry = inServiceCountry;
		this.inServiceCity = inServiceCity;
		this.inServiceAgency = inServiceAgency;
		this.inServicePOC = inServicePOC;
		this.inServiceEmail = inServiceEmail;
		this.inServicePhone = inServicePhone;
		this.inServicePostalAddress = inServicePostalAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AnimalType getType() {
		return type;
	}
	public void setType(AnimalType type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public LocalDate getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(LocalDate acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	public LocalDate getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(LocalDate statusDate) {
		this.statusDate = statusDate;
	}
	public String getAcquisitionSource() {
		return acquisitionSource;
	}
	public void setAcquisitionSource(String acquisitionSource) {
		this.acquisitionSource = acquisitionSource;
	}
	public Boolean getReserved() {
		return reserved;
	}
	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}
	public String getTrainingLocation() {
		return trainingLocation;
	}
	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}
	public LocalDate getTrainingStart() {
		return trainingStart;
	}
	public void setTrainingStart(LocalDate trainingStart) {
		this.trainingStart = trainingStart;
	}
	public LocalDate getTrainingEnd() {
		return trainingEnd;
	}
	public void setTrainingEnd(LocalDate trainingEnd) {
		this.trainingEnd = trainingEnd;
	}
	public String getTrainingStatus() {
		return trainingStatus;
	}
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}
	public String getInServiceCountry() {
		return inServiceCountry;
	}
	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}
	public String getInServiceCity() {
		return inServiceCity;
	}
	public void setInServiceCity(String inServiceCity) {
		this.inServiceCity = inServiceCity;
	}
	public String getInServiceAgency() {
		return inServiceAgency;
	}
	public void setInServiceAgency(String inServiceAgency) {
		this.inServiceAgency = inServiceAgency;
	}
	public String getInServicePOC() {
		return inServicePOC;
	}
	public void setInServicePOC(String inServicePOC) {
		this.inServicePOC = inServicePOC;
	}
	public String getInServiceEmail() {
		return inServiceEmail;
	}
	public void setInServiceEmail(String inServiceEmail) {
		this.inServiceEmail = inServiceEmail;
	}
	public String getInServicePhone() {
		return inServicePhone;
	}
	public void setInServicePhone(String inServicePhone) {
		this.inServicePhone = inServicePhone;
	}
	public String getInServicePostalAddress() {
		return inServicePostalAddress;
	}
	public void setInServicePostalAddress(String inServicePostalAddress) {
		this.inServicePostalAddress = inServicePostalAddress;
	}
	
}

/**
 * Basic dog type
 * @author Student's name
 *
 */
class Dog extends RescueAnimal {
	protected DogBreed breed;

	/**
	 * This constructor can be used to create a Dog
	 */
	protected Dog(String name, AnimalType type, String gender, int age, float weight, LocalDate acquisitionDate,
			LocalDate statusDate, String acquisitionSource, Boolean reserved, String trainingLocation,
			LocalDate trainingStart, LocalDate trainingEnd, String trainingStatus, String inServiceCountry,
			String inServiceCity, String inServiceAgency, String inServicePOC, String inServiceEmail,
			String inServicePhone, String inServicePostalAddress, DogBreed whatBreed) {

		/**
		 * First initialize the parent RescueAnimal attributes
		 */
		super(name, type, gender, age, weight, acquisitionDate, statusDate, acquisitionSource, reserved, trainingLocation,
				trainingStart, trainingEnd, trainingStatus, inServiceCountry, inServiceCity, inServiceAgency, inServicePOC,
				inServiceEmail, inServicePhone, inServicePostalAddress);
		
		// And now initialize the dog-specific attributes
		breed = whatBreed;
		
	}

	/**
	 * Default constructor
	 */
	public Dog() {
		super();
	}

	@Override
	public String toString() {
		return "Dog [breed=" + breed + ", name=" + name + ", type=" + type + ", gender=" + gender + ", age=" + age
				+ ", weight=" + weight + ", acquisitionDate=" + acquisitionDate + ", statusDate=" + statusDate
				+ ", acquisitionSource=" + acquisitionSource + ", reserved=" + reserved + ", trainingLocation="
				+ trainingLocation + ", trainingStart=" + trainingStart + ", trainingEnd=" + trainingEnd
				+ ", trainingStatus=" + trainingStatus + ", inServiceCountry=" + inServiceCountry + ", inServiceCity="
				+ inServiceCity + ", inServiceAgency=" + inServiceAgency + ", inServicePOC=" + inServicePOC
				+ ", inServiceEmail=" + inServiceEmail + ", inServicePhone=" + inServicePhone
				+ ", inServicePostalAddress=" + inServicePostalAddress + "]";
	}

	public DogBreed getBreed() {
		return breed;
	}

	public void setBreed(DogBreed breed) {
		this.breed = breed;
	}	
	
	
}

/**
 * Subclass for creating Monkeys.
 * @author Student's name
 *
 */
class Monkey extends RescueAnimal {
	protected MonkeySpecies species;
	protected int tailLength;
	protected int height;
	protected int bodyLength;
	protected int torsoSize;
	protected int skullSize;
	protected int neckSize;
	
	/**
	 * This constructor can be used to create and initialize 
	 * an instance of a Monkey animal
	 */
	protected Monkey(String name, AnimalType type, String gender, int age, float weight, LocalDate acquisitionDate,
			LocalDate statusDate, String acquisitionSource, Boolean reserved, String trainingLocation,
			LocalDate trainingStart, LocalDate trainingEnd, String trainingStatus, String inServiceCountry,
			String inServiceCity, String inServiceAgency, String inServicePOC, String inServiceEmail,
			String inServicePhone, String inServicePostalAddress, MonkeySpecies monkeyType, int tail, int height, 
			int body, int torso, int skull, int neck) {
		
		// First initialize the general RescueAnimal attributes
		super(name, type, gender, age, weight, acquisitionDate, statusDate, acquisitionSource, reserved, trainingLocation,
				trainingStart, trainingEnd, trainingStatus, inServiceCountry, inServiceCity, inServiceAgency, inServicePOC,
				inServiceEmail, inServicePhone, inServicePostalAddress);
		
		// Now initialize the monkey-specific attributes.
		species = monkeyType;
		tailLength = tail;
		this.height = height;
		bodyLength = body;
		torsoSize = torso;
		skullSize = skull;
		neckSize = neck;
		
	}
	public Monkey() {
		super();
	}
	/**
	 * Create a string that contains all the values of the Monkey instance
	 */
	@Override
	public String toString() {
		return "Monkey [species=" + species + ", tailLength=" + tailLength + ", height=" + height + ", bodyLength="
				+ bodyLength + ", torsoSize=" + torsoSize + ", skullSize=" + skullSize + ", neckSize=" + neckSize
				+ ", name=" + name + ", type=" + type + ", gender=" + gender + ", age=" + age + ", weight=" + weight
				+ ", acquisitionDate=" + acquisitionDate + ", statusDate=" + statusDate + ", acquisitionSource="
				+ acquisitionSource + ", reserved=" + reserved + ", trainingLocation=" + trainingLocation
				+ ", trainingStart=" + trainingStart + ", trainingEnd=" + trainingEnd + ", trainingStatus="
				+ trainingStatus + ", inServiceCountry=" + inServiceCountry + ", inServiceCity=" + inServiceCity
				+ ", inServiceAgency=" + inServiceAgency + ", inServicePOC=" + inServicePOC + ", inServiceEmail="
				+ inServiceEmail + ", inServicePhone=" + inServicePhone + ", inServicePostalAddress="
				+ inServicePostalAddress + "]";
	}
	public MonkeySpecies getSpecies() {
		return species;
	}
	public void setSpecies(MonkeySpecies species) {
		this.species = species;
	}
	public int getTailLength() {
		return tailLength;
	}
	public void setTailLength(int tailLength) {
		this.tailLength = tailLength;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getBodyLength() {
		return bodyLength;
	}
	public void setBodyLength(int bodyLength) {
		this.bodyLength = bodyLength;
	}
	public int getTorsoSize() {
		return torsoSize;
	}
	public void setTorsoSize(int torsoSize) {
		this.torsoSize = torsoSize;
	}
	public int getSkullSize() {
		return skullSize;
	}
	public void setSkullSize(int skullSize) {
		this.skullSize = skullSize;
	}
	public int getNeckSize() {
		return neckSize;
	}
	public void setNeckSize(int neckSize) {
		this.neckSize = neckSize;
	}
	

}

/**
 * This enum represents the list of animal types available.
 * Currently there are only 2: dog and monkey
 * @author Student's name
 *
 */

enum AnimalType {
	DOG,
	MONKEY
}

/**
 * These are the dog breed types that are supported
 * @author Student's Name
 *
 */

enum DogBreed {
	PIT_BULL,
	BULL_TERRIER,
	BEAGLE,
	BELGIAN_MALINOIS,
	BORDER_COLLIE,
	BLOODHOUND,
	COONHOUND,
	ENGLISH_SPRINGER_SPANIEL,
	GERMAN_SHEPHERD,
	GERMAN_SHORTHAIRED_POINTER,
	GOLDEN_RETRIEVER,
	LABRADOR_RETRIEVER,
	NOVA_SCOTIA_DUCK_TOLLING_RETRIEVER,
	ROUGH_COLLIE,
	SMOOTH_COLLIE
}

/**
 * THIS enum is used to identify the monkey species
 * @author Student's name
 *
 */
enum MonkeySpecies {
	CAPUCHIN,
	GUENON,
	MACAQUE,
	MARMOSET,
	SQUIRREL,
	TAMARIN
}


