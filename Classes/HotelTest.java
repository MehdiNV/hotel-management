
public class HotelTest {
	/**
	* Class that is in charge of:
	* a) Using predefined inputs to test the program
	*
	* @author Mehdi Naderi Varandi
	* @version 2.1 (December 2017)
	*/
	
	
	
	public static void main (String[] args){
		System.out.println("Welcome to Assignment 2 \n");
		//Outputs the introductory message to the user, the same as in HotelConfigure
		
		Hotel myHotel=new Hotel ("California","3");
		//The first parameter passed is name of the hotel, whilst the second is the number of rooms
		
		
		
		Room myRoom1=new Room(); //creates a room1 object
		
		Bed myBed1=new Bed("single"); //Creates the object with single bed size
		myRoom1.addsNumberOfBeds(myBed1); //adds the object to the room
		
		myRoom1.setVacancy("true"); //sets the room vacancy to true, hence the room is vacant and open for booking
		myHotel.setHotelVacancy(true); //since the room was vacant, then the hotel must be vacant since it has at least one room that's vacant
		myHotel.addRoom(myRoom1); // adds the room to the hotel
		
		
		Room myRoom2=new Room(); //creates a room2 object
		
		Bed myBed2=new Bed("double"); //Creates the object with double bed size
		myRoom2.addsNumberOfBeds(myBed2); //adds the object to the room

		Bed myBed3=new Bed("single"); //Creates the object with single bed size
		myRoom2.addsNumberOfBeds(myBed3); //adds the object to the room 

		Bed myBed4=new Bed("double"); //Creates the object with double bed size
		myRoom2.addsNumberOfBeds(myBed4); //adds the object to the room
		
		myRoom2.setVacancy("false"); //sets the room vacancy to false, hence the room is fully booked
		myHotel.addRoom(myRoom2); //adds the room2 object to hotels object
		
		
		
		Room myRoom3=new Room(); //creates a room3 object
		
		Bed myBed5=new Bed("double"); //Creates the object with double bed size
		myRoom3.addsNumberOfBeds(myBed5); //adds the object to the room3 object

		Bed myBed6=new Bed("single"); //Creates the object with single bed size
		myRoom3.addsNumberOfBeds(myBed6); //adds the object to the room3 object
		
		myRoom3.setVacancy("false"); //sets the room vacancy to false, hence the room is fully booked
		myHotel.addRoom(myRoom3); //adds the room3 object to hotels object
		
		
		new HotelReport(myHotel); //Generates the report based on the information provided to the class
		
		
	}
	
	
	
}
