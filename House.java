/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  
  /* Default constructor */
  public House() {
    super();
  }

  /* Overloaded constructor with name, address, nFloors only */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
  }

  /* Overloaded constructor with name, address, nFloors, hasDiningRoom only */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors, hasDiningRoom);
    this.residents = new ArrayList<String>();
  }

  /**
   * Full constructor of class House
   * @param name name of the House
   * @param address address of the House
   * @param nFloors number of floors in the House
   * @param hasDiningRoom whether the House has a dining hall or not
   */
  
  public House(String name, String address, int nFloors, boolean hasElevator, boolean hasDiningRoom) {
    super(name, address, nFloors, hasElevator);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  

    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for whether the House has a dining hall
   * @return boolean
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Accessor for the number of residents in the House
   * @return number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Check whether a person is a resident of the House
   * @param person
   * @return boolean
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Add a person to the House
   * @param name
   */
  public void moveIn(String name) {
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of " + this.name + ".");
    }
    this.residents.add(name);
    System.out.println(name + " just became a new resident of " + this.name + ".");
  }

  /**
  * Add multiple persons to the House
  * @param names array of names
  */
  public void moveIn(String[] names) {
    for (String name : names) {
      if (!this.residents.contains(name)) {
        this.residents.add(name);
        System.out.println(name + " just became a new resident of " + this.name + ".");
      }
    }
  }


  /**
   * Remove a person from the House
   * @param name
   * @return name of the person that moved out
   */
  public String moveOut(String name) {
    if (!this.residents.contains(name)) {
      throw new RuntimeException(name + " is not a resident of " + this.name + ".");
    }
    this.residents.remove(name);
    System.out.println(name + " is no longer a resident of " + this.name + ".");
    return name;
  }  

  public String toString() {
      if (hasDiningRoom == true) {
        return super.toString() + " It has a dining hall.";
      } 
      else {
        return super.toString() + " It doesn't have a dining hall.";
      }
  }

  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(name) \n + moveOut(name)");

  }

  public void goToFloor(int floorNum) {
    if (this.hasElevator == false) {
        throw new RuntimeException("Elevator is not available in this building. Please take the stairs.");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
}

  public static void main(String[] args) {
    House ziskind = new House("Ziskind", "1 Henshaw Ave Northampton 01063", 3, true, true);
    House lamont = new House("Lamont", "Prospect Street Northampton 01063", 4, true, true);
    House jordan = new House("Jordan", "The Quad", 4);
    House haven = new House("Haven", "Mountain Neighborhood", 2);
  
    ziskind.showOptions();
    System.out.println("*********" + haven);

    System.out.println(ziskind);
    System.out.println(lamont);
    System.out.println(jordan);

    ziskind.moveIn("Tana");
    ziskind.moveIn("Robbie");
    ziskind.moveOut("Robbie");


    lamont.moveIn("Angela");
    lamont.moveIn("Sarah");
    
    jordan.moveIn("Linh");
    jordan.moveOut("Linh");


    String[] names = {"Grace", "Alice", "Jess" };
    haven.moveIn(names);

    try {
      lamont.moveOut("Marry");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    System.out.println(lamont.nResidents());

    ziskind.goToFloor(2);
    ziskind.goToFloor(5);
    haven.goToFloor(2);
  }

}