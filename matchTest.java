/* Nathan Rosel
 * 530633890
 * 5/27/21
 * Assignment #3 - Stack Operations
 * Utilizing stack queing to creating math operations for push and pop 
 * objects and validation
 */

package nathan;

import java.util.*;

public class matchTest {
	
	static HashMap<Integer, String> errorMessage = new HashMap<>(); // for the error messages 
	static HashMap<Character, Character> pair = new HashMap<>();
	static String[] myExpression = new String[5]; //string array for infix statement
	
	public static void main(String[] args) {
		
		loadExpressions();
		loadErrorMessage();
		loadPair();
		
		
	//1. Expression Match Test - valid or not
		
		for (int i=0; i<5; i++) {
			System.out.println(myExpression[i]);
			
			Stack211<Character> charStack = new Stack211<>();  // generic method from Stack211.java
			
			boolean errorOccured = false;
			
			for (int j = 0; j < myExpression[i].length(); j++) {//read character from infix statement
				
				char c = myExpression[i].charAt(j);
				
			if ((c == '{')||(c == '(')) {
					
					charStack.push(c);
			}
			
			if (c==')') {
				if (charStack.isEmpty()) {
					//print error showing what needs to be expected
					printError(j,2);
					
				} else { //not empty
					char PoppedChar = charStack.pop();
					//charStack.push(PoppedChar);
					//call the pair
					char pushedChar = pair.get('(');
					charStack.push(pushedChar);
					
				}
			}
			
			else if (c=='}') { // } popped = {
			
				if (charStack.isEmpty()) {
					// Load error message if charStack is empty
					printError(j,1);
					
				} else { //not empty
					char PoppedChar = charStack.pop();
						// call the pair
					char pushedChar = pair.get('{');
					charStack.push(pushedChar);
					charStack.push(PoppedChar);
				}
			}
			
				// 
			
				if (!errorOccured && !charStack.isEmpty()) {
					// call print Error
					printError(j, 3);
				}
				
				System.out.println();
			}
			
		}
			
		}
		
	
		public static void loadExpressions() {
			myExpression[0] = "1 + 3) * {2 - 1)";
			myExpression[1] = "((1 +3 ) * {2 - 1)";
			myExpression[2] = "(1 + 3) * (2 - 1} ";
			myExpression[3] = "(1 + 3} * {2 - 1)";
			myExpression[4] = "(1 + 3) * ((2 - 1)) ";
					
		}
		
		public static void loadPair() {
			pair.put('}', '{');
			pair.put(')', '(');
			
		}
		
		public static void printError(int location, int errorNo) {
			//go to the error location, then print a marker showing where the error is located
			for (int i = 0; i < location; i++) {
				System.out.print(" ");
			}
			
			System.out.print("^ ");
			System.out.println(errorMessage.get(errorNo)); // print the error message using errorNo
		}
		
		public static void loadErrorMessage() {  // store the data into the HashMap for the error message
			errorMessage.put(1, "} expected");
			errorMessage.put(2,  ") expected");
			errorMessage.put(3,  "Incomplete Expression");
		}
}
	

		
	


