/*
JInputComboBox✅
has a label + combo box✅
hungarian notation: inc
 */

import javax.swing.*;

public class JInputComboBox extends JComboBox {

    //VARIABLES
    JLabel incLabel;

    //CONSTRUCTOR
    public JInputComboBox(String labelText){
        this.incLabel = new JLabel(labelText);

        this.add(incLabel);
    }
}
