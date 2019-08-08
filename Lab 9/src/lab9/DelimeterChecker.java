package lab9;

import java.util.Scanner;

public class DelimeterChecker {
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter the expresion you wish to delimeter check: ");
		String myExp = reader.next();
		System.out.println(check(myExp));
		
		
		
	}
	
	
	public static boolean check(String s) {
		StackX myStack = new StackX(s.length());
		
		for(int x = 0; x < s.length(); x++) {
			if (isOpeningDelimeter(s.charAt(x)))
				myStack.push(s.charAt(x));
			else if (isClosingDelimeter(s.charAt(x))) {
				if(myStack.isEmpty())
					return false;
				char c = myStack.pop();
				if (!((s.charAt(x) == ']' && c == '[') || (s.charAt(x) == '}' && c == '{') || (s.charAt(x) == ')' && c == '(')))
					return false;
			}
		}
		if(!(myStack.isEmpty()))
			return false;
		return true;
	}
	
	public static boolean isOpeningDelimeter(char c) {
		
		if (c == '[' || c == '{' || c == '(')
			return true;
		else
			return false;
	}
	
	public static boolean isClosingDelimeter(char c) {
		if (c == ']' || c == '}' || c == ')')
			return true;
		else
			return false;
	}
}
