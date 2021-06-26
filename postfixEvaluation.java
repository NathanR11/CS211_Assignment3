/* Nathan Rosel
 * 530633890
 * 5/27/21
 * Assignment #3 - Stack Operations
 * Utilizing stack queing to creating math operations for push and pop 
 * objects and validation
 */

package nathan;

import java.util.*;

public class postfixEvaluation extends infix2Postfix {
	
	static String postfix= post;  //59+
	
	public static void main(String[] args) {
		
		//generates a new Stack211 using the type Integer
		Stack211<Integer> integerSt = new Stack211<>();
		int value;
		
		//iterates through the string post which is the postfix expression for the expression in this
		//iteration
		for (int k=0; k<postfix.length(); k++) {
			
			// stores the current character for this iteration in the variable c
			char c = postfix.charAt(k);
			
			//if c is a number, the character is converted to an integer and stored in the variable value.
			//value is then pushed onto the top of the stack
			
			if (c>='0' && c<='9') {
				value = c - '0';
				// push this to the stack
				integerSt.push(value);
				
			//if c is an operator, the top two values on the stack are popped and stored into the variables
				//value 1 and value 2.  Depending on the operator the operation on the two values is then 
				//calculated and added to the variable newValue.  newValue is then pushed to the top of the 
				//stack
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				//
				// pop two elements 
				
				if (c == '+') {
					// pop2 + pop1
					int pop1 = integerSt.pop();
					int pop2 = integerSt.pop();
					//push the result of this
					integerSt.push(pop2 + pop1);
					
				} else if (c == '-') {
					// pop2-pop1
					int pop1 = integerSt.pop();
					int pop2 = integerSt.pop();
					
					//push the result of this
					integerSt.push(pop2 - pop1);
					
				} else if (c == '*') {
					//pop2*pop 1
					int pop1 = integerSt.pop();
					int pop2 = integerSt.pop();
					
					//push the result of this
					
					integerSt.push(pop2 * pop1);
				} else if (c == '/') {  // integer division 5/2 = 2
					// pop2/pop1
					int pop1 = integerSt.pop();
					int pop2 = integerSt.pop();
					//push the result of this
					integerSt.push(pop2 / pop1);
				}
			}
		}
		int pop = integerSt.pop();
		System.out.println("Evaluation: " + pop);
	}
}
