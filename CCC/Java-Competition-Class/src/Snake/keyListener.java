package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener {
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
		case 37:
		case 65:
			Snake.xv = -1;
			Snake.yv = 0;
			break;
		case 38:
		case 87:
			Snake.xv = 0;
			Snake.yv = -1;
			break;
		case 39:
		case 68:
			Snake.xv = 1;
			Snake.yv = 0;
			break;
		case 40:
		case 83:
			Snake.xv = 0;
			Snake.yv = 1;
			break;
		case 27:
			System.exit(0);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
