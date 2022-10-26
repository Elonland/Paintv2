
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;

public class Canvas extends Application
{
    
    
    @Override
    public void start(Stage stage)
    {
        //Basic stuff.
        Group root = new Group();
        Scene scene = new Scene(root,800,800);

        //Menu
        Menu menu = new Menu("Figures");
        MenuItem m0 = new MenuItem("Nothing");
        MenuItem m1 = new MenuItem("Rectangle");
        MenuBar menuBar = new MenuBar();

        Selected selected = new Selected();

        menu.getItems().addAll(m1,m0); 
        menuBar.getMenus().add(menu);

        m0.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
               selected.selectedNothing();
               System.console().printf("Selected Nothing");
            }
        } );
        
        //Selecting Rectangle option.
        m1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
               selected.selectedRectangle();
               System.console().printf("Selected Rectangle");
            }
        } );

        EventHandler<MouseEvent> SelectingCoordinates = new EventHandler<MouseEvent>() 
        {
            public void handle(MouseEvent click)
            {
                if(!menuBar.isPressed())
                {   
                    System.console().printf("Click coordinates: \nX " + click.getSceneX() 
                                            + "\nY " + click.getSceneY() + "\n");
                    selected.SetCoordinates(click.getSceneX(), click.getSceneY());
                    if(selected.isCreated() == true && selected.recSelected == true)
                    //Trzeba to rozroznic by tylko dla rectangle dzialalo
                    {
                        root.getChildren().add(((NewRectangle)selected.getFigure()).getRec());
                    }
                    else if(selected.isCreated())
                    {
                        // Jak będą wyglądać te figury?
                        // root.getChildren().add(selected.getFigure());
                    }
                }
            }
        };

        NewRectangle rec = new NewRectangle();
        rec.saveCoordinates(100,100);

        if(rec.isCreated() == false)
        {
            System.console().printf("Jeszcze nie gotowy\n");
        }

        rec.saveCoordinates(200,200);

        if(rec.isCreated() == true)
        {
            System.console().printf("Gotowy do zapisu\n");
            root.getChildren().add(rec.getRec());
        }
        

        NewRectangle rec2 = new NewRectangle(300,200);

        //Updating tree.
        root.getChildren().add(rec2.getRec());
        root.getChildren().add(menuBar);
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, SelectingCoordinates);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}