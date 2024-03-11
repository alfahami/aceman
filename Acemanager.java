public class Acemanager {
    private Member[] members;
    private Formation[] formations;
    private StayCard[] stayCards;
    private FacultyInstitute[] facultyInstitutes;
    private City[] cities;


    public Acemanager(Member[] members) {
        this.members = new Member[members.length];
        for (int i = 0; i < this.members.length; i++) {
            this.members[i] = members[i];
            this.members[i].setId(i+1);
        }        
    }

    public Acemanager(City[] cities){
        this.cities = new City[cities.length];
        for (int i = 0; i < cities.length; i++) {
            this.cities[i] = cities[i];
            this.cities[i].setIdCity(i+1);
        }
    }

    public Member getUser(int index) {
        return this.members[index];
    }

    public void setmembers(Member user, int index) {
       Member copy = new Member(user);
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

    public void printCities()

    public String toString() {
        return "{" +
            " members='" + "'" +
            ", formations='" + getFormations() + "'" +
            ", stayCards='" + getStayCards() + "'" +
            ", facultyInstitutes='" + getFacultyInstitutes() + "'" +
            "}";
    }
 
}
