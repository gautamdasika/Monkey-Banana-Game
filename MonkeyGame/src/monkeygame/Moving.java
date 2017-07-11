package monkeygame;

import java.awt.event.KeyEvent;

public class Moving extends State {

	@Override
	public State keyReleased(Monkey monkey, KeyEvent e) {
		// TODO Auto-generated method stub
		return new Idle();
	}
	@Override
	public State keyPressed(Monkey monkey, KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && monkey.getX()!=0) {
        	int x=monkey.getX();
        	int dx=monkey.getSTEP_SIZE();
        	monkey.setX(x-=dx);        			
        }

        if (key == KeyEvent.VK_RIGHT && monkey.getX()!=monkey.getBOARD_SIDE()-monkey.getSTEP_SIZE()) {
        	int x=monkey.getX();
        	int dx=monkey.getSTEP_SIZE();
        	monkey.setX(x+=dx); 
        }

        if (key == KeyEvent.VK_UP && monkey.getY()!=0) {
        	int y=monkey.getY();
        	int dy=monkey.getSTEP_SIZE();
        	monkey.setY(y-=dy); 
        }

        if (key == KeyEvent.VK_DOWN && monkey.getY()!=monkey.getBOARD_SIDE()-monkey.getSTEP_SIZE()) {
        	int y=monkey.getY();
        	int dy=monkey.getSTEP_SIZE();
        	monkey.setY(y+=dy);
        }
		return this;
	}

}
