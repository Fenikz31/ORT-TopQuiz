package model;

public class User {

    private int id;
    private String mFirstName;
    private String EXTRA_SCORE;
    private String mDate;

    public User() {
    }

    // Insert necessary getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getEXTRA_SCORE() {
        return EXTRA_SCORE;
    }

    public void setEXTRA_SCORE(String EXTRA_SCORE) {
        this.EXTRA_SCORE = EXTRA_SCORE;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
