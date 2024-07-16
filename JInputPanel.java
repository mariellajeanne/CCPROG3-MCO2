/*
STEPHEN:
has a label + text field + (error message?) + (description?) ✅
Comments: Although i am not sure what description is for

hungarian notation: inp ✅
new JInputPanel(label, text field default text) ✅
setError(error message, error condition) ✅

for errors, sort error priority ❌
Comments : I am not sure what the errors are

Question : The size of and color of the Label, will it depend on the page?
 */

import javax.swing.*;
import java.awt.*;

public class JInputPanel extends JPanel{

    //VARIABLES
    private JLabel inpLabel;
    private JTextField inpTextField; //Input
    private JLabel inpErrorMessage;
    private JLabel inpDescription;

    //CONSTRUCTOR
    public JInputPanel(String labelText, String deafultText){
        //Initializes the text for label and textfield
        this.inpLabel = new JLabel(labelText);
        this.inpTextField = new JTextField(deafultText);
        this.inpErrorMessage = new JLabel();
        this.inpDescription = new JLabel();

        //Colors the errorMessage in red
        this.inpErrorMessage.setForeground(Color.RED);

        //Adds the label, description, errormessage and description
        add(inpLabel);
        add(inpDescription);
        add(inpErrorMessage);
        add(inpDescription);

        //Hides the errormesage and description
        this.inpErrorMessage.setVisible(false);
        this.inpDescription.setVisible(false);
    }

    //SETTERS
    public void setError(String errorMessage, boolean errorCondition){
        //If errorCondition is true shows the error message
        if(errorCondition){
            this.inpErrorMessage.setText(errorMessage);
            this.inpErrorMessage.setVisible(true);
        }
        //If errorCondition is false hides the error message
        else{
            this.inpErrorMessage.setVisible(true);
        }
    }

}
