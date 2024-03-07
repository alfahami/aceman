public class Formation {
    private int idFormation;
    private int facultyInstitute;
    private String name;
    private int duration;
    /* private droppedYear: coul be calculated */

    public Formation(int idFormation, int facultyInstitute, String name, int duration) {
        this.idFormation = idFormation;
        this.facultyInstitute = facultyInstitute;
        this.name = name;
        this.duration = duration;
    }


    public int getIdFormation() {
        return this.idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public int getFacultyInstitute() {
        return this.facultyInstitute;
    }

    public void setFacultyInstitute(int facultyInstitute) {
        this.facultyInstitute = facultyInstitute;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return "{" +
            " idFormation='" + getIdFormation() + "'" +
            ", facultyInstitute='" + getFacultyInstitute() + "'" +
            ", name='" + getName() + "'" +
            ", duration='" + getDuration() + "'" +
            "}";
    }

}
