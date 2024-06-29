/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates and manages a hotel.
 */

import java.util.ArrayList;

/**
 * The hotel class.
 */
public class Hotel
{
    /* ------------------------------- ATTRIBUTES ------------------------------- */

    private String name;                  // Hotel's name.
    private double basePrice;             // Hotel's base price.
    private final ArrayList<Room> rooms;  // Hotel's rooms.
    
    private static final double DEFAULT_BASE_PRICE = 1299.0; // The default price.
    private static final int MAX_NUM_OF_ROOMS = 50; // The max number of rooms.

    /* ------------------------------- CONSTRUCTOR ------------------------------ */

    /**
     * Constructs the hotel given the name, base price, and number of rooms.
     * 
     * @param name {String} The hotel name.
     * @param basePrice {int} The base price.
     * @param nRooms {int} The number of rooms.
     */
    public Hotel(String name, double basePrice, int nRooms)
    {
        this.name = name;
        this.basePrice = basePrice;
        this.rooms = new ArrayList<>();
    }

    /* --------------------------------- GETTERS -------------------------------- */

    /**
     * Returns the hotel name.
     * 
     * @return {String}
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the room base price.
     * 
     * @return {double}
     */
    public double getBasePrice()
    {
        return this.basePrice;
    }

    /**
     * Returns the default base price of a hotel.
     * 
     * @return {double}
     */
    public double getDefaultPrice()
    {
        return Hotel.DEFAULT_BASE_PRICE;
    }

    /**
     * Returns a room given the index.
     * 
     * @param index {int} The index.
     * @return {Room}
     */
    public Room getRoom(int index)
    {
        if (index >= 0 && index < this.getMaxNumOfRooms())
            return this.rooms.get(index);
        
        return null;
    }

    /**
     * Returns a room given its name.
     * 
     * @return name {String} The room's name.
     */
    public Room getRoom(String name)
    {
        for (int i = 0; i < this.getNumOfRooms(); i++)
        {
            if (this.getRoom(i).getName().equals(name))
                return this.getRoom(i);
        }
        return null;
    }

    /**
     * Returns the number of rooms.
     * 
     * @return {int}
     */
    public int getNumOfRooms()
    {
        return this.rooms.size();
    }

    /**
     * Returns the number of rooms without reservations.
     * 
     * @return {int}
     */
    public int getNumOfAvailRooms()
    {
        int num = 0;

        for (int i = 0; i < this.getNumOfRooms(); i++)
        {
            if(this.getRoom(i).getNumOfReservations() == 0)
                num++;
        }
        return num;
    }

    /**
     * Returns the max number of hotel rooms.
     * 
     * @param {int}
     */
    public int getMaxNumOfRooms()
    {
        return Hotel.MAX_NUM_OF_ROOMS;
    }

    /* --------------------------------- SETTERS -------------------------------- */

    /**
     * Sets the hotel name.
     * 
     * @param name {String} The hotel name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets the base price.
     * 
     * @param basePrice {double} The base price.
     */
    public void setBasePrice(double basePrice)
    {
        this.basePrice = basePrice;
    }

    /* --------------------------------- ADDERS --------------------------------- */

    /**   
     * Adds rooms to the hotel.
     * 
     * Returns true only if the given number of rooms is within
     * the maximum post-addition.
     * 
     * @param num {int} The number of rooms to add.
     * @return {boolean}
     */
    public boolean addRooms(int num)
    {
        if (num >= 1 && this.getNumOfRooms() + num <= Hotel.MAX_NUM_OF_ROOMS)
        {
            for (int i = 0; i < num; i++)
            {
                String roomName = String.valueOf(('A' + (i/5)) + "-" + ((i + 1) % 5));
                this.rooms.add(new Room(roomName, this.basePrice));
            }
            return true;
        }
        return false;
    }

    /* -------------------------------- REMOVERS -------------------------------- */

    /**
     * Removes rooms from the hotel.
     * 
     * Returns true only if the number of rooms to remove is within the number of
     * rooms without reservations.
     * 
     * @param num {int} The number of rooms to remove.
     * @return {boolean}
     */
    public void removeRooms(int num)
    {
        if (num <= this.getNumOfAvailRooms())
        {
            int start = this.getNumOfRooms() - 1;
            int end = this.getNumOfRooms() - num;

            for (int i = start; i >= end; i--)
            {
                this.rooms.remove(i);
            }
        }
    }

    /* -------------------------------- UPDATERS -------------------------------- */

    /* -------------------------------- BOOLEANS -------------------------------- */
}