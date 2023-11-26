package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CriarConex {

    public static Connection getConexao() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectado com Banco de Dados");
            return DriverManager.getConnection("jdbc:mysql://localhost/prova","root","1234");

        }catch (ClassNotFoundException e){
            throw new SQLException(e.getMessage());
        }
    }

}
