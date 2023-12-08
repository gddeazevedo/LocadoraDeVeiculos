package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import controller.MainController;
import exception.CNHException;
import exception.CPFException;
import exception.EmailException;
import exception.ValidadeCNHException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.Font;

import java.awt.event.WindowEvent;
import java.io.Serial;
import java.io.Serializable;

public class ClienteView extends JFrame implements Serializable {
    @Serial
    private static final long serialVersionUID = 7169403174654824820L;

    // Pessoa fisica
    private JTextField textNomeFisico;
    private JTextField textTelefoneFisico;
    private JTextField textCpf;
    private JTextField textEmailFisico;
    private JTextField textCnh;
    private JTextField textValidadeCNH;
    private JTextField textRuaFisico;
    private JTextField textNumeroFisico;
    private JTextField textCepFisico;


    private JTextField textNomeJuridico;
    private JTextField textTelefoneJuridico;
    private JTextField textCnpj;
    private JTextField textContato;
    private JTextField textEmailJuridico;
    private JTextField textRuaJuridico;
    private JTextField textNumeroJuridico;
    private JTextField textCepJuridico;

    public ClienteView() {
        setTitle("Cadastro de Clientes");
        setBounds(433, 164, 500, 500);
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 424, 0 };
        gridBagLayout.rowHeights = new int[] { 20, 241, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        contentPanel.setLayout(gridBagLayout);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        contentPanel.add(panel, gbc_panel);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setToolTipText("");
        GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
        gbc_tabbedPane.fill = GridBagConstraints.BOTH;
        gbc_tabbedPane.gridx = 0;
        gbc_tabbedPane.gridy = 1;
        contentPanel.add(tabbedPane, gbc_tabbedPane);

        showPessoaFisicaTabContent(tabbedPane);
        showPessoaJuridicaTabContent(tabbedPane);
    }

    private void showPessoaFisicaTabContent(JTabbedPane tabbedPane) {
        JPanel panel = new JPanel();
        tabbedPane.addTab("Pessoa Fisica", null, panel, null);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 46, 0, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 14, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel_1);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> actionSalvarPessoaFisica());
        btnSalvar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
        gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
        gbc_btnSalvar.gridx = 0;
        gbc_btnSalvar.gridy = 1;
        panel.add(btnSalvar, gbc_btnSalvar);

        JLabel lblNomeFisico = new JLabel("Nome:");
        lblNomeFisico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNomeFisico = new GridBagConstraints();
        gbc_lblNomeFisico.insets = new Insets(0, 0, 5, 5);
        gbc_lblNomeFisico.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNomeFisico.gridx = 1;
        gbc_lblNomeFisico.gridy = 1;
        panel.add(lblNomeFisico, gbc_lblNomeFisico);

        textNomeFisico = new JTextField();
        GridBagConstraints gbc_textNomeFisico = new GridBagConstraints();
        gbc_textNomeFisico.insets = new Insets(0, 0, 5, 0);
        gbc_textNomeFisico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNomeFisico.gridx = 2;
        gbc_textNomeFisico.gridy = 1;
        panel.add(textNomeFisico, gbc_textNomeFisico);
        textNomeFisico.setColumns(10);

        JLabel lblTelefoneFisico = new JLabel("Telefone:");
        lblTelefoneFisico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblTelefoneFisico = new GridBagConstraints();
        gbc_lblTelefoneFisico.anchor = GridBagConstraints.EAST;
        gbc_lblTelefoneFisico.insets = new Insets(0, 0, 5, 5);
        gbc_lblTelefoneFisico.gridx = 1;
        gbc_lblTelefoneFisico.gridy = 2;
        panel.add(lblTelefoneFisico, gbc_lblTelefoneFisico);

        textTelefoneFisico = new JTextField();
        GridBagConstraints gbc_textTelefoneFisico = new GridBagConstraints();
        gbc_textTelefoneFisico.insets = new Insets(0, 0, 5, 0);
        gbc_textTelefoneFisico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textTelefoneFisico.gridx = 2;
        gbc_textTelefoneFisico.gridy = 2;
        panel.add(textTelefoneFisico, gbc_textTelefoneFisico);
        textTelefoneFisico.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.EAST;
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.gridx = 1;
        gbc_lblEmail.gridy = 3;
        panel.add(lblEmail, gbc_lblEmail);

        textEmailFisico = new JTextField();
        GridBagConstraints gbc_textEmailFisico = new GridBagConstraints();
        gbc_textEmailFisico.insets = new Insets(0, 0, 5, 0);
        gbc_textEmailFisico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textEmailFisico.gridx = 2;
        gbc_textEmailFisico.gridy = 3;
        panel.add(textEmailFisico, gbc_textEmailFisico);
        textEmailFisico.setColumns(10);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblCpf = new GridBagConstraints();
        gbc_lblCpf.anchor = GridBagConstraints.EAST;
        gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
        gbc_lblCpf.gridx = 1;
        gbc_lblCpf.gridy = 5;
        panel.add(lblCpf, gbc_lblCpf);

        textCpf = new JTextField();
        GridBagConstraints gbc_textCpf = new GridBagConstraints();
        gbc_textCpf.insets = new Insets(0, 0, 5, 0);
        gbc_textCpf.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCpf.gridx = 2;
        gbc_textCpf.gridy = 5;
        panel.add(textCpf, gbc_textCpf);
        textCpf.setColumns(10);

        JLabel lblCnh = new JLabel("CNH:");
        lblCnh.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblCnh = new GridBagConstraints();
        gbc_lblCnh.anchor = GridBagConstraints.EAST;
        gbc_lblCnh.insets = new Insets(0, 0, 0, 5);
        gbc_lblCnh.gridx = 1;
        gbc_lblCnh.gridy = 6;
        panel.add(lblCnh, gbc_lblCnh);

        textCnh = new JTextField();
        GridBagConstraints gbc_textCnh = new GridBagConstraints();
        gbc_textCnh.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCnh.gridx = 2;
        gbc_textCnh.gridy = 6;
        panel.add(textCnh, gbc_textCnh);
        textCnh.setColumns(10);

        JLabel lblValidadeCnh = new JLabel("Validade CNH:");
        lblValidadeCnh.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblValidadeCnh = new GridBagConstraints();
        gbc_lblValidadeCnh.anchor = GridBagConstraints.EAST;
        gbc_lblValidadeCnh.insets = new Insets(0, 0, 0, 5);
        gbc_lblValidadeCnh.gridx = 1;
        gbc_lblValidadeCnh.gridy = 7;
        panel.add(lblValidadeCnh, gbc_lblValidadeCnh);

        textValidadeCNH = new JTextField();
        GridBagConstraints gbc_textValidadeCnh = new GridBagConstraints();
        gbc_textValidadeCnh.fill = GridBagConstraints.HORIZONTAL;
        gbc_textValidadeCnh.gridx = 2;
        gbc_textValidadeCnh.gridy = 7;
        panel.add(textValidadeCNH, gbc_textValidadeCnh);
        textValidadeCNH.setColumns(10);

        JLabel lblRuaFisico = new JLabel("Rua:");
        lblRuaFisico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblRuaFisico = new GridBagConstraints();
        gbc_lblRuaFisico.anchor = GridBagConstraints.EAST;
        gbc_lblRuaFisico.insets = new Insets(0, 0, 0, 5);
        gbc_lblRuaFisico.gridx = 1;
        gbc_lblRuaFisico.gridy = 8;
        panel.add(lblRuaFisico, gbc_lblRuaFisico);

        textRuaFisico = new JTextField();
        GridBagConstraints gbc_textRuaFisico = new GridBagConstraints();
        gbc_textRuaFisico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textRuaFisico.gridx = 2;
        gbc_textRuaFisico.gridy = 8;
        panel.add(textRuaFisico, gbc_textRuaFisico);
        textRuaFisico.setColumns(10);

        JLabel lblNumeroFisico = new JLabel("Numero:");
        lblNumeroFisico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNumeroFisico = new GridBagConstraints();
        gbc_lblNumeroFisico.anchor = GridBagConstraints.EAST;
        gbc_lblNumeroFisico.insets = new Insets(0, 0, 0, 5);
        gbc_lblNumeroFisico.gridx = 1;
        gbc_lblNumeroFisico.gridy = 9;
        panel.add(lblNumeroFisico, gbc_lblNumeroFisico);

        textNumeroFisico = new JTextField();
        GridBagConstraints gbc_textNumeroFisico = new GridBagConstraints();
        gbc_textNumeroFisico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNumeroFisico.gridx = 2;
        gbc_textNumeroFisico.gridy = 9;
        panel.add(textNumeroFisico, gbc_textNumeroFisico);
        textNumeroFisico.setColumns(10);

        JLabel lblCepFisico = new JLabel("CEP:");
        lblCepFisico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblCepFisico = new GridBagConstraints();
        gbc_lblCepFisico.anchor = GridBagConstraints.EAST;
        gbc_lblCepFisico.insets = new Insets(0, 0, 0, 5);
        gbc_lblCepFisico.gridx = 1;
        gbc_lblCepFisico.gridy = 10;
        panel.add(lblCepFisico, gbc_lblCepFisico);

        textCepFisico = new JTextField();
        GridBagConstraints gbc_textCepFisico = new GridBagConstraints();
        gbc_textCepFisico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCepFisico.gridx = 2;
        gbc_textCepFisico.gridy = 10;
        panel.add(textCepFisico, gbc_textCepFisico);
        textCepFisico.setColumns(10);
    }

    private void showPessoaJuridicaTabContent(JTabbedPane tabbedPane) {
        JPanel panel = new JPanel();
        tabbedPane.addTab("Pessoa Juridica", null, panel, null);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel_2);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> actionSalvarPessoaJuridica());
        btnSalvar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
        gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
        gbc_btnSalvar.gridx = 0;
        gbc_btnSalvar.gridy = 1;
        panel.add(btnSalvar, gbc_btnSalvar);

        textNomeJuridico = new JTextField();
        JLabel lblNomeJuridico = new JLabel("Nome:");
        lblNomeJuridico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNomeJuridico = new GridBagConstraints();
        gbc_lblNomeJuridico.insets = new Insets(0, 0, 5, 5);
        gbc_lblNomeJuridico.anchor = GridBagConstraints.EAST;
        gbc_lblNomeJuridico.gridx = 1;
        gbc_lblNomeJuridico.gridy = 1;
        panel.add(lblNomeJuridico, gbc_lblNomeJuridico);

        // Pessoa juridica
        GridBagConstraints gbc_textNomeJuridico = new GridBagConstraints();
        gbc_textNomeJuridico.insets = new Insets(0, 0, 5, 0);
        gbc_textNomeJuridico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNomeJuridico.gridx = 2;
        gbc_textNomeJuridico.gridy = 1;
        panel.add(textNomeJuridico, gbc_textNomeJuridico);
        textNomeJuridico.setColumns(10);

        JLabel lblTelefoneJuridico = new JLabel("Telefone:");
        lblTelefoneJuridico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblTelefoneJuridico = new GridBagConstraints();
        gbc_lblTelefoneJuridico.anchor = GridBagConstraints.EAST;
        gbc_lblTelefoneJuridico.insets = new Insets(0, 0, 5, 5);
        gbc_lblTelefoneJuridico.gridx = 1;
        gbc_lblTelefoneJuridico.gridy = 2;
        panel.add(lblTelefoneJuridico, gbc_lblTelefoneJuridico);

        textTelefoneJuridico = new JTextField();
        GridBagConstraints gbc_textTelefoneJuridico = new GridBagConstraints();
        gbc_textTelefoneJuridico.insets = new Insets(0, 0, 5, 0);
        gbc_textTelefoneJuridico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textTelefoneJuridico.gridx = 2;
        gbc_textTelefoneJuridico.gridy = 2;
        panel.add(textTelefoneJuridico, gbc_textTelefoneJuridico);
        textTelefoneJuridico.setColumns(10);

        JLabel lblEmailJuridico = new JLabel("Email:");
        lblEmailJuridico.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblEmailJuridico = new GridBagConstraints();
        gbc_lblEmailJuridico.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmailJuridico.anchor = GridBagConstraints.EAST;
        gbc_lblEmailJuridico.gridx = 1;
        gbc_lblEmailJuridico.gridy = 3;
        panel.add(lblEmailJuridico, gbc_lblEmailJuridico);

        textEmailJuridico = new JTextField();
        GridBagConstraints gbc_textEmailJuridico = new GridBagConstraints();
        gbc_textEmailJuridico.insets = new Insets(0, 0, 5, 0);
        gbc_textEmailJuridico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textEmailJuridico.gridx = 2;
        gbc_textEmailJuridico.gridy = 3;
        panel.add(textEmailJuridico, gbc_textEmailJuridico);
        textEmailJuridico.setColumns(10);

        JLabel lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblCnpj = new GridBagConstraints();
        gbc_lblCnpj.anchor = GridBagConstraints.EAST;
        gbc_lblCnpj.insets = new Insets(0, 0, 5, 5);
        gbc_lblCnpj.gridx = 1;
        gbc_lblCnpj.gridy = 5;
        panel.add(lblCnpj, gbc_lblCnpj);

        textCnpj = new JTextField();
        GridBagConstraints gbc_textCnpj = new GridBagConstraints();
        gbc_textCnpj.insets = new Insets(0, 0, 5, 0);
        gbc_textCnpj.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCnpj.gridx = 2;
        gbc_textCnpj.gridy = 5;
        panel.add(textCnpj, gbc_textCnpj);
        textCnpj.setColumns(10);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblContato = new GridBagConstraints();
        gbc_lblContato.anchor = GridBagConstraints.EAST;
        gbc_lblContato.insets = new Insets(0, 0, 0, 5);
        gbc_lblContato.gridx = 1;
        gbc_lblContato.gridy = 6;
        panel.add(lblContato, gbc_lblContato);

        textContato = new JTextField();
        GridBagConstraints gbc_textContato = new GridBagConstraints();
        gbc_textContato.fill = GridBagConstraints.HORIZONTAL;
        gbc_textContato.gridx = 2;
        gbc_textContato.gridy = 6;
        panel.add(textContato, gbc_textContato);
        textContato.setColumns(10);

        JLabel lblRua = new JLabel("Rua:");
        lblRua.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblRua = new GridBagConstraints();
        gbc_lblRua.anchor = GridBagConstraints.EAST;
        gbc_lblRua.insets = new Insets(0, 0, 0, 5);
        gbc_lblRua.gridx = 1;
        gbc_lblRua.gridy = 7;
        panel.add(lblRua, gbc_lblRua);

        textRuaJuridico = new JTextField();
        GridBagConstraints gbc_textRuaJuridico = new GridBagConstraints();
        gbc_textRuaJuridico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textRuaJuridico.gridx = 2;
        gbc_textRuaJuridico.gridy = 7;
        panel.add(textRuaJuridico, gbc_textRuaJuridico);
        textContato.setColumns(10);

        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNumero = new GridBagConstraints();
        gbc_lblNumero.anchor = GridBagConstraints.EAST;
        gbc_lblNumero.insets = new Insets(0, 0, 0, 5);
        gbc_lblNumero.gridx = 1;
        gbc_lblNumero.gridy = 8;
        panel.add(lblNumero, gbc_lblNumero);

        textNumeroJuridico = new JTextField();
        GridBagConstraints gbc_textNumeroJuridico = new GridBagConstraints();
        gbc_textNumeroJuridico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNumeroJuridico.gridx = 2;
        gbc_textNumeroJuridico.gridy = 8;
        panel.add(textNumeroJuridico, gbc_textNumeroJuridico);
        textContato.setColumns(10);

        JLabel lblCep = new JLabel("CEP:");
        lblCep.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblCep = new GridBagConstraints();
        gbc_lblCep.anchor = GridBagConstraints.EAST;
        gbc_lblCep.insets = new Insets(0, 0, 0, 5);
        gbc_lblCep.gridx = 1;
        gbc_lblCep.gridy = 9;
        panel.add(lblCep, gbc_lblCep);

        textCepJuridico = new JTextField();
        GridBagConstraints gbc_textCepJuridico = new GridBagConstraints();
        gbc_textCepJuridico.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCepJuridico.gridx = 2;
        gbc_textCepJuridico.gridy = 9;
        panel.add(textCepJuridico, gbc_textCepJuridico);
        textContato.setColumns(10);
    }

    private void actionSalvarPessoaFisica() {
       try {
           ClienteController clienteController = MainController.getClienteController();
           String nome = textNomeFisico.getText();
           String telefone = textTelefoneFisico.getText();
           String email = textEmailFisico.getText();
           String cpf = textCpf.getText();
           String numCNH = textCnh.getText();
           String validadeCNH = textValidadeCNH.getText();
           String rua = textRuaFisico.getText();
           String numero = textNumeroFisico.getText();
           String cep = textCepFisico.getText();

           clienteController.addPessoaFisica(nome, email, telefone, cpf, numCNH, validadeCNH, rua, numero, cep);
           JOptionPane.showMessageDialog(this, "Cadastrado com Sucesso");
           this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
       } catch (EmailException emailException) {
           JOptionPane.showMessageDialog(this, emailException.getMessage());
           textEmailFisico.setText("");
       } catch (CNHException cnhException) {
           JOptionPane.showMessageDialog(this, cnhException.getMessage());
           textCnh.setText("");
       } catch (CPFException | ValidadeCNHException e) {
           JOptionPane.showMessageDialog(this, e.getMessage());
           textCpf.setText("");
       }
    }

    protected void actionSalvarPessoaJuridica() {
        try {
            ClienteController pessoaController = MainController.getClienteController();
            String nome = textNomeJuridico.getText();
            String telefone = textTelefoneJuridico.getText();
            String email = textEmailJuridico.getText();
            String cnpj = textCnpj.getText();
            String contato = textContato.getText();
            String rua = textRuaJuridico.getText();
            String numero = textNumeroJuridico.getText();
            String cep = textCepJuridico.getText();
            pessoaController.addPessoaJuridica(nome, email, telefone, cnpj, contato, rua, numero, cep);
            JOptionPane.showMessageDialog(this, "Cadastrado com Sucesso");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } catch (EmailException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            textEmailJuridico.setText("");
        }
    }
}
