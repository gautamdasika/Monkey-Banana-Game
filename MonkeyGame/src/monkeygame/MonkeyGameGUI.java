package monkeygame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MonkeyGameGUI extends JFrame {
	JLabel statusbar;
	Wonderland wl;
	private int score=0;
	private int mainTime=0;
	private int bananaTime=0;
	public MonkeyGameGUI() throws HeadlessException {
		// TODO Auto-generated constructor stub
		initUI();
	}
	public void initUI(){
		statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);
        wl=new Wonderland(statusbar);
		add(wl);
		pack();
		setTitle("Monkey Banana");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void setMainTime(int mainTime) {
		this.mainTime = mainTime;
		repaint();
	}
	public void setBananaTime(int bananaTime) {
		this.bananaTime = bananaTime;
		repaint();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new MonkeyGameGUI();
                ex.setVisible(true);                
            }
        });
	}

}
