import java.util.Comparator;
public class CompareMemeByRating implements Comparator<Meme> {
    /**
     * Compares the Meme m1 to the Meme m2 for order as follows:
     * (1) overall rating (descending)
     * (2) caption (ascending)
     * (3) BackgroundImage (using its natural ordering)
     * (4) creator (using its natural ordering)
     * @param m1 The first Meme to compare.
     * @param m2 The second Meme to compare.
     * @return A negative int if m1 comes before m2, 0 if m1 equals m2, and a positive int if m2 comes before m1.
     */
    @Override
    public int compare(Meme m1, Meme m2) {
        if(m1.calculateOverallRating() - m2.calculateOverallRating() != 0) {
            if(m1.calculateOverallRating() > m2.calculateOverallRating())
                return -1; 
            else
                return 1; 
            
        }
        else if(m1.getCaption().compareTo(m2.getCaption()) != 0)
            return m1.getCaption().compareTo(m2.getCaption());
        else if(m1.getBackgroundImage().compareTo(m2.getBackgroundImage()) != 0)
            return m1.getBackgroundImage().compareTo(m2.getBackgroundImage());
        else if(m1.getCreator().compareTo(m2.getCreator()) != 0)
            return m1.getCreator().compareTo(m2.getCreator());
        else
            return 0;
    }
}