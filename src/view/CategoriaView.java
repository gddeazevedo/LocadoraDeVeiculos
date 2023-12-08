package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CatalogoController;
import controller.MainController;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.io.Serial;
import java.io.Serializable;

public class CategoriaView extends JFrame implements Serializable {
    @Serial
    private static final long serialVersionUID = -5659880888694503154L;

    private final JTextField textNome;
    private final JTextField textTarifaDiaria;

    public CategoriaView() {
        setTitle("Categoria");
        setBounds(433, 164, 500, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Adicionar Categoria");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);

        JLabel nome = new JLabel("Nome:");
        nome.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        GridBagConstraints gbc_nome = new GridBagConstraints();
        gbc_nome.insets = new Insets(0, 0, 5, 5);
        gbc_nome.anchor = GridBagConstraints.EAST;
        gbc_nome.gridx = 1;
        gbc_nome.gridy = 1;
        panel_1.add(nome, gbc_nome);

        textNome = new JTextField();
        GridBagConstraints gbc_textNome = new GridBagConstraints();
        gbc_textNome.insets = new Insets(0, 0, 5, 0);
        gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNome.gridx = 2;
        gbc_textNome.gridy = 1;
        panel_1.add(textNome, gbc_textNome);
        textNome.setColumns(10);

        JLabel percenturalTarifa = new JLabel("Tarifa Diaria:");
        percenturalTarifa.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        GridBagConstraints gbc_percenturalTarifa = new GridBagConstraints();
        gbc_percenturalTarifa.anchor = GridBagConstraints.EAST;
        gbc_percenturalTarifa.insets = new Insets(0, 0, 5, 5);
        gbc_percenturalTarifa.gridx = 1;
        gbc_percenturalTarifa.gridy = 3;
        panel_1.add(percenturalTarifa, gbc_percenturalTarifa);

        textTarifaDiaria = new JTextField();
        GridBagConstraints gbc_textTarifaDiaria = new GridBagConstraints();
        gbc_textTarifaDiaria.insets = new Insets(0, 0, 5, 0);
        gbc_textTarifaDiaria.fill = GridBagConstraints.HORIZONTAL;
        gbc_textTarifaDiaria.gridx = 2;
        gbc_textTarifaDiaria.gridy = 3;
        panel_1.add(textTarifaDiaria, gbc_textTarifaDiaria);
        textTarifaDiaria.setColumns(10);

        JButton btnSalvar = new JButton("SALVAR");
        btnSalvar.setBackground(Color.LIGHT_GRAY);
        btnSalvar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnSalvar.addActionListener(e -> actionSalvar());
        GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
        gbc_btnSalvar.insets = new Insets(0, 0, 5, 0);
        gbc_btnSalvar.gridx = 2;
        gbc_btnSalvar.gridy = 4;
        panel_1.add(btnSalvar, gbc_btnSalvar);

    }

    protected void actionSalvar() {
        CatalogoController catalogoController = MainController.getCatalogoController();

        String nome = textNome.getText();
        double tarifaDiaria = Double.parseDouble(textTarifaDiaria.getText());

        catalogoController.addCategoria(nome, tarifaDiaria);
        JOptionPane.showMessageDialog(this, "Cadastrado com Sucesso");
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
