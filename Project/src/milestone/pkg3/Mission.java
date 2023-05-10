package milestone.pkg3;

import java.io.Serializable;
import java.time.LocalDate;

public class Mission implements Serializable {

    int Index;
    String mission;
    String mType;
    LocalDate mDate;

    public Mission(int Index, String mission, String mType, LocalDate mDate) {
        this.Index = Index;
        this.mission = mission;
        this.mType = mType;
        this.mDate = mDate;
    }

    public Mission(String mission, String mType, LocalDate mDate) {
        this.mission = mission;
        this.mType = mType;
        this.mDate = mDate;
    }

    public String getMission() {
        return mission;
    }

    public String getmType() {
        return mType;
    }

    public LocalDate getmDate() {
        return mDate;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public void setmDate(LocalDate mDate) {
        this.mDate = mDate;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int Index) {
        this.Index = Index;
    }

    @Override
    public String toString() {
        return "Index: " + Index + "\n" + "Mission: " + mission + "\n" + "Pilot type needed is " + mType + "\n" + "Mission needs to be initiated by " + mDate + "\n";
    }

    public void display() {
        System.out.println("Index=" + Index + ", Mission=" + mission + ", type=" + mType + ", date=" + mDate);
    }
}
