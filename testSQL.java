import java.util.Arrays;

public class testSQL {
    public static void main(String[] args) {
        // Select query and show the result
        conMySQL.selectQuery("SELECT * FROM empleados;");
        System.out.println(Arrays.toString(conMySQL.getResult()));

        // Create the result array and add the data from the previous select query and show the array named result
        String [] result = conMySQL.getResult();
        System.out.println(Arrays.toString(result));

        // Update query and show the result
        conMySQL.updateQuery("UPDATE empleados SET NOMBRE='PEPE' WHERE ID_EMPLEADO=2;");
        conMySQL.selectQuery("SELECT * FROM empleados WHERE ID_EMPLEADO=2;");
        System.out.println(Arrays.toString(conMySQL.getResult()));

        // Insert query and show the result
        conMySQL.insertQuery("INSERT INTO empleados(nombre,apellidos,telefono,correo,direccion,pass) VALUES ('Asier','Perez',684662812,'asier@gmail.com','Direccion1','Contra1');");
        conMySQL.selectQuery("SELECT * FROM empleados;");
        System.out.println(Arrays.toString(conMySQL.getResult()));

        // Delete query and show the result
        conMySQL.deleteQuery("DELETE FROM empleados WHERE ID_EMPLEADO=2;");
        conMySQL.selectQuery("SELECT * FROM empleados;");
        System.out.println(Arrays.toString(conMySQL.getResult()));
    }
}
