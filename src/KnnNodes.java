/**
 * Created by luoluyao on 2017/11/10.
 */
public class KnnNodes extends Node {

    private String label;
    private double dis;

    public KnnNodes(float x, float y, String label, double dis) {
        super(x, y);
        this.label = label;
        this.dis = dis;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }
}
