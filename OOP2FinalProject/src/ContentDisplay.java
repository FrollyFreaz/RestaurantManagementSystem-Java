import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.DataFile;
import Controllers.Infopass;
import Controllers.JCBConstant;
import Models.MenuInfo;
import Models.ReservationInfo;
import Models.TableInfo;
import Models.UserInfo;

public class ContentDisplay extends JPanel implements ActionListener{
	private Infopass infoDirect = new Infopass();
	private JCBConstant returnerJCB = new JCBConstant();
	private DataFile dataF = new DataFile();
	
	
    private JLabel manage, laddMenu, laddReservation, laddUser, laddTable;
    private JLabel userPutter1,userPutter2,
    tablePutter1,tablePutter2,
    resPutter1,resPutter2,resPutter3,
    menuPutter1,menuPutter2,menuPutter3;
    private JPanel pMenu,pRes,pUser,pTable;
    //TextFields,JComboBoxes
    private JTextField userGetter1 ,userGetter2;
    private JComboBox tableGetter1,tableGetter2;
    private JComboBox resGetter1 ,resGetter2 ,resGetter3;
    private JTextField menuGetter1;
    private JComboBox menuGetter2, menuGetter3;
	//Buttons
    private JButton next1 ,next2 ,next3 ,next4;
    private JButton prev1 ,prev2 ,prev3 ,prev4;
    private JButton save1 ,save2 ,save3 ,save4;
    
    private final int HEIGHT =100;
    private int counter1=0;
    private int counter2=0;
    private int counter3=0;
    private int counter4=0;
    //Client temps
    private String tempFN = new String();
    private String tempLN = new String();
    private String tempMail = new String();
    private String tempPassword = new String();
    private String tempPhone = new String();
    private String tempWHO = new String();
    //Table temps
    private String tempBranch = new String();
    private String tempSizeTable = new String();
    private String tempPriceTable = new String();
    private String tempAvailability = new String();
    //Reservation temps
    private String tempTID = new String();
    private String tempUID = new String();
    private String tempMID = new String();
    private String tempDATE = new String();
    private String tempTypeRes = new String();
    //Menu temps
    private String tempNameMenu = new String();
    private String tempTypeMenu = new String();
    private String tempPriceMenu;
    
    
    
    
    
    
    
    
    
	public ContentDisplay() {
		
		instantiate();
		labelDescriptor();
		panelDescriptor();
		boxDescriptor();
		
		//This
		this.setLayout(null);
		this.setBounds(Resolution.getPixelsfromPrcntg(1, 0.25) ,0 ,Resolution.getPixelsfromPrcntg(1, 1) , (int) this.getMaximumSize().getHeight());
		this.setBackground(Color.GREEN.darker().darker().darker());
		this.add(manage);
		this.add(pUser);
		this.add(pTable);
		this.add(pRes);
		this.add(pMenu);
		this.add(next1); this.add(next2); this.add(next3); this.add(next4);
		this.add(prev1); this.add(prev2); this.add(prev3); this.add(prev4);
		this.add(save1); this.add(save2); this.add(save3); this.add(save4);
		this.setVisible(true);
	}

	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//User
		if(e.getSource().equals(next1)) {
			if(counter1==0) {
			counter1++;
			tempFN = userGetter1.getText();
			tempLN = userGetter2.getText();
			userGetter1.setText(tempMail);
		    userGetter2.setText(tempPassword);
		    
			userPutter1.setText("Email");
			userPutter2.setText("Password");
			}
			else if(counter1==1) { 
				counter1++;
				tempMail = userGetter1.getText();
				tempPassword = userGetter2.getText();
				userGetter1.setText(tempPhone);
			    userGetter2.setText(tempWHO);
				userPutter1.setText("Phone");
				userPutter2.setText("Admin/Client");
			}
		}
		else if(e.getSource().equals(prev1)) {
			if(counter1==2) {
				counter1--;
			tempPhone =userGetter1.getText();
			tempWHO = userGetter2.getText();
			userGetter1.setText(tempMail);
			userGetter2.setText(tempPassword);
			userPutter1.setText("Email");
			userPutter2.setText("Password");
			}
			else if(counter1==1) {
				counter1--;
				userGetter1.setText(tempFN);
				userGetter2.setText(tempLN);
				userPutter1.setText("Firstname");
				userPutter2.setText("Lastname");
			}
		}
		//Table
		if(e.getSource().equals(next2)) {
			if(counter2==0) {
				
			counter2++;
			tempBranch = tableGetter1.getSelectedItem().toString();
			tempSizeTable = tableGetter2.getSelectedItem().toString();
			tableGetter1.setVisible(false);
			tableGetter2.setVisible(false);
			pTable.removeAll();
			tableGetter1 = new JComboBox(returnerJCB.tablePrice());
			tableGetter2 = new JComboBox(returnerJCB.tableAvailability());
			tableGetter1.setBorder(BorderFactory.createRaisedBevelBorder()); tableGetter1.setBackground(Color.LIGHT_GRAY);
			tableGetter2.setBorder(BorderFactory.createRaisedBevelBorder()); tableGetter2.setBackground(Color.LIGHT_GRAY);
			pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel());
			pTable.add(laddTable); pTable.add(tableGetter1); pTable.add(new JLabel()); pTable.add(tableGetter2); pTable.add(new JLabel());
			pTable.add(new JLabel()); pTable.add(tablePutter1);  pTable.add(new JLabel()); pTable.add(tablePutter2); pTable.add(new JLabel());
			tableGetter1.setVisible(true);
			tableGetter2.setVisible(true);
			tableGetter1.setSelectedItem(tempPriceTable);//.setText(tempPriceTable);
			tableGetter2.setSelectedItem(tempAvailability);//.setText(tempAvailability);
			tablePutter1.setText("Price");
			tablePutter2.setText("Availability");
			}
		}
		else if(e.getSource().equals(prev2)) {
			if(counter2==1) {
			counter2--;
			tempPriceTable = tableGetter1.getSelectedItem().toString();
			tempAvailability = tableGetter2.getSelectedItem().toString();
			tableGetter1.setVisible(false);
			tableGetter2.setVisible(false);
			pTable.removeAll();
			tableGetter1 = new JComboBox(returnerJCB.Branches());
			tableGetter2 = new JComboBox(returnerJCB.tableSize());
			tableGetter1.setBorder(BorderFactory.createRaisedBevelBorder()); tableGetter1.setBackground(Color.LIGHT_GRAY);
			tableGetter2.setBorder(BorderFactory.createRaisedBevelBorder()); tableGetter2.setBackground(Color.LIGHT_GRAY);
			pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel());
			pTable.add(laddTable); pTable.add(tableGetter1); pTable.add(new JLabel()); pTable.add(tableGetter2); pTable.add(new JLabel());
			pTable.add(new JLabel()); pTable.add(tablePutter1);  pTable.add(new JLabel()); pTable.add(tablePutter2); pTable.add(new JLabel());
			tableGetter1.setVisible(true);
			tableGetter2.setVisible(true);
			tableGetter1.setSelectedItem(tempBranch);//.setText(tempBranch);
			tableGetter2.setSelectedItem(tempSizeTable);//.setText(tempSizeTable);
			tablePutter1.setText("Branch");
			tablePutter2.setText("Size");
			}
		}
		//Reservation
		if(e.getSource().equals(next3)) {
			if(counter3==0) {
				counter3++;
				if(resGetter1.getSelectedItem()==null)
					tempTID =" ";
				else {tempTID = resGetter1.getSelectedItem().toString();};
				if(resGetter3.getSelectedItem()==null)
					tempUID =" ";
				else {tempUID = resGetter3.getSelectedItem().toString();};
				resGetter1.setVisible(false);
				resGetter3.setVisible(false);
				pRes.removeAll();
				resGetter1 = new JComboBox(infoDirect.getMenuNames());
				resGetter3 = new JComboBox(returnerJCB.resType());
				resGetter1.setBorder(BorderFactory.createRaisedBevelBorder()); resGetter1.setBackground(Color.LIGHT_GRAY);
				resGetter3.setBorder(BorderFactory.createRaisedBevelBorder()); resGetter3.setBackground(Color.LIGHT_GRAY);
				pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel());
				pRes.add(laddReservation); pRes.add(resGetter1); pRes.add(resGetter2); pRes.add(resGetter3); pRes.add(new JLabel());
				pRes.add(new JLabel()); pRes.add(resPutter1); pRes.add(resPutter2); pRes.add(resPutter3); pRes.add(new JLabel());
				resGetter1.setVisible(true);
				resGetter2.setVisible(false);
				resGetter3.setVisible(true);
				resPutter1.setVisible(true);
				resPutter2.setVisible(false);
				resPutter3.setVisible(true);
				resGetter1.setSelectedItem(tempMID);
				resGetter3.setSelectedItem(tempTypeRes);
			resPutter1.setText("Menu number");
			resPutter3.setText("Type");
			}
			else if(counter3==1) {
				counter3++;
				if(resGetter1.getSelectedItem()==null) 
				tempMID = " ";
				else {tempMID = resGetter1.getSelectedItem().toString();};
				if(resGetter3.getSelectedItem()==null) 
				tempTypeRes =" ";
				else {tempTypeRes = resGetter3.getSelectedItem().toString();};
				tempTypeRes = resGetter3.getSelectedItem().toString();
				resPutter1.setVisible(false);
				resGetter1.setVisible(false);
				resPutter3.setVisible(false);
				resGetter3.setVisible(false);
				resGetter2.setVisible(true);
				resPutter2.setVisible(true);
				resPutter2.setText("Date");
			}
		}
		else if(e.getSource().equals(prev3)) {
			if(counter3==2) {
				counter3--;
				if(resGetter2.getSelectedItem()==null) tempDATE=" ";
				else {tempDATE = resGetter2.getSelectedItem().toString();};
				resGetter2.setVisible(false);
				resPutter2.setVisible(false);
				resGetter1.setVisible(true);
				resPutter1.setVisible(true);
				resGetter3.setVisible(true);
				resPutter3.setVisible(true);
			}
			else if(counter3==1) {
				counter3--;
				if(resGetter1.getSelectedItem()==null) tempMID = " ";
				else {tempMID = resGetter1.getSelectedItem().toString();};
				if(resGetter3.getSelectedItem()==null) tempTypeRes = " ";
				else {tempTypeRes = resGetter3.getSelectedItem().toString();};
				resGetter1.setVisible(false);
				resGetter3.setVisible(false);
				pRes.removeAll();
				resGetter1 = new JComboBox(infoDirect.getTableNums());
				resGetter3 = new JComboBox(infoDirect.getUID());
				resGetter1.setBorder(BorderFactory.createRaisedBevelBorder()); resGetter1.setBackground(Color.LIGHT_GRAY);
				resGetter3.setBorder(BorderFactory.createRaisedBevelBorder()); resGetter3.setBackground(Color.LIGHT_GRAY);
				pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel());
				pRes.add(laddReservation); pRes.add(resGetter1); pRes.add(resGetter2); pRes.add(resGetter3); pRes.add(new JLabel());
				pRes.add(new JLabel()); pRes.add(resPutter1); pRes.add(resPutter2); pRes.add(resPutter3); pRes.add(new JLabel());
				resGetter1.setVisible(true); resGetter2.setVisible(false); resGetter3.setVisible(true);
				resPutter1.setVisible(true); resPutter2.setVisible(false); resPutter3.setVisible(true);
				resGetter1.setSelectedItem(tempTID);//.setText(tempTID);
				resGetter3.setSelectedItem(tempUID);//.setText(tempUID);
				resPutter1.setText("Table number");
				resPutter3.setText("User ID");
			}
		}
		//Menu
		if(e.getSource().equals(next4)) {
			if(counter4==0) {
				//
				counter4++;
				tempNameMenu = menuGetter1.getText(); 
			    tempTypeMenu = menuGetter3.getSelectedItem().toString();
				menuPutter1.setVisible(false);
				menuGetter1.setVisible(false);
				menuPutter3.setVisible(false);
				menuGetter3.setVisible(false);
				menuPutter2.setVisible(true);
				menuGetter2.setVisible(true);
			}
		}
		else if(e.getSource().equals(prev4)) {
			if(counter4==1) {
				//
				counter4--;
				tempPriceMenu = menuGetter2.getSelectedItem().toString();
				menuPutter1.setVisible(true);
				menuGetter1.setVisible(true);
				menuPutter3.setVisible(true);
				menuGetter3.setVisible(true);
				menuPutter2.setVisible(false);
				menuGetter2.setVisible(false);
			}
		}
		
		
		if(e.getSource().equals(save1)) {
			switch(counter1) {
			    case 0:
			    	tempFN = userGetter1.getText();
			    	tempLN = userGetter2.getText();
				    break;
			    case 1:
			    	tempMail = userGetter1.getText();
			    	tempPassword = userGetter2.getText();
			        break;
			    case 2:
			    	tempPhone = userGetter1.getText();
			    	tempWHO = userGetter2.getText();
			        break;
			}
			if(infoDirect.passName(tempFN) && infoDirect.passName(tempLN) && infoDirect.mailUnique(tempMail) && infoDirect.mailSyntax(tempMail) 
			&& infoDirect.confirmWHO(tempWHO) && infoDirect.phoneSyntax(tempPhone) && infoDirect.phoneUnique(tempPhone)) {
				JOptionPane.showMessageDialog(null, "Enter other data values!", "Error",JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
			}
			else {
				UserInfo newUser = new UserInfo(tempFN,tempLN,tempMail,tempPassword,tempPhone,infoDirect.getWHO(tempWHO));
				try {
					DataFile.users.add(newUser);
					infoDirect.generateUID(newUser);
					dataF.saveToClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Some error occured that prevented us from saving!Please retry later"
							, "Error",JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
				}
			}
		}
		
		if(e.getSource().equals(save2)) {
			switch(counter2) {
			    case 0:
			    	tempBranch = tableGetter1.getSelectedItem().toString();
			    	tempSizeTable = tableGetter2.getSelectedItem().toString();
			    	break;
			    case 1:
			    	tempPriceTable = tableGetter1.getSelectedItem().toString();
			    	tempAvailability = tableGetter2.getSelectedItem().toString();
			    	break;
			}
			if(tempBranch.compareTo(" ")!=0 && tempSizeTable.compareTo(" ")!=0 && tempPriceTable.compareTo(" ")!=0 
					&& tempAvailability.compareTo(" ")!=0) {
				TableInfo table = new TableInfo(tempBranch,Integer.parseInt(tempSizeTable),Float.parseFloat(tempPriceTable)
						,tempAvailability);
				try {
					DataFile.tables.add(table);
					infoDirect.generateTID(table);
					dataF.saveToTable();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Some error occured that prevented us from saving!Please retry later"
							, "Error",JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "One or more values are not yet chosen!To proceed,choose a value for each box", "Error"
						, JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
			}
		}
		
		if(e.getSource().equals(save3)) {
			switch(counter3) {
			    case 0:
			    	if(resGetter1.getSelectedItem()==null) tempTID = " ";
			    	else { tempTID = resGetter1.getSelectedItem().toString(); };
			    	if(resGetter3.getSelectedItem()==null) tempUID = " ";
			    	else {tempUID = resGetter3.getSelectedItem().toString();};
			    	break;
			    case 1:
			    	if(resGetter1.getSelectedItem()==null) tempMID = " ";
			    	else {tempMID = resGetter1.getSelectedItem().toString();};
			    	if(resGetter3.getSelectedItem()==null) tempTypeRes = " ";
			    	else {tempTypeRes = resGetter3.getSelectedItem().toString();};
			    	
			    	break;
			    case 2:
			    	if(resGetter2.getSelectedItem()==null) tempDATE = " ";
			    	else {tempDATE = resGetter2.getSelectedItem().toString();};
			    	break;
			}
			if(tempTID.compareTo(" ")!=0 && tempUID.compareTo(" ")!=0 && tempMID.compareTo(" ")!=0 && tempTypeRes.compareTo(" ")!=0 
					&& tempDATE.compareTo(" ")!=0) {
				ReservationInfo resInfo = new ReservationInfo(Integer.parseInt(tempTID) ,Integer.parseInt(tempUID)
						,infoDirect.menutoID(tempMID) ,tempDATE ,infoDirect.getFinalPrice(infoDirect.getMPrice(infoDirect.menutoID(tempMID)), infoDirect.getTPrice(Integer.parseInt(tempTID))),tempTypeRes);
				
			    try {
			    	DataFile.reservations.add(resInfo);
			    	infoDirect.generateRID(resInfo);
					dataF.saveToRes();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Some error occured that prevented us from saving!Please retry later"
							, "Error",JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "One or more values are not yet chosen!To proceed,choose a value for each box", "Error"
						, JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
			}
			
		}
		if(e.getSource().equals(save4)) {
			switch(counter4) {
			    case 0:
			    	tempNameMenu = menuGetter1.getText();
			    	tempTypeMenu = menuGetter3.getSelectedItem().toString();
			    	break;
			    case 1:
			    	tempPriceMenu = menuGetter2.getSelectedItem().toString();
			    	break;
			}
			if(tempNameMenu.compareTo(" ")!=0 && tempTypeMenu.compareTo(" ")!=0 && tempPriceMenu.compareTo(" ")!=0) {
				MenuInfo menu = new MenuInfo(tempNameMenu,Float.parseFloat(tempPriceMenu),tempTypeMenu);
				try {
					DataFile.menu.add(menu);
					infoDirect.generateMID(menu);
					dataF.saveToMenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Some error occured that prevented us from saving!Please retry later"
							, "Error",JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "One or more values are not yet chosen!To proceed,choose a value for each box", "Error"
						, JOptionPane.OK_OPTION, EntryForm.MAIN_ICON);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void instantiate() {
		//Front General
		manage = new JLabel("Management System");
		laddUser = new JLabel("  Users  ");
		laddTable = new JLabel("  Tables  ");
		laddReservation = new JLabel("  Reservation ");
		laddMenu = new JLabel("  Menu ");
		
		//User
		userGetter1 =new JTextField();
		userGetter2 =new JTextField();
		userPutter1 = new JLabel("Firstname");
		userPutter2 = new JLabel("Lastname");
		//Table
		tableGetter1 = new JComboBox(returnerJCB.Branches());
		tableGetter2 = new JComboBox(returnerJCB.tableSize());
		tablePutter1 = new JLabel("Branch");
		tablePutter2 = new JLabel("Size");
		//Reservation
		resGetter1 = new JComboBox(infoDirect.getTableNums());
		resGetter2 = new JComboBox(returnerJCB.resDates());
		resGetter3 = new JComboBox(infoDirect.getUID());
		resPutter1 = new JLabel("Table number");
		resPutter2 = new JLabel("Date");
		resPutter3 = new JLabel("User ID");
		//Menu
		menuGetter1 = new JTextField();
		menuGetter2 = new JComboBox(returnerJCB.menuPrice());
		menuGetter3 = new JComboBox(returnerJCB.menuType());
		menuPutter1 = new JLabel("Name");
		menuPutter2 = new JLabel("Price");
		menuPutter3 = new JLabel("Type");
		
		//Buttons
		next1 = new JButton();
		next2 = new JButton();
		next3 = new JButton();
		next4 = new JButton();
		prev1 = new JButton();
		prev2 = new JButton();
		prev3 = new JButton();
		prev4 = new JButton();
		save1 = new JButton();
		save2 = new JButton();
		save3 = new JButton();
		save4 = new JButton();
		
		//Panels
		pRes = new JPanel();
		pMenu = new JPanel();
		pUser = new JPanel();
		pTable = new JPanel();
	}
	
	private void labelDescriptor() {
		Cursor cr = new Cursor(Cursor.HAND_CURSOR);
		manage.setBounds(400, 30, 300, 50); manage.setFont(new Font("Roman",Font.BOLD,30)); manage.setForeground(Color.WHITE);
		laddUser.setFont(new Font("Roman",Font.BOLD,22)); laddUser.setForeground(Color.WHITE); laddUser.setVisible(true);
		laddTable.setFont(new Font("Roman",Font.BOLD,22)); laddTable.setForeground(Color.WHITE);
		laddReservation.setFont(new Font("Roman",Font.BOLD,22)); laddReservation.setForeground(Color.WHITE);
		laddMenu.setFont(new Font("Roman",Font.BOLD,22)); laddMenu.setForeground(Color.WHITE);
		
		//User
		userPutter1.setFont(new Font("Roman",Font.PLAIN,17)); userPutter1.setForeground(Color.WHITE); userPutter1.setVisible(true);
		userPutter2.setFont(new Font("Roman",Font.PLAIN,17)); userPutter2.setForeground(Color.WHITE); userPutter2.setVisible(true);
		
		//Table
		tablePutter1.setFont(new Font("Roman",Font.PLAIN,17)); tablePutter1.setForeground(Color.WHITE); tablePutter1.setVisible(true);
		tablePutter2.setFont(new Font("Roman",Font.PLAIN,17)); tablePutter2.setForeground(Color.WHITE); tablePutter2.setVisible(true);
		
		//Reservations
		resGetter2.setVisible(false);
		resPutter1.setFont(new Font("Roman",Font.PLAIN,17)); resPutter1.setForeground(Color.WHITE); resPutter1.setVisible(true);
		resPutter2.setFont(new Font("Roman",Font.PLAIN,17)); resPutter2.setForeground(Color.WHITE); resPutter2.setVisible(false);
		resPutter3.setFont(new Font("Roman",Font.PLAIN,17)); resPutter3.setForeground(Color.WHITE); resPutter3.setVisible(true);
		
		//Menu
		menuGetter2.setVisible(false);
		menuPutter1.setFont(new Font("Roman",Font.PLAIN,17)); menuPutter1.setForeground(Color.WHITE); menuPutter1.setVisible(true);
		menuPutter2.setFont(new Font("Roman",Font.PLAIN,17)); menuPutter2.setForeground(Color.WHITE); menuPutter2.setVisible(false);
		menuPutter3.setFont(new Font("Roman",Font.PLAIN,17)); menuPutter3.setForeground(Color.WHITE); menuPutter3.setVisible(true);
		
		//Next buttons
		next1.setBounds(80, 190, 30, 30);
		next1.setBackground(Color.GREEN.darker().darker());
		next1.setBorder(BorderFactory.createRaisedBevelBorder());
		next1.addActionListener(this);
		next1.setToolTipText("next");
		next1.setCursor(cr);
		next2.setBounds(80, 330, 30, 30);
		next2.setBackground(Color.GREEN.darker().darker());
		next2.setBorder(BorderFactory.createRaisedBevelBorder());
		next2.addActionListener(this);
		next2.setToolTipText("next");
		next2.setCursor(cr);
		next3.setBounds(80, 470, 30, 30);
		next3.setBackground(Color.GREEN.darker().darker());
		next3.setBorder(BorderFactory.createRaisedBevelBorder());
		next3.addActionListener(this);
		next3.setToolTipText("next");
		next3.setCursor(cr);
		next4.setBounds(80, 610, 30, 30);
		next4.setBackground(Color.GREEN.darker().darker());
		next4.setBorder(BorderFactory.createRaisedBevelBorder());
		next4.addActionListener(this);
		next4.setToolTipText("next");
		next4.setCursor(cr);
		
		//Previous buttons
		prev1.setBounds(10, 190, 30, 30);
		prev1.setBackground(Color.GREEN.darker().darker());
		prev1.setBorder(BorderFactory.createRaisedBevelBorder());
		prev1.addActionListener(this);
		prev1.setToolTipText("prev");
		prev1.setCursor(cr);
		prev2.setBounds(10, 330, 30, 30);
		prev2.setBackground(Color.GREEN.darker().darker());
		prev2.setBorder(BorderFactory.createRaisedBevelBorder());
		prev2.addActionListener(this);
		prev2.setToolTipText("prev");
		prev2.setCursor(cr);
		prev3.setBounds(10, 470, 30, 30);
		prev3.setBackground(Color.GREEN.darker().darker());
		prev3.setBorder(BorderFactory.createRaisedBevelBorder());
		prev3.addActionListener(this);
		prev3.setToolTipText("prev");
		prev3.setCursor(cr);
		prev4.setBounds(10, 610, 30, 30);
		prev4.setBackground(Color.GREEN.darker().darker());
		prev4.setBorder(BorderFactory.createRaisedBevelBorder());
		prev4.addActionListener(this);
		prev4.setToolTipText("prev");
		prev4.setCursor(cr);
		
		//Save buttons
		save1.setBounds(45, 190, 30, 30);
		save1.setBackground(Color.RED.darker().darker());
		save1.setBorder(BorderFactory.createRaisedBevelBorder());
		save1.addActionListener(this);
		save1.setToolTipText("Save");
		save1.setCursor(cr);
		save2.setBounds(45, 330, 30, 30);
		save2.setBackground(Color.RED.darker().darker());
		save2.setBorder(BorderFactory.createRaisedBevelBorder());
		save2.addActionListener(this);
		save2.setToolTipText("Save");
		save2.setCursor(cr);
		save3.setBounds(45, 470, 30, 30);
		save3.setBackground(Color.RED.darker().darker());
		save3.setBorder(BorderFactory.createRaisedBevelBorder());
		save3.addActionListener(this);
		save3.setToolTipText("Save");
		save3.setCursor(cr);
		save4.setBounds(45, 610, 30, 30);
		save4.setBackground(Color.RED.darker().darker());
		save4.setBorder(BorderFactory.createRaisedBevelBorder());
		save4.addActionListener(this);
		save4.setToolTipText("Save");
		save4.setCursor(cr);
		
	}

	private void panelDescriptor() {
		//User
				pUser.setBounds(120, 120, 900, HEIGHT);
				pUser.setLayout(new GridLayout(3,5));
				pUser.setBorder(BorderFactory.createRaisedBevelBorder());
				pUser.setBackground(Color.GREEN.darker().darker().darker());
				pUser.add(new JLabel());
				pUser.add(new JLabel());
				pUser.add(new JLabel());
				pUser.add(new JLabel());
				pUser.add(new JLabel());
				pUser.add(laddUser);
				pUser.add(userGetter1);
				pUser.add(new JLabel());
				pUser.add(userGetter2);
				pUser.add(new JLabel());
				pUser.add(new JLabel()); pUser.add(userPutter1); pUser.add(new JLabel()); pUser.add(userPutter2); pUser.add(new JLabel());
				
				//Table
				pTable.setBounds(120, 260, 900, HEIGHT);
				pTable.setLayout(new GridLayout(3,5));
				pTable.setBorder(BorderFactory.createRaisedBevelBorder());
				pTable.setBackground(Color.GREEN.darker().darker().darker());
				pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel()); pTable.add(new JLabel());
				pTable.add(laddTable);//1
				pTable.add(tableGetter1);
				pTable.add(new JLabel());
				pTable.add(tableGetter2);
				pTable.add(new JLabel());//5
				pTable.add(new JLabel()); pTable.add(tablePutter1); pTable.add(new JLabel()); pTable.add(tablePutter2); pTable.add(new JLabel());
				
				//Reservation
				pRes.setBounds(120, 400, 900, HEIGHT);
				pRes.setLayout(new GridLayout(3,5));
				pRes.setBorder(BorderFactory.createRaisedBevelBorder());
				pRes.setBackground(Color.GREEN.darker().darker().darker());
				pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel()); pRes.add(new JLabel());
				pRes.add(laddReservation);
				pRes.add(resGetter1);
				pRes.add(resGetter2);
				pRes.add(resGetter3);
				pRes.add(new JLabel());
				pRes.add(new JLabel()); pRes.add(resPutter1); pRes.add(resPutter2); pRes.add(resPutter3); pRes.add(new JLabel());
				
				//Menu
				pMenu.setBounds(120, 540, 900, HEIGHT);
				pMenu.setLayout(new GridLayout(3,5));
				pMenu.setBorder(BorderFactory.createRaisedBevelBorder());
				pMenu.setBackground(Color.GREEN.darker().darker().darker());
				pMenu.add(new JLabel());  pMenu.add(new JLabel()); pMenu.add(new JLabel()); pMenu.add(new JLabel());  pMenu.add(new JLabel());
				pMenu.add(laddMenu);
				pMenu.add(menuGetter1);
				pMenu.add(menuGetter2);
				pMenu.add(menuGetter3); 
				pMenu.add(new JLabel());
				pMenu.add(new JLabel()); pMenu.add(menuPutter1); pMenu.add(menuPutter2); pMenu.add(menuPutter3); pMenu.add(new JLabel());
	}

	private void boxDescriptor() {
		userGetter1.setBorder(BorderFactory.createRaisedBevelBorder());
		userGetter2.setBorder(BorderFactory.createRaisedBevelBorder());
		tableGetter1.setBorder(BorderFactory.createRaisedBevelBorder());
		tableGetter1.setBackground(Color.LIGHT_GRAY);
		tableGetter2.setBorder(BorderFactory.createRaisedBevelBorder());
		tableGetter2.setBackground(Color.LIGHT_GRAY);
		resGetter1.setBorder(BorderFactory.createRaisedBevelBorder());
		resGetter1.setBackground(Color.LIGHT_GRAY);
		resGetter2.setBorder(BorderFactory.createRaisedBevelBorder());
		resGetter2.setBackground(Color.LIGHT_GRAY);
		resGetter3.setBorder(BorderFactory.createRaisedBevelBorder());
		resGetter3.setBackground(Color.LIGHT_GRAY);
		menuGetter1.setBorder(BorderFactory.createRaisedBevelBorder());
		menuGetter2.setBorder(BorderFactory.createRaisedBevelBorder());
		menuGetter2.setBackground(Color.LIGHT_GRAY);
		menuGetter3.setBorder(BorderFactory.createRaisedBevelBorder());
		menuGetter3.setBackground(Color.LIGHT_GRAY);
	}
}
