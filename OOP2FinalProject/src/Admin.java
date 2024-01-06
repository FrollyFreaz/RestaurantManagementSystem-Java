import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import Models.UserInfo;

public class Admin extends JFrame{
	private Profile userProfile;
	private ContentDisplay contentDisplay;
	
	public Admin(UserInfo user) {
		contentDisplay = new ContentDisplay();
		
		userProfile = new Profile(user);
		userProfile.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.LIGHT_GRAY));
		this.setLayout(null);
		this.add(userProfile);
		this.add(contentDisplay);
		this.setTitle(EntryForm.RESTAURANT_NAME);
		this.setBounds(Resolution.getPixelsfromPrcntg(1, 0.22) ,Resolution.getPixelsfromPrcntg(2, 0.1464) ,Resolution.getPixelsfromPrcntg(1, 1) ,Resolution.getPixelsfromPrcntg(2, 1));
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
