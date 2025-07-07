package model;

import java.util.Date;
import libreriaGenerica.generic;

public class employeed {
    private generic<Object, Object> dt1_e; // id_employeed, name_employeed, email_employeed
    private generic<Double, Date> dt2_e; // dni_employeed, salary, birthdate, create
    private String gender;

    public employeed() {
        super();
    }

    public employeed(int id_employeed, String name_employeed, double dni_employeed, String email_employeed,
                     String gender, Date birthdate, Date create, double salary) {
        dt1_e = new generic<Object, Object>(id_employeed, name_employeed, email_employeed);
        dt2_e = new generic<>(dni_employeed, salary, birthdate, create);
        this.gender = gender;
    }

    // Getters y Setters
    public int getId_employeed() {
        return (int) dt1_e.getAttribute1();
    }

    public void setId_employeed(int id_employeed) {
        dt1_e.setAttribute1(id_employeed);
    }

    public String getName_employeed() {
        return (String) dt1_e.getAttribute2();
    }

    public void setName_employeed(String name_employeed) {
        dt1_e.setAttribute2(name_employeed);
    }

    public String getEmail_employeed() {
        return (String) dt1_e.getAttribute3();
    }

    public void setEmail_employeed(String email_employeed) {
        dt1_e.setAttribute3(email_employeed);
    }

    public double getDni_employeed() {
        return dt2_e.getAttribute1();
    }

    public void setDni_employeed(double dni_employeed) {
        dt2_e.setAttribute1(dni_employeed);
    }

    public double getSalary() {
        return dt2_e.getAttribute2();
    }

    public void setSalary(double salary) {
        dt2_e.setAttribute2(salary);
    }

    public Date getBirthdate() {
        return dt2_e.getAttribute3();
    }

    public void setBirthdate(Date birthdate) {
        dt2_e.setAttribute3(birthdate);
    }

    public Date getCreate() {
        return dt2_e.getAttribute4();
    }

    public void setCreate(Date create) {
        dt2_e.setAttribute4(create);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}