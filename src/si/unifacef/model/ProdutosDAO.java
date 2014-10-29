package si.unifacef.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import si.unifacef.pojo.Produtos;


public class ProdutosDAO {
    public int insere(Produtos produtos){
        int result = 0;
        String nome = produtos.getNome();
        String descricao = produtos.getDescricao();
        String preco = produtos.getPreco();
        PreparedStatement canal;
        try{
            BancoDados.conexao();
            String sql;
            sql = "insert into tb_produtos (nome, descricao, preco) values (?, ?, ?)";
            
            canal = BancoDados.conexao.prepareStatement(sql);
            canal.setString(1, nome);
            canal.setString(2, descricao);
            canal.setString(3, preco);
            result = canal.executeUpdate();
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }
    
    //***************************CONSULTA*****************************
    
    public ArrayList<Produtos> consulta(){
        PreparedStatement canal;
        ResultSet rs;
        ArrayList<Produtos> produtos = new ArrayList();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_produtos order by nome";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Produtos produto = new Produtos();
                    produto.setCodigo(rs.getInt("codigo"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getString("preco"));
                    produtos.add(produto);
                }
            return produtos;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    //*****************************REMOVE************************
    
    public int remove(Produtos produto){
        int result = 0;
        int codigo = produto.getCodigo();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql = "delete from tb_produtos where codigo = ?";
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
    
    /**************************ATUALIZA*******************************/
    
     public int atualiza(Produtos produto){
        int result = 0;
        int codigo = produto.getCodigo();
        String nome = produto.getNome();
        String descricao = produto.getDescricao();
        String preco = produto.getPreco();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "update tb_produtos set nome = ?, descricao = ?, preco = ? where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            canal.setString(1, nome);
            canal.setString(2, descricao);            
            canal.setString(3, preco);
            canal.setInt(4, codigo);
            
            result = canal.executeUpdate();
            return result; // retorna 1
        }
        catch(Exception e){
            System.out.println(e);
            return -1; // indica o erro
        }
    }
     //CONSULTA PRODUTOS TELA CAIXA
     public int consultaProdutoCaixa(Produtos produtos){
         int result = 0;
        PreparedStatement canal;
        ResultSet rs;
        int codigo = produtos.getCodigo();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_produtos";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Produtos produto = new Produtos();
                    produto.setCodigo(rs.getInt("codigo"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getString("preco"));

                
                    result = canal.executeUpdate();
                    return result;
                }
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
        return 0;
    }
     
     //CONSULTA POR CODIGO
    public Produtos consultaCodigo(Produtos produto){
         
        int codigo = produto.getCodigo();
        PreparedStatement canal;
        ResultSet rs;
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_produtos where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            canal.setInt(1, codigo);
            rs = canal.executeQuery();
              Produtos produtos = new Produtos();
                while(rs.next()){
                   
                  
                    produtos.setCodigo(rs.getInt("codigo"));
                    produtos.setNome(rs.getString("nome"));
                    produtos.setDescricao(rs.getString("descricao"));
                    produtos.setPreco(rs.getString("preco"));
                     return produtos;
                }
                return null;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
