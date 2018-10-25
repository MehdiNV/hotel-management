import java.util.ArrayList;

public class Room {
	/**
	* Class that is in charge of:
	* a) Allowing the program create room objects 
	* b) This allows the program to have room objects that can store individual beds inside them via...
	*...adding the bed objects to their ArrayList (namely the numberOfBeds)
	*
	* Author: Mehdi Naderi Varandi
	* @version 2.1 (December 2017)
	*/
	
	
		//a) Fields:
		private ArrayList<Bed> numberOfBeds=new ArrayList<Bed>();
		//ArrayList for the number of beds in a room
		//Stores bed objects inside the ArrayList (i.e. 0 is bed object 1)

		private boolean isRoomVacant; //Stores whether the room is vacant
		
		private int singleBed; //Stores how many single beds the room has
		
		private int doubleBed; //Stores how many double beds the room has 

		
		//c) Methods:
		
		public void addsNumberOfBeds(Bed passedBed) {
            numberOfBeds.add(passedBed);
		    //set method for number of beds in a room
		}

		public void setVacancy(String vacancyInput){
			//Checks if 
			if (vacancyInput.equals("true")){
				this.isRoomVacant=true;
			}
			else if (vacancyInput.equals("talse")){
				this.isRoomVacant=false;
		    }

		}
		
		public boolean getVacancy(){
			return isRoomVacant;
			//Returns if the room is vacant or not
		}
		
		public ArrayList<Bed> getList(){
			return numberOfBeds;
			//Returns list
		}

		public int getBeds(String size){
			singleBed=0;
			doubleBed=0;
			//Initialises both variables to 0 to prevent side effects 
			
			for (int LoopCounter=0; LoopCounter<numberOfBeds.size();LoopCounter++){
				
				
				//Search algorithm based on linear search which is designed to go through the list (numberOfBeds)..
				//and check whether the result outputted is 'Single' or 'Double', which increments the respective variable
				//This allows the user to know how many single/double beds there are specifically in their room
				
				if (numberOfBeds.get(LoopCounter).getsizeBedSize().equals("single")){
					//Checks if the bed size is single
					singleBed+=1;
					
				}
				else if (numberOfBeds.get(LoopCounter).getsizeBedSize().equals("double")){
					//Checks if the bed size is double
					doubleBed+=1;
				}
				
			}
			
			
			if (size.equals("Single")){
				return singleBed; //Returns incremented variable (of how many single beds there are in the room)
			}
			else if (size.equals("Double")){
				return doubleBed; //Returns incremented variable (of how many double beds there are in the room)
			}
			
			return numberOfBeds.size();
			//Returns size of the list
		}
		
}
