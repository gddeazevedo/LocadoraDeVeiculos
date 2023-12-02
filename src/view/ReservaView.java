package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Cliente;
import controller.MainController;
import controller.ServicosController;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ReservaView extends JFrame implements Serializable {
    @Serial
    private static final long serialVersionUID = -8123454427135734983L;

    private final JTextField textDataInicio;
    private final JTextField textDataFim;
    private final JComboBox<Categoria> comboBoxCategoriaVeiculo;
    private final JList<String> listSeguro;
    private final JComboBox<Cliente> comboBoxCliente;


    public ReservaView() {
        setTitle("Reserva");
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Cadastro Reserva");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.DARK_GRAY);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionSalvar();
            }
        });
        btnSalvar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
        GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
        gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
        gbc_btnSalvar.gridx = 0;
        gbc_btnSalvar.gridy = 0;
        panel_1.add(btnSalvar, gbc_btnSalvar);


        JLabel lblCategoriaVeiculo = new JLabel("Categoria do Veiculo");
        lblCategoriaVeiculo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblCategoriaVeiculo = new GridBagConstraints();
        gbc_lblCategoriaVeiculo.anchor = GridBagConstraints.EAST;
        gbc_lblCategoriaVeiculo.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategoriaVeiculo.gridx = 1;
        gbc_lblCategoriaVeiculo.gridy = 1;
        panel_1.add(lblCategoriaVeiculo, gbc_lblCategoriaVeiculo);

        comboBoxCategoriaVeiculo = new JComboBox<>(MainController.getCatalogoController().getDefaultComboBoxModelForCategoria());
        GridBagConstraints gbc_comboBoxCategoriaVeiculo = new GridBagConstraints();
        gbc_comboBoxCategoriaVeiculo.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxCategoriaVeiculo.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCategoriaVeiculo.gridx = 2;
        gbc_comboBoxCategoriaVeiculo.gridy = 1;
        panel_1.add(comboBoxCategoriaVeiculo, gbc_comboBoxCategoriaVeiculo);

        JLabel lblNewLabel_1 = new JLabel("Datas no formato:");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 2;
        panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

        JLabel lblDataInicio = new JLabel("Data de Inicio:");
        lblDataInicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblDataInicio = new GridBagConstraints();
        gbc_lblDataInicio.anchor = GridBagConstraints.EAST;
        gbc_lblDataInicio.insets = new Insets(0, 0, 5, 5);
        gbc_lblDataInicio.gridx = 1;
        gbc_lblDataInicio.gridy = 2;
        panel_1.add(lblDataInicio, gbc_lblDataInicio);

        textDataInicio = new JTextField();
        GridBagConstraints gbc_textDataInicio = new GridBagConstraints();
        gbc_textDataInicio.insets = new Insets(0, 0, 5, 0);
        gbc_textDataInicio.fill = GridBagConstraints.HORIZONTAL;
        gbc_textDataInicio.gridx = 2;
        gbc_textDataInicio.gridy = 2;
        panel_1.add(textDataInicio, gbc_textDataInicio);
        textDataInicio.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("(DD/MM/YYYY)");
        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 3;
        panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

        JLabel lblDataFim = new JLabel("Data de Fim:");
        lblDataFim.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblDataFim = new GridBagConstraints();
        gbc_lblDataFim.anchor = GridBagConstraints.EAST;
        gbc_lblDataFim.insets = new Insets(0, 0, 5, 5);
        gbc_lblDataFim.gridx = 1;
        gbc_lblDataFim.gridy = 3;
        panel_1.add(lblDataFim, gbc_lblDataFim);

        textDataFim = new JTextField();
        GridBagConstraints gbc_textDataFim = new GridBagConstraints();
        gbc_textDataFim.insets = new Insets(0, 0, 5, 0);
        gbc_textDataFim.fill = GridBagConstraints.HORIZONTAL;
        gbc_textDataFim.gridx = 2;
        gbc_textDataFim.gridy = 3;
        panel_1.add(textDataFim, gbc_textDataFim);
        textDataFim.setColumns(10);

        JLabel lblSeguros = new JLabel("Seguros:");
        lblSeguros.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblSeguros = new GridBagConstraints();
        gbc_lblSeguros.anchor = GridBagConstraints.EAST;
        gbc_lblSeguros.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeguros.gridx = 1;
        gbc_lblSeguros.gridy = 4;
        panel_1.add(lblSeguros, gbc_lblSeguros);

        listSeguro = new JList<String>(new Vector<>(MainController.getCatalogoController().getSeguros()));
        GridBagConstraints gbc_listSeguro = new GridBagConstraints();
        gbc_listSeguro.insets = new Insets(0, 0, 5, 0);
        gbc_listSeguro.fill = GridBagConstraints.BOTH;
        gbc_listSeguro.gridx = 2;
        gbc_listSeguro.gridy = 4;
        panel_1.add(listSeguro, gbc_listSeguro);


        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_lblCliente = new GridBagConstraints();
        gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
        gbc_lblCliente.anchor = GridBagConstraints.EAST;
        gbc_lblCliente.gridx = 1;
        gbc_lblCliente.gridy = 6;
        panel_1.add(lblCliente, gbc_lblCliente);

        comboBoxCliente = new JComboBox<>(MainController.getClienteController().getDefaultComboBoxModelForCliente());

        GridBagConstraints gbc_comboBoxCliente = new GridBagConstraints();
        gbc_comboBoxCliente.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCliente.gridx = 2;
        gbc_comboBoxCliente.gridy = 6;
        panel_1.add(comboBoxCliente, gbc_comboBoxCliente);
    }

    private void actionSalvar() {
        ServicosController servicosController = MainController.getServicosController();

        Categoria categoria = (Categoria) comboBoxCategoriaVeiculo.getSelectedItem();
        Date dInicio;
        List<String> seguros = listSeguro.getSelectedValuesList();
        Cliente cliente = (Cliente) comboBoxCliente.getSelectedItem();
        Date dFim;

        try {
            dInicio = new SimpleDateFormat("dd/MM/yyyy").parse(textDataInicio.getText());
            dFim = new SimpleDateFormat("dd/MM/yyyy").parse(textDataFim.getText());
            JOptionPane.showMessageDialog(this, "Cadastrado com Sucesso");
            servicosController.addReserva(categoria, dInicio, dFim, cliente, seguros);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, String.format("Data invalida. Favor inserir no formato dd/mm/aaaa!"),
                    "Data invalida", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }

    }

}
