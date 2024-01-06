import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Models.UserInfo;

public class Client extends JFrame{
	private Profile userProfile;
	private ClientReservation userReservation;
	
	public Client(UserInfo user) {
		userProfile = new Profile(user);
		userProfile.setBounds(0 ,0 ,Resolution.getPixelsfromPrcntg(1, 0.235) ,(int) this.getMaximumSize().getHeight());
		userProfile.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.DARK_GRAY));
		userReservation = new ClientReservation(user);
		userReservation.setBounds(Resolution.getPixelsfromPrcntg(1, 0.235) ,0 ,Resolution.getPixelsfromPrcntg(1, 0.834) ,Resolution.getPixelsfromPrcntg(2, 1));
		this.setLayout(null);
		this.add(userProfile);
		this.add(userReservation);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setBounds(Resolution.getPixelsfromPrcntg(1, 0.22) ,Resolution.getPixelsfromPrcntg(2, 0.1464) ,Resolution.getPixelsfromPrcntg(1, 0.434) ,Resolution.getPixelsfromPrcntg(1, 0.359));
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}
	
}
