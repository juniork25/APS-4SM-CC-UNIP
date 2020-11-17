/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;


public class BdLivro {
    
    /* ----CONEXÃO COM O BD-> */
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdLivro() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----LIVRO-> */
    
    // CREATE - Adiciona um registro
    public void adicionaLivro(Book l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO livro(name, author, publisher, ano, disponibilidade)"
                + "VALUES(?, ?, ?, ?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setString(1, l.getNome());
        stmt.setString(2, l.getAuthor());
        stmt.setString(3, String.valueOf(l.getPublisher()));
        stmt.setString(4, String.valueOf(l.getIsbn()));
        stmt.setDouble(5, l.getPreco());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Book> getLista(String nome) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM livro WHERE exemplar like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Book> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Book l = new Book();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            l.setId(Integer.valueOf(rs.getString("id_livro")));
            l.setNome(rs.getString("nome"));
            l.setAuthor(rs.getString("author"));
            l.setPublisher(rs.getString("publisher"));
            l.setIsbn(rs.getString("isbn"));
            l.setPreco(Double.valueOf(rs.getString("preco")));
            
            // Adiciona o registro na lista
            lista.add(l);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // UPDATE - Atualiza registros
    public void altera(Book l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE livro set exemplar=?, autor=?, edicao=?, ano=?, disponibilidade=?"
                + "WHERE id_livro=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setString(1, l.getNome());
        stmt.setString(2, l.getAuthor());
        stmt.setString(2, l.getPublisher());
        stmt.setString(2, l.getIsbn());
        stmt.setString(4, String.valueOf(l.getPreco()));
        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(6, l.getId());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
    
    // UPDATE - Altera a disponibilidade do livro
    public void alteraDisponibilidadeLivro(Book l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE livro set disponibilidade=?"
                + "WHERE id_livro=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"  
        stmt.setDouble(1, l.getPreco());
        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(2, l.getId());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
    
    // DELETE - Apaga registros
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM livro WHERE id_livro=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, id);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();
        
    }
    /* <-LIVRO---- */
}
