import java.awt.*;
import javax.swing.*;

public class MemePanel extends JPanel {
    // MemePanel components
    CaptionPanel caption_panel;
    VerticalAlignPanel verticalalign_panel;

    // Default Constructor 
    public MemePanel() {
        // Construct the MemePanel & set it's border
        super(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Meme"));

        // Initialize the caption_panel & add it to the northern region of the MemePanel
        caption_panel = new CaptionPanel();
        this.add(caption_panel, BorderLayout.NORTH);

        // Initialize the verticalalign_panel & add it to the MemePanel
        verticalalign_panel = new VerticalAlignPanel();
        this.add(verticalalign_panel);
    }
}