/**  
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 */

import java.util.ArrayList;
import java.util.HashMap;

/**  
 * The reservation class.
 */
public class Reservation
{    
    /* ------------------------------- ATTRIBUTES ------------------------------- */

    private final String guestName;               // The guest's name.

    private final int checkIn;                    // The check-in date.
    private final int checkOut;                   // The check-out date.

    private final Room room;                      // The reservation's room.
    private double nightlyPrice;                  // The nightly price.
    private double totalPrice;                    // The overall price.
    private final HashMap<Integer, Double> rates; // The rates of each night.
    private final ArrayList<String> codes;        // The codes applied.

    /* ------------------------------- CONSTRUCTOR ------------------------------ */

    /** 
     * Constructs a reservation given the guest name, room information, and
     * check-in and check-out dates.
     * 
     * @param guestName {String} The guest's name.
     * @param room {Room} The reservation's room.
     * @param checkIn {int} The check-in date.
     * @param checkOut {int} The check-out date.
     */
    public Reservation(String guestName, Room room, int checkIn, int checkOut)
    {
        this.guestName = guestName;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        this.nightlyPrice = room.getBasePrice();
        
        this.rates = new HashMap<>();

        for (int i = checkIn; i < checkOut; i++)
        {
            rates.put(i, room.getRate(i));
        }

        this.totalPrice = (checkOut - checkIn - rates.size()) * nightlyPrice;

        for (Integer i : rates.keySet())
        {
            this.totalPrice += nightlyPrice * rates.get(i);
        }

        this.codes = new ArrayList<>();
    }

    /* --------------------------------- GETTERS -------------------------------- */

    /** 
     * Returns the guest name.
     * 
     * @return {String}
     */
    public String getGuestName()
    {
        return this.guestName;
    }

    /** 
     * Returns the check-in date.
     * 
     * @return {int}
     */
    public int getCheckIn()
    {
        return this.checkIn;
    }

    /**
     * Returns the check-out date.
     * 
     * @return {int}
     */
    public int getCheckOut()
    {
        return this.checkOut;
    }

    /** 
     * Returns the reservation's room.
     * 
     * @return {Room}
     */
    public Room getRoom()
    {
        return this.room;
    }

    /**
     * Returns the name of the reservation's room.
     * 
     * @return {String}
     */
    public String getRoomName()
    {
        return this.room.getName();
    }

    /** 
     * Returns the nightly price.
     * 
     * @return {double}
     */
    public double getNightlyPrice()
    {
        return this.nightlyPrice;
    }

    /**
     * Returns the total reservation price.
     * 
     * @return {double}
     */
    public double getTotalPrice()
    {
        return this.totalPrice;
    }

    /**
     * Returns the rate of a given date.
     * 
     * @param date {int} The date.
     * @return {double}
     */
    public double getRate(int date)
    {
        return rates.containsKey(date) ? (double) rates.get(date) : 1.0;
    }

    /* --------------------------------- SETTERS -------------------------------- */

    /**  
     * Sets the reservation's nightly price.
     * 
     * @param nightyPrice {double} The nightly price.
     */
    public void setNightlyPrice(double nightlyPrice)
    {
        this.nightlyPrice = nightlyPrice;
    }

    /**
     * Sets the reservation's discount.
     * 
     * Returns true only if the application of the discount code is successful.
     * 
     * @param code {String} The discount code.
     * @return {boolean}
     */
    public boolean setDiscount(String code)
    {
        /*   
         * Code: "I_WORK_HERE"
         * Applies a 10% discount.
         */
        if (code.equals("I_WORK_HERE") && !codes.contains(code))
        {
            totalPrice *= 0.90;
            codes.add(code);
            return true;
        }
        /*   
         * Code: "STAY4_GET1"
         * The first day is free if there are more than 5 reservation days.
         */
        else if (code.equals("STAY4_GET1") && !codes.contains(code) &&
                (checkOut - checkIn) >= 5)
        {
            totalPrice -= nightlyPrice * (rates.containsKey(checkIn) ?
                          (double) rates.get(checkIn) : 1);
            codes.add(code);
            return true;
        }
        /*   
         * Code: "PAYDAY"
         * Applies a 7% discount if the reservation dates include 15 or 30.
         * This excludes the check-out date.
         */
        else if (code.equals("PAYDAY") && !codes.contains(code) &&
                ((15 >= checkIn && 15 < checkOut) ||
                 (30 >= checkIn && 30 < checkOut)))
        {
            totalPrice *= 0.93;
            codes.add(code);
            return true;
        }
        return false;
    }

    /* --------------------------------- ADDERS --------------------------------- */

    /* -------------------------------- REMOVERS -------------------------------- */

    /* -------------------------------- UPDATERS -------------------------------- */

    /* --------------------------------- ADDERS --------------------------------- */

    /* -------------------------------- REMOVERS -------------------------------- */

    /* -------------------------------- UPDATERS -------------------------------- */

    /* -------------------------------- BOOLEANS -------------------------------- */
}
