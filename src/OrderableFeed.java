import java.util.*;
public class OrderableFeed extends Feed {
    //Constructor
    public OrderableFeed() {
        super();
    }

    /**
     * Reorders the OrderableFeed's Memes by caption, using Meme's natural ordering.
     */
    public void sortByCaption() {
        Collections.sort(this.getMemes());
    }

    /**
     * Reorders the OrderableFeed's Memes by rating.
     */
    public void sortByRating() {
        Collections.sort(this.getMemes(), new CompareMemeByRating());
    }
    
    /**
     * Reorders the OrderableFeed's Memes by creator.
     */
    public void sortByCreator() {
        Collections.sort(this.getMemes(), new CompareMemeByCreator());
    }
}