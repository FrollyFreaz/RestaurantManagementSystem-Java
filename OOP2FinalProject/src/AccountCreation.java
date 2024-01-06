import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controllers.DataFile;
import Controllers.Infopass;
import Models.UserInfo;

public class AccountCreation extends JFrame implements ActionListener{
	private JTextField createMail,createPhone,createName1,createName2;
	private JPasswordField createPassword;
	private JButton confirmButton;
	private JLabel create,lFirst,lLast,lEmail,lPassword,lPhone,
	lcopyright1,lcopyright2,lcopyright3,lcopyright4,lcopyright5,lcopyright6;
	
	public AccountCreation() {
		Cursor cr = new Cursor(Cursor.HAND_CURSOR);
        
        create = new JLabel("Account creation");
        create.setBounds(Resolution.getPixelsfromPrcntg(1, 0.13909224) ,Resolution.getPixelsfromPrcntg(2, 0.01464) ,Resolution.getPixelsfromPrcntg(1, 0.17), Resolution.getPixelsfromPrcntg(2, 0.02196));
		create.setFont(new Font("Roman",Font.BOLD,26));
		create.setForeground(Color.BLACK);
		
		lFirst = new JLabel("First name ");
		lFirst.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.0732) ,Resolution.getPixelsfromPrcntg(1, 0.078) ,Resolution.getPixelsfromPrcntg(2, 0.04392));
		lFirst.setFont(new Font("Courrier",Font.PLAIN,20));
		
		lLast = new JLabel("Last name ");
		lLast.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.109809) ,Resolution.getPixelsfromPrcntg(1, 0.078) ,Resolution.getPixelsfromPrcntg(2, 0.04396));
		lLast.setFont(new Font("Courrier",Font.PLAIN,20));
		
		lEmail = new JLabel("Mail ");
		lEmail.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.146412884) ,Resolution.getPixelsfromPrcntg(1, 0.078) ,Resolution.getPixelsfromPrcntg(2, 0.04392));
		lEmail.setFont(new Font("Courrier",Font.PLAIN,20));
		
		lPassword = new JLabel("Password ");
		lPassword.setFont(new Font("Courrier",Font.PLAIN,20));                                                                
		lPassword.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.183016105) ,Resolution.getPixelsfromPrcntg(1, 0.078) ,Resolution.getPixelsfromPrcntg(2, 0.04392));
		
		lPhone = new JLabel("Phone ");
		lPhone.setFont(new Font("Courrier",Font.PLAIN,20));
		lPhone.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.219619326) ,Resolution.getPixelsfromPrcntg(1, 0.078) ,Resolution.getPixelsfromPrcntg(2, 0.04392));
		
		lcopyright1 = new JLabel();
		lcopyright1.setText("\"Restoland\" is protected as a trademark in Lebanon Patent \nand Trademark Law,and");
		lcopyright1.setFont(new Font("Courrier",Font.ITALIC,10));
		lcopyright1.setBounds(Resolution.getPixelsfromPrcntg(1, 0.017) ,Resolution.getPixelsfromPrcntg(2, 0.29) ,Resolution.getPixelsfromPrcntg(1, 0.307) ,Resolution.getPixelsfromPrcntg(2, 0.0732));
		
		lcopyright2 = new JLabel();
		lcopyright2.setText(" by International Trademark and Intellectual Property Laws and Treaties as a buisness");
		lcopyright2.setFont(new Font("Courrier",Font.ITALIC,10));
		lcopyright2.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.3) ,Resolution.getPixelsfromPrcntg(1, 0.318) ,Resolution.getPixelsfromPrcntg(2, 0.0732));
		
		lcopyright3 = new JLabel();
		lcopyright3.setText("which has been in continuous use since December16,2022. Unauthorized use of");
		lcopyright3.setFont(new Font("Courrier",Font.ITALIC,10));
		lcopyright3.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.31) ,Resolution.getPixelsfromPrcntg(1, 0.300146412) ,Resolution.getPixelsfromPrcntg(2, 0.0732));
		
		lcopyright4 = new JLabel();
		lcopyright4.setText(" the \"Restoland\" trademark is strictly prohibited .The \"Restoland\" trademark");
		lcopyright4.setFont(new Font("Courrier",Font.ITALIC,10));
		lcopyright4.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.32) ,Resolution.getPixelsfromPrcntg(1, 0.300146412) ,Resolution.getPixelsfromPrcntg(2, 0.0732));
		
		lcopyright5 = new JLabel();
		lcopyright5.setText("All other trademarks, product names and company names or logos cited");
		lcopyright5.setFont(new Font("Courrier",Font.ITALIC,10));
		lcopyright5.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.33) ,Resolution.getPixelsfromPrcntg(1, 0.300146412) ,Resolution.getPixelsfromPrcntg(2, 0.0732));
		
		lcopyright6 = new JLabel();
		lcopyright6.setText("herein are the property of their respective owners.");
		lcopyright6.setFont(new Font("Courrier",Font.ITALIC,10));
		lcopyright6.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.34) ,Resolution.getPixelsfromPrcntg(1, 0.300146412) ,Resolution.getPixelsfromPrcntg(2, 0.0732));
		
		createName1 = new JTextField();
		createName1.setBounds(Resolution.getPixelsfromPrcntg(1, 0.109809) ,Resolution.getPixelsfromPrcntg(2, 0.080527086) ,Resolution.getPixelsfromPrcntg(1, 0.19765) ,Resolution.getPixelsfromPrcntg(2, 0.02196));
		createName1.setBorder(BorderFactory.createBevelBorder(1, Color.GREEN, Color.BLACK));
		
		createName2 = new JTextField();
		createName2.setBounds(Resolution.getPixelsfromPrcntg(1, 0.109809) ,Resolution.getPixelsfromPrcntg(2, 0.117130307) ,Resolution.getPixelsfromPrcntg(1, 0.19765) ,Resolution.getPixelsfromPrcntg(2, 0.02196));
		createName2.setBorder(BorderFactory.createBevelBorder(1, Color.GREEN, Color.BLACK));
		
		createMail = new JTextField();
		createMail.setText("");
		createMail.setSelectedTextColor(Color.DARK_GRAY);
		createMail.setBounds(Resolution.getPixelsfromPrcntg(1, 0.109809) ,Resolution.getPixelsfromPrcntg(2, 0.153733528) ,Resolution.getPixelsfromPrcntg(1, 0.19765) ,Resolution.getPixelsfromPrcntg(2, 0.02196));
		createMail.setBorder(BorderFactory.createBevelBorder(1, Color.GREEN, Color.BLACK));
		
		createPassword = new JPasswordField();
		createPassword.setBounds(Resolution.getPixelsfromPrcntg(1, 0.109809) ,Resolution.getPixelsfromPrcntg(2, 0.190336749) ,Resolution.getPixelsfromPrcntg(1, 0.19765) ,Resolution.getPixelsfromPrcntg(2, 0.02196));
		createPassword.setBorder(BorderFactory.createBevelBorder(1, Color.GREEN, Color.BLACK));
		
		createPhone = new JTextField();
		createPhone.setBounds(Resolution.getPixelsfromPrcntg(1, 0.109809) ,Resolution.getPixelsfromPrcntg(2, 0.22693997) ,Resolution.getPixelsfromPrcntg(1, 0.19765) ,Resolution.getPixelsfromPrcntg(2, 0.02196));
		createPhone.setBorder(BorderFactory.createBevelBorder(1, Color.GREEN, Color.BLACK));
		
		confirmButton = new JButton();
		confirmButton.setBounds(Resolution.getPixelsfromPrcntg(1, 0.36603221) ,Resolution.getPixelsfromPrcntg(2, 0.27818448) ,Resolution.getPixelsfromPrcntg(1, 0.0732) ,Resolution.getPixelsfromPrcntg(2, 0.024158125));
		confirmButton.setBackground(Color.WHITE);
		confirmButton.setText("Confirm");
		confirmButton.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.GREEN));
		confirmButton.addActionListener(this);
		confirmButton.setCursor(cr);
		
		this.setLayout(null);
		this.add(create);
		this.add(lFirst);
		this.add(lLast);
		this.add(lEmail);
		this.add(lPassword);
		this.add(lPhone);
		this.add(createName1);
		this.add(createName2);
		this.add(createMail);
		this.add(createPassword);
		this.add(createPhone);
		this.add(lcopyright1);
		this.add(lcopyright2);
		this.add(lcopyright3);
		this.add(lcopyright4);
		this.add(lcopyright5);
		this.add(confirmButton);
		this.setTitle(EntryForm.RESTAURANT_NAME);
		this.setBounds(Resolution.getPixelsfromPrcntg(1, 0.270863836) ,Resolution.getPixelsfromPrcntg(2, 0.124450951) ,Resolution.getPixelsfromPrcntg(1, 0.474377745) ,Resolution.getPixelsfromPrcntg(2, 0.43));
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int counter;
		
		if(e.getSource().equals(confirmButton)) {
			counter=0;
			Infopass pass =new Infopass();
			if (!pass.phoneSyntax(createPhone.getText()) || !pass.phoneUnique(createPhone.getText())) {
				JOptionPane.showMessageDialog(null,"Phone can not be referenced with symbols or letters!"
						,"Error",JOptionPane.ERROR_MESSAGE);
				counter++;
			}
			else if(!pass.passName(createName1.getText()) || !pass.passName(createName2.getText())) {
				JOptionPane.showMessageDialog(null,"Name can only be using letters!"
						,"Error",JOptionPane.ERROR_MESSAGE);
				counter++;
			}
			else if(!pass.mailSyntax(createMail.getText()) || !pass.mailUnique(createMail.getText())) {
				JOptionPane.showMessageDialog(null,"Mail format cannot be accepted!"
						,"Error",JOptionPane.ERROR_MESSAGE);
				counter++;
			}
			if(counter==0) {
				@SuppressWarnings("deprecation")
				String g_Pass =createPassword.getText();
				int jaweb=JOptionPane.showConfirmDialog(null,"Save the information?"
						,"Error",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,EntryForm.MAIN_ICON);
				if(jaweb==0) {
					UserInfo user = new UserInfo(createName1.getText(), createName2.getText(), createMail.getText(),
							g_Pass,createPhone.getText(),'A');
					pass.generateUID(user);
					DataFile.users.add(user);
				DataFile dtF = new DataFile();
				try {
					dtF.saveToClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.setVisible(false);
				LoginForm goodToGo = new LoginForm();
				this.removeAll();
				}
			}
		}
		
	}
	
}
