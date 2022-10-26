
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import java.lang.Math;

public class NewRectangle extends Rectangle implements Figure
{
    Rectangle rec;
   
    private Point2D firstPoint2d;
    private Point2D secPoint2d;

    public NewRectangle(double x, double y)
    {
        rec = new Rectangle(x,y,100,100);
    }


    private boolean firstSaved = false;   
    private boolean ping = false; 

    public void saveCoordinates(double x, double y)
    {
        if(firstSaved == false)
        {
            firstPoint2d = new Point2D(x, y);
            firstSaved = true;
            ping = false;
        }
        else
        {
            secPoint2d = new Point2D(x, y);
            firstSaved = false;
            ping = true;
            final double width = Math.abs(firstPoint2d.getX() - secPoint2d.getX());
            final double hight = Math.abs(firstPoint2d.getY() - secPoint2d.getY());
            //Muszisz znajdywać min X oraz max Y
            rec = new Rectangle(firstPoint2d.getX(),firstPoint2d.getY(),width,hight);
        }
        //System.console().printf("x: " + x + "\ny: " + y + "\n");
    }

    public Rectangle getRec()
    {
        return rec;
    }

    public boolean isCreated()
    {
        return ping;
    }

    EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>()
    {
        private double dx;
        private double dy;
        private double x = rec.getX();
        private double y = rec.getY();
        private void doMove(MouseEvent event)
        {
            //Rectangle.class.cast(event.getSource()).transform(dx + event.getSceneX(), dy + event.getSceneY());
            x = dx + event.getSceneX();
            y = dy + event.getSceneY();
            rec.setX(dx + event.getSceneX());
            rec.setY(dy + event.getSceneY());
        }
        @Override
        public void handle(MouseEvent e)
        {
            if(e.getEventType() == MouseEvent.MOUSE_PRESSED)
            {
                dx = x - e.getSceneX();
                dy = y - e.getSceneY();
                System.console().printf("Mouse Pressed\n");
            }
            if(e.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
                doMove(e);
                System.console().printf("Mouse Dragged\n");
            }
        }
    };

    

}
