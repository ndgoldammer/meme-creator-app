import java.awt.*;
import javax.swing.*;

public class VerticalAlignPanel extends JPanel {
    // VerticalAlignPanel components
    JLabel label;
    JComboBox<String> cbox;
    String[] options = {"top", "middle", "bottom"};

    // Default Constructor
    public VerticalAlignPanel() {
        // Construct the VerticalAlignPanel
        super();

        // Construct the label & add it to the VerticalAlignPanel
        label = new JLabel("Vertical Align: ");
        label.setPreferredSize(new Dimension(95, 25));
        this.add(label, BorderLayout.WEST);

        // Construct the cbox & add it to the VerticalAlignPanel
        cbox = new JComboBox<String>(options);
        cbox.setPreferredSize(new Dimension(360, 25));
        cbox.setMaximumSize(cbox.getPreferredSize());
        this.add(cbox);
    }
}