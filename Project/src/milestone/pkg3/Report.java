package milestone.pkg3;

import java.io.Serializable;


public class Report extends Problemreport implements Serializable{
    private String Report;
  
    public Report(String Report, String Text, String Name, int Index) {
        super(Text, Name, Index);
        this.Report = Report;
    }
    public Report(String Report, String Text, String Name) {
        super(Text, Name);
        this.Report = Report;
    }

    public void setReport(String Report) {
        this.Report = Report;
    }

    public String getReport() {
        return Report;
    }
    @Override
    public String toString() {
        return "Report{" + "Report=" + Report  + ", PilotName=" + getName() + ", PilotIndex=" + getIndex() + '}';
    }
    
    
}
