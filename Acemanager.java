public class Acemanager {
    private Member[] members;
    private Formation[] formations;
    private StayCard[] stayCards;
    private FacultyInstitute[] facultyInstitutes;
    private City[] cities;


    public Acemanager(City[] cities, Formation[] formations, FacultyInstitute[] facs, Member[] members, StayCard[] cards){
        this.members = new Member[members.length];
        for (int i = 0; i < this.members.length; i++) {
            this.members[i] = members[i];
            this.members[i].setIdMember(i+1);
        }     
        
        this.stayCards = new StayCard[cards.length];
        for (int i = 0; i < this.stayCards.length; i++) {
            this.stayCards[i] = cards[i];
            this.stayCards[i].setIdCard(i+1);
        }   
        
        this.cities = new City[cities.length];
        for (int i = 0; i < this.cities.length; i++) {
            this.cities[i] = cities[i];
            this.cities[i].setIdCity(i+1);
        }  
        
        this.formations = new Formation[formations.length];
        for (int i = 0; i < this.formations.length; i++) {
            this.formations[i] = formations[i];
            this.formations[i].setIdFormation(i+1);
        }  

        this.facultyInstitutes = new FacultyInstitute[facs.length];
        for (int i = 0; i < this.facultyInstitutes.length; i++) {
            this.facultyInstitutes[i] = facs[i];
            this.facultyInstitutes[i].setIdFacultyInstitute(i+1);
        }  
    }

    public Acemanager(Member[] members) {
        this.members = new Member[members.length];
        for (int i = 0; i < this.members.length; i++) {
            this.members[i] = members[i];
            this.members[i].setIdMember(i+1);
        }        
    }

    public Acemanager(City[] cities){
        this.cities = new City[cities.length];
        for (int i = 0; i < cities.length; i++) {
            this.cities[i] = cities[i];
            this.cities[i].setIdCity(i+1);
        }
    }

    public Member getMember(int index) {
        return this.members[index];
    }

    public void setmember(Member Member, int index) {
       Member copy = new Member(Member);
       this.members[index] = copy;
    }

    public Formation getFormation(int i) {
        return this.formations[i];
    }

    public void setFormation(int i, Formation formation) {
        Formation copy = new Formation(formation);
        this.formations[i] = formation;
    }

    public StayCard getStayCard(int i) {
        return this.stayCards[i];
    }

    public void setStayCard(int i, StayCard stayCard) {
        StayCard copy = new StayCard(stayCard);
        this.stayCards[i] = copy;
    }

    public City getCity(int i){
        return this.cities[i];
    }

    public FacultyInstitute getFacultyInstitute(int i) {
        return this.facultyInstitutes[i];
    }

    public void setFacultyInstitutes(FacultyInstitute[] facultyInstitutes) {
        this.facultyInstitutes = facultyInstitutes;
    }

    public void printAnyArrays(Object[] arrays){
        if(arrays != null){
            System.out.print("\n");
            for (int i = 0; i < arrays.length; i++) {

                Member member = getMember(i);

            /* HACK TO HAVE AN AWESOME DISPLAY OF THE ARRAY IN THE CONSOLE */

                // we used ternary for displayind id in the same column no matter how many digits it holds
                String printId = ( i < 9 ?  ("  " + String.valueOf(member.getIdMember())) : (" " + String.valueOf(member.getIdMember())));
                String fullName = member.getFirstName() + " " + member.getLastName();


                // THINK ABOUT USING STRINGBUILDER as it offers a set length, the idea would be to print all the Stringbuilder object and when no value found print space
                
            /* HACK ENDS  */
                
                // switch array instance
                String className = arrays[i].getClass().getName();
                switch(className){
                    case "Member":
                        // Get the stay card of the member
                        
                        System.out.println( printId + ". | " + formatString(fullName, 17) + "| " + member.getAge() + " ys. old | " + member.getPassport() + " | "  + member.getMatriculeAmci() + " | " + getCard(member.getIdStayCard()).getCardNum() + " | " + formatString(getCard(member.getIdStayCard()).getPattern(), 10) + " | " + formatString(getCityName(member.getIdCity()), 9)  + " | " + formatString(getFormationMember(member.getIdFormation()).getName(), 19) + " | " + formatString(getFormationMember(member.getIdFormation()).getFCertificate(), 15));
                        System.out.print("\n\n");
                        break;
                    case "City":
                        System.out.println("Display Cities");
                        break;
                    case "Formation":
                        System.out.println("Display formation");
                        break;
                    case "FacultyInstitute":

                        break;
                    case "StayCard":

                        break;
                }
            }
            System.out.print("\n");
        } else System.exit(0);
    }

    public StayCard getCard(int idStayCard){
            for (int j = 0; j < this.stayCards.length; j++) {
                if(idStayCard == getStayCard(j).getIdCard()){
                    return getStayCard(j);
                } 
            }
            return null;   
    }

    public String getCityName(int idCity){
        String cityName = "";
            for (int j = 0; j < this.cities.length; j++) {
                if(idCity == getCity(j).getIdCity()){
                    cityName = getCity(j).getName();
                } 
            }
        return cityName; 
    }

    public Formation getFormationMember(int idFormation){
            for (int j = 0; j < this.formations.length; j++) {
                if(idFormation == getFormation(j).getIdFormation()){
                   return getFormation(j);
                } 
            }
            return null; 
    }

    public String getFacultyInstituteName(int idFacultyInstitute){
        String facInstitute = "";
            for (int j = 0; j < this.facultyInstitutes.length; j++) {
                if(idFacultyInstitute == getFacultyInstitute(j).getIdFacultyInstitute()){
                    facInstitute = getFacultyInstitute(j).getNameFacInst();
                } 
            }
            return facInstitute; 
    }

    public String getCertificateName(int idFormation){
        String certifName = "";
            for (int j = 0; j < this.formations.length; j++) {
                if(idFormation == getFormation(j).getIdFormation()){
                    certifName = getFormation(j).getFCertificate();
                } 
            }
            return certifName; 
    }

    public String formatString(String s, int i){
        String space = " ";
        if(s.length() < i){
            for (int j = 0; j <= i- s.length(); j++) {
                space += " "; 
            }
        }
        return s + space;
    }

 
}
