package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

public class PagementoView  extends JFrame implements Serializable {
    @Serial
    private static final long serialVersionUID = -7223244303135066346L;


    public PagementoView() {
        setTitle("Pagamentos");
        setBounds(433, 164, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }
}
