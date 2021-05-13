
public class Main {
    public static void main(String[] args) {


        //test code:
        String[] userList = new String[] {"user1","user2","user3","user4","user5"};
        HomePage page = new HomePage(userList);
 
        page.setTemperature(19.5);
        page.setHumidity(0.45);
        page.setLightSensor(0.8);
        page.setAirPressure(1024.0);

        page.setLights(false);
        page.setHeating(true);

        

        System.out.println(page.getSeletedUser());
    }
}