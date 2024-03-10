import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        User admin = new User(1, "NBE388507J", 1, 20111473, 1, 255, 1, "TOIHIR", "AL-FAHAMI", "1992-05-21", "altoihir@gmail.com", true);

        User moderator = new User(2, "NBE38567K", 2, 20110124, 1, 222, 2, "ISSIHAKA", "MOHAMED", "1999-04-09", "issihaka@gmail.com", true);

        User standard = new User(3, "NBE32567O", 3, 20153421, 3, 232, 3, "IDRISSE", "MCHINDA", "1998-05-01", "mchinda@gmail.com", true);



        Role adminRole = new Role(1, "administrateur", null, null);
        Role stdRole = new Role(2, "standard", null, null);

        User[] users = {admin, moderator, standard};

        Acemanager acemanager = new Acemanager(users);
        User Update = acemanager.getUser(0);
        Update.setEmail("alfaht.21@gmail.com");
 
    }

    public static FacultyInstitute addFacultyInstitute(){
        System.out.print("Enter Faculty/Institue name? ");
        String facultyInstitute = scan.nextLine();
        
        return new FacultyInstitute(facultyInstitute, null);


        
    }

    public static StayCard addStayCard(){
        System.out.print("Please enter card ID number ? ");
        String cardNum = scan.nextLine();
        System.out.print("Please fill in the obtention date? ");
        String obtentionYear = scan.nextLine();
        System.out.print("Enter the expiration date ? ");
        String expirationYear = scan.nextLine();
        System.out.print("Enter the pin ? ");
        int pin = scan.nextInt();
        scan.nextLine(); //next Line trap
        System.out.print("Please enter the pattern-motif- of the card?  ");
        String pattern = scan.nextLine();

        return new StayCard(cardNum, obtentionYear, expirationYear, pin, pattern);

    }

    public static City addCity() {
        System.out.print("What's the city called ?" );    
        String name = scan.nextLine();
        System.out.print("Which region is the city located?" );
        String region = scan.nextLine();

        return new City(name, region);
    }

    public static Formation addFormation(){
        System.out.print("What's the name of the formation? ");
        String formationName = scan.nextLine();
        System.out.print("How many years does the formation have? ");
        int duration = scan.nextInt();
        scan.nextLine(); // next line trap
        System.out.print("Which certificate is provided by the program? ");
        String certificate = scan.nextLine();
        
        return new Formation(formationName, duration, certificate);
    }


}
