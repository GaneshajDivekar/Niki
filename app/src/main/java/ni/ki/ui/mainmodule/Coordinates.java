package ni.ki.ui.mainmodule;

public class Coordinates {
    private int x1,x2,y1,y2;
    private int x3,x4,y3,y4;

    public double getWidth() {
        return  width=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
       // return height;
       return height=Math.sqrt((x4-x3)*(x4-x3) + (y4-y3)*(y4-y3));
    }

    public void setHeight(double height) {
        this.height = height;
    }

    double width,height;


    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
        this.x3=x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
        this.x4=x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
        this.y4=y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
        this.y3=y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }
}
