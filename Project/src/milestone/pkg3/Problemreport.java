package milestone.pkg3;

import java.io.Serializable;

public class Problemreport implements Serializable {

    private String Text;
    private String Name;
    private int Index;

    public Problemreport(String Text, String Name, int Index) {
        this.Text = Text;
        this.Name = Name;
        this.Index = Index;
    }

    public Problemreport(String Text, String Name) {
        this.Text = Text;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public int getIndex() {
        return Index;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setIndex(int Index) {
        this.Index = Index;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public Problemreport(String Text) {
        this.Text = Text;
    }

}
