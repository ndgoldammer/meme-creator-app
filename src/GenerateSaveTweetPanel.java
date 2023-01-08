import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import twitter4j.*;

public class GenerateSaveTweetPanel extends JPanel {
    // GenerateSaveTweetPanel Components
	MemeCreator creator;
    JButton generate;
    JButton save;
    JButton tweet;

	// Default Constructor
	public GenerateSaveTweetPanel(MemeCreator creator) {
		// Construct the GenerateSaveTweetPanel
		super();

		// Initialize the creator with the given parameter, creator
		this.creator = creator;

        // Construct the generate button with a GenerateButtonListener & add it to the GenerateSaveTweetPanel
        generate = new JButton("Generate Meme");
        generate.setPreferredSize(new Dimension(120, 30));
		generate.addActionListener(new GenerateButtonListener());
		this.add(generate); 

		// Construct the save button with a SaveButtonListener & add it to the GenerateSaveTweetPanel
		save = new JButton("Save Meme");
		save.setPreferredSize(new Dimension(95, 30));
		save.addActionListener(new SaveButtonListener());
		this.add(save);

		// Construct the tweet button with a TweetButtonListener & add it to the GenerateSaveTweetPanel
		tweet = new JButton("Tweet Meme");
		tweet.setPreferredSize(new Dimension(105, 30));
		tweet.addActionListener(new TweetButtonListener());
		this.add(tweet);
    }

    // ActionListener class for the generate button
    private class GenerateButtonListener implements ActionListener {
        // Implements the ActionListener Interface
        @Override
    	public void actionPerformed(ActionEvent event) {
			// Necessary information to construct the graphicalmeme
			String filename = creator.backgroundimage_panel.file_panel.filename_label.getText();
			String title = creator.backgroundimage_panel.title_panel.textfield.getText();
			String description = creator.backgroundimage_panel.description_panel.textfield.getText();
			String caption = creator.meme_panel.caption_panel.textfield.getText();
			String alignment = (String) creator.meme_panel.verticalalign_panel.cbox.getSelectedItem();
			BackgroundImage image = new BackgroundImage(filename, title, description);
			
			// Construct the graphicalmeme
			creator.graphical_meme = new GraphicalMeme(image, caption, creator.user);
			creator.graphical_meme.setCaptionVerticalAlign(alignment);

			// Try to compile the graphicalmeme
			try {
				BufferedImage buffimage = creator.graphical_meme.compileMeme();
				creator.display_label.setIcon(new javax.swing.ImageIcon(buffimage));
				creator.viewing_panel.repaint();
			}
			catch(IOException e) {
				System.err.println(e.toString());
			}
			catch(Exception e) {
				System.err.println(e.toString());
			}
    	} 
    }

	// ActionListener class for the save button
	private class SaveButtonListener implements ActionListener {
        // Implements the ActionListener Interface
    	@Override
        public void actionPerformed(ActionEvent event) {
            // Construct a file chooser window with a title and file filter
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("Save Meme");
            jfc.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
			int state = jfc.showSaveDialog(null);

            // If the user has saved the Meme file
            if(state == JFileChooser.APPROVE_OPTION) {
                String destination = jfc.getSelectedFile().getAbsolutePath();
                if (!destination.contains(".png"))
                    destination += ".png";
                try {
                	ImageIO.write(creator.graphical_meme.compileMeme(), "png", new File(destination));
                }
                catch(IllegalArgumentException e) {
                	System.err.println(e.toString());
                }
                catch(IOException e) {
                	System.err.println(e.toString());
                }
                catch(Exception e) {
                	System.err.println(e.toString());
                }
            }
        }
    }

	// ActionListener class for the tweet button
	private class TweetButtonListener implements ActionListener { 
		// Implements the ActionListener interface
		@Override 
		public void actionPerformed(ActionEvent event) {
			// Construct a JFileChooser to choose the image file
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Choose a Meme to Tweet");
			int state = jfc.showOpenDialog(null);

			// If the user selected a file and clicked open
			if(state == JFileChooser.APPROVE_OPTION) {
				// The Meme file selected by the user
				File file = jfc.getSelectedFile();

				// The caption of the Meme to be tweeted
				String msg = creator.backgroundimage_panel.description_panel.textfield.getText();

				// Construct a Twitter object
				Twitter twitter = TwitterFactory.getSingleton();
				
				// Try to tweet the image
				try {
					long[] mediaIds = new long[1];
					UploadedMedia media = twitter.uploadMedia(file);
					mediaIds[0] = media.getMediaId();
					StatusUpdate statusUpdate = new StatusUpdate(msg);
					statusUpdate.setMediaIds(mediaIds);
					twitter.updateStatus(statusUpdate);
				}
				catch(TwitterException e) {
					System.out.println(e.getErrorMessage());
				}
			}
		}
	}
}