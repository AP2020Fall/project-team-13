package BattleSea.Model;

public class Coordination {
    private final int xAxis;
    private final int yAxis;
    private String content;
    private String previousContent;
    private boolean isBombed;
    private boolean isOccupied;

    public Coordination(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        content = "";
        previousContent = "";
    }

    public void setContent(String content) {
        this.previousContent = this.content;
        this.content = content;
    }

    public String getPreviousContent() {
        return previousContent;
    }

    public void rollbackContentChange() {
        String temp = this.content;
        this.content = this.previousContent;
        this.previousContent = temp;
    }

    public boolean Bomb() {
        if (this.isBombed) return false;
        else {
            this.isBombed = true;
            return true;
        }
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void unoccupy() {
        this.isOccupied = false;
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

}
