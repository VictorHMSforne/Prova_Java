package View;

import Controller.BdUsuario;
import Model.Usuario;
import Controller.BdUsuario;
import View.FormCadastro;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;







public class FormLogin extends Frame {

    JLabel lblLogin,lblSenha;

    JTextField txtLogin,txtSenha;

    JButton btnEntrar,btnCadastrar;

    public FormLogin(){
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel pnlLogin = new JPanel();
        pnlLogin.setLayout(new GridLayout(3,2));
        TitledBorder Login = new TitledBorder("LOGIN");
        pnlLogin.setBorder(Login);

        lblLogin = new JLabel("Login:");
        lblSenha = new JLabel("Senha:");

        txtLogin = new JTextField();
        txtSenha =  new JTextField();

        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");

        pnlLogin.add(lblLogin);
        pnlLogin.add(txtLogin);
        pnlLogin.add(lblSenha);
        pnlLogin.add(txtSenha);
        pnlLogin.add(btnEntrar);
        pnlLogin.add(btnCadastrar);

        frame.add(pnlLogin,BorderLayout.NORTH);
        frame.setVisible(true);

        btnEntrar.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario user = new Usuario();
                    user.setLogin(txtLogin.getText());
                    user.setSenha(txtSenha.getText());

                    BdUsuario u = new BdUsuario(); // instancia um objeto do BDusaurio


                    if (u.pesquisaUsuario(user)) { //uso um método do BdUsuario, para o objeto user realizar a mesma coisa
                        JOptionPane.showMessageDialog(null, "Usuário Logado com Sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário.");
                }

            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCadastro cadastro = new FormCadastro();

            }
        });



    }


}

