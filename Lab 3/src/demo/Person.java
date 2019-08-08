package demo;

//Adjusted by Jacob Coriell

public class Person {
	static int currentyear = 2017;
	private String name;
	private int birth_date;
	private int age;
	
	//constructor
	public Person(String name, int bdate){
		this.name = name;
		this.birth_date = bdate;
	}

	//store a different year of birth in birth_date
	public void reset_birthday(int year){
		birth_date = year;
	}
	
	//Display all of person's info including their age after it is calculated
	public void printInfo() {
		System.out.println("This is " + name);
		System.out.printf("I was born in %d. ",birth_date);
		age = currentyear - birth_date;
		System.out.printf("I am %d years old ",age);
	}
	
	//test to see if the person is eligible for medicare, person must be 65 or older to be eligible.
	public void medicareTest() {
		if (age >= 65){
			System.out.println("\nI'm a senior citizen");
			age = currentyear - birth_date;
			System.out.printf("I am %d years old ",age);
		}
		else{
			System.out.println("\nI'm not old enough to be classified as a senior by Medicare!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person John = new Person("John",1957); //create a new John object and pass "John" as the name and 1957 bdate (birthday)
		John.printInfo(); //print out name, year of birth and age
		John.medicareTest(); //print out whether or not the person is eligible for Medicare 
		
		
	}

}