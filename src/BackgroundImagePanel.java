import java.awt.*;
import javax.swing.*;
public class BackgroundImagePanel extends JPanel {
    // BackgroundImagePanel components
    FilePanel file_panel;
    TitlePanel title_panel;
    DescriptionPanel description_panel;

    // Default constructor
    public BackgroundImagePanel() {
        // Construct the BackgroundImagePanel & set it's border
        super(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Background Image"));

        // Initialize the file_panel & add it to the northern region of the BackgroundImagePanel
        file_panel = new FilePanel();
        this.add(file_panel, BorderLayout.NORTH);

        // Initialize the title_panel & add it to the center region of the BackgroundImagePanel
        title_panel = new TitlePanel();
        this.add(title_panel, BorderLayout.CENTER);

        // Initialize the description_panel & add it to the southern region of the BackgroundImagePanel
        description_panel = new DescriptionPanel();
        this.add(description_panel, BorderLayout.SOUTH);
    }
}