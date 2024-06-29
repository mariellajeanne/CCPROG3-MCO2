/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates and manages a room.
 */

import java.util.ArrayList;

/**
 * The room class.
 */
public class Room
{
    /* ------------------------------- ATTRIBUTES ------------------------------- */

    private final String name;                         // Room's name.
    private double basePrice;                          // Room's base price.
    private final ArrayList<Reservation> reservations; // Room's reservations.
    
    /* ------------------------------- CONSTRUCTOR ------------------------------ */

    /**
     * Constructs a room given the name and base price.
     * 
     * @param name {String} The room's name.
     * @param basePrice {double} The room's base price.
     */
    public Room(String name, double basePrice)
    {
        this.name = name;
        this.basePrice = basePrice;
        this.reservations = new ArrayList<>();
    }

    /* --------------------------------- GETTERS -------------------------------- */

    /**  
     * Returns the room's name.
     * 
     * @return {String}
     */
    public String getName()
    {
        return this.name;
    }

    /**  
     * Returns the room's base price.
     * 
     * @return {double}
     */
    public double getBasePrice()
    {
        return this.basePrice;
    }

    /**
     * Returns the room's reservation price.
     * 
     * @return {double}
     */
    public double getTotalPrice()
    {
        double sum = 0;

        for (int i = 0; i < this.getNumOfReservations(); i++)
        {
            // REVIEW Total room price.
            sum += this.getReservation(i).getTotalPrice();
        }

        return sum;
    }

    /**
     * Returns a reservation given the index.
     * 
     * @param index {int} The index.
     * @return {Reservation}
     */
    public Reservation getReservation(int index)
    {
        return this.reservations.get(index);
    }

    /**  
     * Returns the room's number of reservations.
     * 
     * @return {int}
     */
    public int getNumOfReservations()
    {
        return this.reservations.size();
    }

    /* --------------------------------- SETTERS -------------------------------- */

    /**   
     * Sets the room's base price. 
     * 
     * @param basePrice {int} The room's base price.
     */
    public void setBasePrice(int basePrice)
    {
        this.basePrice = basePrice;
    }

    /* --------------------------------- ADDERS --------------------------------- */

    /**   
     * Adds a reservation to the room.
     * 
     * @param guestName {String} The guest name.
     * @param checkIn {int} The check-in date.
     * @param checkOut {int} The check-out date.
     */
    public void addReservation(String guestName, int checkIn, int checkOut)
    {
        this.reservations.add(new Reservation(guestName, this, checkIn, checkOut));
    }

    /* -------------------------------- REMOVERS -------------------------------- */

    /**
     * Removes a reservation.
     * 
     * @param reservation {Reservation} The reservation.
     */
    public void removeReservation(Reservation reservation)
    {
        this.reservations.remove(reservation);
    }

    /* -------------------------------- UPDATERS -------------------------------- */

    /* -------------------------------- BOOLEANS -------------------------------- */

    /**   
     * Checks if the room is available given the check-in and check-out dates.
     * 
     * @param checkIn {int} The check-in date.
     * @param checkOut {int} The check-out date.
     * @return {boolean}
     */
    public boolean areDatesAvailable(int checkIn, int checkOut)
    {   
        for (int i = 0; i < this.getNumOfReservations(); i++)
        {
            /*
             * Checks if the given check-in date is within the reservation's
             * check-in date and the day before the reservation's check-out date.
             * 
             * Checks if the given check-out date is within the day after the
             * reservation's check-in date and the reservation's check-out date.
             */
            if ((checkIn >= this.getReservation(i).getCheckIn() &&
                checkIn < this.getReservation(i).getCheckOut()) ||

                (checkOut > this.getReservation(i).getCheckIn() &&
                checkOut <= this.getReservation(i).getCheckOut()))
                
                return false;
        }
        return true;
    }
}
