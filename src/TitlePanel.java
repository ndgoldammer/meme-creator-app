import java.awt.*;
import javax.swing.*;

public class TitlePanel extends JPanel {
    // TitlePanel components
    JLabel label;
    JTextField textfield;

    // Default Constructor
    public TitlePanel() {
        // Construct the TitlePanel
        super();

        // Construct the label & add it to the TitlePanel
        label = new JLabel("Title: ");
        label.setPreferredSize(new Dimension(99, 25));
        this.add(label);

        // Construct the textfield & add it to the TitlePanel
        textfield = new JTextField(29);
        this.add(textfield);
    }
}