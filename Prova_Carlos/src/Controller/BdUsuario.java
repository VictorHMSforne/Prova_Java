package Controller;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Usuario;

import javax.swing.*;

public class BdUsuario  {


    private Connection conexao;

    public BdUsuario() throws SQLException {
        this.conexao = CriarConex.getConexao();
    }

    public void adicionaUsuario(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuario(nome, login, senha, email)" + "VALUES (?,?,?,?)";
        PreparedStatement stmt;
        stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getLogin());
        stmt.setString(3, u.getSenha());
        stmt.setString(4, u.getEmail());

        stmt.execute();
        stmt.close();

    }

    public boolean pesquisaUsuario(Usuario usua) throws SQLException {
        String sql = "SELECT id, nome, login, senha , email from usuario WHERE login = ? and senha = ?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, usua.getLogin());
            stmt.setString(2, usua.getSenha());

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); //aqui retorna true
            }
        }


    }
}