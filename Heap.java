/**   
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Contains the data currently being processed by the system.
 */

import java.util.ArrayList;

/**
 * The heap class.
 */
public class Heap {

    /* ------------------------------- ATTRIBUTES ------------------------------- */

    /*
     * Program information.
     */
    private static Heap heap;         // The single instance of the heap class.
    private static boolean isRunning; // Determines if the program is running.

    /* 
     * State information.
     */
    private static Context state;    // The system's current state.
    private static boolean hadError; // Determines if there was an input error.
    private static String feedback;  // The most recent feedback by the system.

    /*
     * Data containers.
     */
    private static ArrayList<Hotel> hotels; // The system's current hotels.
    private static Hotel hotel;             // The hotel being processed.
    private static Room room;               // The room being processed.
    private static Reservation reservation; // The reservation being processed.
    private static String text;             // The text being processed.
    private static int checkIn;             // The check-in date being processed.
    private static int checkOut;            // The check-out date being processed.
    
    /* ------------------------------- CONSTRUCTOR ------------------------------ */

    /**  
     * Constructs the heap.
     */
    private Heap()
    {
        Heap.isRunning = true;

        Heap.state = Context.MAIN_MENU;
        Heap.hadError = false;
        Heap.feedback = "";

        Heap.hotels = new ArrayList<>();
    }

    /* --------------------------------- GETTERS -------------------------------- */

    /**  
     * Returns the single instance of the heap.
     * 
     * @return {Heap}
     */
    public static Heap getInstance()
    {
        if (Heap.heap == null)
            Heap.heap = new Heap();
        
        return Heap.heap;
    }

    /**
     * Returns the feedback.
     * 
     * @return {String}
     */
    public String getFeedback()
    {
        return Heap.feedback;
    }

    /**
     * Returns the current system state.
     * 
     * @return {State}
     */
    public Context getState()
    {
        return Heap.state;
    }

    /**
     * Returns the number of hotels in the system.
     * 
     * @return {int}
     */
    public int getNumOfHotels()
    {
        return Heap.hotels.size();
    }

    /**
     * Returns a hotel of the system given the index.
     * 
     * @param index {int} The index.
     * @return {Hotel}
     */
    public Hotel getHotel(int index)
    {
        if (index >= 0 && index < getNumOfHotels())
            return Heap.hotels.get(index);
        
        return null;
    }

    /**
     * Returns a hotel of the system given its name.
     * 
     * @param name {String} The hotel name.
     * @return {Hotel}
     */
    public Hotel getHotel(String name)
    {
        for (int i = 0; i < getNumOfHotels(); i++)
        {
            if (getHotel(i).getName().equals(name))
                return getHotel(i);
        }
        return null;
    }

    /**
     * Returns the hotel being processed.
     * 
     * @return {Hotel}
     */
    public Hotel getHotel()
    {
        return Heap.hotel;
    }

    /**
     * Returns the room being processed.
     * 
     * @return {Room}
     */
    public Room getRoom()
    {
        return Heap.room;
    }

    /**
     * Returns the reservation being processed.
     * 
     * @return {Reservation}
     */
    public Reservation getReservation()
    {
        return Heap.reservation;
    }

    /**
     * Returns the text being processed.
     * 
     * @return {String}
     */
    public String getText()
    {
        return Heap.text;
    }

    /**
     * Returns the check-in date being processed.
     * 
     * @return {int}
     */
    public int getCheckIn()
    {
        return Heap.checkIn;
    }

    /**
     * Returns the check-out date being processed.
     * 
     * @return {int}
     */
    public int getCheckOut()
    {
        return Heap.checkOut;
    }

    /* --------------------------------- SETTERS -------------------------------- */

    /**
     * Sets the program's error state.
     * 
     * @param hadError {boolean} The error state.
     */
    public void setErrorState(boolean hadError)
    {
        Heap.hadError = hadError;
    }

    /**
     * Sets the feedback being processed.
     * 
     * @param feedback {String} The feedback.
     */
    public void setFeedback(String feedback)
    {
        Heap.feedback = feedback;
    }

    /**
     * Sets the hotel being processed given the index.
     * 
     * @param index {int} The index.
     */
    public void setHotel(int index)
    {
        Heap.hotel = getHotel(index);
    }

    /**
     * Sets the hotel being processed given the name.
     * 
     * @param name {String} The hotel name.
     */
    public void setHotel(String name)
    {
        Heap.hotel = getHotel(name);
    }

    /**
     * Sets the hotel being processed given the hotel object.
     * 
     * @param hotel {Hotel} The hotel.
     */
    public void setHotel(Hotel hotel)
    {
        Heap.hotel = hotel;
    }

    /**
     * Sets the room being processed.
     * 
     * @param room {Room} The room.
     */
    public void setRoom(Room room)
    {
        Heap.room = room;
    }

    /**
     * Sets the reservation being processed.
     * 
     * @param reservation {Reservation} The reservation.
     */
    public void setReservation(Reservation reservation)
    {
        Heap.reservation = reservation;
    }

    /**
     * Sets the text being processed.
     * 
     * @param text {String} The text.
     */
    public void setText(String text)
    {
        Heap.text = text;
    }

    /**
     * Sets the check-in date being processed.
     * 
     * Returns true only if the given check-in date is within 1 to 30.
     * 
     * @param checkIn {int} The check-in date.
     * @return {boolean}
     */
    public boolean setCheckIn(int checkIn)
    {
        if (checkIn >= 1 && checkIn <= 30)
        {
            Heap.checkIn = checkIn;
            return true;
        }
        return false;
    }

    /**
     * Sets the check-out date being processed.
     * 
     * Returns true only if the given check-out date is within 2 to 31.
     * 
     * @param checkOut {int} The check-out date.
     * @return {boolean}
     */
    public boolean setCheckOut(int checkOut)
    {
        if (checkOut >= 2 && checkOut <= 31)
        {
            Heap.checkOut = checkOut;
            return true;
        }
        return false;
    }

    /* --------------------------------- ADDERS --------------------------------- */

    /**
     * Adds a hotel to the system.
     * 
     * Returns true only if the given name is unique and the number of rooms to be
     * added is within 1 to 50.
     * 
     * @param name {String} The hotel name.
     * @param basePrice {int} The base price.
     * @param nRooms {int} The number of hotel rooms.
     * @return {Hotel}
     */
    public boolean addHotel(String name, double basePrice, int nRooms)
    {
        if (nRooms < 1 || nRooms > 50)
            return false;
            
        for (int i = 0; i < getNumOfHotels(); i++)
        {
            if (getHotel(i).getName().equals(name)) 
                return false;
        }
        Heap.hotels.add(new Hotel(name, basePrice, nRooms));
        return true;
    }

    /* -------------------------------- REMOVERS -------------------------------- */

    /**
     * Removes a hotel given the name.
     * 
     * Returns true if the given name exists; false otherwise. 
     */
    public boolean removeHotel(String name)
    {
        Hotel hotelToRemove = getHotel(name);

        if (hotelToRemove != null)
        {
            Heap.hotels.remove(hotelToRemove);
            return true;
        }
        return false;
    }

    /* -------------------------------- UPDATERS -------------------------------- */

    /**
     * Notifies the program to be terminated.
     */
    public void endRun()
    {
        Heap.isRunning = false;
    }

    /* -------------------------------- BOOLEANS -------------------------------- */

    /**
     * Identifies if the system is still running.
     * 
     * @return {boolean}
     */
    public boolean isRunning()
    {
        return Heap.isRunning;
    }

    /**
     * Identifies if there was an input error.
     * 
     * @return {boolean}
     */
    public boolean hadError()
    {
        return Heap.hadError;
    }
}
