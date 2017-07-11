package monkeygame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Wonderland extends JPanel implements ActionListener {
	private final int P_WIDTH=700;
	private final int P_HEIGHT=700;
	private final int RAND_POS = 10;
	private final int BLOCK_SIZE=P_WIDTH/10;
	private final int DELAY = 1000;
	
	private int mainTime=30;
	private int bananaTime=10;
	
	private Banana banana;
	private Monkey monkey;
	
	private Timer timer;
	private int score;
	private JLabel statusbar;
	
	public Wonderland(JLabel statusbar) {
		// TODO Auto-generated constructor stub
		this.statusbar=statusbar;
	     initWonderland();
	}
	
	private void initWonderland(){
		addKeyListener(new TAdapter());
		 setBackground(Color.green);
	     setFocusable(true);
	     setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
	     monkey=new Monkey(BLOCK_SIZE,P_WIDTH);
	     banana=new Banana();
	     score=0;
	     loadImages();
		locateBanana();
		locateMonkey();
		timer = new Timer(DELAY, this);
	    timer.start();
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }
	 private void doDrawing(Graphics g) {
	        if(mainTime>0){
	        	Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(Color.white);
	        g2d.drawImage(banana.getImage(), banana.getX(), banana.getY(), BLOCK_SIZE,BLOCK_SIZE, this);
	        g2d.drawImage(monkey.getImage(), monkey.getX(), monkey.getY(), BLOCK_SIZE,BLOCK_SIZE, this);
	        }
	        else{
	        	timer.stop();
	        	gameOver(g);	        	
	        }
	    }
	 private void gameOver(Graphics g) {
		 String msg;
	        if(score>15)
	        msg = "You won! your score is ";
	        else
	        msg = "You lost! your score is ";
	        Font small = new Font("Helvetica", Font.BOLD, 30);
	        FontMetrics metr = getFontMetrics(small);

	        g.setColor(Color.blue);
	        g.setFont(small);
	        g.drawString(msg+score, (P_WIDTH - metr.stringWidth(msg)) / 2, P_HEIGHT / 2);
	    }
	 private void loadImages() {

	        ImageIcon iid = new ImageIcon(this.getClass().getResource("/banana.png"));
	        banana.setImage(iid.getImage());

	        ImageIcon iia = new ImageIcon(this.getClass().getResource("/monkey.png"));
	        monkey.setImage(iia.getImage());
	    }
		

	private void locateBanana() {

        int r = (int) (Math.random() * RAND_POS);
        banana.setX(r * BLOCK_SIZE);

        r = (int) (Math.random() * RAND_POS);
        banana.setY(r * BLOCK_SIZE);
    }
	private void locateMonkey() {

        int r = (int) (Math.random() * RAND_POS);
        monkey.setX(r * BLOCK_SIZE);

        r = (int) (Math.random() * RAND_POS);
        monkey.setY(r * BLOCK_SIZE);
    }
	 private void checkBanana() {

	        if ((banana.getX()==monkey.getX()) && (banana.getY()==monkey.getY())) {
	            score++;
	            statusbar.setText("score:  "+score+"   time left:"+mainTime+"   eat banana in"+bananaTime);
	            locateBanana();
	            bananaTime=10;
	        }
	    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		mainTime--;
		bananaTime--;
		statusbar.setText("score: "+score+"   time left: "+mainTime+"   eat banana in: "+bananaTime);
		if(bananaTime==0){
			locateBanana();
			bananaTime=10;
		}
		repaint();
	}
	public class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e){
			monkey.keyReleased(e);
			//checkBanana();
			//repaint();
		}
		@Override
		public void keyPressed(KeyEvent e){
			monkey.keyPressed(e);
			checkBanana();
			repaint();
		}
	}
}
