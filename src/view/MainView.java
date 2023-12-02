package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.Serial;
import java.io.Serializable;

public class MainView extends JFrame implements Serializable {
    @Serial
    private static final long serialVersionUID = 517294119658988912L;

    public MainView() {
        setTitle("Locadora de veculos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel menuPanel = new JPanel();
        contentPane.add(menuPanel, BorderLayout.NORTH);

        JLabel menuLabel = new JLabel("Menu Principal");
        menuLabel.setForeground(Color.DARK_GRAY);
        menuLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        menuPanel.add(menuLabel);

        JPanel buttonsPanel = new JPanel();
        contentPane.add(buttonsPanel, BorderLayout.CENTER);

        initCatalogoButton(buttonsPanel);
        initServicosButton(buttonsPanel);
        initClientesButton(buttonsPanel);
        initListagemButton(buttonsPanel);
    }

    private void initCatalogoButton(JPanel panel) {
          JButton btnCatalogo = new JButton("Catalogo");
          btnCatalogo.addActionListener(e -> actionCatalogoView());
          btnCatalogo.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
          GridBagConstraints gbc_btnCatalogo = new GridBagConstraints();
          gbc_btnCatalogo.anchor = GridBagConstraints.WEST;
          gbc_btnCatalogo.insets = new Insets(0, 0, 5, 5);
          gbc_btnCatalogo.gridx = 1;
          gbc_btnCatalogo.gridy = 0;
          panel.add(btnCatalogo, gbc_btnCatalogo);
    }

    private void initServicosButton(JPanel panel) {
        JButton btnServicos = new JButton("Serviços");
        btnServicos.addActionListener(e -> actionServicosView());
        btnServicos.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_btnServicos = new GridBagConstraints();
        gbc_btnServicos.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnServicos.insets = new Insets(0, 0, 5, 5);
        gbc_btnServicos.gridx = 2;
        gbc_btnServicos.gridy = 0;
        panel.add(btnServicos, gbc_btnServicos);
    }

    private void initClientesButton(JPanel panel) {
        JButton btnNewButton = new JButton("Clientes");
        btnNewButton.addActionListener(e -> actionClienteView());
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnNewButton.gridx = 3;
        gbc_btnNewButton.gridy = 0;
        panel.add(btnNewButton, gbc_btnNewButton);
    }

    private void initListagemButton(JPanel panel) {
        JButton btnListagem = new JButton("Listagem");
        btnListagem.addActionListener(e -> actionListagemView());
        btnListagem.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        GridBagConstraints gbc_btnListagem = new GridBagConstraints();
        gbc_btnListagem.insets = new Insets(0, 0, 5, 5);
        gbc_btnListagem.gridx = 1;
        gbc_btnListagem.gridy = 1;
        panel.add(btnListagem, gbc_btnListagem);
    }

    private void actionCatalogoView() {
        CatalogoView catalogoView = new CatalogoView();
        catalogoView.setVisible(true);
    }

    private void actionServicosView() {
        ServicosView servicosView = new ServicosView();
        servicosView.setVisible(true);
    }

    private void actionClienteView() {
        ClienteView clienteView = new ClienteView();
        clienteView.setVisible(true);
    }

    private void actionListagemView() {
        ListagemView listagemView = new ListagemView();
        listagemView.setVisible(true);
    }
}
