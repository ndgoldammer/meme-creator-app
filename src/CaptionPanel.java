import java.awt.*;
import javax.swing.*;
public class CaptionPanel extends JPanel {
    // CaptionPanel components
    JLabel label;
    JTextField textfield;

    // Default Constructor
    public CaptionPanel () {
        // Construct the CaptionPanel
        super();

        // Construct the label & add it to the CaptionPanel
        label = new JLabel("Caption: ");
        label.setPreferredSize(new Dimension(99, 25));
        this.add(label);
 
        // Construct the textfield & add it to the CaptionPanel
        textfield = new JTextField(29);
        this.add(textfield);    
    }
}