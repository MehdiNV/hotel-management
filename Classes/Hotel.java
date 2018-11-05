import java.util.ArrayList;

public class Hotel {

	/**
	* Class that is in charge of:
	* a) Allowing the program to store information about rooms and some of their beds
	* b) For example, room stores information about the beds, whilst the Room object is added to the ArrayList (overallRooms) in hotel
	* c) When the hotel object is passed on to hotel report, all the information combined is given out to the user in the form of a report
	*
	* Author: Mehdi Naderi Varandi
	* Date: December 2017
	*/
	
	//a) Fields:
	
		private String hotelName;
		//Stores value of the hotel name
		
		private int numberOfRooms;
		//Stores value of the number of rooms in the hotel
		
		private static ArrayList<Room> overallRooms=new ArrayList<Room>();
		//Stores the overall information about all the rooms in the hotel
		
		private boolean isVacant;
		//Stores whether the hotel has vacancies or not
		
		
		
		//b) Constructor:
		public Hotel(String name, String roomNumbers){
			setHotelName(name); //Sets hotel name
			setNumberOfRooms(roomNumbers); //sets number of rooms in the hotel
		}
		
		
		
		//c) Methods:
		public void setHotelName(String name) {
			this.hotelName =name;
			//Set method for the hotel's name
		}
		

		public void setHotelVacancy(boolean isVacant){
			this.isVacant=isVacant; //Only time this method is called is when the
			//boolean passed on to it is true, hence no check needs to be done here
			
		}

		public void setNumberOfRooms(String roomNumbers) {
			this.numberOfRooms=Integer.parseInt(roomNumbers);
			//Set method for number of rooms in the hotel
		}
		

		public void addRoom(Room myRoom){
			overallRooms.add(myRoom);
			//Adds room object to the list for storing the value
		}
		
		
		public String getHotelName() {
			return hotelName;
			//Get method for the hotel name
		}
		
		public int getNumberOfRooms() {
			return numberOfRooms;
			//get method for the size of rooms in array list
		}
	
		
		public int getListSize(){
			return overallRooms.size();
			//Get method for the size of the list, returns how big the size is
		}
		
		
		public ArrayList<Room> getRoom(){
			return overallRooms;
			//Get method for the list itself
		}
		
		public boolean getHotelVacancy(){
			return isVacant;
			//returns if the hotel is vacant or not
		}
		
		
}
