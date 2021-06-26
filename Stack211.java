/* Nathan Rosel
 * 530633890
 * 5/27/21
 * Assignment # 3 - Stack Operations
 * Utilizing stack queing to creating math operations for push and pop 
 * objects and validation
 */

package nathan;

import java.util.*;

public class Stack211 <T> {
	
	//variable use for index of the stack
	public int stackTop;
	
	//generic ArrayList used to simulate the stack
	public ArrayList <T> myStack = new ArrayList<T>();
	
	//Constructor for the class that sets the initial value of stackTop to -1 which indicates
	//empty stack
	Stack211() { //create a constructor
		stackTop = -1;
	
	}
	//pushes value on to the stack.  First increases stackTop and then adds given value to
	//ArrayList myStack
	public void push(T c) {
		stackTop++;
		myStack.add(c);

	}
	//pop off top value of stack by removing value in ArrayList myStack at index
	//stackTop and stores into the variable c.  Decreases stackTop and returns c
	public T pop() {
		T c = myStack.remove(stackTop);
		stackTop--;
		return c;
	}
	//test if stack is empty by checking if stackTop is less than 0
	public boolean isEmpty() {
		if (stackTop < 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//Looks at the value at the top of the stack by getting value in myStack at the index stackTop
	public T topOfStack() {
		T c = myStack.get(stackTop);
		return c;
	}

}
