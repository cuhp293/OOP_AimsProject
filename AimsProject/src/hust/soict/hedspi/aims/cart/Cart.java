package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	// Add Media
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media has been added.");
			return;
		} else {
			System.out.println("The cart is almost full.");
		}
	}
	
	// Remove Media
	public void removeMedia (Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media has been removed.");
		} else {
			System.out.println("The media is not in the cart.");
		}
	}
	
	// Sort by Title
	public void sortByTitle() {
		System.out.println("Sort by Title: ");
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		printCart();
	}
	
	// Sort by Cost
	public void sortByCost() {
		System.out.println("Sort by Cost: ");
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		printCart();
	}

    public void displayCartItems() {
        for (Media media : itemsOrdered) {
        	int i = 1;
            System.out.printf("%-3d %-20s %8f\n", i, media.getTitle(), media.getCost());
            i++;
        }
        System.out.println("Total Cost \t" + totalCost());
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered)
            total += media.getCost();
        return total;
    }

    // Print the list of ordered items of a cart
	public void printCart() {
		System.out.println("\n\n******************************CART******************************");
		System.out.println("Ordered Items:");

        for (Media media : itemsOrdered)
            System.out.print (media.toString());
        System.out.println("Total cost: " + totalCost());
        System.out.println("****************************************************************");
	}
	
	// Search for DVDs in the cart by ID and display the result
	public void searchByID() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ID: ");
		int id = scanner.nextInt();
		for (Media media : itemsOrdered) {
			if (media.getId() == (id-1)) {
				System.out.println("Search by id: " + id + ": \n" + media.toString());
				return;
			}
		}
		System.out.println("No match is found!");
	}

	// Search for DVDs in the cart by title and display the result
	public void searchByTitle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter title: ");
		String title = scanner.nextLine();
		for (Media media : itemsOrdered) {
			if (media.isMatch(title)) {
				System.out.println("Search by title: " + title + ": \n" + media.toString());
				return;
			}
		}
		System.out.println("No match is found!");
	}
	
	// Search media to remove from cart
	public Media searchByTitleRemove(String title) {
		for (Media media : itemsOrdered) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}
	
	// Count DVD in the current cart
	public void countDVDs() {
		int i = 0;
		for (Media media : itemsOrdered) {
			if (media instanceof DigitalVideoDisc)
				i++;
		}
		System.out.println("The number of DVDs in the current cart: " + i);
	}
	
	public void placeOrder() {
		if (itemsOrdered.size() == 0)
			System.out.println("Cart is empty!");
		else {
			itemsOrdered.clear();
			System.out.println("An order is created, your current cart is empty!");
		}
	}

}
