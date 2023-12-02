package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serial;
import java.io.Serializable;

public class ServicosView extends JFrame implements Serializable {
    @Serial
    private static final long serialVersionUID = -4719141453780206841L;

    public ServicosView() {
        setTitle("SistemaDaLocadora");
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Menu Servicos");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);

        JButton btnFazerReserva = new JButton("Fazer Reserva");
        btnFazerReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionReservaView();
            }
        });
        btnFazerReserva.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_btnFazerReserva = new GridBagConstraints();
        gbc_btnFazerReserva.anchor = GridBagConstraints.WEST;
        gbc_btnFazerReserva.insets = new Insets(0, 0, 5, 5);
        gbc_btnFazerReserva.gridx = 1;
        gbc_btnFazerReserva.gridy = 1;
        panel_1.add(btnFazerReserva, gbc_btnFazerReserva);

        JButton btnFazerLocacao = new JButton("Fazer Locacao");
        btnFazerLocacao.addActionListener(e -> actionLocacaoView());
        btnFazerLocacao.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_btnFazerLocacao = new GridBagConstraints();
        gbc_btnFazerLocacao.anchor = GridBagConstraints.WEST;
        gbc_btnFazerLocacao.insets = new Insets(0, 0, 5, 5);
        gbc_btnFazerLocacao.gridx = 1;
        gbc_btnFazerLocacao.gridy = 2;
        panel_1.add(btnFazerLocacao, gbc_btnFazerLocacao);

        JButton btnValoresLocacao = new JButton("Valores Da Locacao");
        btnValoresLocacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionValoresLocacaoView();
            }
        });
        btnValoresLocacao.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_btnValoresLocacao = new GridBagConstraints();
        gbc_btnValoresLocacao.anchor = GridBagConstraints.WEST;
        gbc_btnValoresLocacao.insets = new Insets(0, 0, 5, 5);
        gbc_btnValoresLocacao.gridx = 1;
        gbc_btnValoresLocacao.gridy = 3;
        panel_1.add(btnValoresLocacao, gbc_btnValoresLocacao);

        JButton btnRealizarDevolucao = new JButton("Realizar Devolucao");
        btnRealizarDevolucao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionDevolucaoView();
            }
        });
        btnRealizarDevolucao.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        GridBagConstraints gbc_btnRealizarDevolucao = new GridBagConstraints();
        gbc_btnRealizarDevolucao.anchor = GridBagConstraints.WEST;
        gbc_btnRealizarDevolucao.insets = new Insets(0, 0, 5, 5);
        gbc_btnRealizarDevolucao.gridx = 1;
        gbc_btnRealizarDevolucao.gridy = 4;
        panel_1.add(btnRealizarDevolucao, gbc_btnRealizarDevolucao);
    }

    private void actionLocacaoView() {
        LocacaoView locacaoView = new LocacaoView();
        locacaoView.setVisible(true);
    }

    private void actionReservaView() {
        ReservaView reservaView = new ReservaView();
        reservaView.setVisible(true);
    }

    private void actionValoresLocacaoView() {
        ValoresLocacaoView valoresLocacaoView = new ValoresLocacaoView();
        valoresLocacaoView.setVisible(true);
    }

    private void actionDevolucaoView() {
        DevolucaoView devolucaoView = new DevolucaoView();
        devolucaoView.setVisible(true);
    }
}
