
import javax.swing.JOptionPane;

public class HotelConfigure {
	/**
	* Class that is in charge of:
	* a) Taking user inputs
	* b) Validating user inputs
	* 
	*
	* Author: Mehdi Naderi Varandi
	* Date: December 2017
	*/
	
	public static void main (String[] args){
		System.out.println("Welcome to Hotel Management System \n");
		//Outputs the introductory message to the user
		HotelConfigure callMethods = new HotelConfigure();

		
		
		String hotelName=callMethods.inputValidation("Please enter the new name of your new hotel",false,false,false);
		String roomNumbers=callMethods.inputValidation("Please enter the number of rooms in your hotel:",true,false,false);
		//Gets name of hotel and the number of room numbers. However, it first validates the inputs via the inputValidation method
		
		
		
		Hotel myHotel=new Hotel (hotelName,roomNumbers);
		//Passes two constants along, which act as identifiers
		
		callMethods.bedAndRoomInputs(myHotel,callMethods);
		//Passes them onto the input method
		
	}
	
	public String inputValidation(String question, boolean isIntegerNeeded, boolean isSizeNeeded,boolean isVacancyNeeded){
		//The inputValidation method takes:
		// 1) The string question that's to be asked of the user
		// 2) One of the following 3 boolean values passed must be true:
		// 3) if the first boolean is true, it signals to the method that integers are needed as inputs (i.e. room numbers)...
		// ... allowing the method to validate against strings being inputed as integers
		// 4) if the second boolean is true, it signals to the method that only 2 inputs are needed - either 'single' or 'double'...
		// ... as those are the only bed sizes allowed. This allows the program to validate against all inputs except those 2
		// 5) if the third and final boolean is true, it signals to the method that only 2 inputs are needed - either 'true' or 'false'...
		// ... as user inputs true to if the room is vacant or false if the room is not vacant
		
		
		String returnInput;
		//Declares the string that's going to be returned to the user at the very start

		while(true){
			String userStringInput;
			try{ //This try block is used to catch errors from when users input the wrong answers such as -1 for room numbers
				//This allows the program to prevent erroneous inputs from causing it to crash/disrupting program flow
				//Hence, by using this block I can allow the program to catch exceptions and allow users to re-enter their inputs
				
				userStringInput=JOptionPane.showInputDialog(question);
				//Displays to the user 
				
				if (userStringInput.length()==0){ //Stops users from entering nothing or catching them when they press cancel
					JOptionPane.showMessageDialog(null,"You've entered nothing. Please enter an input","Mild error",JOptionPane.WARNING_MESSAGE);
					//Outputs an error message to the user with the "You've entered nothing" message, "Mild error" title and warning image at side
					//This is to notify the user to enter an actual input next time/ stop them from clicking cancel
					
					continue; //restarts the loop so that the user is asked for input again
				}
				
				else if (((isIntegerNeeded)   &&   (Integer.parseInt(userStringInput)==0)) ){
					JOptionPane.showMessageDialog(null,"The nubmer you entered was 0. Please input a number bigger than 1","Mild error",JOptionPane.WARNING_MESSAGE);
					//Checks if number is 0, as long as integerNeeded is true
					//This prevents the user from say, entering that the hotel has 0 rooms or that a room has 0 beds

				}
				else if (((isIntegerNeeded==false))){
					//Knows that no integers are needed, and hence checks if the userStringInput contains an integer
					//It does this by using a try catch block. It firstly converts the input to an integer - if the input is a string, it should...
					//throw an exception a string composed of letters should not be able to be converted into an integer..
					//Hence, if it is an integer, program flow should not move to the catch block hence the error message placed right below ParseInt
					
					try{
						//This part of the block checks if the string is an integer or not. Bear in mind that with a string, integers included with...
						//the string are counted as a string as well - this is validated against later (i.e. single1 or double99)
						
						Integer.parseInt(userStringInput);
						JOptionPane.showMessageDialog(null,"You have entered a number. Please only enter letters ","Mild error",JOptionPane.WARNING_MESSAGE);		
						continue;
						

						
					}
					catch(java.lang.NumberFormatException e){
						//From this point on, we know that the input is a string only or at least a string that has an integer included
						//For the hotel name, I believe it's ok for integers to be included in it as some hotels may have numbers in their name
						//However, the other inputs which take in strings (bed size and vacansies) need very specific strings
						
						
						if (((isSizeNeeded) && (!(userStringInput.toLowerCase().equals("single") || userStringInput.toLowerCase().equals("double"))))){
							JOptionPane.showMessageDialog(null,"You did not enter either single or double. Please only enter those 2 inputs "
									+ "to specify your bed size","Mild error",JOptionPane.WARNING_MESSAGE);	
							continue;

						}
						
						else if (((isVacancyNeeded) && (!(userStringInput.toLowerCase().equals("true") || userStringInput.toLowerCase().equals("false"))))){
							JOptionPane.showMessageDialog(null,"You did not enter either true or false. Please only enter those 2 inputs "
									+ "to specify the vacancy of your room","Mild error",JOptionPane.WARNING_MESSAGE);		
							continue;

						}
						
						
						returnInput=userStringInput; //Sets the variable that's returned to the user to be equal to the StringInput
						break;//breaks the loop, allowing the value to be returned to whatever called the validation method
					}
					
					
					
				}
				
				else {
					returnInput=userStringInput;
					break;
				}
				
				
			}
			catch (java.lang.NumberFormatException e){
				JOptionPane.showMessageDialog(null, "You have entered an errorneous input! Please input differently next time","ERROR",JOptionPane.ERROR_MESSAGE);
				continue;
				//Catches the user entering an erroneous input and asks them to enter their input again. This prevents the program from...
				//...having wrong inputs that can cause an error
			}
			
			catch(java.lang.NullPointerException e){
				JOptionPane.showMessageDialog(null, "You have entered nothing/null! Please input differently next time","ERROR",JOptionPane.ERROR_MESSAGE);
				continue;
				//Catches the user entering null and hence asks them to enter their input again. This allows the program to prevent the user from...
				//pressing the cancel button on the InputPrompt as a way to input nothing into the program
			}
			
		}
	
		return returnInput.toLowerCase();
		//returns the input to the user in a lowercase format
	}
	
	
	public void bedAndRoomInputs(Hotel myHotel,HotelConfigure callMethods){
		//Method gets input of number of beds per room, and the specific size of each bed in that room
		//This is then relayed onto the ArrayLists in the respective classes 
		
		
		int holdIntegerInput;
		//Holds integer inputs from the scanner class
		String holdStringInput;
		//Holds string inputs from the scanner class
		
		for (int LoopCounter=1; LoopCounter<((myHotel.getNumberOfRooms())+1); LoopCounter++){
			
			Room myRoom=new Room();
			
		    JOptionPane.showMessageDialog(null,"Please input information regarding room number " + (LoopCounter),"Please input information",JOptionPane.PLAIN_MESSAGE);
		    //Outputs information to user to prompt input
		    
		    holdIntegerInput=Integer.parseInt(callMethods.inputValidation("How many beds do you want in room " + (LoopCounter) + " ?",true,false,false));
		    //Calls the validation method, while passing the question "How many beds..." and letting the method know that only integers are needed
		    
		    
		    for (int Loop2Counter=0; Loop2Counter<(holdIntegerInput);Loop2Counter++){
		    	holdStringInput=callMethods.inputValidation("Please enter the size of Bed number " + (Loop2Counter+1),false,true,false);
		    	
		    	Bed myBed= new Bed (holdStringInput.toLowerCase());
		    	//Creates new bed using the bedsize provided
		    	
		    	myRoom.addsNumberOfBeds(myBed);
		    	//Adds bed object to room object
		    	
		    }
		   
		   
		    holdStringInput=callMethods.inputValidation(("Is this room vacant? Please enter either True or False"),false,false,true);
		    myRoom.setVacancy(holdStringInput);
		    //This part of the code asks the user for whether the room is vacant or not, and passes the...
		    //value given to the Room object. The method it is passed on to (setVacancy) checks...
		    //the value (as the parameter given is a String) and sets isRoomVacant to either true or false accordingly
		    
		    
		    myHotel.addRoom(myRoom);
		    //Adds the room object to Hotel object
		    
		    
		    
		    if (holdStringInput.equals("true")){
				myHotel.setHotelVacancy(true);
			}
			//Checks whether the users input for room vacancy is true. If it is, setHotelVacancy method in Hotel...
		    //will ensure that the hotel displays a vacant status. 
		    
		    
		}
		
		new HotelReport(myHotel);
		//Generates a new hotel report based on the hotel object passed to it
	}
}
	
