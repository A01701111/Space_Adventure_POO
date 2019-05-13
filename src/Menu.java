import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
	private JPanel panelS;
    private JButton iniciar, salir;
    private CanvasMenu fondo;

    public Menu() {
        super("juego ");
        setSize(1800, 980);
        setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        panelS = new JPanel();
        iniciar = new JButton("START");
        salir = new JButton("EXIT");
        iniciar.addActionListener(this);
        salir.addActionListener(this);

        iniciar.setPreferredSize(new Dimension(150, 60));
        salir.setPreferredSize(new Dimension(150, 60));

        panelS.setLayout(new FlowLayout());
        panelS.setOpaque(true);
        panelS.setBackground(Color.BLUE);
        panelS.setForeground(Color.BLUE);
        panelS.add(iniciar);
        panelS.add(salir);
        fondo = new CanvasMenu("Space Adventure");
        this.add(fondo, BorderLayout.CENTER);
        this.add(panelS, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        // TODO Auto-generated method stub

        if (evento.getSource() == iniciar) {
            MyWindow mv = new MyWindow();
            mv.setVisible(true);
            mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
        } else {
            System.exit(0);

        }
    }

    public JPanel getPanelS() {
        return panelS;
    }

    public void setPanelS(JPanel panelS) {
        this.panelS = panelS;
    }

    public JButton getIniciar() {
        return iniciar;
    }

    public void setIniciar(JButton iniciar) {
        this.iniciar = iniciar;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    public CanvasMenu getFondo() {
        return fondo;
    }

    public void setFondo(CanvasMenu fondo) {
        this.fondo = fondo;
    }
}

