import com.hotel.managment.Hotel;
import com.hotel.models.*;
import com.hotel.services.DiningService;
import com.hotel.services.GymService;
import com.hotel.services.SpaService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        hotel.setHotelName("Royal Hotel");
        Room standerRoom1=new StanderRoom("101",200);
        Room standerRoom2=new StanderRoom("102",200);
        Room deluxRoom1=new DeluxRoom("103",300);
        Room deluxRoom2=new DeluxRoom("104",300);
        Room suitRoom1=new SuiteRoom("105",400);
        Room suitRoom2=new SuiteRoom("106",400);
        hotel.addRoom(standerRoom1);
        hotel.addRoom(standerRoom2);
        hotel.addRoom(deluxRoom1);
        hotel.addRoom(deluxRoom2);
        hotel.addRoom(suitRoom1);
        hotel.addRoom(suitRoom2);
        hotel.displayAllRooms();
        hotel.bookRoom("101",new Customer("Fatma","fatma@gmail.com","01015002065"),new GymService());
        hotel.bookRoom("103",new Customer("Fatma","fatma@gmail.com","01015002065"),new GymService(),new DiningService());
        hotel.bookRoom("101",new Customer("Ahmed","ahmed@gmail.com","01025697456"));
        hotel.bookRoom("105",new Customer("Khadiga","khadiga@gmail.com","01024645820"),new GymService(),new DiningService(),new SpaService());
        hotel.displayBookingDetails("103");



    }
}