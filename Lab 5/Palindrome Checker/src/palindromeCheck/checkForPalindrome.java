/**
 * 
 */
package palindromeCheck;

import java.util.Scanner;

/**
 * @author Jacob Coriell
 *
 */
public class checkForPalindrome {
	private String userString;
	private String compareString = new String();
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the string you would like to test as a palindrome.");
		String userString = reader.next() + "";
		System.out.println(isaPalindrome(userString));
		
	}
	//Accepts the string the user wants to test as a palindrome. 
	public static Boolean isaPalindrome(String expr) {
		if(expr.length() == 1) { //if the expression is just one character it is a palindrome 
			return true;
			}
		else if(expr.length() == 2) { //if the string is two characters and they are the same, it is a palindrome
			if (expr.charAt(0) == expr.charAt(1))
				return true;
		}
		else {
			if((expr.substring(0,1)).equals(expr.substring(expr.length()-1))) { //if the first character is the same as the
			return isaPalindrome(expr.substring(1, expr.length()-1));			//last character, recursively call the method
			}																//with the string between those letters
		}																	//return the boolean obtained from that
		return false;
	}
}

