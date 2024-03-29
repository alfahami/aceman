import java.util.Scanner;

public class Aceman {

    // TO DO: in case two members have the same name (deletion, update)
    static Scanner scan = new Scanner(System.in);
    static String[][] users = new String[20][13];
    static String[][] cin = new String[10][7];
    static String[][] roles = new String[3][4];
    static String[][] formations = new String[10][5];
    static String[][] facultiesInstitues = new String[10][4];
    static String[][] cities = new String[10][3];

    public static void main(String[] args) {

        // Populate Base table
        fillHeaders();
        fillIDs();
        fillCities();
        fillFacsInsitutes();
        fillFormations();
        fillRoles();
        baseMembers();
        
        welcome();
        menu();
        scan.close();

    }

    // GENERAL FUNCTIONS
    public static void welcome() {
        System.out.println("\n\n\t\t\tWelcome to ACEMANAGER: an assocoiation membership application manager\n\n\n");
    }

    public static void goodBye() {
        System.out.println("\n\n\t\tTHANKS FOR USING ACEMANAGER ... GOOD BYE!!!\n");
        System.exit(0);
    }

    public static void menu() {
        System.out.print(
                "\n\n What would you like to manage ?\n\n \t1. List all members.\n\t2. Add a new member\n\t3. Remove a member.\n\t4. Update an exisiting member.\n\t5. Find a member by their name.\n\n Or\n \t6. Would you like me to generate different reports?\n\t7. QUIT\n\nPlease choose an option : ");

        // TO DO: Force user to type integer, either he types integer or he quits the
        // app - Done

        int choice = 0;
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (choice >= 1 && choice <= 7) {
                    break;
                } else {
                    System.out.print("Please enter a digit between 1 - 7: ");
                    // No need for another scan.next() as the scan will alway wait, scan tricks ;)
                }
            } else {
                System.out.print("Please enter a digit between 1 - 7: ");
                scan.next();
            }
        }
        switch (choice) {
            case 1:
                scan.nextLine(); // nextLine trap
                printTable(users);
                pressAnyKey();
                break;

            case 2:
                scan.nextLine(); // nextLine trap
                addMember();
                System.out.println("\nHere are the updated member list: \n");
                printTable(users);
                System.out.print("Would you like to add another member ? ");
                memberRequest();
                break;

            case 3:
                scan.nextLine(); // nextLine trap
                System.out.print("Which member would you like to remove ? ");
                String memberName = scan.nextLine();
                remove(memberName);
                pressAnyKey();
                break;

            case 4:
                scan.nextLine(); // nextLine trap
                System.out.print("Which member do you want to upadate? ");
                String updateName = scan.nextLine().toUpperCase();
                int line = searchByName(updateName);
                if (line != -1) {
                    // Do the replacement
                    if (users[line][1].equals(updateName)) {
                        System.out.print("Please enter the new first name: ");
                        String newLName = scan.nextLine().toUpperCase();
                        users[line][1] = newLName;
                    }
                    if (users[line][2].equals(updateName)) {
                        System.out.print("Please enter the new last name: ");
                        String newFName = scan.nextLine().toLowerCase();
                        users[line][2] = newFName;
                    }
                    printTable(users);
                    pressAnyKey();

                } else {
                    System.out.println(updateName + " is not an existing member. Would you like to add him/her ? ");
                    String ans = scan.nextLine();
                    if (ans.equalsIgnoreCase("yes")) {
                        addMember();
                    } else {
                        menu();
                    }
                }
                break;

            case 5:
                scan.nextLine(); // next line trap
                System.out.print("Which member are you looking for: ");
                String member = scan.nextLine();
                int row = searchByName(member);
                if (row != -1) {
                    System.out.print("\n\n");
                    printMember(row);
                    System.out.print("\n\n");
                    pressAnyKey();

                } else {
                    System.out.print("\n\n\t\tMember not FOUND!!!\n\nWould you like to add him/her as new member ? ");
                    memberRequest();
                }
                break;
            // TO DO: reports generation welcome menu
            case 6:
                scan.nextLine(); // nextLine trap
                System.out.println("\t\t\t\tTo be implemented soon\n\n\n");
                pressAnyKey();
                break;
            case 7:
                goodBye();
                break;
            default:
                System.out.println("\t\t\t\tIt looks like you don't understand English! GET AWAY and go get a LIFE!");
                System.exit(0);
                break;
        }
    }

    public static void addMember() {
        System.out.println("Enter the new member details.\n");

        System.out.print("\tFirst name: ");
        String fname = scan.nextLine().toUpperCase();

        System.out.print("\tLast name: ");
        String lname = scan.nextLine().toUpperCase();

        System.out.print("\tBirth Date : ");
        String birth = scan.nextLine();

        System.out.print("\tPassport : ");
        String pssprt = scan.nextLine().toUpperCase();

        System.out.print("\tCIN : ");
        String cin = scan.nextLine().toUpperCase();

        System.out.print("\tMatricule AMCI - type 0 if no scholarship -: ");
        String matAmci = scan.nextLine();

        // check the city
        System.out.print("\tCity : ");
        String cityName = scan.nextLine().toUpperCase();
        String idCity = getCityID(cityName); // Creating a link key between users-->cities table

        System.out.print("\tAdhesion Number: ");
        String numAdhesion = scan.nextLine().toUpperCase();

        System.out.print("\tEmail : ");
        String email = scan.nextLine().toLowerCase();

        System.out.print("\tDo you have an adhesion -type YES or NO-: ");
        String statusAdhesion = scan.nextLine().toUpperCase();
        while (!statusAdhesion.equalsIgnoreCase("YES") && !statusAdhesion.equalsIgnoreCase("NO")) {
            System.out.print("\tPlease type \"YES\" or \"NO\" ");
            statusAdhesion = scan.nextLine().toUpperCase();
        }

        System.out.print("\tStudy Field : ");
        String fieldName = scan.nextLine().toUpperCase();
        String fieldID = getFieldID(fieldName); // Creating a link key between users-->formation table

        // Yasseem's LOGIC
        System.out.print("\tDo you want to be an admin of this app? ");
        String answer = scan.nextLine();
        switch (answer) {
            case "cat":
                answer = "1";
                break;
            default:
                answer = "2";
                break;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i][1] == null) {

                users[i][1] = lname;
                users[i][2] = fname;
                users[i][3] = birth;
                users[i][4] = pssprt;
                users[i][5] = cin;
                users[i][6] = matAmci;
                users[i][7] = numAdhesion;
                users[i][8] = idCity;
                users[i][9] = fieldID;
                users[i][10] = email;
                users[i][11] = answer;
                users[i][12] = statusAdhesion;

                break;
            }
        }

    }

    public static void memberRequest() {
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("no")) {
            menu();
        } else {
            while (answer.equalsIgnoreCase("yes")) {
                addMember();
                printTable(users);
                System.out.print("Would you like to add another member? ");
                answer = scan.nextLine();
            }
            menu();
        }
    }

    // TO DO: if two members have the same first name and last name
    public static void remove(String memberName) {
        int row = searchByName(memberName);
        if (row != -1) {
            System.out.print("\n\n");
            printMember(row);
            System.out.print("\n\n");
            System.out.print("\nDeletion is irreversible ? Would you like to proceed ? ");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                for (int j = 1; j < users[row].length; j++) {
                    users[row][j] = null;
                }
                printTable(users);
            } else if (answer.equalsIgnoreCase("no")) {
                menu();
            }
        } else {
            System.out.print("Sorry ... Member doesn't exist yet. Would you like to add him/her? ");
            String resp = scan.nextLine();
            if (resp.equalsIgnoreCase("yes")) {
                addMember();
            } else if (resp.equalsIgnoreCase("no")) {
                menu();
            }
        }
    }

    // get the city ID
    public static String getCityID(String cityName) {
        while (true) {
            for (int j = 1; j < cities.length; j++) {
                if (cityName.equals(cities[j][1])) {
                    return cities[j][0];
                }
            }
            System.out.println(
                    "\t\tFES - MEKNES - OUJDA - KENITRA - RABAT - SALE are the cities managed by now, please choose one of them.");
            System.out.print("\t");
            cityName = scan.nextLine().toUpperCase();
        }
        // return "this should never execute! If it does, DEBUUUUUG!!!";
    }

    // ANDJIB'S LOGIC
    public static String getFieldID(String fieldName) {
        for (int i = 0; i < formations.length; i++) {
            if (fieldName.equals(formations[i][2])) {
                return formations[i][0];
            }
        }
        System.out.println("\n\n\t\tSorry ... we only manage CHIMIE | INFORMATIQUE | MATHEMATIQUES");
        goodBye();
        System.exit(0);
        return "This should never be executed ... if so DEBUUUUUUG";
    }

    // ZAKS LOGIC
    public static int searchByName(String name) {
        int row;
        for (int i = 0; i < users.length; i++) {
            if (name.equalsIgnoreCase(users[i][1]) || name.equalsIgnoreCase(users[i][2])) {
                row = i;
                return row;
            }
        }
        return -1;
    }

    // Helpers

    public static void printTable(String[][] array) {
        System.out.print("\n");
        for (int i = 0; i < array.length; i++) {
            // if it's not an empty row
            if (array[i][1] != null) {
                for (int j = 0; j < array[i].length; j++) {
                    if (i == 0) {
                        System.out.print("  " + array[i][j] + "    ");
                    } else {
                        System.out.print("  " + array[i][j] + "   ");
                    }
                }

            } else {
                continue;
            }
            System.out.println("\n");
        }
        System.out.println();
    }

    public static void printMember(int rownNumber) {
        for (int j = 0; j < users[rownNumber].length; j++) {
            System.out.print("  " + users[rownNumber][j] + "    ");
        }
    }

    public static void pressAnyKey() {
        System.out.print("Press Enter key to continue... ");
        scan.nextLine();
        menu();
    }

    

    // POPULATE ID AND BASE VALUES
    public static void fillIDs(String[][] array) {
        for (int i = 1; i < array.length; i++) {
            array[i][0] = Integer.toString(i);
        }
    }

    public static void fillIDs() {
        fillIDs(users);
        fillIDs(formations);
        fillIDs(facultiesInstitues);
        fillIDs(cities);
        fillIDs(cin);
        fillIDs(roles);
    }

    // all IDs have the first row
    public static void fillRoles() {

        roles[1][0] = "1";
        roles[1][1] = "ADMIN";
        roles[1][2] = "0:00";
        roles[1][3] = "00:00";

        roles[2][0] = "1";
        roles[2][1] = "LAMBDA";
        roles[2][2] = "NULL";
        roles[2][3] = "NULL";
    }

    public static void fillFormations() {
        formations[1][0] = "1";
        formations[1][1] = "1"; // id_facultes
        formations[1][2] = "CHIMIE";
        formations[1][3] = "3";
        formations[1][4] = "Licence";

        formations[2][0] = "2";
        formations[2][1] = "2"; // id_facultes
        formations[2][2] = "INFORMATIQUE";
        formations[2][3] = "2";
        formations[2][4] = "Master";

        formations[3][0] = "3";
        formations[3][1] = "1"; // id_facultes
        formations[3][2] = "MATHEMATIQUES";
        formations[3][3] = "3";
        formations[3][4] = "Doctorat";

    }

    public static void fillFacsInsitutes() {
        facultiesInstitues[1][0] = "1";
        facultiesInstitues[1][1] = "FSDM";
        facultiesInstitues[1][2] = "USMBA";
        facultiesInstitues[1][3] = "1";

        facultiesInstitues[2][0] = "2";
        facultiesInstitues[2][1] = "FS MI";
        facultiesInstitues[2][2] = "UMI";
        facultiesInstitues[2][3] = "2";

        facultiesInstitues[3][0] = "3";
        facultiesInstitues[3][1] = "FS Oujda";
        facultiesInstitues[3][2] = "UMI";
        facultiesInstitues[3][3] = "3";

        facultiesInstitues[3][0] = "4";
        facultiesInstitues[3][1] = "FSK";
        facultiesInstitues[3][2] = "UIT";
        facultiesInstitues[3][3] = "4";
    }

    public static void fillCities() {
        cities[1][0] = "1";
        cities[1][1] = "FES";
        cities[1][2] = "Fes-Boulemane";

        cities[2][0] = "2";
        cities[2][1] = "MEKNES";
        cities[2][2] = "Fes-Boulemane";

        cities[3][0] = "3";
        cities[3][1] = "OUJDA";
        cities[3][2] = "Fes-Boulemane";

        cities[4][0] = "4";
        cities[4][1] = "KENITRA";
        cities[4][2] = "Rabat-Sale-Kenitra";

        cities[5][0] = "5";
        cities[5][1] = "RABAT";
        cities[5][2] = "Rabat-Sale-Kenitra";

        cities[6][0] = "6";
        cities[6][1] = "SALE";
        cities[6][2] = "Rabat-Sale-Kenitra";
    }

    public static void fillHeaders() {
        // Putting headers
        users[0][0] = "ID_USR";
        users[0][1] = "LNAME";
        users[0][2] = "FNAME";
        users[0][3] = "BIRTH";
        users[0][4] = "PSSPRT";
        users[0][5] = "CIN";
        users[0][6] = "M_AMCI";
        users[0][7] = "ID_ADHSN";
        users[0][8] = "ID_CTY";
        users[0][9] = "ID_FRMTN";
        users[0][10] = "EMAIL";
        users[0][11] = "ROLE";
        users[0][12] = "ADHRNT_STS";

        cin[0][0] = "ID_CIN";
        cin[0][1] = "ID_USR";
        cin[0][2] = "ID_CTY";
        cin[0][3] = "OBTN_YR";
        cin[0][4] = "EXPR8YR";
        cin[0][5] = "ADRSS";
        cin[0][6] = "PIN";

        roles[0][0] = "ID_ROLE";
        roles[0][1] = "NM_roles";
        roles[0][2] = "SSN_STRT";
        roles[0][3] = "SSN_END";

        formations[0][0] = "ID_FRMT";
        formations[0][1] = "ID_FC_INST";
        formations[0][2] = "NM_FRMT";
        formations[0][3] = "DRTN_FRMT";
        formations[0][4] = "DIPLOME";

        facultiesInstitues[0][0] = "ID_FCT_INST";
        facultiesInstitues[0][1] = "UNIVERSITY";
        facultiesInstitues[0][2] = "NM_facultiesInstitues";
        facultiesInstitues[0][3] = "ID_CTY";

        cities[0][0] = "ID_CTY";
        cities[0][1] = "NM_CTY";
        cities[0][2] = "NM_RGN";
    }

    public static void baseMembers() {

        users[1][0] = "1";
        users[1][1] = "TOIHIR";
        users[1][2] = "AL FAHAMI";
        users[1][3] = "21/05/1992";
        users[1][4] = "NBE3457564";
        users[1][5] = "C016745J";
        users[1][6] = "20111489";
        users[1][7] = "14";
        users[1][8] = "1"; // id_ville
        users[1][9] = "3"; // id_frmtion
        users[1][10] = "alt@gmail.com";
        users[1][11] = "1";
        users[1][12] = "YES";

        users[2][0] = "2";
        users[2][1] = "HAFIDHOU";
        users[2][2] = "MAOULIDA";
        users[2][3] = "22/05/2998";
        users[2][4] = "NBE345678";
        users[2][5] = "C016745B";
        users[2][6] = "202478";
        users[2][7] = "22";
        users[2][8] = "1"; // id_ville;
        users[2][9] = "4"; // id_frmtion
        users[2][10] = "haf@gmail.com";
        users[2][11] = "2"; // id_role
        users[2][12] = "YES";

        users[3][0] = "3";
        users[3][1] = "CHARFIA";
        users[3][2] = "MOHAMED";
        users[3][3] = "22/09/2001";
        users[3][4] = "NBE345678";
        users[3][5] = "C016745B";
        users[3][6] = "202478";
        users[3][7] = "22";
        users[3][8] = "4"; // id_city
        users[3][9] = "4"; // id_frmtion
        users[3][10] = "chaf@gmail.com";
        users[3][11] = "2"; // id_role
        users[3][12] = "YES";

        users[4][0] = "4";
        users[4][1] = "DAKOINE";
        users[4][2] = "TOIHIR";
        users[4][3] = "12/08/1999";
        users[4][4] = "NBE345678";
        users[4][5] = "C016745B";
        users[4][6] = "404478";
        users[4][7] = "44";
        users[4][8] = "1"; // id_city
        users[4][9] = "4"; // id_frmtion
        users[4][10] = "dak1@gmail.com";
        users[4][11] = "2"; // id_role
        users[4][12] = "YES";

        users[5][0] = "5";
        users[5][1] = "ANDJOUZA";
        users[5][2] = "ADAM";
        users[5][3] = "22/05/2002";
        users[5][4] = "NBE545678";
        users[5][5] = "C016745B";
        users[5][6] = "202478";
        users[5][7] = "22";
        users[5][8] = "1"; // id_ville;
        users[5][9] = "4"; // id_frmtion
        users[5][10] = "andj@gmail.com";
        users[5][11] = "2"; // id_role
        users[5][12] = "YES";

        users[6][0] = "6";
        users[6][1] = "DJAWAD";
        users[6][2] = "SIDI";
        users[6][3] = "22/06/2005";
        users[6][4] = "NBE646678";
        users[6][5] = "C016746B";
        users[6][6] = "202478";
        users[6][7] = "26";
        users[6][8] = "1"; // id_ville
        users[6][9] = "5"; // id_frmtion;
        users[6][10] = "djad@gmail.com";
        users[6][11] = "1"; // id_role
        users[6][12] = "YES";

        users[7][0] = "7";
        users[7][1] = "BEHRAM";
        users[7][2] = "MAHAMET";
        users[7][3] = "22/07/1998";
        users[7][4] = "NBE74778";
        users[7][5] = "C017747B";
        users[7][6] = "202478";
        users[7][7] = "65";
        users[7][8] = "1"; // id_ville;
        users[7][9] = "1"; // id_frmtion
        users[7][10] = "ben@gmail.com";
        users[7][11] = "2"; // id_role
        users[7][12] = "NO";

        users[8][0] = "8";
        users[8][1] = "ISSIHAKA";
        users[8][2] = "MOHAMED";
        users[8][3] = "22/08/1990";
        users[8][4] = "NBE8488";
        users[8][5] = "C018848B";
        users[8][6] = "202488";
        users[8][7] = "65";
        users[8][8] = "1"; // id_ville
        users[8][9] = "1"; // id_frmtion
        users[8][10] = "ism@gmail.com";
        users[8][11] = "1"; // id_role
        users[8][12] = "NO";

        users[9][0] = "9";
        users[9][1] = "ABDALLAH";
        users[9][2] = "SAID";
        users[9][3] = "20/06/1999";
        users[9][4] = "NB38488";
        users[9][5] = "C018832B";
        users[9][6] = "202418";
        users[9][7] = "61";
        users[9][8] = "4"; // id_ville
        users[9][9] = "1"; // id_frmtion
        users[9][10] = "abd@gmail.com";
        users[9][11] = "1"; // id_role
        users[9][12] = "NO";

        users[10][0] = "10";
        users[10][1] = "ROUSHDAT";
        users[10][2] = "TOIHIR";
        users[10][3] = "20/09/1994";
        users[10][4] = "NBE104501";
        users[10][5] = "C018109B";
        users[10][6] = "2024120";
        users[10][7] = "70";
        users[10][8] = "3"; // id_ville
        users[10][9] = "1"; // id_frmtion
        users[10][10] = "rou@gmail.com";
        users[10][11] = "2"; // id_role
        users[10][12] = "NO";
    }
}
