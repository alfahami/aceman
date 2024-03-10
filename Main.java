public class Main {
    public static void main(String[] args) {
        
        User admin = new User(1, "NBE388507J", 1, 20111473, 1, 255, 1, "TOIHIR", "AL-FAHAMI", "1992-05-21", "altoihir@gmail.com", true);

        User moderator = new User(2, "NBE38567K", 2, 20110124, 1, 222, 2, "ISSIHAKA", "MOHAMED", "1999-04-09", "issihaka@gmail.com", true);

        User standard = new User(3, "NBE32567O", 3, 20153421, 3, 232, 3, "IDRISSE", "MCHINDA", "1998-05-01", "mchinda@gmail.com", true);

        StayCard card1 = new StayCard(1, 1, 1, "C018507J", 2023, 2026, 234564);
        StayCard card2 = new StayCard(2, 2, 2, "C017505G", 2022, 2025, 231564);
        StayCard card3 = new StayCard(3, 3, 3, "C012505B", 2020, 2024, 201564);

        City fes = new City(1, "Fes", "Fes-Boulemane");
        City rabat = new City(2, "Rabat", "Rabat-Salé-Kénitra");
        City kenitra = new City(3, "Kénitra", "Rabat-Salé-Kénitra");

        Role adminRole = new Role(1, "administrateur", null, null);
        Role stdRole = new Role(2, "standard", null, null);

        User[] users = {admin, moderator, standard};

        Acemanager acemanager = new Acemanager(users);
        User Update = acemanager.getUser(0);
        Update.setEmail("alfaht.21@gmail.com");


        System.out.println(admin.toString());
        System.out.println(moderator.toString());
        System.out.println(standard.toString());

        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());

        System.out.println(fes.toString());
        System.out.println(rabat.toString());
        System.out.println(kenitra.toString());

    }
}
