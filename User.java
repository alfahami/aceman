import java.time.LocalDate;
import java.time.Period;

public class User {
    private int id;
    private String passport;

    private int idStayCard;
    private int matriculeAmci;
    private int idCity;
    private int idMembership;
    private int idFormation;
    private int role;


    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;
    private String email;
    private boolean isMember;


    public User(int id, String passport, int idStayCard, int matriculeAmci, int idCity, int idFormation, int role, String firstName, String lastName, String birthDate, String email, boolean isMember) {
        this.id = id;
        this.passport = passport;
        this.idStayCard = idStayCard;
        this.matriculeAmci = matriculeAmci;
        this.idCity = idCity;
        this.idFormation = idFormation;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = toAge(this.birthDate);
        this.email = email;
        this.isMember = isMember;
    }

    public User(User source){
        this.id = source.id;
        this.passport = source.passport;
        this.idStayCard = source.idStayCard;
        this.matriculeAmci = source.matriculeAmci;
        this.idCity = source.idCity;
        this.idMembership = source.idMembership;
        this.idFormation = source.idFormation;
        this.role = source.role;
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.birthDate = source.birthDate;
        this.age = source.age;
        this.email = source.email;
        this.isMember = source.isMember;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getIdStayCard() {
        return this.idStayCard;
    }

    public void setIdStayCard(int idStayCard) {
        this.idStayCard = idStayCard;
    }

    public int getMatriculeAmci() {
        return this.matriculeAmci;
    }

    public void setMatriculeAmci(int matriculeAmci) {
        this.matriculeAmci = matriculeAmci;
    }

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getIdFormation() {
        return this.idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        age = toAge(this.birthDate);
        return age;
    }

    public void setAge(String birthDate) {
        this.age = toAge(birthDate);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMember() {
        return this.isMember;
    }

    public boolean getIsMember() {
        return this.isMember;
    }

    public void setisMember(boolean isMember) {
        this.isMember = isMember;
    }

    public int toAge(String birthDate){
        return Period.between(LocalDate.parse(birthDate), LocalDate.now()).getYears();
    }

    public String toString() {
        return "FullName= " + getLastName() + " " + getFirstName()    + "\n" 
            + "Birth Date= " + getBirthDate() + "\n"
            + "Age= " + getAge() + "\n"
            + "Passport= " + getPassport() + "\n"
            + "Email= " + getEmail() + "\n"
            + "Membership =" + getIsMember()
            +"\n\n";
    }


    

}
