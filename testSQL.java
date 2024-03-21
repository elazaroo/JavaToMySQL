import java.util.Arrays;

public class testSQL {
    public static void main(String[] args) {
        conMySQL.selectQuery("SELECT * FROM PRUEBATABLA WHERE APELLIDO ='LAZARO';");
        System.out.println(Arrays.toString(conMySQL.getResult()));

        conMySQL.updateQuery("UPDATE PRUEBATABLA SET NOMBRE='PEPE' WHERE ID=2;");
        conMySQL.selectQuery("SELECT * FROM PRUEBATABLA WHERE ID=2;");
        System.out.println(Arrays.toString(conMySQL.getResult()));

        conMySQL.insertQuery("INSERT INTO PRUEBATABLA VALUES (3,'Asier','Perez','asier@gmail.com');");
        conMySQL.selectQuery("SELECT * FROM PRUEBATABLA;");
        System.out.println(Arrays.toString(conMySQL.getResult()));

        conMySQL.deleteQuery("DELETE FROM PRUEBATABLA WHERE ID=2;");
        conMySQL.selectQuery("SELECT * FROM PRUEBATABLA;");
        System.out.println(Arrays.toString(conMySQL.getResult()));
    }
}