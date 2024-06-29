/**  
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 */

/**  
 * The reservation class.
 */
public class Reservation
{    
    /* ------------------------------- ATTRIBUTES ------------------------------- */

    private final String guestName; // The guest's name.

    private final int checkIn;      // The check-in date.
    private final int checkOut;     // The check-out date.

    private final Room room;        // The reservation's room.
    private double nightlyPrice;    // The reservation's price per night.   // TODO Deal with this later according to the new specs.

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

        this.nightlyPrice = this.room.getBasePrice();
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
        // REVIEW Price per "night"?
        return (this.checkOut - this.checkIn) * this.nightlyPrice;
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

    /* --------------------------------- ADDERS --------------------------------- */

    /* -------------------------------- REMOVERS -------------------------------- */

    /* -------------------------------- UPDATERS -------------------------------- */

    /* --------------------------------- ADDERS --------------------------------- */

    /* -------------------------------- REMOVERS -------------------------------- */

    /* -------------------------------- UPDATERS -------------------------------- */

    /* -------------------------------- BOOLEANS -------------------------------- */
}
