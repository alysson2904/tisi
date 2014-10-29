/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package si.unifacef.com.br.controller;

import si.unifacef.model.ClienteDAO;
import si.unifacef.pojo.Cliente;

/**
 *
 * @author Vitor
 */
public class ClienteController {
    public int insereCliente (Cliente cliente){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.insere(cliente);
    }
}
