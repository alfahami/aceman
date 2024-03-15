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
            for (int i = 0; i < arrays.length; i++) {
                
                System.out.println("\n─ ─ ─ ─ ─ ─ ─ ─  ─ ─ ─ ─ ─ ─ ─ ─  ─ ─ ─ ─ ─ ─ ─ ─  ─ ─ ─ ─ ─ ─ ─ ─ ");
                // switch array instance
                String className = arrays[i].getClass().getName();
                switch(className){
                    case "Member":
                        System.out.println( "\n " + this.members[i].getIdMember() + " ┆ " + this.members[i].toString()+" ┆");
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

    public String toString() {
        return "{" +
            " members='" + "'" +
            ", formations='" + getFormations() + "'" +
            ", stayCards='" + getStayCards() + "'" +
            ", facultyInstitutes='" + getFacultyInstitutes() + "'" +
            "}";
    }
 
}
