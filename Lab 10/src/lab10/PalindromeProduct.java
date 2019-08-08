package lab10;

import java.util.Stack;

public class PalindromeProduct {

	public static void main(String[] args) {
		int operand1;
		int operand2;
		PalindromeProduct runner = new PalindromeProduct();
		Stack<Integer> myStack = new Stack();
		
		for(int x = 1; x < 10000; x++) {
			for(int y = 1; y < 10000; y++) {
				operand1 = x;
				operand2 = y;
				String result = operand1 * operand2 + "";
				if(runner.isPalindrome(result)) {
					myStack.push(operand1);
					myStack.push(operand2);
				}
			}
		}
		
		int num1 = myStack.pop();
		int num2 = myStack.pop();
		
		System.out.println(num1 + " " + num2 + " multiply together to make " + num1 * num2);
			
	}
	
	
	
	public boolean isPalindrome(String s) {
		if (s.length() == 1)
			return true;
		else if (s.length() == 2) {
			if (s.charAt(0) == s.charAt(1))
				return true;
		}
		else if (s.charAt(0) == s.charAt(s.length() - 1))
			return isPalindrome(s.substring(1, s.length() - 1));
		else
			return false;
		
		return false;
	}
}
