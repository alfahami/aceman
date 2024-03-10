public class Acemanager {
    private Member[] users;
    private Formation[] formations;
    private StayCard[] stayCards;
    private FacultyInstitute[] facultyInstitutes;


    public Acemanager(Member[] users) {
        this.users = new Member[users.length];
        for (int i = 0; i < this.users.length; i++) {
            this.users[i] = users[i];
        }
    }


    public Member getUser(int index) {
        return this.users[index];
    }

    public void setUsers(Member user, int index) {
       Member copy = new Member(user);
       this.users[index] = copy;
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

    public String toString() {
        return "{" +
            " users='" + "'" +
            ", formations='" + getFormations() + "'" +
            ", stayCards='" + getStayCards() + "'" +
            ", facultyInstitutes='" + getFacultyInstitutes() + "'" +
            "}";
    }
 
}
