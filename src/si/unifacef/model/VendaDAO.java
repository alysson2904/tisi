/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package si.unifacef.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import si.unifacef.pojo.Cliente;

/**
 *
 * @author Vitor
 */
public class VendaDAO {
    //CONSULTAR CLIENTE POR CPF
    public int consultaCpf(Cliente cliente){
        String cpf = cliente.getCpf();
        PreparedStatement canal;
        ResultSet rs;
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_cliente where cpf = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Cliente clientes = new Cliente();
                    clientes.setCodigo(rs.getInt("codigo"));
                    clientes.setNome(rs.getString("nome"));
                    clientes.setEndereco(rs.getString("endereco"));
                    //cliente.setRg(rs.getString("rg"));
                    clientes.setCpf(rs.getString("cpf"));
                    clientes.setCidade(rs.getString("cidade"));
                    clientes.setEstado(rs.getString("estado"));
                    cliente.add(clientes);
                }
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }
    
}
