import java.awt.*;
import javax.swing.*;

public class MemeCreator extends JFrame {
    // Essential MemeCreator data
    public User user;
    public GraphicalMeme graphical_meme;
    public static final long serialVersionUID = 1L;

    // Primary components of the MemeCreator gui
    public JPanel main_panel;   
    public JPanel control_panel;
    public JPanel viewing_panel;
    
    // Primary subcomponents of the MemeCreator gui
    public BackgroundImagePanel backgroundimage_panel;
    public MemePanel meme_panel;
    public GenerateSaveTweetPanel gst_panel;
    public JLabel display_label;

    // Default Constructor
    public MemeCreator(User u) {
        user = u;
    }

    // Initializes all MemeCreator gui components
    private void gui() {
        // Set the title & default close operation of the MemeCreator
        this.setTitle("Meme Creator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the main_panel
        main_panel = new JPanel(new BorderLayout());

        // Initialize the control_panel & add it to the western region of the main_panel
        control_panel = new JPanel(new BorderLayout());
        control_panel.setPreferredSize(new Dimension(500,570));
        main_panel.add(control_panel, BorderLayout.WEST);

        // Initialize the viewing_panel panel & add it to the center of the main_panel panel
        viewing_panel = new JPanel(new BorderLayout());
        viewing_panel.setPreferredSize(new Dimension(550, 550));
        main_panel.add(viewing_panel, BorderLayout.CENTER);

        // Initialize the backgroundimage_panel & add it to the northern region of the control_panel
        backgroundimage_panel = new BackgroundImagePanel();
        control_panel.add(backgroundimage_panel, BorderLayout.NORTH);

        // Initialize the meme_panel & add it to the center of the control_panel
        meme_panel = new MemePanel();
        control_panel.add(meme_panel, BorderLayout.CENTER);

        // Initialize the gst_panel & add it to the southern region of the control_panel
        gst_panel = new GenerateSaveTweetPanel(this);
        control_panel.add(gst_panel, BorderLayout.SOUTH);

        // Initialize the display_label & add it to the center of the viewing_panel
        display_label = new JLabel();
        display_label.setHorizontalAlignment(JLabel.CENTER);
        display_label.setPreferredSize(new Dimension(550, 550));
        viewing_panel.add(display_label, BorderLayout.CENTER);

        this.getContentPane().add(main_panel);
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);
    }

    // Driver 
    public static void main(String[] args) {
        //User for the MemeCreator
        User u = new User();
        MemeCreator mc = new MemeCreator(u);

        //Invoke and start the MemeCreator GUI 
        javax.swing.SwingUtilities.invokeLater(() -> mc.gui());
    }
}