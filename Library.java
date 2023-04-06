import java.util.Hashtable;
import java.util.Set;

/* This is a stub for the Library class */

public class Library extends Building {
  private Hashtable<String, Boolean> collection;
  

  /**
   * Constructor for class Library
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors, hasElevator);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Check if a title is in the collection
   * @param title
   * @return boolean
   */
  public boolean containsTitle(String title) { // returns true if the title appears as a key in the Libary's collection, false otherwise
    if (this.collection.containsKey(title)) {
      return true;
    }
    else { 
      return false ;
    }
  }

  /**
   * Add a book into the collection
   * @param title
   */
  public void addTitle(String title) {
    if (this.containsTitle(title)) {
      throw new RuntimeException(title + " is already added into the collection.");
    }
    this.collection.put(title, true);
    System.out.println(title + " has been added to the collection.");
  }  

  /**
   * Remove a book from the collection  
   * @param title
   * @return title of the removed book 
   */
  public String removeTitle(String title) {
    if (!this.containsTitle(title)) {
      throw new RuntimeException(title + " is not in the collection.");
    } 
    this.collection.remove(title);
    return (title + " has been removed from the collection.");
  }

  /**
   * Check whether a book is in the collection or not 
   * @param title
   * @return boolean
   */
  public boolean isAvailable(String title) {  // returns true if the title is currently available, false otherwise
    if (this.collection.get(title).equals(true)) {
      return true;
    }
    else {
      return false;
    }
  } 

  /**
   * Method to check out a book and hange its status 
   * @param title
   */
  public void checkOut(String title) {
    if (!this.isAvailable(title)) {
      System.out.println(title + " is currently not available for check-out.");
    }
    this.collection.put(title, false);
    System.out.println(title + " has just been checked out.");
  }

  /**
   * Method to return a book and change its status
   * @param title
   */
  public void returnBook(String title) {
    if (this.isAvailable(title)) {
      System.out.println(title + " is already in the collection. You might be at the wrong place or returning the wrong book.");
    }
    this.collection.put(title, true);
    System.out.println(title + " successfully returned.");
  }

  /**
   * Print out the collection
   */
  public void printCollection() {  // prints out the entire collection in an easy-to-read way (including checkout status) 
    System.out.println("***** NEILSON LIBRARY COLLECTION *****");
    Set<String> keys = this.collection.keySet();
    int x = 0;
    for (String key: keys) {
      x += 1;
      System.out.println(x + ". " + key);
    }
  }
  
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + printCollection()");

  }

  public void goToFloor(int floorNum) {
    if (this.hasElevator == false) {
        throw new RuntimeException("Elevator is not available in this building. Please take the stairs.");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  public static void main(String[] args) {
    Library Neilson = new Library("Neilson", "7 Neilson Drive, Northampton 01063", 4, true); 

    Neilson.showOptions();

    Neilson.addTitle("On Earth We're Briefly Gorgeous");
    Neilson.addTitle("When Math Goes Wrong In The Real World");
    Neilson.addTitle("20th Century Boy");
    Neilson.addTitle("Sweet Reason");
    Neilson.addTitle("Oliver Twist");

    try {
       Neilson.addTitle("Oliver Twist");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }


    System.out.println(Neilson.removeTitle("20th Century Boy"));

    try {
      Neilson.removeTitle("Introduction to Macroeconomics");
    } catch (Exception e) {
     System.err.println(e.getMessage());
    }


    Neilson.printCollection();
    Neilson.checkOut("On Earth We're Briefly Gorgeous");
    Neilson.checkOut("Sweet Reason");
    Neilson.checkOut("Sweet Reason");
    Neilson.returnBook("Sweet Reason");

  }
}