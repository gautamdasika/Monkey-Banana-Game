package monkeygame;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Monkey {
	private Image image;
	private int X;
	private int Y;
	private State state;
	private final int STEP_SIZE;
	private final int BOARD_SIDE;
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		try {
			state=state.keyReleased(this,e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			if(state==null){
				System.out.println("Null");
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		try {
			state=state.keyPressed(this,e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			if(state==null){
				System.out.println("Null");
			}
		}

	}
	public Monkey(int STEP_SIZE,int BOARD_SIDE) {
		this.STEP_SIZE=STEP_SIZE;
		this.BOARD_SIDE=BOARD_SIDE;
		state=new Idle();
	}
	public int getBOARD_SIDE() {
		return BOARD_SIDE;
	}
	public int getSTEP_SIZE() {
		return STEP_SIZE;
	}
}
