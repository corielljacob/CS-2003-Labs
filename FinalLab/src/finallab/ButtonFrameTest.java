package finallab;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ButtonFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				Lab frame = new Lab();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		}
);

	}

}
