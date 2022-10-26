
//Selection of figures for drawing
public enum StateMachine 
{
    NotSelected
    {
        Figure prop;
        public StateMachine nextState(int x)
        {
            if(x == 0)
                return Rectangle;
            return NotSelected;
        }
        public void Handle(double x, double y, int TimesClicked)
        {
            System.console().printf("Nothing is selected\n");
        }
        public Figure getFigure()
        {
            return prop;
        }
        public boolean isCreated()
        {
            return false;
        }
    },
    Rectangle
    {
        Figure rec = new NewRectangle();
        public StateMachine nextState(int x)
        {
            return NotSelected;
        }
        public void Handle(double x, double y, int TimesClicked)
        {
            System.console().printf("Rectangle is during creation\n");

            if(TimesClicked <= 2)
            {
                //Save coordinates
                rec.saveCoordinates(x,y);
            }
            else
            {
                //Error
                System.console().printf("Something went wrong\n");
            }
            
        }
        public Figure getFigure()
        {
            return rec;
        }
        public boolean isCreated()
        {
            return ((NewRectangle)rec).isCreated();
        }

    };

    public abstract StateMachine nextState(int x);
    public abstract void Handle(double x, double y, int counter);
    public abstract Figure getFigure();
    public abstract boolean isCreated();
 };
