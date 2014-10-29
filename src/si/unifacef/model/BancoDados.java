package si.unifacef.model;
import java.sql.*;

public class BancoDados {
    static Connection conexao; // representa a conexão com o banco
    static Statement canal; // representa o canal de comunicação
    public static Connection conexao(){ // public para as classes DAO acessarem ele    
        try{
            // carrega o driver de conexão
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/APLICACAO_COMERCIAL";
            // conecta ao banco de dados
            conexao = DriverManager.getConnection(url, "postgres", "info2013");
            return conexao;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
            return null; // indica o erro
        }
    }
}
