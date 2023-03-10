//-----------------------------------------------------
// Title: Product Class
// Author: Ayda Nil Özyürek
// Description: This class holds data about product.
//------------------------------------------------
public class Product {

	private int id;
	private String name;
	private int piece;	
	
	public Product(int id, String name, int piece) {
		this.id = id;
		this.name = name;
		this.piece = piece;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPiece() {
		return piece;
	}
	
	public void setPiece(int piece) {
		this.piece = piece;
	}	
}
