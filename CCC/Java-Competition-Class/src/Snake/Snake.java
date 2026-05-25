package Snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel {

	static int xlen = 1200, ylen = 600, xv = 0, yv = 0, tc1 = 60, tc2 = 30, gs = 20, px = (int) (Math.random() * tc1),
			py = (int) (Math.random() * tc2), ax = (int) (Math.random() * tc1), ay = (int) (Math.random() * tc2),
			tail = 5;
	static ArrayList<int[]> trail = new ArrayList<int[]>();

	public Snake() {
		setPreferredSize(new Dimension(xlen, ylen));
		setBackground(Color.black);

		new Timer(0, (ActionEvent e) -> {
			game();
			repaint();
			try {
				Thread.sleep(1000 / 15);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}).start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trail.add(new int[] { px, py });
		JFrame f = new JFrame();
		f.addKeyListener(new keyListener());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Snake");
		f.add(new Snake(), BorderLayout.CENTER);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

	public static void game() {
		px += xv;
		py += yv;
		if (px < 0) {
			px = tc1 - 1;
		}
		if (px > tc1 - 1) {
			px = 0;
		}
		if (py < 0) {
			py = tc2 - 1;
		}
		if (py > tc2 - 1) {
			py = 0;
		}
	}

	void painter(Graphics2D g) {
		g.setColor(Color.green);
		for (int i = 0; i < trail.size() - 1; i++) {
			g.fillRect((trail.get(i)[0] * gs) + 2, (trail.get(i)[1] * gs) + 2, gs - 4, gs - 4);
			if (trail.get(i)[0] == px && trail.get(i)[1] == py) {
				tail = 5;
			}
		}
		g.fillRect((trail.get(trail.size() - 1)[0] * gs) + 1, (trail.get(trail.size() - 1)[1] * gs) + 1, gs - 2,
				gs - 2);
		trail.add(new int[] { px, py });
		while (trail.size() > tail) {
			trail.remove(0);
		}

		if (ax == px && ay == py) {
			tail++;
			ax = (int) (Math.random() * tc1);
			ay = (int) (Math.random() * tc2);
		}

		g.setColor(Color.red);
		g.fillRect((ax * gs) + 1, (ay * gs) + 1, gs - 2, gs - 2);
	}

	@Override
	public void paintComponent(Graphics gg) {
		super.paintComponent(gg);
		Graphics2D g = (Graphics2D) gg;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		painter(g);
	}

}
