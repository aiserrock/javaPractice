package bus_class;

public class Bus_Class {

    public static void main(String[] args) {
        int revenue = 0;
        Bus bus_1 = new Bus(54, 400, 0), bus_2 = new Bus(45, 500, 0);
        
        System.out.print("bus_1");
        bus_1.print();
        System.out.println();
        
        System.out.print("bus_2");
        bus_2.print();
        System.out.println();
        
        bus_1.setSeatsTaken(25);
        bus_2.setSeatsTaken(30);
        
        revenue = bus_1.getRevenue() + bus_2.getRevenue();
        
        if(revenue > 11000)
            System.out.print("Хорошечно\n");
        else
            System.out.println("Зря ездили\n");
    }
    
}