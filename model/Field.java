package model;

import java.util.Objects;

public class Field {
    private int id;
    private int idFac;
    private String name;
    private String certificate;
    private int duration;

    public Field(int id, int idFac, String name, String certificate, int duration) {
        setId(id);
        setIdFac(idFac);
        setName(name);
        setCertificate(certificate);
        setDuration(duration);
    }

    public Field(Field source) {
        setId(source.id);
        setIdFac(source.idFac);
        setName(source.name);
        setCertificate(source.certificate);
        setDuration(source.duration);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be greater than 0");
        this.id = id;
    }

    public int getIdFac() {
        return this.idFac;
    }

    public void setIdFac(int idFac) {
        if (idFac <= 0)
            throw new IllegalArgumentException("Faculty ID must be greater than 0");
        this.idFac = idFac;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }

    public String getCertificate() {
        return this.certificate;
    }

    public void setCertificate(String certificate) {
        if (certificate == null || certificate.isBlank())
            throw new IllegalArgumentException("Certificate cannot be null or blank");
        this.certificate = certificate;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0 || duration > 5)
            throw new IllegalArgumentException("Duration must be between 1 and 5");
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "[" +
                " ID='" + getId() + "'" +
                ", IDFac='" + getIdFac() + "'" +
                ", Name='" + getName() + "'" +
                ", Certificate='" + getCertificate() + "'" +
                ", Duration='" + getDuration() + "'" +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Field)) {
            return false;
        }
        Field field = (Field) o;
        return id == field.id && idFac == field.idFac && Objects.equals(name, field.name)
                && Objects.equals(certificate, field.certificate) && duration == field.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFac, name, certificate, duration);
    }

}
