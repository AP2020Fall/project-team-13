package BattleSea.Model;

public class Coordination implements Comparable<Coordination> {
    private final int xAxis;
    private final int yAxis;
    private String content;
    private boolean isBombed;
    private boolean isOccupied;

    public Coordination(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean Bomb() {
        if (this.isBombed) return false;
        else {
            this.isBombed = true;
            if (this.isOccupied) setContent("+");
            else setContent("-");
            return true;
        }
    }

    public boolean Occupy(int shipCode) {
        if (this.isOccupied) return false;
        else {
            this.isOccupied = true;
            setContent("#");
            return true;
        }
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
