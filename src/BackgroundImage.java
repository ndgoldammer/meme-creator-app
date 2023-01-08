public class BackgroundImage implements Comparable<BackgroundImage> {
   //BackgroundImage data
   private String imageFileName; 
   private String title; 
   private String description;  

   //Constructors
   public BackgroundImage() {
      this.imageFileName = "No Image File Name Yet";
      this.title = "No Title Yet";
      this.description = "No Description Yet";
   }
   public BackgroundImage(String imageFileName, String title, String description) {
      this.imageFileName = imageFileName;
      this.title = title;
      this.description = description;
   }

   //Functions to obtain and manipulate BackgroundImage data
   public String getImageFileName() {
      return this.imageFileName;
   }
   public void setImageFileName(String imageFileName) {
     this.imageFileName = imageFileName;
   }
   public String getTitle() {
      return this.title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getDescription() {
      return this.description;
   }
   public void setDescription(String description) {
      this.description = description;
   }

   /**
    * Checks if the BackgroundImage is equal to the Object o.
    * Compares their class, title, description, and imageFileName.
    * @param o The Object to compare with the BackgroundImage
    * @return Returns true if the BackgroundImage equals o, false if otherwise.
    */
   @Override
   public boolean equals(Object o)
   {
      if(o == null || this.getClass() != o.getClass())
         return false;
      BackgroundImage bi = (BackgroundImage) o;
      return (imageFileName.equals(bi.imageFileName) && title.equals(bi.title) && description.equals(bi.description));
   }

   /**
    * Returns a String representation of the BackgroundImage.
    * @return Returns the String "title < description >".
    */
   @Override
   public String toString() {
      return title + " <" + description + ">";
   }
   
   /**
    * Compares the BackgroundImage with the BackgroundImage bi for order as follows:
    * (1) imageFileName (ascending)
    * (2) title (ascending)
    * (3) description (ascending)
    * @param bi The BackgroundImage to be compared to for order.
    * @return A negative int if the BackgroundImage comes before bi, 0 if the BackgroundImage equals bi, and a positive int if the BackgroundImage comes after bi.
    */
   @Override
   public int compareTo(BackgroundImage bi) {
      if(this.imageFileName.compareTo(bi.imageFileName) != 0)
         return this.imageFileName.compareTo(bi.imageFileName);
      else if(this.title.compareTo(bi.title) != 0)
         return this.title.compareTo(bi.title);
      else if(this.description.compareTo(bi.description) != 0)
         return this.description.compareTo(bi.description);
      else
         return 0;
   }
}