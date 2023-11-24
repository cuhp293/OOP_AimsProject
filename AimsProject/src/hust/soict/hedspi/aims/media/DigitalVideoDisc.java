package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {

    private static int nbDigitalVideoDiscs = 0;

    // Create constructor method
    public DigitalVideoDisc() {
    	super();
	}

    public DigitalVideoDisc(String title) {
		setTitle(title);
		setId(nbDigitalVideoDiscs);
		nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		setTitle(title);
		setCategory(category);
		setCost(cost);
		setId(nbDigitalVideoDiscs);
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		setTitle(title);
		setCategory(category);
		setDirector(director);
		setCost(cost);
		setId(nbDigitalVideoDiscs);
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		setTitle(title);
		setCategory(category);
		setDirector(director);
		setLength(length);
		setCost(cost);
		setId(nbDigitalVideoDiscs);
		nbDigitalVideoDiscs++;
	}
    
    public String toString() {
    	return this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector()
    	 + " - " + this.getLength() + " - " + this.getCost() + "$\n";
    }
    public boolean isMatch(String title) {
    	if (getTitle().equals(title))
    		return true;
    	else
    		return false;
    }
    
}