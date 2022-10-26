import javafx.scene.shape.Rectangle;

public class NewRectangle extends Rectangle 
{
    Rectangle rec;
    private double x;
    private double y;
    private double width;
    private double hight;
    public NewRectangle(double width, double hight)
    {
        rec = new Rectangle(width,hight);
        this.width = width;
        this.hight = hight;
        this.x = 0;
        this.y = 0;
    }
    public NewRectangle()
    {
        x = 0;
        y = 0;
    }

    public void getCoordinates()
    {
        System.console().printf("x: " + x + "\ny: " + y + "\n");
    }

    public double getNewX()
    {
        return x;
    }

    public double getNewY()
    {
        return y;
    }


    public void transform(double dx, double dy)
    {
        x = dx;
        y = dy;
        //System.console().printf("dx: " + dx + "\ndy: " + dy + "\n");
        rec.setX(x);
        rec.setY(y);
    }

    public Rectangle getRec()
    {
        return rec;
    }

    public void readRec(Rectangle newRec)
    {
        rec = newRec;
    }
}
