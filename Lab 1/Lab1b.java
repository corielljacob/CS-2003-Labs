package Lab1;


/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author Jacob Coriell
 * @Date_completed: 09/01/2017
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

public class Lab1b {

	Vector<Double> doubleVector; //A vector of Double objects
	double counter = 0.0, total = 0.0;
	/**
	 * Constructor: calls method readFile that reads the doubles contained in the
	 * file "<code>filename</code>" and computes the average of the elements.
	 * 
	 * @param filename
	 *            name of the file containing doubles.
	 */
	public Lab1b(String filename) {
		readFile(filename);
	}

	/** Reads double from a file named <code>filename</code> and
     * computes the average of the elements contained in the file 
     * @param filename name of the file containing the doubles 
     */
     public void readFile(String filename) {
	/*  This method will accept the name of the file and then open 
    	*	a stream in order to read the file. A vector of type doubles
    	*	is instantiated in order to store the doubles from the file.
    	*	A while loop is used to gather each element in the file and add 
    	*	it to the vector. Once that is finished, a method named computeAvg is
    	*	called in order to computer the average of the doubles. This method is guarded 
    	*	by a try/catch in case of file reading errors.
    	*/
    	try {
    		File inputFile = new File(filename);
    		Scanner reader = new Scanner(inputFile); /*we declare this in order to read from our 
    												 *	file */													
    		doubleVector = new Vector<Double>();
    		
    		double element;
    		while(reader.hasNext()) {
    			element = reader.nextDouble();
    			doubleVector.add(element); //add the double from the file into the vector
    		}
    		computeAvg();
    		reader.close();
    		
    		
    } catch (IOException e) {
		System.err.println("IOException in reading input file!!!"); 
    		}
    }// end readFile(String filename)
    
    public void computeAvg() {
    	/*	This method utilizes a for/each loop in order to accumulate the doubles
    	 * 	into a variable named total. Each iteration causes a counter to increase
    	 * 	by one so that we can take the average.
    	 */
    		for(double i : doubleVector) {
    			total += i; 
    			counter++;
    		}
    		System.out.println("The average is " + (total/counter)); //display the average
    			
    }

	/**
	 * main : creates a Lab1b Object with the filename passed in argument
	 */
	public static void main(String[] args) {
		//Lab1b lab = new Lab1b("Lab1b.dat");
		if (args.length == 0)								//While using eclipse, you don't 
			System.err.println("enter the data file name!"); //usually use command line to run
		else													//your programs and command line 
			new Lab1b(args[0]);								//is where you would provide
	} // end main											//arguments for main. Eclipse
															//offers run configurations
} // end class Lab1b											//which allows you to provide an
															//argument and that is what I have done
															//I entered "lab1b.dat" as the argument