import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        // Fill Cities
        City[] cities = fillCities();
        System.out.println(Arrays.toString(cities));

        
 
    }

    public static Member addMember(){
        System.out.print("Please, enter member first name? ");
        String fname = scan.nextLine();
        System.out.print("Please, enter member last name? ");
        String lname = scan.nextLine();
        System.out.print("Please, enter member's passport? ");
        String passport = scan.nextLine();
        System.out.print("Please, enter member birthdate in the format \"yyyy-mm-dd\"? ");
        String birthDate = scan.nextLine();
        System.out.print("Enter AMCI's registration number ");
        int regNumber = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter member's email? ");
        String email = scan.nextLine();
        System.out.print("Is the member adhering? type \"true or false\" ");
        boolean mAdmission = scan.nextBoolean();

        return new Member(passport, regNumber, fname, lname, birthDate, email, mAdmission);
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
        System.out.print("Please enter the reason of the residence permit?  ");
        String reason = scan.nextLine();

        return new StayCard(cardNum, obtentionYear, expirationYear, pin, reason);

    }

    public static City addCity(int id) {
        System.out.print("What's the city called ?" );    
        String name = scan.nextLine();
        System.out.print("Which region is the city located?" );
        String region = scan.nextLine();

        return new City(id, name, region);
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

    public static City[] fillCities(){
        City fes = new City(1, "FES","FES-BOULEMANE");
        City meknes = new City(2, "MEKNES", "FES-BOULEMANE");
        City oujda = new City(3, "OUJDA", "FES-BOULEMANE");
        City rabat = new City(4, "RABAT", "RABAT-SALE-KENITRA");
        City kenitra = new City(5, "KENITRA", "RABAT-KENITRA, -SALE");
        City sale = new City(6, "SALE", "RABAT-SALE-KENITRA");
        City grandCasablanca = new City(7, "CASABLANCA", "CASABLANCA-SETTAT");
        City casablanca = new City(8, "CASABLANCA", "CASABLANCA-SETTAT");
        City tanger = new City(9, "TANGER", "TANGER-TETOUAN-AL HOCEIMA");
        City tetouan = new City(10, "TETOUAN", "TANGER-TETOUAN-AL HOCEIMA");

        City[] cities = {fes, meknes, oujda, rabat, kenitra, sale, grandCasablanca, casablanca, tanger, tetouan};

        return cities;
        
    }


}
