import java.awt.*;
import javax.swing.*;
public class DescriptionPanel extends JPanel {
    // DescriptionPanel components
    JLabel label;
    JTextField textfield;

    // Default Constructor
    public DescriptionPanel () {
        // Construct the DescriptionPanel
        super();

        // Construct the label & add it to the DescriptionPanel
        label = new JLabel("Description: ");
        label.setPreferredSize(new Dimension(99, 25));
        this.add(label);

        // Construct the textfield & add it to the DescriptionPanel
        textfield = new JTextField(29);
        this.add(textfield);
    }
}