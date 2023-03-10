
//-----------------------------------------------------
// Title: TreeNodeQ1 Class
// Author: Ayda Nil Özyürek
// Description: This class is where we use the data to read the file and get the required output values.
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

		// The part written to read the txt file
		BufferedReader reader;
		try (Scanner scanner = new Scanner(System.in)) {
			String fileName = scanner.nextLine();
			reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();
			String items[];

			BinarySearchTreeQ1 bst = new BinarySearchTreeQ1();
			System.out.println();
			System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------");
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
					if (list.get(0).equalsIgnoreCase("Add_product")) {
						Product product = new Product(Integer.parseInt(list.get(1)), list.get(2),
								Integer.parseInt(list.get(3)));
						bst.insert(product);
						System.out.println("Create Product:");
						System.out.println();
						System.out.println("		       ID: " + list.get(1));
						System.out.println("		       Name: " + list.get(2));
						System.out.println("		       Piece: " + list.get(3));
					} else if (list.get(0).equalsIgnoreCase("Is_Available")) {
						Product product = bst.traversal(Integer.parseInt(list.get(1)));
						if (product == null || product.getPiece() == 0) {
							System.out.println("The product is out of stock!!!");
						} else {
							System.out.println("There are " + product.getPiece() + " products");
							System.out.println();
						}
					} else {
						System.out.println();
						System.out.println();
						System.out.println("Thank you for using ITS, Good Bye!");
					}
				}

				line = reader.readLine();
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
