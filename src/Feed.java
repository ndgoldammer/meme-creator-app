import java.util.ArrayList;

public class Feed {
   //Feed data
   private ArrayList<Meme> memes;

   //Constructor
   public Feed() {
      memes = new ArrayList<>();
   }

   //Functions to obtain and manipulate Feed data
   public ArrayList<Meme> getMemes() {
      return this.memes;
   }
   public void setMemes(ArrayList<Meme> memes) {
      this.memes = memes;
   }

   /**
    * Finds a Meme from the Feed that the User u did not create and hasn't seen.
    * @param u The User the Meme will be found for
    * @return Returns a Meme from the Feed if a new Meme is found, and false if otherwise.
    */
   public Meme getNewMeme(User u) {
      if(this.memes.isEmpty() == false) {
         for(int i = 0; i < this.memes.size(); i++) {
            if(u.getMemesViewed().contains(this.memes.get(i)) == false && u.getMemesCreated().contains(this.memes.get(i)) == false)
               return this.memes.get(i);
         }
      }
      return null;
   }
   
   @Override
   public String toString() {
      String returnString = "";
      String memeString;
      Meme meme;
      for(int i = 0; i < this.memes.size(); i++) {
         meme = this.memes.get(i);
         memeString = meme.toString();
         returnString = returnString.concat(memeString + "\n");  
      }
      return returnString;
   }
}
