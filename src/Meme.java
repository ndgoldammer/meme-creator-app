public class Meme implements Comparable<Meme> {
   //Meme data
   private User creator; 
   private BackgroundImage backgroundImage;
   private Rating[] ratings;
   private String caption;
   private String captionVerticalAlign;
   private boolean shared;

   //Constructors
   public Meme() {
      this.creator = new User();
      this.backgroundImage = new BackgroundImage();
      this.ratings = new Rating[10];
      this.caption = "No caption Yet";
      this.captionVerticalAlign = "bottom";
      this.shared = false;
   }
   public Meme(BackgroundImage backgroundImage, String caption, User creator) {
      this.backgroundImage = backgroundImage;
      this.caption = caption;
      this.creator = creator;
      this.ratings = new Rating[10];
      this.captionVerticalAlign = "bottom";
      this.shared = false;
   }

   //Functions to obtain and manipulate Meme data
   public void setCreator(User creator) {
      this.creator = creator;
   }
   public User getCreator() {
      return this.creator;
   }
   public void setBackgroundImage(BackgroundImage backgroundImage) {
      this.backgroundImage = backgroundImage;
   }
   public BackgroundImage getBackgroundImage() {
     return this.backgroundImage;
   }
   public void setRatings(Rating[] ratings) {
      this.ratings = ratings;
   }
   public Rating[] getRatings() {
      return this.ratings;
   }
   public void setCaption(String caption) {
      this.caption = caption;
   }
   public String getCaption() {
      return this.caption;
   }
   public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
      if((captionVerticalAlign.equalsIgnoreCase("top")) || (captionVerticalAlign.equalsIgnoreCase("middle")) || (captionVerticalAlign.equalsIgnoreCase("bottom"))) {
         this.captionVerticalAlign = captionVerticalAlign;
         return true;
      }
      return false;
   }
   public String getCaptionVerticalAlign() {
      return this.captionVerticalAlign;
   }
   public void setShared(boolean shared) {
      this.shared = shared;
   }
   public boolean getShared() {
      return shared;
   }

   /**
    * Returns a String representation of the Meme.
    * @return Returns the String "backgroundImage 'caption' overallRating [+1: the number of +1 ratings, -1: the number of -1 ratings]".
    */
   @Override
   public String toString() {
      return this.backgroundImage.toString() + " \'" + this.caption + "\' " + this.calculateOverallRating() + " [+1: " + this.getNumberOfRatings(1) + ", -1: " + this.getNumberOfRatings(-1) + "]" + " - created by " + this.creator.getUserName();
   }
   private int getNumberOfRatings(int one) {
      int accumulator = 0;
      if(one == 1) {
         for(int i = 0; i < this.ratings.length; i++) {
            if((this.ratings[i] != null) && (this.ratings[i].getScore() == 1))
               accumulator++;
         }
      }
      else {
         for(int i = 0; i < this.ratings.length; i++)
         {
            if((this.ratings[i] != null) && (this.ratings[i].getScore() == -1))
               accumulator++;
         }
      }
      return accumulator;
   }

   /**
    * Checks if the Meme is equal to the Object o. Compares their class, creator, caption, and backgroundImage.
    * @param o The Object to compare with the Meme
    * @return Returns true if the Meme equals o, false if otherwise.
    */
   @Override
   public boolean equals(Object o) {
      if(o instanceof Meme) {
         Meme m = (Meme) o;
         if(this.creator.equals(m.creator) && this.caption == m.caption && this.backgroundImage.equals(m.backgroundImage))
            return true;
      }
      return false;
   }

   /**
    * Calculates the Meme's overall rating.
    * @return Returns the sum of all the Meme's ratings, and 0.0 if the Meme has no ratings.
    */
   public double calculateOverallRating() {
      double sum = 0.0;
      for(int i = 0; i < ratings.length; i++) {
         if(this.ratings[i] != null)
            sum = sum + ratings[i].getScore();
      }
      return sum;
   }

   /**
    * Adds the Rating r to the Meme's ratings.
    * @param r The Rating to add.
    * @return Returns true if the Rating was added, and false if otherwise.
    */
   public boolean addRating(Rating object) {
      for(int i = 0; i < ratings.length; i++) {
         if(ratings[i] == null) {
            ratings[i] = object;
            return true;
         }
         else if(ratings[9] != null) {
            for(int j = 0; j < ratings.length - 1; j++)  {
               ratings[j] = ratings[j + 1];
               if(j + 1 == 9) {
                  ratings[j + 1] = object;
                  return true;
               }
            }
         }
      }
      return false; 
   }
   
   /**
    * Compares the Meme with the Meme m for order as follows:
    * (1) caption (ascending)
    * (2) BackgroundImage (using BackgroundImage natural ordering)
    * (3) overall rating (descending)
    * (4) shared memes
    * @param m The Meme to be compared to for order.
    * @return A negative int if the Meme comes before m, 0 if the Meme equals m, and a positive int if m comes before the Meme.
    */
   @Override
   public int compareTo(Meme object) {
      if(this.caption.compareTo(object.caption) != 0)
         return this.caption.compareTo(object.caption);
      else if(this.backgroundImage.compareTo(object.backgroundImage) != 0)
         return this.backgroundImage.compareTo(object.backgroundImage);
      else if(this.calculateOverallRating() - object.calculateOverallRating() != 0.0) {
         if(this.calculateOverallRating() > object.calculateOverallRating())
            return -1;
         else
            return 1;
      }
      else if(this.getShared() != object.getShared()) {
         if(this.getShared())
            return -1;
         else
            return 1;
      }
      else
         return 0;
   }
}