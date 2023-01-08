import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FilePanel extends JPanel {
    // FilePanel components
    JLabel file_label;
    JButton upload;
    JLabel filename_label;

    // Default constructor
    public FilePanel() {
        // Construct the FilePanel
        super();

        // Initialize the file_label & add it to the FilePanel
        file_label = new JLabel("File: ");
        file_label.setPreferredSize(new Dimension(100, 20));
        this.add(file_label);

        // Initialize the upload with an UploadButtonListener & add it to the FilePanel
        upload = new JButton("Browse Files");
        upload.setPreferredSize(new Dimension(85, 20));
        upload.addActionListener(new UploadButtonListener());
        this.add(upload);

        // Initialize the filename_label & add it to the FilePanel
        filename_label = new JLabel("");
        filename_label.setPreferredSize(new Dimension(265, 20));
        this.add(filename_label);
    }

    // ActionListener class for the upload button
    class UploadButtonListener implements ActionListener {
        // Implements the ActionListener interface
        @Override
        public void actionPerformed(ActionEvent e) {
            // Construct a JFileChooser to choose the image file
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("Choose a Background Image");
            jfc.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
            int state = jfc.showOpenDialog(null);
            if(state == JFileChooser.APPROVE_OPTION)
                filename_label.setText(jfc.getSelectedFile().getAbsolutePath());     
        }
    }
}