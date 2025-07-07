package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.query;

public class employeedDAO {
    private employeed e;
    private query q = new query();

    public employeedDAO() {
        super();
    }

    public employeedDAO(employeed e) {
        super();
        this.e = e;
    }

    public List<employeed> getAllEmployeeds() {
        List<employeed> employeeds = new ArrayList<>();
        ResultSet res = q.queryRest("SELECT id_employeed, name_employeed, dni_employeed, email_employeed, gender, birthdate, `create`, salary FROM tienda_p66.employeed;");
        try {
            while (res.next()) {
                int id = res.getInt("id_employeed");
                String name = res.getString("name_employeed");
                double dni = res.getDouble("dni_employeed");
                String email = res.getString("email_employeed");
                String gender = res.getString("gender");
                Date birthdate = res.getDate("birthdate");
                Date create = res.getDate("create");
                double salary = res.getDouble("salary");

                employeeds.add(new employeed(id, name, dni, email, gender, birthdate, create, salary));
            }
            q.closeConn();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la base de datos para empleados: " + ex.getMessage());
            ex.printStackTrace();
        }
        return employeeds;
    }

    // Aquí podrías añadir métodos para addEmployeed, updateEmployeed, deleteEmployeed si los necesitas.
    // Ejemplo de addEmployeed:
    public boolean addEmployeed() {
        // Asegúrate de que el formato de fecha para birthdate y create coincida con tu base de datos
        // o usa PreparedStatement para manejar las fechas correctamente.
        return q.queryUpdate(String.format("INSERT INTO tienda_p66.employeed (name_employeed, dni_employeed, email_employeed, gender, birthdate, `create`, salary) VALUES ('%s', %f, '%s', '%s', '%s', '%s', %f);",
                e.getName_employeed(), e.getDni_employeed(), e.getEmail_employeed(), e.getGender(),
                (e.getBirthdate() != null ? new java.sql.Date(e.getBirthdate().getTime()).toString() : "NULL"), // Formato YYYY-MM-DD
                (e.getCreate() != null ? new java.sql.Date(e.getCreate().getTime()).toString() : "NULL"), // Formato YYYY-MM-DD
                e.getSalary()));
    }
}