import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Member {
    private int idMember;
    private StringBuilder passport;

    private int idStayCard;
    private int matriculeAmci;
    private int idCity;
    private int idFormation;
    private int role;


    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;
    private String email;
    private boolean isMember;


    public Member(){

    }
    public Member(int idMember, int idStayCard, int idCity, int idFormation, String firstName, String lastName, String passport, String birthDate, int matriculeAmci, String email, boolean isMember) {
        this.idMember = idMember;
        this.idStayCard = idStayCard;
        this.idCity = idCity;
        this.idFormation = idFormation;
        this.passport = new StringBuilder(passport);;
        this.passport.setLength(9);
        this.matriculeAmci = matriculeAmci;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = toAge(this.birthDate);
        this.email = email;
        this.isMember = isMember;
    }

    public Member(Member source){
        this.passport = source.passport;
        this.idStayCard = source.idStayCard;
        this.matriculeAmci = source.matriculeAmci;
        this.idFormation = source.idFormation;
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.birthDate = source.birthDate;
        this.age = source.age;
        this.email = source.email;
        this.isMember = source.isMember;
    }

    public int getIdMember() {
        return this.idMember;
    }

    public void setIdMember(int id) {
        this.idMember = id;
    }

    public StringBuilder getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = new StringBuilder(passport);
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
        // DateTimeFormatter is specifying the format of the date that will be used in setting memebrr birthdate

        return Period.between(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now()).getYears();
    }

    public String toString() {
        return getLastName() + " " + getFirstName() + " | " + getAge() + " ans | " + getPassport() + " | " + getMatriculeAmci() + " | " + getEmail();
    }


    

}
