public class Acemanager {
    private User[] users;
    private Formation[] formations;
    private StayCard[] stayCards;
    private FacultyInstitute[] facultyInstitutes;



    public Acemanager(User[] users) {
        this.users = new User[users.length];
        for (int i = 0; i < this.users.length; i++) {
            this.users[i] = users[i];
        }
    }


    public User getUser(int index) {
        return this.users[index];
    }

    public void setUsers(User user, int index) {
       User copy = new User(user);
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
