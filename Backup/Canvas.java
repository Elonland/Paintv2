
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;  
import javafx.event.EventHandler;
import javafx.stage.*;

public class Canvas extends Application
{
    
    
    @Override
    public void start(Stage stage)
    {
        Group root = new Group();
        Scene scene = new Scene(root,800,800);

        NewRectangle rec = new NewRectangle(200,200);
        //NewRectangle rec2 = new NewRectangle(300,200);

        //rec.transform(100, 100);
        rec.getCoordinates();

        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>()
        {
            private double dx;
            private double dy;
            
            private void doMove(MouseEvent event)
            {

                //System.console().printf("dx: " + dx + "\ndy: " + dy + "\n");

                /* 
                Rectangle prop;
                prop = (Rectangle) event.getSource();
                */

                rec.transform(dx + event.getSceneX(), dy + event.getSceneY());

               // x += dx;
               // y += dy;
            }
            @Override
            public void handle(MouseEvent e)
            {
                if(e.getEventType() == MouseEvent.MOUSE_PRESSED)
                {
                    dx = rec.getNewX() - e.getSceneX();
                    dy = rec.getNewY() - e.getSceneY();
                    //System.console().printf("x: " + x + "\ny: " + y + "\n");
                }
                if(e.getEventType() == MouseEvent.MOUSE_DRAGGED)
                {
                    doMove(e);
                }
                    
                    //rec.transform(e.getSceneX(), e.getSceneY());
            }
        };

        root.addEventHandler(MouseEvent.ANY, mouseEvent);
        //rec.getRec().addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent);

        root.getChildren().add(rec.getRec());
        //root.getChildren().add(rec2.getRec());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}