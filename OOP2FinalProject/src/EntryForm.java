import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Controllers.JCBConstant;

public class EntryForm {
	public static final ImageIcon MAIN_ICON = new ImageIcon(JCBConstant.MAIN_LINK_EXCECUTION + "\\Picture\\Logo2.PNG");
	public static final String RESTAURANT_NAME="Restoland";
	private int input;
	private AccountCreation create;
	private LoginForm login;
	
	public EntryForm() {//this, "Do you have an existing account?","Welcome to "+RESTAURANT_NAME,JOptionPane.YES_NO_CANCEL_OPTION
		input = JOptionPane.showConfirmDialog(null, "Do you have an existing account?",
				"Welcome to "+RESTAURANT_NAME, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, MAIN_ICON);
		
	}
	
	public void _Account() {
		if(input==0) {
			login = new LoginForm();
			}
		else if(input==1) {
			create = new AccountCreation();
		}
		else
			System.out.println("It was a pleasure to meet you :)");
	}
}
