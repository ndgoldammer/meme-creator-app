public class Rating {
   //Rating data
   private User user;
   private int score;

   //Constructors 
   public Rating() {
      this.user = new User();
      this.score = 0;
   }
   public Rating(User user, int score) {
      this.user = user;
      if((score == -1) || (score == 0) || (score == 1))
         this.score = score;
      else
         score = 0;
   }

   //Functions to obtain and manipulate Rating data
   public void setUser(User user) {
      this.user = user;
   }
   public User getUser() {
      return this.user;
   }
   public boolean setScore(int score) {
      if(score == -1 || score == 0 || score == 1) {
         this.score = score;
         return true;
      }
      return false;
   }
   public int getScore() {
      return this.score;
   }

   /**
    * Returns a String representation of the Rating. 
    * @return Returns a String representation of the Rating. 
    */
   @Override
   public String toString() {
      if(this.score == -1)
         return this.user.getUserName() + " rated as a downvote";
      else if(this.score == 0)
         return this.user.getUserName() + " rated as a pass";
      else
         return this.user.getUserName() + " rated as an upvote";
   }
   
   /**
    * Checks if the Rating is equal to the Object o. Compares their class, score, and user.
    * @param o The Object to compare with the Rating. 
    * @return Returns true if the Rating equals o, false if otherwise.
    */
   @Override
   public boolean equals(Object o) {
      if(o instanceof Rating) {
         Rating r = (Rating) o;
         return (this.score == r.score && this.user.equals(r.user));
      }
      return false;
   }  
}