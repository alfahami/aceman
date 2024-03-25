import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Member {
    private int idMember;
    private StringBuilder passport;

    private int idCard;
    private int matriculeAmci;
    private int idCity;
    private int idFacultyInstitute;
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
    public Member(int idMember, int idCard, int idCity, int idFacultyInstitute, int idFormation, String firstName, String lastName, String passport, String birthDate, int matriculeAmci, String email, boolean isMember) {
        this.idMember = idMember;
        this.idCard = idCard;
        this.idCity = idCity;
        this.idFormation = idFormation;
        this.idFacultyInstitute = idFacultyInstitute;
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
        this.idMember = source.idMember;
        this.idCard = source.idCard;
        this.idCity = source.idCity;
        this.idFormation = source.idFormation;
        this.idFacultyInstitute = source.idFacultyInstitute;
        this.passport = new StringBuilder(source.passport);
        this.passport.setLength(9);
        this.matriculeAmci = source.matriculeAmci;
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.birthDate = source.birthDate;
        this.age = source.toAge(this.birthDate);
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

    public int getIdCard() {
        return this.idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
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


    public int getIdFacultyInstitute() {
        return this.idFacultyInstitute;
    }

    public void setIdFacultyInstitute(int idFacultyInstitute) {
        this.idFacultyInstitute = idFacultyInstitute;
    }

    public boolean isIsMember() {
        return this.isMember;
    }
    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
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
        setAge(toAge(birthDate)); // update automatically member's age
    }

    public int getAge() {
        age = toAge(this.birthDate);
        return age;
    }

    private void setAge(int age) {
        this.age = age;
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

    // this shouldn't be accessed out of this class
    private int toAge(String birthDate){
        // DateTimeFormatter is specifying the format of the date that will be used in setting memebrr birthdate

        return Period.between(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now()).getYears();
    }

    public String toString() {
        return getLastName() + " " + getFirstName() + " | " + getAge() + " ans | " + getPassport() + " | " + getMatriculeAmci() + " | " + getEmail();
    }
}
