import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        // Fill Cities
        Formation[] formations = fillFormations();
        FacultyInstitute[] facs = fillFacsInsts(formations, null);
        City[] cities = fillCities();

        StayCard[] cards = fillStayCard();
        Member[] members = fillMembers();


        // The dude that manages ACEM
        Acemanager admin = new Acemanager(cities, formations, facs, members,cards);
        admin.printAnyArrays(members);
        System.out.println();
        System.out.println();
        admin.printAnyArrays(cities);
       // admin.getMember(0).setBirthDate("21/09/1988");

    
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

        int idMember = 0, idCard = 0, idCity = 0;
        int idFormation = 0;
        int idFacultyInstitute = 0;

        return new Member(idMember, idCard, idCity, idFacultyInstitute, idFormation, fname, lname, passport, birthDate, regNumber, email, mAdmission);
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

        // TO DO: ask for member name and pick the corresponding ID
        int idMember = 0;
        // Check the last ID and add new entry as new id
        int idCard = 0;
        // Get the city of the input city name
        int idCity = 0;

        return new StayCard(idCard, idMember, idCity, cardNum, obtentionYear, expirationYear, pin, reason);

    }

    public static City createCity(int id) {
        System.out.print("What's the city called ?" );    
        String name = scan.nextLine();
        System.out.print("Which region is the city located?" );
        String region = scan.nextLine();

        return new City(id, name, region, null);
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


    // FILL BASE ARRAYS

    public static Member[] fillMembers(){
        
        Member admin = new Member(1, 1, 1, 2, 9, "TOIHIR", "AL-FAHAMI",  "NBE388507", "19/03/1985", 20111473, "alf@gmail.com", true);

        Member std1 = new Member(2, 3, 2, 1, 10, "ALLAOUI", "ZAKARIA",  "NBE356347M", "13/09/1998", 20209854, "alzak@gmail.com", true);

        Member std2 = new Member(3, 2, 4, 2, 3,"ABOU", "BACAR",  "NBE456880P", "03/06/1998", 20193476, "abou@gmail.com", false);

        Member std3 = new Member(4, 5, 3, 1, 5, "MCHINDA", "MAROUANE",  "NBE565897K", "13/06/2000", 20204356, "mch@gmail.com", false);

        Member std4 = new Member(5, 8, 2, 3, 6, "ROUSHDAT", "YOUSSEF",  "NBE3348990h", "19/04/1998", 20223456, "roush@gmail.com", false);

        Member std5 = new Member(6, 4, 2, 5, 1, "ANDJIB", "ADAM",  "NBE356980U", "17/02/1999", 20187643, "and@gmail.com", true);

        Member std6 = new Member(7, 9, 1, 6, 2, "FAROUK", "HAIDAR",  "NBE678990F", "09/05/2002", 20166690, "far@gmail.com", false);

        Member std7 = new Member(8, 7, 9, 1, 4,"ABJAD", "AJMAL",  "NBE3568999N", "06/09/1999", 20204599, "abj@gmail.com", true);
        
        Member std8 = new Member(9, 3, 6, 2, 8, "AKMAL", "HAKIM",  "NBE556897G", "02/01/2004", 20216798, "akm@gmail.com", true);

        Member moderator = new Member(10, 4, 8, 4, 3, "ISSIHAKA", "MOHAMED",  "NBE789996B", "19/01/1995", 20174567, "ism@gmail.com", true);

        Member[] members = {admin, std1, std2, std3, std4, std5, std6, std7, std8, moderator};

        return members;
    }

    public static StayCard[] fillStayCard(){
        StayCard card1 = new StayCard(1, 1, 1, "C018507B", "23/09/2023", "23/09/2026", 234361, "Reg. Exc.");
        StayCard card2 = new StayCard(2, 3, 2, "C019879H", "21/05/2022", "21/05/2025", 234565, "Reg. Exc.");
        StayCard card3 = new StayCard(3, 2, 4, "C019561K", "19/02/2021", "19/02/2024", 212565, "Etudiant");
        StayCard card4 = new StayCard(4, 5, 4, "C019561K", "19/02/2021", "19/02/2024", 212565, "Reg. Exc.");
        StayCard card5 = new StayCard(5, 4, 3, "C019561L", "10/02/2021", "10/02/2024", 202565, "Travail");
        StayCard card6 = new StayCard(6, 7, 3, "C012361L", "10/02/2021", "10/02/2024", 202565, "Travail");
        StayCard card7 = new StayCard(7, 6, 1, "C019563M", "02/01/2023", "02/01/2026", 203565, "Travail");
        StayCard card8 = new StayCard(8, 9, 8, "C019523N", "01/01/2024", "01/01/2027", 103465, "Etudiant");
        StayCard card9 = new StayCard(9, 10, 7, "C023456C", "02/01/2023", "02/01/2026", 123565, "Etudiant");
        StayCard card10 = new StayCard(10, 8, 5, "C0345678P", "14/09/2020", "14/09/2023", 203565, "Travail");

        StayCard[] cards = {card1, card2, card3, card4, card5, card6, card7, card8, card9, card10};

        return cards;

    }

    public static FacultyInstitute[] fillFacsInsts(Formation[] formations, String cityName){
        FacultyInstitute fs = new FacultyInstitute(1, "FS", formations, 1);
        FacultyInstitute fsjes = new FacultyInstitute(2, "FSJES", formations, 2);
        FacultyInstitute ensa = new FacultyInstitute(3, "ENSA", formations, 5);
        FacultyInstitute encg = new FacultyInstitute(4, "ENCG", formations, 3);
        FacultyInstitute est = new FacultyInstitute(5, "EST", formations, 4);
        FacultyInstitute facMed = new FacultyInstitute(5, "F. MD", formations, 4);

        FacultyInstitute[] facs = {fs, fsjes, ensa, encg, est, facMed};
        return facs;
    }

    public static Formation[] fillFormations(){
        Formation smi = new Formation(1, "SMI", 3, "LF");
        Formation smc = new Formation(2, "SMC", 3, "LICENCE F");
        Formation smp = new Formation(3, "SMP", 4, "LICENCE P");
        Formation sma = new Formation(4, "SMA", 3, "LICENCE F");
        Formation mip = new Formation(5, "SMP", 3, "LICENCE F");
        Formation bigData = new Formation(6, "BIG DATA & BI", 2, "MASTER SP");
        Formation mp = new Formation(7, "MATH PHYSIQUE", 2, "MASTER RE");
        Formation algebre = new Formation(8, "ALGEBRE APPLIQUEE", 2, "MASTER RE");
        Formation dctrInfo = new Formation(9, "BLOCKCHAIN IN IOT", 2, "DOCTORAT");
        Formation dctrBio = new Formation(10, "BIO DES SYSTEMES", 3, "DOCTORAT");

        Formation[] formations = {smi, sma, smp, smc, mip, bigData, mp, algebre, dctrInfo, dctrBio};

        return formations;
    }

    public static City[] fillCities(){
        City fes = new City(1, "FES","FES-BOULEMANE", fillFacsInsts(fillFormations(), null));
        City meknes = new City(2, "MEKNES", "FES-BOULEMANE", fillFacsInsts(fillFormations(), null));
        City oujda = new City(3, "OUJDA", "FES-BOULEMANE", fillFacsInsts(fillFormations(), null));
        City rabat = new City(4, "RABAT", "RABAT-SALE-KENITRA", fillFacsInsts(fillFormations(), null));
        City kenitra = new City(5, "KENITRA", "RABAT-KENITRA-SALE", fillFacsInsts(fillFormations(), null));
        City sale = new City(6, "SALE", "RABAT-SALE-KENITRA", fillFacsInsts(fillFormations(), null));
        City grandCasablanca = new City(7, "CASABLANCA", "CASABLANCA-SETTAT", fillFacsInsts(fillFormations(), null));
        City casablanca = new City(8, "Gd CASA", "CASABLANCA-SETTAT", fillFacsInsts(fillFormations(), null));
        City tanger = new City(9, "TANGER", "TANGER-TETOUAN-AL HOCEIMA", fillFacsInsts(fillFormations(), null));
        City tetouan = new City(10, "TETOUAN", "TANGER-TETOUAN-AL HOCEIMA", fillFacsInsts(fillFormations(), null));

        City[] cities = {fes, meknes, oujda, rabat, kenitra, sale, grandCasablanca, casablanca, tanger, tetouan};

        return cities;
        
    }


}
