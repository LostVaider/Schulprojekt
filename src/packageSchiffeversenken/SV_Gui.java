package packageSchiffeversenken;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SV_Gui extends JFrame implements MouseListener {

	private Steuerung steuerung;
	private ZeichenFlaeche zeichenFlaeche;

	public SV_Gui(Steuerung steuerung) {

		super();

		this.steuerung = steuerung;

		setTitle("Schiffeversenken");
		getContentPane().setLayout(null);

		setSize(1150, 800);
		setLocationRelativeTo(null);

		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// Button anlegen
		JButton button = new JButton("Hilfe!");
		menuBar.add(button);
		button.setBounds(60, 600, 220, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog((JButton) e.getSource(), "Regeln.");

			}
		});

		repaint();

		ZeichenflächeMachen();
	}

	public void ZeichenflächeMachen() {

		zeichenFlaeche = new ZeichenFlaeche();
		zeichenFlaeche.setLayout(null);
		zeichenFlaeche.setBounds(0, 0, 1150, 800);
		zeichenFlaeche.setBackground(Color.WHITE);
		// zeichenFlaeche.setBorder(border);
		zeichenFlaeche.addMouseListener(this);
		// zeichenFlaeche.addMouseMotionListener(this);
		getContentPane().add(zeichenFlaeche);
	}

	private class ZeichenFlaeche extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics zeichenFlaeche) {
			super.paintComponent(zeichenFlaeche);
			zeichne(zeichenFlaeche);

			repaint();

		}
	}

	public void zeichne(Graphics g)

	{
		int fontSize = 15;
		Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
		g.setFont(f);
		g.setColor(Color.BLACK);

		for (int x = 50; x <= 550; x = x + 50) {

			g.drawLine(x, 50, x, 550);
			g.drawLine(50, x, 550, x);
		}

		for (int x = 50; x <= 550; x = x + 50) {
			g.drawLine(x + 550, 50, x + 550, 550);
			g.drawLine(600, x, 1100, x);
		}

		for (int zahlen = 1; zahlen <= 11; zahlen++) {

			for (int x = 65; x <= 550; x = x + 50)

			{
				g.drawString("" + zahlen++, x, 30);
			}
		}
		for (int zahlen = 1; zahlen <= 10; zahlen++) {

			for (int x = 75; x <= 550; x = x + 50) {
				g.drawString("" + zahlen++, 20, x);

			}
		}
		for (int zahlen = 1; zahlen <= 10; zahlen++) {

			for (int x = 615; x <= 1100; x = x + 50) {
				g.drawString("" + zahlen++, x, 30);

			}
		}
		for (int zahlen = 1; zahlen <= 10; zahlen++) {

			for (int x = 75; x <= 550; x = x + 50) {
				g.drawString("" + zahlen++, 575, x);

			}
			g.drawString("Spielfeld1", 260, 600);
			g.drawString("Spielfeld2", 820, 600);
		}

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {

				if (steuerung.getSpielfeldElement(1, x - 1, y - 1) != 0) {
					g.fillRect(x * 50, y * 50, 50, 50);

				}

				if (steuerung.getSpielfeldElement(2, x - 1, y - 1) != 0) {
					g.fillRect(550 + x * 50, y * 50, 50, 50);

				}
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX() / 50;
		int y = e.getY() / 50;

		if (x <= 10) {

			System.out.println("Feld1: x:" + x + " y:" + y);
			steuerung.setxyK(x, y, 1, 1);
		} else {
			x = x - 11;
			System.out.println("Feld2: x:" + x + " y:" + y);

			steuerung.setxyK(x, y, 2, 2);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}