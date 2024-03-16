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

    public void setmembers(Member Member, int index) {
       Member copy = new Member(Member);
       this.members[index] = copy;
    }

    public Formation[] getFormations() {
        return this.formations;
    }

    public void setFormations(Formation[] formations) {
        this.formations = formations;
    }

    public StayCard[] getStayCards() {
        return this.stayCards;
    }

    public void setStayCards(StayCard[] stayCards) {
        this.stayCards = stayCards;
    }

    public FacultyInstitute[] getFacultyInstitutes() {
        return this.facultyInstitutes;
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

                String space = " ";
                if(fullName.length() < 17){
                    for (int j = 0; j <= 20 - fullName.length(); j++) {
                       space.repeat(j); 
                    }
                }
                String displayFullName = fullName + space;
                
            /* HACK ENDS  */
                
                // switch array instance
                String className = arrays[i].getClass().getName();
                switch(className){
                    case "Member":
                        // Get the stay card of the member
                        String cardNum = getCard(member.getIdStayCard());

                        System.out.println( printId + ". | " + displayFullName + "| " + member.getAge() + " ys. old | " + member.getPassport() + "   |" + cardNum);
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

    public String getCard(int idStayCard){
        for (int i = 0; i < this.stayCards.length; i++) {
            if(idStayCard == stayCards[i].getIdCard()){
                return stayCards[i].getCardNum();
            } else {
                return "No Card";
            }
        }
        return "This should never be executed";
    }

    public String toString() {
        return "{" +
            " members='" + "'" +
            ", formations='" + getFormations() + "'" +
            ", stayCards='" + getStayCards() + "'" +
            ", facultyInstitutes='" + getFacultyInstitutes() + "'" +
            "}";
    }
 
}
