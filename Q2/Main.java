
//-----------------------------------------------------
// Title: Main  Class
// Author: Ayda Nil Özyürek
// Description:  This class is where we use the data to read the file and get the required output values.
//------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		BufferedReader reader;
		try (Scanner scanner = new Scanner(System.in)) {
			String fileName = scanner.nextLine();
			reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();
			String items[];

			BinarySearchTreeQ2 bst = new BinarySearchTreeQ2();
			System.out.println("--------------- WELCOME TO CDRC SYSTEM ---------------");
			while (line != null) {
				items = line.split(" ");

				if (items.length > 0 && !items[0].equals("")) {
					// --------------------------------------------------------
					// Summary: The list structure here is a structure that does not affect our
					// algorithm. We have set up this structure to more accurately read the data in
					// the txt file given to us. The spaces in the txt file were causing us an error
					// in the output, so we prevented this.
					// --------------------------------------------------------
					List<String> list = new LinkedList<String>(Arrays.asList(items));
					ListIterator<String> it = list.listIterator();
					while (it.hasNext()) {
						if (it.next().equals("")) {
							it.remove();
						}
					}

					// The part where we use the methods we created in the BinarySearchJava class.
					// We used the methods in appropriate places by making the necessary
					// arrangements according to the output type requested from us.
					if (list.get(0).equalsIgnoreCase("Add_Captain")) {
						Captain captain = new Captain(Integer.parseInt(list.get(1)), list.get(2));
						bst.insert(captain);
						System.out.println("Add Captain: Add a new captain record in the System");
						System.out.println();
						System.out.println("		       ID: " + list.get(1));
						System.out.println("		       Name: " + list.get(2));
						System.out.println("		       Available: True");
						System.out.println("		       Rating star: 0");
						System.out.println("----------------------------------------------------------------");
					} else if (list.get(0).equalsIgnoreCase("Is_Available")) {
						Captain captain = bst.traversal(Integer.parseInt(list.get(1)));
						if (captain == null) {
							System.out.println("IsAvailable: Couldn't find any captain with ID number " + list.get(1));
							System.out.println();
							System.out.println("----------------------------------------------------------------");
						} else if (!captain.isAvailable()) {
							System.out.println("IsAvailable: The captain " + captain.getName()
									+ " is not available. He is on another ride!");
							System.out.println();
							System.out.println("----------------------------------------------------------------");
						} else {
							captain.setAvailable(false);
							System.out.println("IsAvailable: Reserve a new Ride with captain " + list.get(1));
							System.out.println();
							System.out.println("----------------------------------------------------------------");
						}
					} else if (list.get(0).equalsIgnoreCase("Display_captain")) {
						Captain captain = bst.traversal(Integer.parseInt(list.get(1)));
						if (captain == null) {
							System.out.println(
									"Display Captain: Couldn't find any captain with ID number " + list.get(1));
							System.out.println();
							System.out.println("----------------------------------------------------------------");
						} else {
							System.out.println("Display Captain: ");
							System.out.println("		       ID: " + captain.getId());
							System.out.println("		       Name: " + captain.getName());
							System.out.println("		       Available: " + captain.isAvailable());
							System.out.println("		       Rating star: " + captain.getRatingStar());
							System.out.println();
							System.out.println("----------------------------------------------------------------");
						}

					} else if (list.get(0).equalsIgnoreCase("Finish")) {
						Captain captain = bst.traversal(Integer.parseInt(list.get(1)));
						if (captain == null) {
							System.out.println("Finish: Couldn't find any captain with ID number " + list.get(1));
							System.out.println("----------------------------------------------------------------");
						} else if (captain.isAvailable()) {
							System.out.println("Finish: The captain " + captain.getName() + " is not in a ride");
							System.out.println("----------------------------------------------------------------");
						} else {
							captain.setAvailable(true);
							captain.setRatingStar(Integer.parseInt(list.get(2)));
							System.out.println("Finish: Finish ride with captain " + list.get(1));
							System.out.println("		       ID: " + captain.getId());
							System.out.println("		       Name: " + captain.getName());
							System.out.println("		       Available: " + captain.isAvailable());
							System.out.println("		       Rating star: " + captain.getRatingStar());
							System.out.println("----------------------------------------------------------------");
						}
					} else if (list.get(0).equalsIgnoreCase("Delete_captain")) {
						Captain captain = bst.traversal(Integer.parseInt(list.get(1)));

						if (captain == null) {
							System.out
									.println("Delete Captain: Couldn't find any captain with ID number " + list.get(1));
							System.out.println("----------------------------------------------------------------");
						}

						bst.delete(Integer.parseInt(list.get(1)));

					} else if (list.get(0).equalsIgnoreCase("Display_all_captains")) {
						bst.displayAllCaptains();
					} else {
						System.out.println();
						System.out.println("Thank you for using CDRC, Good Bye!");
					}
				}

				line = reader.readLine();
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
