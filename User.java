import java.time.LocalDate;
import java.time.Period;

public class User {
    private int id;
    private String passport;

    private String idStayCard;
    private int matriculeAmci;
    private int idCity;
    private int idAdhesion;
    private int idFormation;
    private int role;


    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;
    private String email;
    private boolean adherant;

    public User() {
    }
    

    public User(int id, String passport, String idStayCard, int matriculeAmci, int idCity, int idAdhesion, int idFormation, int role, String firstName, String lastName, String birthDate, String email, boolean adherant) {
        this.id = id;
        this.passport = passport;
        this.idStayCard = idStayCard;
        this.matriculeAmci = matriculeAmci;
        this.idCity = idCity;
        this.idAdhesion = idAdhesion;
        this.idFormation = idFormation;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = toAge(this.birthDate);
        this.email = email;
        this.adherant = adherant;
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

    public String getIdStayCard() {
        return this.idStayCard;
    }

    public void setIdStayCard(String idStayCard) {
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

    public int getIdAdhesion() {
        return this.idAdhesion;
    }

    public void setIdAdhesion(int idAdhesion) {
        this.idAdhesion = idAdhesion;
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

    public boolean isAdherant() {
        return this.adherant;
    }

    public boolean getAdherant() {
        return this.adherant;
    }

    public void setAdherant(boolean adherant) {
        this.adherant = adherant;
    }

    public int toAge(String birthDate){
        return Period.between(LocalDate.parse(birthDate), LocalDate.now()).getYears();
    }

    

}
