/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package si.unifacef.com.br.controller;

import si.unifacef.model.ProdutosDAO;
import si.unifacef.pojo.Produtos;

/**
 *
 * @author Vitor
 */
public class ProdutosController {
    public int insereProdutos (Produtos produto){
        ProdutosDAO produtosDAO = new ProdutosDAO();
        return produtosDAO.insere(produto);
    }
}
