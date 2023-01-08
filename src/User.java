import java.util.ArrayList;
import java.util.TreeSet;

public class User implements Comparable<User> {
    //User data
    private String userName;
    private ArrayList<Meme> memesCreated;
    private TreeSet<Meme> memesViewed;

    //Constructors
    public User() {
        userName = "No Username Yet";
        memesCreated = new ArrayList<>();
        memesViewed = new TreeSet<>();
    }
    public User(String userName) {
        this.userName = userName;
        memesCreated = new ArrayList<>();
        memesViewed = new TreeSet<>();
    }

    //Functions to obtain and manipulate User data
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }
     public void setMemesCreated(ArrayList<Meme> memesCreated) {
        this.memesCreated = memesCreated;
    }
    public ArrayList<Meme> getMemesCreated() {
        return this.memesCreated;
    }
    public void setMemesViewed(ArrayList<Meme> memesViewed) {
        for(int i = 0; i < memesViewed.size(); i++) {
            this.memesViewed.add(memesViewed.get(i));
        }
    }
    public ArrayList<Meme> getMemesViewed() {
        ArrayList<Meme> memes = new ArrayList<>();
        for(Meme m : this.memesViewed) {
            memes.add(m);
        }
        return memes;
    }

    /**
     * Rates a Meme m with the given int r. Adds the Meme m to the memesViewed list.
     * @param m The Meme to be rated
     * @param r The int rating to give the Meme m
     */
    public void rateMeme(Meme m, int r) {
        this.memesViewed.add(m);
        m.addRating(new Rating(this, r));
    }

    /**
     * Creates a new Meme. Adds the created Meme to the User's createdMemes list.
     * @param bi The BackgroundImage of the Meme to be created
     * @param caption The caption of the Meme to be created
     * @return Returns the created Meme
     */
    public Meme createMeme(BackgroundImage bi, String caption) {
        Meme m = new Meme(bi, caption, this);
        this.memesCreated.add(m);
        return m;
    }

    /**
     * Deletes the Meme m if (1) the User is the creator of the Meme m and (2) the Meme m hasn't been shared.
     * @param m The Meme to be deleted
     * @return Returns true if m has been deleted, and false if otherwise
     */
    public boolean deleteMeme(Meme meme) {
        for(int i = 0; i < this.memesCreated.size(); i++) {
            if(meme.equals(this.memesCreated.get(i)) && meme.getShared() == false) {
            	this.memesCreated.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Shares the Meme m to the Feed f.
     * @param m The Meme to share
     * @param f The feed to share the Meme m in
     */
    public void shareMeme(Meme m, Feed f) {
        m.setShared(true);
        f.getMemes().add(m);
    }

    /**
     * Rates the next Meme from the Feed f with the int r and adds it to the User's memesViewed list.
     * @param f The Feed to obtain the next Meme from
     * @param r The rating to give the next Meme
     * @return Returns true if the next Meme has been rated, and false if otherwise
     */
    public boolean rateNextMemeFromFeed(Feed f, int r) {
        if(f.getNewMeme(this) != null) {
            Meme m = f.getNewMeme(this);
            this.memesViewed.add(m);
            m.addRating(new Rating(this, r));
            return true;
        }
        else
            return false;
    }

    /**
     * Calculates the User's reputation, which is the average rating of all Memes created by the User.
     * If the User has not created any Memes or had any of their Memes rated, their reputation is 0.0.
     * @return Returns the average rating of all Memes created by the User.
     */
    public double calculateReputation() {
        double rep = 0.0;
        if(this.memesCreated.isEmpty() == false) {
            for(int i = 0; i < this.memesCreated.size(); i++) {
            	rep = rep + this.memesCreated.get(i).calculateOverallRating();
            }
            return rep;
        }
        return rep;
    }

    /**
     * Returns a String representation of the User.
     * @return Returns the String "[username] has rated ( number of memes viewed ) memes, ( reputation )".
     */
    @Override
    public String toString() {   
        double rep = Math.round(this.calculateReputation() * 10.0) / 10.0;
        return this.userName + " has rated (" + memesViewed.size() + ") memes, (" + rep + ")";
    }

    /**
     * Checks if the User is equal to the Object o. Compares their class and userName.
     * @param o The Object to compare with the User
     * @return Returns true if the User equals o, false if otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof User) {
            User u = (User) o;
            if(this.userName == u.userName)
                return true;
        }
        return false;
    }
    
    /**
     * Compares the User with the User u for order as follows:
     * (1) userName (ascending)
     * (2) number of memes created (descending)
     * @param u The User to be compared to for order.
     * @return A negative int if the User comes before u, 0 if the User equals u, and a positive int if the User comes after u.
     */
    @Override
    public int compareTo(User u) {
        if(this.userName.compareTo(u.userName) != 0)
            return this.userName.compareTo(u.userName);
        else if(this.memesCreated.size() - u.memesCreated.size() != 0) {
            if(this.memesCreated.size() > u.memesCreated.size())
                return -1;
            return 1;
            
        }
        else
            return 0;
    }
}