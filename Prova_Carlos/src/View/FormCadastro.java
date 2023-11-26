package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controller.BdUsuario;
import Model.Usuario;
import View.FormLogin;


public class FormCadastro extends JFrame {

    JLabel lblNome,lblLogin,lblSenha,lblEmail;
    JTextField txtNome,txtLogin,txtSenha,txtEmail;

    JButton btnSalvar,btnLogar;


    public FormCadastro() {
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //pnlCADASTRO

        JPanel pnlCadastro = new JPanel();
        pnlCadastro.setLayout(new GridLayout(5,2));
        TitledBorder Cadastro = new TitledBorder("CADASTRO");
        pnlCadastro.setBorder(Cadastro);

        lblNome = new JLabel("Nome:");
        lblLogin = new JLabel("Login:");
        lblSenha = new JLabel("Senha:");
        lblEmail = new JLabel("Email:");

        txtNome = new JTextField();
        txtLogin = new JTextField();
        txtSenha = new JTextField();
        txtEmail = new JTextField();

        btnSalvar = new JButton("Salvar");
        btnLogar = new JButton("Logar");

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario user = new Usuario();
                    user.setNome(txtNome.getText());
                    user.setLogin(txtLogin.getText());
                    user.setSenha(txtSenha.getText());
                    user.setEmail(txtEmail.getText());

                    BdUsuario u = new BdUsuario();
                    u.adicionaUsuario(user);

                    JOptionPane.showMessageDialog(null,"Usuário Cadastrado com Sucesso");

                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Erro ao Cadastrar Usuário");
                }
            }
        });

        btnLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormLogin formLogin = new FormLogin();
            }
        });


        pnlCadastro.add(lblNome);
        pnlCadastro.add(txtNome);
        pnlCadastro.add(lblLogin);
        pnlCadastro.add(txtLogin);
        pnlCadastro.add(lblSenha);
        pnlCadastro.add(txtSenha);
        pnlCadastro.add(lblEmail);
        pnlCadastro.add(txtEmail);
        pnlCadastro.add(btnSalvar);
        pnlCadastro.add(btnLogar);

        frame.add(pnlCadastro,BorderLayout.NORTH);
        frame.setVisible(true);








    }

}
