import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controllers.Infopass;

public class LoginForm extends JFrame implements KeyListener{
	boolean client=false,admin=false;
	private JLabel login ,lEmail ,lPassword;
	private JTextField mail;
	private JPasswordField password;
	private Infopass info;
	private JPanel white ,black;
	
	public LoginForm() {
		login = new JLabel("Login");
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Courrier",Font.BOLD,Resolution.getPixelsfromPrcntg(2, 0.02)));
		
        white = new JPanel();
        white.setBackground(Color.BLACK);
        white.setBounds(0, 0, Resolution.getPixelsfromPrcntg(1, 0.366), Resolution.getPixelsfromPrcntg(2, 0.0439));
        white.setBorder(BorderFactory.createBevelBorder(1, Color.GREEN, Color.GRAY));
        white.add(login);
        
        black = new JPanel();
        black.setBackground(Color.WHITE);
        black.setBounds(0, 0, Resolution.getPixelsfromPrcntg(1, 0.366), Resolution.getPixelsfromPrcntg(2, 0.2928));
        black.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		
		lEmail = new JLabel("Email");
		lEmail.setForeground(Color.BLACK);
		lEmail.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.0732), Resolution.getPixelsfromPrcntg(1, 0.0732) , Resolution.getPixelsfromPrcntg(2, 0.044));
		lEmail.setFont(new Font("Courrier",Font.PLAIN,20));
		
		mail = new JTextField();
		mail.setText("");
		mail.setSelectedTextColor(Color.DARK_GRAY);
		mail.setBounds(Resolution.getPixelsfromPrcntg(1, 0.11) ,Resolution.getPixelsfromPrcntg(2, 0.08052) ,Resolution.getPixelsfromPrcntg(1, 0.19765) ,Resolution.getPixelsfromPrcntg(2, 0.022));
		mail.addKeyListener(this);
		mail.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.GREEN));
		//
		lPassword = new JLabel("Password");
		lPassword.setForeground(Color.BLACK);
		lPassword.setFont(new Font("Courrier",Font.PLAIN,20));
		lPassword.setBounds(Resolution.getPixelsfromPrcntg(1, 0.01464) ,Resolution.getPixelsfromPrcntg(2, 0.109) ,Resolution.getPixelsfromPrcntg(1, 0.0732) ,Resolution.getPixelsfromPrcntg(2, 0.044));
		
		password = new JPasswordField();
		password.setBounds(Resolution.getPixelsfromPrcntg(1, 0.11) , Resolution.getPixelsfromPrcntg(2, 0.1171) ,Resolution.getPixelsfromPrcntg(1, 0.198) ,Resolution.getPixelsfromPrcntg(2, 0.022));
		password.addKeyListener(this);
		password.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.GREEN));
		
		this.add(mail);
		this.setTitle(EntryForm.RESTAURANT_NAME);
		this.add(lEmail);
		this.add(lPassword);
		this.add(password);
		this.setLayout(null);
		this.addKeyListener(this);
		this.setBounds(Resolution.getPixelsfromPrcntg(1, 0.38) ,Resolution.getPixelsfromPrcntg(2, 0.27) ,Resolution.getPixelsfromPrcntg(1, 0.366) ,Resolution.getPixelsfromPrcntg(2, 0.234));
		this.setResizable(false);
		this.add(white);
		this.add(black);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	private void checker() {
		info =new Infopass();
		String getPass = password.getText();
		String getMail = mail.getText();
		if(info.userConfirmer(getMail, getPass)) {
			if(info.isAdmin(getMail)) {
				client =false;
				admin =true;
			}
			else {
				client =true;
				admin =false;
			}
		}
		
	}//Here change the value of client and admin
	
	private void continuer() {
		if(client) {
			JOptionPane.showMessageDialog(null, "Welcome user "+info.name(mail.getText()),"Logged in successfully!"
					,JOptionPane.YES_OPTION,EntryForm.MAIN_ICON);
			Client client = new Client(info.getUser(mail.getText()));
			this.setVisible(false);
			this.removeAll();
		}
		else if(admin) {
			JOptionPane.showMessageDialog(null, "Welcome admin "+info.name(mail.getText()),"Logged in successfully!"
					,JOptionPane.OK_OPTION,EntryForm.MAIN_ICON);
			Admin admin = new Admin(info.getUser(mail.getText()));
			this.setVisible(false);
			this.removeAll();
		}
			else
				JOptionPane.showMessageDialog(null, "Retry","Email or password is incorrect!",JOptionPane.OK_CANCEL_OPTION);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_ENTER) {
			checker();
			continuer();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
