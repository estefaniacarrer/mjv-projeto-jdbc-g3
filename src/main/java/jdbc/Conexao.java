package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static Connection connection;
    public static void iniciarConexao(){

        try{

            if(connection==null) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
                System.out.println("CONEXAO REALIZADA COM SUCESSO");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Erro ao tentar realizar uma conexão");
        }
    }
    public static Connection getConnection(){

        return connection;
    }
}
