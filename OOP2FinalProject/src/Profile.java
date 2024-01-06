import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.UserInfo;

public class Profile extends JPanel{
	JLabel picture = new JLabel();
	public Profile(UserInfo user) {
	    /*JLabel profile = new JLabel(" Profile");
	    profile.setFont(new Font("Roman",Font.BOLD,30));
	    profile.setBounds(Resolution.getPixelsfromPrcntg(1, 0.066), Resolution.getPixelsfromPrcntg(2, 0.01464), Resolution.getPixelsfromPrcntg(1, 0.09), Resolution.getPixelsfromPrcntg(2, 0.0314));
	    profile.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.GRAY));
	    profile.setForeground(Color.BLACK);
	    */
		JLabel frontName = new JLabel("Name :" + "  " + user.getFirstname() + "  " + user.getLastname());
		frontName.setFont(new Font("Courrier",Font.BOLD,17));
		frontName.setForeground(Color.BLACK);
		JLabel frontID = new JLabel("ID :" + " " + user.getUserID());
		frontID.setFont(new Font("Courrier",Font.BOLD,17));
		frontID.setForeground(Color.BLACK);
		JLabel frontMail = new JLabel("E-mail :" + " " + user.getEmail());
		frontMail.setFont(new Font("Courrier",Font.BOLD,17));
		frontMail.setForeground(Color.BLACK);
		JLabel frontPhone = new JLabel("Phone :" + " " + user.getPhone());
		frontPhone.setFont(new Font("Courrier",Font.BOLD,17));
		frontPhone.setForeground(Color.BLACK);
		JPanel picPanel = new JPanel();
		picPanel.setBackground(Color.BLACK);
		picPanel.setBounds(0, 0, Resolution.getPixelsfromPrcntg(1, 0.25), Resolution.getPixelsfromPrcntg(2, 0.2));
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(4,1));
		infoPanel.add(frontID);
		infoPanel.add(frontName);
		infoPanel.add(frontMail);
		infoPanel.add(frontPhone);
		infoPanel.setBounds(Resolution.getPixelsfromPrcntg(1, 0.003) ,Resolution.getPixelsfromPrcntg(2, 0.2), Resolution.getPixelsfromPrcntg(1, 0.23), Resolution.getPixelsfromPrcntg(2, 0.18));
		infoPanel.setBackground(null);
		infoPanel.setBorder(BorderFactory.createLineBorder(getBackground().darker().darker(), 2, true));
		this.setLayout(null);
		this.add(picPanel);
		this.add(infoPanel);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(0, 0, Resolution.getPixelsfromPrcntg(1, 0.25), Resolution.getPixelsfromPrcntg(2, 0.7));
	}
	
	
}
