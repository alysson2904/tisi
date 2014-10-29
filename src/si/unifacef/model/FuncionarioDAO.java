package si.unifacef.model;
import si.unifacef.pojo.Funcionario;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class FuncionarioDAO {
    public int insere(Funcionario funcionario){
        int result = 0;
        String nome = funcionario.getNome();
        String cpf = funcionario.getCpf();
        String chapa = funcionario.getChapa();
        String setor = funcionario.getSetor();
        PreparedStatement canal;
        try{
            BancoDados.conexao();
            String sql;
            sql= "insert into tb_funcionario (nome, cpf, chapa, setor) values (?, ?, ?, ?)";           
            canal = BancoDados.conexao.prepareStatement(sql);
            canal.setString(1, nome);
            canal.setString(2, cpf);
            canal.setString(3, chapa);
            canal.setString(4, setor);
            result = canal.executeUpdate();
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
         }
    }
    public int atualizar(Funcionario funcionario){
        return 0;
    }
    
    //*****************CONSULTA*********************************
        public ArrayList<Funcionario> consulta(){
        PreparedStatement canal;
        ResultSet rs;
        ArrayList<Funcionario> funcionarios = new ArrayList();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_funcionario";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setCodigof(rs.getInt("codigof"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setChapa(rs.getString("chapa"));
                    funcionario.setSetor(rs.getString("setor"));
                    funcionarios.add(funcionario);
                }
            return funcionarios;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
        
        //************************REMOVE******************
        
        public int remove(Funcionario funcionario){
        int result = 0;
        int codigof = funcionario.getCodigof();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql = "delete from tb_funcionario where codigof = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql);
            canal.setInt(1, codigof);
            result = canal.executeUpdate();
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }
        
        /********************ATUALIZA***************/
        
        public int atualiza(Funcionario funcionario){
        int result = 0;
        int codigo = funcionario.getCodigof();
        String nome = funcionario.getNome();
        String cpf = funcionario.getCpf();
        String chapa = funcionario.getChapa();
        String setor = funcionario.getSetor();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "update tb_funcionario set nome = ?, cpf = ?, chapa = ?, setor = ? where codigof = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            canal.setString(1, nome);
            canal.setString(2, cpf);            
            canal.setString(3, chapa);
            canal.setString(4, setor);
            canal.setInt(5, codigo);
            
            result = canal.executeUpdate();
            return result; // retorna 1
        }
        catch(Exception e){
            System.out.println(e);
            return -1; // indica o erro
        }
    }
        /*************************CONSULTA POR NOME****************************
        public  ArrayList<Funcionario> buscaNome(){
        ResultSet rs;
        String nome = buscaNome.getNome();
        ArrayList<Funcionario> funcionariosbusca = new ArrayList();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql = "select * from tb_funcionario where nome like nome$";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql);
            rs = canal.executeQuery();
                while(rs.next()){
                    Funcionario funcionariobusca = new Funcionario();
                    funcionario.setCodigof(rs.getInt("codigof"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setChapa(rs.getString("chapa"));
                    funcionario.setSetor(rs.getString("setor"));
                    funcionariosbusca.add(funcionario);
                }
            return funcionariosbusca;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
        }*/
}
           
        


