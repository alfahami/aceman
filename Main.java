import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        // Fill Cities
        City[] cities = fillCities();
        Formation[] formations = fillFormations();
        FacultyInstitute[] facs = fillFacsInsts(formations, null);

        StayCard[] cards = fillStayCard();
        Member[] members = fillMembers();

        //System.out.println(Arrays.toString());

        // The dude that manages ACEM
        Acemanager admin = new Acemanager(cities, formations, facs, members,cards);
        admin.printAnyArrays(members);

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

        return new Member(idMember, idCard, idCity, fname, lname, passport, birthDate, regNumber, email, mAdmission);
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


    // FILL BASE ARRAYS

    public static Member[] fillMembers(){
        Member moderator = new Member(9, 8, 3, "ISSIHAKA", "MOHAMED",  "NBE789996B", "19/01/1995", 20174567, "ism@gmail.com", true);
        Member admin = new Member(1, 1, 1, "TOIHIR", "AL-FAHAMI",  "NBE356854O", "21/05/1992", 20111473, "alf@gmail.com", true);
        Member std1 = new Member(2, 3, 2, "ALLAOUI", "ZAKARIA",  "NBE356347M", "13/09/1998", 20209854, "alzak@gmail.com", true);
        Member std2 = new Member(3, 2, 4, "ABOU", "BACAR",  "NBE456880P", "03/06/1998", 20193476, "abou@gmail.com", false);
        Member std3 = new Member(4, 5, 3, "MCHINDA", "MAROUANE",  "NBE565897K", "13/06/2000", 20204356, "mch@gmail.com", false);
        Member std4 = new Member(5, 6, 2, "ROUSHDAT", "YOUSSEF",  "NBE3348990h", "19/04/1998", 20223456, "roush@gmail.com", false);
        Member std5 = new Member(6, 3, 2, "ANDJIB", "ADAM",  "NBE356980U", "17/02/1999", 20187643, "and@gmail.com", true);
        Member std6 = new Member(7, 1, 1, "FAROUK", "HAIDAR",  "NBE678990F", "09/05/2002", 20166690, "far@gmail.com", false);
        Member std7 = new Member(8, 3, 9, "ABJAD", "AJMAL",  "NBE3568999N", "06/09/1999", 20204599, "abj@gmail.com", true);
        Member std8 = new Member(9, 5, 8, "AKMAL", "HAKIM",  "NBE556897G", "02/01/2004", 20216798, "akm@gmail.com", true);

        Member[] members = {admin, moderator, std1, std2, std3, std4, std5, std6, std7, std8};

        return members;
    }

    public static StayCard[] fillStayCard(){
        StayCard card1 = new StayCard(1, 1, 1, "C018507B", "23/09/2023", "23/09/2026", 234361, "Regularisation Exceptionelle");
        StayCard card2 = new StayCard(2, 3, 2, "C019879H", "21/05/2022", "21/05/2025", 234565, "Regularisation Exceptionelle");
        StayCard card3 = new StayCard(3, 2, 4, "C019561K", "19/02/2021", "19/02/2024", 212565, "Etudiant");
        StayCard card4 = new StayCard(4, 5, 4, "C019561K", "19/02/2021", "19/02/2024", 212565, "Regularisation Exceptionelle");
        StayCard card5 = new StayCard(5, 4, 3, "C019561L", "10/02/2021", "10/02/2024", 202565, "Travail");
        StayCard card6 = new StayCard(6, 7, 3, "C019561L", "10/02/2021", "10/02/2024", 202565, "Travail");
        StayCard card7 = new StayCard(7, 6, 1, "C019563M", "02/01/2023", "02/01/2026", 203565, "Travail");
        StayCard card8 = new StayCard(8, 9, 8, "C019523N", "01/01/2024", "01/01/2027", 103465, "Etudiant");
        StayCard card9 = new StayCard(9, 10, 7, "C023456C", "02/01/2023", "02/01/2026", 123565, "Etudiant");
        StayCard card10 = new StayCard(10, 8, 5, "C0345678P", "14/09/2020", "14/09/2023", 203565, "Travail");

        StayCard[] cards = {card1, card2, card3, card4, card5, card6, card7, card8, card9, card10};

        return cards;

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
