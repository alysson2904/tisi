package si.unifacef.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import si.unifacef.pojo.Cliente;

public class ClienteDAO {
    public int insere(Cliente cliente){
        int result = 0;
        String nome = cliente.getNome();
        String endereco = cliente.getEndereco();
       // String rg = cliente.getRg();
        String cpf = cliente.getCpf();
        String cidade = cliente.getCidade();
        String estado = cliente.getEstado();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "insert into tb_cliente (cpf, nome, endereco, cidade, estado) values (?, ?, ?, ?, ?)";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            canal.setString(1, cpf);
            canal.setString(2, nome);
            //canal.setString(3, rg);
            canal.setString(3, endereco);
            canal.setString(4, cidade);
            canal.setString(5, estado);
            result = canal.executeUpdate();
            return result; // retorna 1
        }
        catch(Exception e){
            System.out.println(e);
            return -1; // indica o erro
        }
    }
    //**************************remove**********************
    public int remove(Cliente cliente){
        int result = 0;
        int codigo = cliente.getCodigo();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql = "delete from tb_cliente where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql);
            canal.setInt(1, codigo);
            result = canal.executeUpdate();
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }        
    

    //**************atualiza******************
    public int atualizar(Cliente cliente){
        int result = 0;
        int codigo = cliente.getCodigo();
        String nome = cliente.getNome();
        String endereco = cliente.getEndereco();
        String cpf = cliente.getCpf();
        String cidade = cliente.getCidade();
        String estado = cliente.getEstado();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "update tb_cliente set nome = ?, cpf = ?, endereco = ?, cidade = ?, estado = ? where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            canal.setString(1, nome);
            canal.setString(2, cpf);            
            canal.setString(3, endereco);
            canal.setString(4, cidade);
            canal.setString(5, estado);
            canal.setInt(6, codigo);
            
            result = canal.executeUpdate();
            return result; // retorna 1
        }
        catch(Exception e){
            System.out.println(e);
            return -1; // indica o erro
        }
    }

    //*************consulta*************
   
    public ArrayList<Cliente> consulta(){
        PreparedStatement canal;
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_cliente";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(rs.getInt("codigo"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEndereco(rs.getString("endereco"));
                    //cliente.setRg(rs.getString("rg"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setCidade(rs.getString("cidade"));
                    cliente.setEstado(rs.getString("estado"));
                    clientes.add(cliente);
                }
            return clientes;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    
    //CONSULTAR CLIENTE POR CPF
    public Cliente consultaCpf(Cliente cliente){
         
        String cpf = cliente.getCpf();
        PreparedStatement canal;
        ResultSet rs;
        try{
            BancoDados.conexao(); // método
            System.out.println("Entrou");
            String sql;
            sql = "select * from tb_cliente where cpf = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            System.out.println("Entrou");
            canal.setString(1, cpf);
            rs = canal.executeQuery();
            System.out.println("Entrou");
              Cliente clientes = new Cliente();
                while(rs.next()){
                   
                  
                    clientes.setCodigo(rs.getInt("codigo"));
                    clientes.setNome(rs.getString("nome"));
                    clientes.setEndereco(rs.getString("endereco"));
                    clientes.setCpf(rs.getString("cpf"));
                    clientes.setCidade(rs.getString("cidade"));
                    clientes.setEstado(rs.getString("estado"));
                     return clientes;
                }
                return null;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    
    
}
