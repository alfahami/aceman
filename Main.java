import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        User admin = new User(1, "NBE388507J", 1, 20111473, 1, 255, 1, "TOIHIR", "AL-FAHAMI", "1992-05-21", "altoihir@gmail.com", true);

        User moderator = new User(2, "NBE38567K", 2, 20110124, 1, 222, 2, "ISSIHAKA", "MOHAMED", "1999-04-09", "issihaka@gmail.com", true);

        User standard = new User(3, "NBE32567O", 3, 20153421, 3, 232, 3, "IDRISSE", "MCHINDA", "1998-05-01", "mchinda@gmail.com", true);

        StayCard card1 = new StayCard(1, 1, 1, "C018507J", 2023, 2026, 234564);
        StayCard card2 = new StayCard(2, 2, 2, "C017505G", 2022, 2025, 231564);
        StayCard card3 = new StayCard(3, 3, 3, "C012505B", 2020, 2024, 201564);


        Role adminRole = new Role(1, "administrateur", null, null);
        Role stdRole = new Role(2, "standard", null, null);

        User[] users = {admin, moderator, standard};

        Acemanager acemanager = new Acemanager(users);
        User Update = acemanager.getUser(0);
        Update.setEmail("alfaht.21@gmail.com");

        City fes = addCity();
        System.out.println(fes.toString());


        
    }

    public static  City addCity() {
        System.out.print("What's the city called ?" );    
        String name = scan.nextLine();
        System.out.print("Which region is the city located?" );
        String region = scan.nextLine();

        scan.close();
        return new City(name, region);

    }



}
