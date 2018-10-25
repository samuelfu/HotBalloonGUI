import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author jrk based on cay horstmann
 *
 */
public class HW4Runner {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		JSlider mySlider = new JSlider(SwingConstants.VERTICAL,0,10,5);
		
		final GroupOfObjects myObj = new MassAscension();

		final MyIcon myIcon = new MyIcon(myObj, ICON_W, ICON_H);

		final JLabel myLabel = new JLabel(myIcon);

		myFrame.add(myLabel);
		myFrame.add(mySlider);
		myFrame.setLayout(new FlowLayout());
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);

		int delay = 50;
		myObj.jitter(1);
		// Milliseconds between timer ticks
		Timer myTimer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				myObj.massTranslate(0, -1);
				myLabel.repaint();
			}
		});
		myTimer.start();
		
		mySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				myTimer.setDelay( mySlider.getValue() * 10);
			}
		});
		
	}

	private static final int ICON_W = 600;
	private static final int ICON_H = 1000;
}
