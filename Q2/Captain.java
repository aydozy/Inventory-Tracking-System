//-----------------------------------------------------
// Title: Captain Class
// Author: Ayda Nil Özyürek
// Description: This class holds data about captain.
//------------------------------------------------
public class Captain {

	private int id;
	private String name;
	private boolean available;
	private int ratingStar;

	public Captain(int id, String name) {
		this.id = id;
		this.name = name;
		this.available = true;
		this.ratingStar = 0;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(int ratingStar) {
		this.ratingStar = ratingStar;
	}
}
