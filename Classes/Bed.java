import java.util.ArrayList;

public class Bed {

	/**
	* Class that is in charge of:
	* a) Allowing the program to create new objects named beds which have...
	* ... either a single or double size. The size is stored via the setMethod, whilst the...
	* ...bed object created is added to the room object
	* 
	*
	* Author: Mehdi Naderi Varandi
	* Date: December 2017
	*/
	
	
	//a) Fields:
		private String sizeBedSize;
		// Field for the size of the bed i.e whether its single/double

		
		
	//b)Constructor:
	public Bed (String sizeBedSize){
		setBedSize(sizeBedSize);
	}
		
		
	
	//c)Methods	
	
	public void setBedSize(String sizeOfBed) {
		this.sizeBedSize=sizeOfBed;
		//Adds size of bed to the ArrayList, along with "," to separate each value stored from the other
			
	} //Closing bracket for method setBedSize
		
	public String getsizeBedSize(){
		return sizeBedSize;
		//Get method for sizeBedSize 
	}
	
	
	
	
	
	
	
} //Closing bracket for class body
