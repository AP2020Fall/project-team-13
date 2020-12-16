package BattleSea.Model;

public class Coordination implements Comparable<Coordination> {
    private final int xAxis;
    private final int yAxis;
    private String content;
    private String previousContent;
    private boolean isBombed;
    private boolean isOccupied;

    public Coordination(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        content="";
        previousContent="";
    }

    public void setContent(String content) {
        this.previousContent=this.content;
        this.content = content;
    }

    public String getPreviousContent() {
        return previousContent;
    }

    public void rollbackContentChange(){
        this.content=this.previousContent;
    }

    public boolean Bomb() {
        if (this.isBombed) return false;
        else {
            this.isBombed = true;
            return true;
        }
    }

    public boolean occupy() {
        if (this.isOccupied) return false;
        else {
            this.isOccupied = true;
            return true;
        }
    }

    public void unoccupy(){
        this.isOccupied=false;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public String getContent() {
        return content;
    }

    public boolean isBombed() {
        return isBombed;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int compareTo(Coordination o) {
        return (this.xAxis - o.getXAxis()) + (this.yAxis - o.getYAxis());
    }

    public Coordination getClone(){
        return new Coordination(this.getXAxis(),this.getYAxis());
    }
}
