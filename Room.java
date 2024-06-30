/**
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Creates and manages a room.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The room class.
 */
public class Room
{
    /* ------------------------------- ATTRIBUTES ------------------------------- */

    private final String name;                         // Room's name.
    private final String type;                         // Room's type.

    private double basePrice;                          // Room's base price.
    private final HashMap<Integer, Double> rates;      // Room's price rates.
    private final ArrayList<Reservation> reservations; // Room's reservations.
    
    /* ------------------------------- CONSTRUCTOR ------------------------------ */

    /**
     * Constructs a room given the name and base price.
     * 
     * @param name {String} The room's name.
     * @param type {String} The room's type.
     * @param basePrice {double} The room's base price.
     */
    public Room(String name, String type, double basePrice)
    {
        this.name = name;
        this.type = type;

        this.basePrice = switch (type)
        {
            case "DELUXE" -> basePrice * 1.20;
            case "EXECUTIVE" -> basePrice * 1.35;
            default -> basePrice;
        };
        
        this.rates = new HashMap<>();
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
     * Returns the room's type.
     * 
     * @return {String}
     */
    public String type()
    {
        return this.type;
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
     * Returns the room's total reservation prices.
     * 
     * @return {double}
     */
    public double getTotalPrice()
    {
        double sum = 0;

        for (int i = 0; i < getNumOfReservations(); i++)
        {
            sum += getReservation(i).getTotalPrice();
        }

        return sum;
    }

    /**
     * Returns the rate of a given date.
     * 
     * @return {double}
     */
    public double getRate(int date)
    {
        return rates.get(date);
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

    /**
     * Sets the rate of a given date.
     * 
     * Returns true if the rate modification is successful.
     * 
     * @param date {int} The date.
     * @param rate {double} The rate.
     * 
     * @return {boolean}
     */
    public boolean setDateRate(int date, double rate)
    {
        /*  
         * The given date must be within 1 to 30.
         * This does not include 31 because we are only counting nights.
         * 
         * The rate must be within 50% to 150%.
         */
        if ((date >= 1 && date <= 30) && (rate >= .5 && rate <= 1.5))
        {
            rates.put(date, rate);
        }
        return false;
    }

    /* --------------------------------- ADDERS --------------------------------- */

    /**   
     * Adds a reservation to the room.
     * 
     * @param guestName {String} The guest name.
     * @param checkIn {int} The check-in date.
     * @param checkOut {int} The check-out date.
     * @param code {String} The discount code.
     */
    public void addReservation(String guestName, int checkIn, int checkOut)
    {
        reservations.add(new Reservation(guestName, this, checkIn, checkOut));
    }

    /* -------------------------------- REMOVERS -------------------------------- */

    /**
     * Removes a reservation.
     * 
     * @param reservation {Reservation} The reservation.
     */
    public void removeReservation(Reservation reservation)
    {
        reservations.remove(reservation);
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
        for (int i = 0; i < getNumOfReservations(); i++)
        {
            /*
             * Checks if the given check-in date is within the reservation's
             * check-in date and the day before the reservation's check-out date.
             * 
             * Checks if the given check-out date is within the day after the
             * reservation's check-in date and the reservation's check-out date.
             */
            if ((checkIn >= getReservation(i).getCheckIn() &&
                checkIn < getReservation(i).getCheckOut()) ||

                (checkOut > getReservation(i).getCheckIn() &&
                checkOut <= getReservation(i).getCheckOut()))
                
                return false;
        }
        return true;
    }
}
