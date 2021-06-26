/* Nathan Rosel
 * 530633890
 * 5/27/21
 * Assignment #3 - Stack Operations
 * Utilizing stack queing to creating math operations for push and pop 
 * objects and validation
 */

package nathan;

import java.util.HashMap;

public class infix2Postfix extends matchTest {
	
	public static String infix = myExpression[3];  //come from stage 1 (matchTest) - comes from stage 1 with no error
	
	//creates the String variable post which will be the postfix expression
	public static String post = "";
	
	public static HashMap<Character, Integer> precedence = new HashMap<>();
	
	//Stage 2: Infix --> postfix
	
	public static void main(String[] args) {
		
		loadPrecedence();
		System.out.println(infix);
		//Generate new Stack211 with the type Character
		
		Stack211<Character> st = new Stack211<Character>();
		post = "";
		
		//Iterates through each character in the current expression iteration
		for (int j=0; j<infix.length(); j++) {
			
		//crates a new variable c which holds the character in the current iteration
			char c = infix.charAt(j);
		
		//if c is a number between 0 and 9 it is added to the post variable expression
		//how to change 
		
			if (c >= 0 && c <= 9) {
			// c is added to the post variable expression
			
			post += c;
			}
			
			if (c == '(' || c == '{'){ // else if c is a left bracket (parenthesis or curly brace) it is pushed on to the stack
			
			st.push(c);
			
		}
		
	
		//if c is a right bracket (parentheses or curly brace), the top of the stack is popped
		//and the value is added to the variable p. While p is not a left bracket, p is added
		//to the post variable expression and the next value on top of the stack is popped off 
		//and stored in the variable p.
		
		if (c == ')' || c =='}') {
			char p = st.pop();
			
			while (p != '(' || p != '{') {
				post += p;
				p = st.pop();
			}
		}//checks if c is an operator
		if (c == '+' || c == 'c' || c == '*' || c == '/'){  //push but need to check what's current at top of stack
			//while the stack is not empty and the priority of c is higher than or equal to the 
			//top of the stack, the top of the stack is popped and stored into the variable p
			//p is then added to the post variable expression
			//if c is not a higher priority than the top of the stack it is pushed on to the 
			//top of the stack
			while(!st.isEmpty() && precedence.get(c) >= st.topOfStack()) {
				int p = st.topOfStack();
				post += p;
				
				if (precedence.get(c) < st.topOfStack()){
				  st.push(c);
			}
				
			}
			
		
		//after iterating through the expression, while the stack is not empty, the top of the stack 
		//is stored in the variable p. p is then added to the post variable expression
		while(st != null) {
			char p = st.topOfStack();
			post += p;
		}
		
		System.out.println("Postfix: "  + post);
	}
}

}
	
	//precedence then it returns true.  Otherwise it returns false.
	
	public static boolean checkPrecedence (char topOfStack, char c) {
		
		// checks if c has a higher precedence than the top of the stack.
		if (precedence.get(c) >= precedence.get(topOfStack)) {
			return true;
		}
		return false;
	}
	
	public static void loadPrecedence() {
		
		//contains the values for the different operators.  Brackets have the highest precedence and + and - 
		//operators have the lowest precedence
			precedence.put('+',  1);
			precedence.put('-', 1);
			precedence.put('*', 2);
			precedence.put('/',2);
			precedence.put('(',3);
			precedence.put('{', 3);
	}
	
}