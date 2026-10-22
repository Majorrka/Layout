import javax.swing.*;
import java.awt.*;

public class LayoutDemoApp extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;

    public LayoutDemoApp() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LayoutDemoApp");
        setLayout(new BorderLayout());

        jLabel1.setText("Wybierz uklad:");
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabel1, BorderLayout.NORTH);

        jButton1.setText("FlowLayout");
        jButton2.setText("BorderLayout");
        jButton3.setText("GridLayout");
        jButton4.setText("BoxLayout");
        jButton5.setText("CardLayout");
        jButton6.setText("GridBagLayout");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(jButton3);
        panel.add(jButton4);
        panel.add(jButton5);
        panel.add(jButton6);
        add(panel, BorderLayout.CENTER);

        setSize(300, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame okno = new JFrame("FlowLayout");
        okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        okno.setSize(400, 200);
        okno.setLayout(new FlowLayout());

        okno.add(new JLabel("FlowLayout"));
        for (int i = 1; i <= 8; i++) {
            okno.add(new JButton("Przycisk " + i));
        }
        okno.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame okno = new JFrame("BorderLayout");
        okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        okno.setSize(400, 300);
        okno.setLayout(new BorderLayout());

        okno.add(new JButton("NORTH"), BorderLayout.NORTH);
        okno.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        okno.add(new JButton("WEST"), BorderLayout.WEST);
        okno.add(new JButton("EAST"), BorderLayout.EAST);
        okno.add(new JButton("CENTER"), BorderLayout.CENTER);
        okno.setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame okno = new JFrame("GridLayout");
        okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        okno.setSize(300, 300);
        okno.setLayout(new GridLayout(3, 3));

        for (int i = 1; i <= 9; i++) {
            okno.add(new JButton("" + i));
        }
        okno.setVisible(true);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame okno = new JFrame("BoxLayout");
        okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        okno.setSize(300, 300);
        okno.setLayout(new BoxLayout(okno.getContentPane(), BoxLayout.Y_AXIS));

        okno.add(new JButton("Przycisk 1"));
        okno.add(Box.createRigidArea(new Dimension(0, 20)));
        okno.add(new JButton("Przycisk 2"));
        okno.add(Box.createGlue());
        okno.add(new JButton("Przycisk 3"));
        okno.setVisible(true);
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame okno = new JFrame("CardLayout");
        okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        okno.setSize(350, 250);
        okno.setLayout(new BorderLayout());

        final CardLayout karty = new CardLayout();
        final JPanel panelKart = new JPanel(karty);

        JPanel k1 = new JPanel();
        k1.setBackground(Color.CYAN);
        k1.add(new JLabel("Karta 1"));

        JPanel k2 = new JPanel();
        k2.setBackground(Color.GREEN);
        k2.add(new JLabel("Karta 2"));

        JPanel k3 = new JPanel();
        k3.setBackground(Color.PINK);
        k3.add(new JLabel("Karta 3"));

        panelKart.add(k1, "k1");
        panelKart.add(k2, "k2");
        panelKart.add(k3, "k3");

        JButton wstecz = new JButton("Wstecz");
        JButton dalej = new JButton("Dalej");
        wstecz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                karty.previous(panelKart);
            }
        });
        dalej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                karty.next(panelKart);
            }
        });

        JPanel dol = new JPanel();
        dol.add(wstecz);
        dol.add(dalej);

        okno.add(panelKart, BorderLayout.CENTER);
        okno.add(dol, BorderLayout.SOUTH);
        okno.setVisible(true);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        final JFrame okno = new JFrame("GridBagLayout");
        okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        okno.setSize(350, 200);
        okno.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        okno.add(new JLabel("Login:"), c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1.0;
        okno.add(new JTextField(), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 0;
        okno.add(new JLabel("Haslo:"), c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.weightx = 1.0;
        okno.add(new JPasswordField(), c);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 0.5;
        okno.add(new JButton("Zaloguj"), c);

        JButton anuluj = new JButton("Anuluj");
        anuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                okno.dispose();
            }
        });
        c.gridx = 2;
        c.gridy = 2;
        okno.add(anuluj, c);

        okno.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LayoutDemoApp::new);
    }
}
