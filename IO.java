/**  
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * Handles the program's I/O.
 */

/**  
 * The I/O class.
 */
public class IO
{
    /* ------------------------------- ATTRIBUTES ------------------------------- */

    private static IO io;     // The single instance of the I/O class.
    private static Heap heap; // The data currently being stored by the system.
    // TODO Scan inputs with the GUI.

    /* ------------------------------- CONSTRUCTOR ------------------------------ */

    /**  
     * Constructs the single instance of the I/O class.
     */
    private IO()
    {
        IO.heap = Heap.getInstance();
    }

    /* --------------------------------- GETTERS -------------------------------- */

    /** 
     * Returns the single instance of the I/O class.
     * 
     * @return {IO}
     */
    public IO getInstance()
    {
        if (IO.io == null)
            IO.io = new IO();
        
        return IO.io;
    }

    /* ------------------------------- IO MANAGER ------------------------------- */

    /* -------------------------------- SCANNERS -------------------------------- */

    /* ----------------------------- INPUT MANAGERS ----------------------------- */

}
