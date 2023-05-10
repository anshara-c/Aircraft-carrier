package milestone.pkg3;

import java.io.Serializable;
import java.time.LocalDate;

public class commandingofficer extends employee implements Serializable {

    int rankid;
    String rank;

    public commandingofficer(int rankid, String rank, String name) {
        super(name);
        this.rankid = rankid;
        this.rank = rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setrankId(int rankid) {
        this.rankid = rankid;
    }

    public int getrankId() {
        return rankid;
    }

    @Override
    public String toString() {
        return "Id=" + rankid + ", Name=" + getName() + ", Rank=" + rank;
    }

    public void display() {
        System.out.println("Id=" + rankid + ", Name=" + getName() + ", Rank=" + rank);
    }
}
