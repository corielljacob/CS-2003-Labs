package finallab;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab extends JFrame  {
		private JPanel buttonPanel;
		private static final int DEFAULT_WIDTH = 300;
		
		private static final int DEFAULT_HEIGHT = 300;
		
		private int clicks = 0;

		public Lab() {
			setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
			this.setTitle("Color Generator");
			//create buttons
			JButton changeButton = new JButton("Change");
			JButton resetButton = new JButton("Reset");
			JButton closeButton = new JButton("Close");
			
			buttonPanel = new JPanel();
			
			//add buttons to panel
			buttonPanel.add(changeButton);
			buttonPanel.add(resetButton);
			buttonPanel.add(closeButton);
			
			//add panel to frame
			add(buttonPanel);
			
			ColorAction changeAction = new ColorAction(1);
			ColorAction resetAction = new ColorAction(2);
			ColorAction closeAction = new ColorAction(3);
			
			changeButton.addActionListener(changeAction);
			resetButton.addActionListener(resetAction);
			closeButton.addActionListener(closeAction);
		}
		
		private class ColorAction implements ActionListener
		{
			private Color backgroundColor;
			private boolean quit;
			private boolean reset;
			
			public ColorAction(int n) {
				if (n == 2)
					reset = true;
				else if (n == 3)
					quit = true;
				
			}
			
			public void actionPerformed(ActionEvent event)
			{
				if(quit)
					System.exit(0);
				if(reset)
					clicks = 0;
				else
					clicks++;
				if (clicks == 5)
					clicks = 1;
				determineColor();
				buttonPanel.setBackground(backgroundColor);
			}
			
			public void determineColor() {
				if (clicks == 1)
					backgroundColor = (Color.black);
				else if (clicks == 2)
					backgroundColor = (Color.green);
				else if(clicks == 3)
					backgroundColor = (Color.orange);
				else if(clicks == 4)
					backgroundColor = (Color.pink);
			}
		}
		
		
}
