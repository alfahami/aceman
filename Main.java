import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        // Fill Cities
        Formation[] formations = fillFormations();
        FacultyInstitute[] facs = fillFacsInsts(formations, null);
        City[] cities = fillCities();

        Card[] cards = fillStayCard();
        Member[] members = fillMembers();


        // The dude that manages ACEM
        Acemanager admin = new Acemanager(cities, formations, facs, members,cards);
        int option = menu();
        
        inputProcess(option, admin);
        
    }

    public static void inputProcess(int option, Acemanager admin){
        switch(option){
            case 1:
                scan.nextLine(); // next Line trap
                admin.printAnyArrays(admin.getMembers());
                admin.printAnyArrays(admin.getCards());
                admin.printAnyArrays(admin.getCities());
                admin.printAnyArrays(admin.getFaculties());
                admin.printAnyArrays(admin.getFormations());
                cls(admin);
                break;
            case 2:
                String choice0 = xMenu(2, "Member");
                switch (choice0) {
                    case "2.1":
                        admin.printAnyArrays(admin.getMembers());
                        cls(admin);
                        break;
                    case "2.2":
                        Member newMember = inputMemberDetails(admin);
                        admin.addMember(newMember);
                        String answer = "yes";
                        System.out.print("Would you like to add another member? -Type \"Yes\" or \"No\"- ");
                            answer = scan.nextLine();
                        while(answer.equalsIgnoreCase("yes")) { 
                            Member anotherMember = inputMemberDetails(admin);
                            admin.addMember(anotherMember);
                            System.out.print("Would you like to add another member? -Type \"Yes\" or \"No\"- ");
                            answer = scan.nextLine();
                        }
                        cls(admin);
                        break;
                    case "2.3":
                        // TO DO: UPDATE A MEMBER
                        break;
                    case "2.4":
                    // TO DO: DELETE A MEMBER
                    break;
                    default:
                        break;
                }
                
                break;
            case 3:
                String choice1 = xMenu(3, "Card");
                switch(choice1){
                    case "3.1":
                        admin.printAnyArrays(admin.getCards());
                        cls(admin);
                        break;
                    case "3.2":
                        //TODO ADD CARDS
                        System.out.println("You can only add a card while adding a member. Check add member please");
                        cls(admin);
                        break;
                    case "3.3":
                        //TODO UPDATE A CARD
                        break;
                    case "3.4":
                        //TODO DELETE A CARD
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                String choice2 = xMenu(4, "City");
                switch(choice2){
                    case "4.1":
                        admin.printAnyArrays(admin.getCities());
                        cls(admin);
                        break;
                    case "4.2":
                        City newCity = inputCity(admin, admin.getFaculties());
                        if(admin.addCity(newCity)){
                            admin.printAnyArrays(admin.getCities());
                            cls(admin);
                        } else {
                            System.out.print("\n\t\t\t\t\t\t\t\t\t\tCity already added.");
                            cls(admin);
                        }
                        break;
                    case "4.3": 
                        //TODO UPDATE A CITY
                        break;
                    case "4.4":
                        // TODO DELETE A CITY
                        break;
                    default:
                        bye();
                }
                break;
            case 5:
                String choice3 = xMenu(5, "Formations");
                switch(choice3){
                    case "5.1":
                        admin.printAnyArrays(admin.getFormations());
                        cls(admin);
                        break;
                    case "5.2":
                        Formation newFormation = inputFormation(admin);
                        admin.addFormation(newFormation);
                        // PRESS ANY KEY TO CONTINUE
                        cls(admin);
                        break;
                    case "5.3": 
                        //TODO UPDATE A FORMATION
                        break;
                    case "5.4":
                        // TODO DELETE A FORMATION
                        break;
                    default:
                    break;
                }
                break;
            case 6: 
                String choice4 = xMenu(6, "Faculty");
                switch(choice4){
                    case "6.1":
                        admin.printAnyArrays(admin.getFaculties());
                        cls(admin);
                        break;
                    case "6.2":
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\tWhich city is the faculty/institue located ? ");
                        String city = scan.nextLine();
                        FacultyInstitute newFac = inputFacultyInstitute(admin, admin.getFormations(), admin.getCities(), city);
                        admin.addFaculty(newFac);
                        cls(admin);
                        break;
                    case "6.3": 
                        //TODO UPDATE A FAC
                        break;
                    case "6.4":
                        // TODO DELETE A FAC
                        break;
                    default:
                    break;
                }
                break;
            case 7:
                // TODO : implements reports generation
                break;
            case 8: 
                bye();
                break;
            default:   
                bye();
                break;
        }
        
    }
    
    public static Member inputMemberDetails(Acemanager admin){
        //scan.nextLine();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease, enter member first name? ");
        String fname = scan.nextLine().toUpperCase();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease, enter member last name? ");
        String lname = scan.nextLine().toUpperCase();

        System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease, enter member's passport? ");
        String passport = scan.nextLine().toUpperCase();
        while(admin.checkPassport(passport)) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tPassport number already in use\n\t\t\t\t\t\t\t\t\t\tPlease enter the correct passport number: ");
            passport = scan.nextLine();
        }

        System.out.print("\n\t\t\t\t\t\t\t\t\t\tWhere does the member live ? ");
        String cityName = scan.nextLine().toUpperCase();
        City cityMember = admin.checkCity(cityName);
        int idCity = 0;
        if(cityMember != null){
            idCity = cityMember.getIdCity();
        } else {
            System.out.println("\n\t\t\t\t\t\t\t\t\t\tCity not found! let's add it");
            City city = inputCity(admin, admin.getFaculties());
            admin.addCity(city);
            idCity = city.getIdCity();
        }

       System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease, enter member's cin? ");
        String cin = scan.nextLine().toUpperCase();
        while(admin.checkCin(cin)) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\t\tCIN number already in use\n\t\t\t\t\t\t\t\t\t\tPlease enter the correct cin number: ");
            cin = scan.nextLine();
        }
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\tCIN doesn't exist yet, let's add it ");
        Card newCard = inputCard(admin, idCity);
        admin.addCard(newCard);
        int idCard = newCard.getIdCard();

        System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease, enter member birthdate in the format \"dd/mm/yyyy\" ");
        String birthDate = scan.nextLine();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter AMCI's registration number ");
        int regNumber = scan.nextInt();
        while(admin.checkMatAMCI(regNumber)) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tMatricule already in use\n\t\t\t\t\t\t\t\t\t\tPlease enter the correct AMCI mat: ");
            regNumber = scan.nextInt();
        }
        scan.nextLine();

        System.out.print("\n\t\t\t\t\t\t\t\t\t\tWhich Fields is the member subscribed to? ");
        String field = scan.nextLine().toUpperCase();
        Formation formation = admin.findFormationByName(field);
        int idFormation = 0;
        if(formation != null) idFormation = formation.getIdFormation();
        else {
            System.out.println("\n\t\t\t\t\t\t\t\t\t\tFaculty does't exist,let's go ahead and add it");
            Formation newFormation = inputFormation(admin);
            admin.addFormation(newFormation);
            idFormation = newFormation.getIdFormation();
        }
        
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter member's email ");
        String email = scan.nextLine().toLowerCase();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tIs the member adhering? type \"true or false\" ");
        boolean mAdmission = scan.nextBoolean();
        scan.nextLine();
        
        return new Member(admin.getMembers().length + 1, idCard, idCity, 2, idFormation, fname, lname, passport, birthDate, regNumber, email, mAdmission);
    }  

    public static FacultyInstitute inputFacultyInstitute(Acemanager admin, Formation[] formations, City[] cities, String cityName){
        int idCity = 0;
        if(admin.checkCity(cityName) != null){
            idCity = admin.checkCity(cityName).getIdCity();
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter Faculty/Institue name? ");
            String facultyInstitute = scan.nextLine().toUpperCase();
            return new FacultyInstitute(0, facultyInstitute, formations, idCity);
        
            // If the city is not found, it should be added
        } else {
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t" + cityName + " is not added yet! Let's add it now\n\n");
            City newCity = inputCity(admin, admin.getFaculties());
            newCity.setIdCity(admin.getCities().length+1);
            admin.grow(cities);
            admin.setCity(newCity, admin.getCities().length - 1);
            admin.printAnyArrays(admin.getCities());
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter Faculty/Institue name? ");
            String facultyInstitute = scan.nextLine().toUpperCase();
            return new FacultyInstitute(admin.getFaculties().length + 1, facultyInstitute, formations, idCity);
        }     
    }

    public static Card inputCard(Acemanager admin, int idCity){
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease enter card ID number: ");
       
        String cardNum = scan.nextLine().toUpperCase();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease fill in the obtention date: ");
        String obtentionDate = scan.nextLine();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter the expiration date ? ");
        String expirationDate = scan.nextLine();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter the pin ? ");
        int pin = scan.nextInt();
        scan.nextLine(); //next Line trap
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tPlease enter the reason of the residence permit?  ");
        String reason = scan.nextLine();

        return new Card(admin.getCards().length + 1, admin.getMembers().length + 1, idCity, cardNum, obtentionDate, expirationDate, pin, reason);
    }

    public static City inputCity(Acemanager admin, FacultyInstitute[] facs) {
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tWhat's the city called ? " );    
        String name = scan.nextLine().toUpperCase();
        while(admin.checkCity(name) == null){
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tWhich region is the city located? " );
            String region = scan.nextLine().toUpperCase();
    
            return new City(admin.getCities().length + 1, name, region, facs);
        }
        return null;
    }

    public static Formation inputFormation(Acemanager admin){
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tWhat's the name of the formation? ");
        String formationName = scan.nextLine().toUpperCase();
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tHow many years does the formation have? ");
        int duration = scan.nextInt();
        scan.nextLine(); // next line trap
        System.out.print("\n\t\t\t\t\t\t\t\t\t\tWhich certificate is provided by the program? ");
        String certificate = scan.nextLine().toUpperCase();
        int idCity = 0;
        
        return new Formation(admin.getFormations().length + 1, idCity, formationName, duration, certificate);
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

    public static Card[] fillStayCard(){
        Card card1 = new Card(1, 1, 1, "C018507B", "23/09/2023", "23/09/2026", 234361, "Reg. Exc.");
        Card card2 = new Card(2, 3, 2, "C019879H", "21/05/2022", "21/05/2025", 234565, "Reg. Exc.");
        Card card3 = new Card(3, 2, 4, "C019561K", "19/02/2021", "19/02/2024", 212565, "Etudiant");
        Card card4 = new Card(4, 5, 4, "C019561K", "19/02/2021", "19/02/2024", 212565, "Reg. Exc.");
        Card card5 = new Card(5, 4, 3, "C019561L", "10/02/2021", "10/02/2024", 202565, "Travail");
        Card card6 = new Card(6, 7, 3, "C012361L", "10/02/2021", "10/02/2024", 202565, "Travail");
        Card card7 = new Card(7, 6, 1, "C019563M", "02/01/2023", "02/01/2026", 203565, "Travail");
        Card card8 = new Card(8, 9, 8, "C019523N", "01/01/2024", "01/01/2027", 103465, "Etudiant");
        Card card9 = new Card(9, 10, 7, "C023456C", "02/01/2023", "02/01/2026", 123565, "Etudiant");
        Card card10 = new Card(10, 8, 5, "C034567P", "14/09/2020", "14/09/2023", 203565, "Travail");

        Card[] cards = {card1, card2, card3, card4, card5, card6, card7, card8, card9, card10};

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
        Formation smi = new Formation(1, 3, "SMI", 3, "LICENCE F");
        Formation smc = new Formation(2, 4,"SMC", 3, "LICENCE F");
        Formation smp = new Formation(3, 3, "SMP", 4, "LICENCE P");
        Formation sma = new Formation(4, 8, "SMA", 4, "BACHELOR");
        Formation mip = new Formation(5, 9, "MIP", 3, "LICENCE F");
        Formation bigData = new Formation(6, 1, "BIG DATA & BI", 2, "MASTER SP");
        Formation mp = new Formation(7, 5, "MATH PHYSIQUE", 2, "MASTER RE");
        Formation algebre = new Formation(8, 6, "ALGEBRE APPLIQUEE", 2, "MASTER RE");
        Formation dctrInfo = new Formation(9, 7, "BLOCKCHAIN IN IOT", 2, "DOCTORAT");
        Formation dctrBio = new Formation(10, 3, "BIO DES SYSTEMES", 3, "DOCTORAT");

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

    public static String xMenu(int x, String arrayName){
        System.out.print("\n\t\t\t\t\t\t\t\t\t\t" + String.valueOf(x) + ".1 " + arrayName + " List\n\t\t\t\t\t\t\t\t\t\t" + String.valueOf(x) + ".2 Add a " + arrayName + "\n\t\t\t\t\t\t\t\t\t\t" + String.valueOf(x) + ".3 Delete a " + arrayName +"\n\t\t\t\t\t\t\t\t\t\t" + String.valueOf(x) + ".4 Update a " + arrayName + "\n\t\t\t\t\t\t\t\t\t\t" + String.valueOf(x) + ".5 Back to principal menu\n\t\t\t\t\t\t\t\t\t\tPlease choose an option: ");
        scan.nextLine();
        String choice = scan.nextLine();
        return choice;
    }

    public static void cls(Acemanager admin){
        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\tType ENTER to continue.. ");
        scan.nextLine();
        System.out.print("\033\143");
        int choice = menu();
        inputProcess(choice, admin);
        
    }

    public static int menu(){
        System.out.println("\n\t\t\t\t\t\t\t\t\t===========================\n\n" +
        "\t\t\t\t\t\t\t\t\t\s  Welcome to ACEMANAGER\n" + "\t\t\t\t\t\t\t\t\s  An association membership management\n\n"+
        "\t\t\t\t\t\t\t\t\t===========================\n");
        System.out.print("\n\t\t\t\t\t\t\t\t\tWhat would you like to do?\n\n\t\t\t\t\t\t\t\t\t1. List all tables\n\t\t\t\t\t\t\t\t\t2. Manage Members\n\t\t\t\t\t\t\t\t\t3. Manage Stay cards\n\t\t\t\t\t\t\t\t\t4. Manage Cities\n\t\t\t\t\t\t\t\t\t5. Manage Formations\n\t\t\t\t\t\t\t\t\t6. Manage Faculties\n\t\t\t\t\t\t\t\t\t7. Generate different reports\n\t\t\t\t\t\t\t\t\t8. Exit\n\t\t\t\t\t\t\t\t\tPlease choose an option: ");
        int option = 0;
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                option = scan.nextInt();
                if (option >= 1 && option <= 8) {
                    break;
                } else {
                    System.out.print("\n\t\t\t\t\t\t\t\t\tPlease enter a digit between 1 - 8: ");
                    // No need for another scan.next() as the scan will alway wait, scan tricks ;)
                }
            } else {
                System.out.print("\n\t\t\t\t\t\t\t\t\tPlease enter a digit between 1 - 8: ");
                scan.next();
            }
        }
        return option;
    }

    public static void bye(){
        System.out.println("\n\t\t\t\t\t\t\t\t\t===========================\n\n" +
        "\t\t\t\t\t\t\t\t\t\s   BYE BYE!!! CHEERS!!!\n" + "\t\t\t\t\t\t\t\t\s\s\s\s\s   Thanks for using ACEMANAGER\n\n"+
        "\t\t\t\t\t\t\t\t\t===========================\n");
    }


}
