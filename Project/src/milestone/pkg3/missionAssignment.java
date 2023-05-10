package milestone.pkg3;

import java.io.Serializable;

public class missionAssignment implements Serializable {

    private String name;
    private int missionIndex;

    public missionAssignment(String name, int missionIndex) {
        this.name = name;
        this.missionIndex = missionIndex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMissionIndex(int missionIndex) {
        this.missionIndex = missionIndex;
    }

    public String getName() {
        return name;
    }

    public int getMissionIndex() {
        return missionIndex;
    }

}
