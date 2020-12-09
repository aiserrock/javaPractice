package bus_class;

public class Bus
{    
    private int seats, seatPrice, seatsTaken;
    
    public Bus()
    {
        seats = seatPrice = seatsTaken = 0;
    }
    
    public Bus(int seats, int seatPrice, int seatsTaken)
    {
        this.seats = seats;
        this.seatPrice = seatPrice;
        this.seatsTaken = seatsTaken;
    }
    
    public Bus(Bus other)
    {
        this.seats = other.seats;
        this.seatPrice = other.seatPrice;
        this.seatsTaken = other.seatsTaken;
    }
    
    public int getSeats()
    {
        return seats;
    }
    
    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    
    public int getSeatPrice()
    {
        return seatPrice;
    }
    
    public void setSeatPrice(int seatPrice)
    {
        this.seatPrice = seatPrice;
    }
    
    public int getSeatsTaken()
    {
        return seatsTaken;
    }
    
    public void setSeatsTaken(int seatsTaken)
    {
        if(this.seats >= seatsTaken)
            this.seatsTaken = seatsTaken;
    }

    public int getSeatsFree()
    {
        return seats - seatsTaken;
    }
    
    public boolean isFull()
    {
        return seats == seatsTaken;
    }
    
    public int getRevenue()
    {
        return seatsTaken * seatPrice;
    }
    
    public void print()
    {
        System.out.format(": %d, %d, %d", seats, seatPrice, seatsTaken);
    }
}

