
public class Selected 
{
    StateMachine stateMachine = StateMachine.NotSelected;

    boolean recSelected = false;

    int counter = 0;

    public void selectedNothing() // Jak będzie wybrana inna figura musisz tam wstawić recSelected = false.
    {
        stateMachine = StateMachine.NotSelected;
        recSelected = false;
    }

    public void selectedRectangle() // Jak będzie wybrana inna figura musisz tam wstawić recSelected = false.
    {
        stateMachine = StateMachine.Rectangle;
        recSelected = true;
    }

    public void SetCoordinates(double x, double y)
    {
        stateMachine.Handle(x,y,counter);   //Ma counter sens?

        if(stateMachine == StateMachine.Rectangle && counter == 2)
        {
            counter = 0;
        }
    }

    public boolean rectangleSelected()
    {
        return recSelected;
    }

    public Figure getFigure()
    {
        return stateMachine.getFigure();
    }

    public boolean isCreated()
    {
        return stateMachine.isCreated();
    }

}
