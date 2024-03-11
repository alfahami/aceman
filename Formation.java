public class Formation {
    private int idFormation;
    private int idFacultyInstitute;
    private String name;
    private String fCertificate;
    private int duration;
    /* private droppedYear: coul be calculated */

    public Formation(int idCity, String name, int duration, String fCertificate) {
        this.fCertificate = fCertificate;
        this.name = name;
        this.duration = duration;
    }


    public int getIdFormation() {
        return this.idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public int getidFacultyInstitute() {
        return this.idFacultyInstitute;
    }

    public void setidFacultyInstitute(int idFacultyInstitute) {
        this.idFacultyInstitute = idFacultyInstitute;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFCertificate() {
        return this.fCertificate;
    }

    public void setFCertificate(String fCertificate) {
        this.fCertificate = fCertificate;
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
            ", idFacultyInstitute='" + getidFacultyInstitute() + "'" +
            ", name='" + getName() + "'" +
            ", duration='" + getDuration() + "'" +
            "}";
    }
}
