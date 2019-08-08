/**
 * 
 */
package Names;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Jacob Coriell
 *
 */
public class SeatMap {
	private int numnames;
	private String[][] seatMap;
	
	public void readfile() {
	try {
		//File inputFile = new File("names.dat");
		//Scanner input = new Scanner(inputFile);
		Scanner countinput = new Scanner(new FileInputStream("names.dat"), "UTF-8");
		Scanner sendinput = new Scanner(new FileInputStream("names.dat"), "UTF-8");
		numnames = 0;
		
		while (countinput.hasNextLine()) {
			String elt = countinput.nextLine();
			numnames++;	
		}
		countinput.close();
		System.out.println(numnames);
		if ((numnames % 2) == 0) {
			seatMap = new String[numnames/2][5];
		}else {
		}	   // odd
		
		while (sendinput.hasNextLine()) {
			String element = sendinput.nextLine();
			populateArray(element);
		}
		sendinput.close();
	}
	catch (IOException e) {
	    System.err.println("IOException in reading input file!!!");
		}
	}
	
	public void populateArray(String name) {
		for (int x = 0; x < seatMap.length; x++) {
			for (int y = 0; y < seatMap[0].length; y++) {
				seatMap[x][y] = name;
				System.out.println(seatMap[x][y]);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SeatMap obj = new SeatMap();
		obj.readfile();

	}

}
