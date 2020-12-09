package horsesequalpower;

public class HorsesEqualPower
{
    
    public static void main(String[] args)
    {
        Horse horse = new Horse();
        
        System.out.format("%b\n", horse.getHorse_Has_Power());
    }
    
}

class Horse
{
    private boolean has_power;
    
    public Horse()
    {
        try
        {
            this.has_power = false;
            if(this.has_power == false)
                throw new HorseHasNoPowerException("This is clearly wrong");
        }
        catch(HorseHasNoPowerException e)
        {
            this.getPower();
        }
    }
    
    private void getPower()
    {
        this.has_power = true;
    }
    
    public boolean getHorse_Has_Power()
    {
        return this.has_power;
    }
}



