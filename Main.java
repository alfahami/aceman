
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        // Fill Cities
        City[] cities = fillCities();
        Formation[] formations = fillFormations();
        FacultyInstitute[] facs = fillFacsInsts(formations, null);


        System.out.println(Arrays.toString(cities));

        Acemanager admin = new Acemanager(cities);

        
 
    }

    public static Member createMember(){
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

    public static FacultyInstitute createFacultyInstitute(Formation[] formations, City[] cities, String cityName){
        int idCity = 0;
        for (int i = 0; i < cities.length; i++) {
            if(cities[i].getName().equals(cityName)) {
                idCity = cities[i].getIdCity();
            }
        }
        System.out.print("Enter Faculty/Institue name? ");
        String facultyInstitute = scan.nextLine();
        
        return new FacultyInstitute(0, facultyInstitute, formations, idCity);  
    }

    public static StayCard createStayCard(){
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

    public static City createCity(int id) {
        System.out.print("What's the city called ?" );    
        String name = scan.nextLine();
        System.out.print("Which region is the city located?" );
        String region = scan.nextLine();

        return new City(id, name, region);
    }

    public static Formation createFormation(int id){
        System.out.print("What's the name of the formation? ");
        String formationName = scan.nextLine();
        System.out.print("How many years does the formation have? ");
        int duration = scan.nextInt();
        scan.nextLine(); // next line trap
        System.out.print("Which certificate is provided by the program? ");
        String certificate = scan.nextLine();
        
        return new Formation(id, formationName, duration, certificate);
    }

    public static FacultyInstitute[] fillFacsInsts(Formation[] formations, String cityName){
        FacultyInstitute fsdm = new FacultyInstitute(1, "FACULTE DES SCIENCES DHAR MEHRAZ", formations, 1);
        FacultyInstitute fsmy = new FacultyInstitute(2, "FACULTE DES SCIENCES MOULAY YACOUB", formations, 2);
        FacultyInstitute fsk = new FacultyInstitute(2, "FACULTE DES SCIENCES KENITRA", formations, 5);
        FacultyInstitute fso = new FacultyInstitute(3, "FACULTE DES SCIENCES OUJDA", formations, 3);
        FacultyInstitute fsr = new FacultyInstitute(3, "FACULTE DES SCIENCES RABAT", formations, 4);

        FacultyInstitute[] facs = {fso, fsdm, fsmy, fsk, fsr};
        return facs;
        




    }

    public static Formation[] fillFormations(){
        Formation smi = new Formation(1, "SCIENCES MATHEMATIQUES ET INFORMATIQUE", 3, "LICENCE FONDAMENTALE");
        Formation smc = new Formation(2, "SCIENCES MATIERE ET CHIMIE", 3, "LICENCE FONDAMENTALE");
        Formation smp = new Formation(3, "SCIENCES MATHEMATIQUES ET PHYSIQUE", 4, "LICENCE PROFESSIONELLE");
        Formation sma = new Formation(4, "SCIENCES MATHEMATIQUES ET APPLIQUES", 3, "LICENCE FONDAMENTALE");
        Formation mip = new Formation(5, "MATHEMATIQUES INFORMATIQUE ET PHYSIQUE", 3, "LICENCE FONDAMENTALE");
        Formation bigData = new Formation(6, "BIG DATA ET BUSINESS INTELLIGENCE", 2, "MASTER SPECIAISE");
        Formation mp = new Formation(7, "PHYSIQUE MATHEMATIQUES", 2, "MASTER DE RECHERHCE");
        Formation algebre = new Formation(8, "ALGEBRE APPLIQUEE", 2, "MASTER DE RECHERCHE");
        Formation dctrInfo = new Formation(9, "BLOCKCHAIN IN IOT", 2, "RECHERHCE DOCTORALE");
        Formation dctrBio = new Formation(10, "BIOLOGIE ET BIOLOGIE DES SYSTEMES", 3, "RECHERCHE DOCTORALE");

        Formation[] formations = {smi, sma, smp, smc, mip, bigData, mp, algebre, dctrInfo, dctrBio};

        return formations;
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
