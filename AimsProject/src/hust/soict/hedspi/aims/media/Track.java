package hust.soict.hedspi.aims.media;

public class Track {

	private String title;
	private int length;
	
	// Create constructor
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	// Create getter
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}

}