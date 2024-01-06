import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import Controllers.DataFile;
import Controllers.Infopass;
import Controllers.JCBConstant;
import Models.ReservationInfo;
import Models.UserInfo;

public class ClientReservation extends JPanel implements ItemListener,ActionListener{
	private JCBConstant constJCB= new JCBConstant();
	private Infopass infoDirect;
	private JLabel resText,tableText,profilePic,userTChoice,typeText,menuText,timeText;
	private JPanel inputPanel,mainInputPanel,timePanel;
	private String []columns = {"Number","Branch","People","Price","Availibility"};
	private String[][] data;
	private String[] m={"Month"};
	private TTable tTables;
	private JButton enter, more, menuDownload;
	private JComboBox tableNums,menuNums,types,year,month,day;
	private UserInfo user;
	
	public ClientReservation(UserInfo you) {
		user = you;
		/*profilePic = new JLabel();
        size = profilePic.getPreferredSize(); 
        profilePic.setBounds(Resolution.getPixelsfromPrcntg(1, 0.234) ,Resolution.getPixelsfromPrcntg(2, 0.02) , size.width, size.height);
        */
		infoDirect = new Infopass();
		data = infoDirect.toTable();
		
		resText = new JLabel("Reservations ");
		resText.setFont(new Font("Roman",Font.BOLD,30));
		resText.setBounds(Resolution.getPixelsfromPrcntg(1, 0.307) ,Resolution.getPixelsfromPrcntg(2, 0.022) ,Resolution.getPixelsfromPrcntg(1, 0.227) ,Resolution.getPixelsfromPrcntg(2, 0.0512));
		resText.setForeground(Color.WHITE);
		
		tableText = new JLabel("                            Tables available");
		tableText.setFont(new Font("Roman",Font.BOLD,22));
		tableText.setBounds(Resolution.getPixelsfromPrcntg(1, 0.022) ,Resolution.getPixelsfromPrcntg(2, 0.139) ,Resolution.getPixelsfromPrcntg(1, 0.366) ,Resolution.getPixelsfromPrcntg(2, 0.0366));
		tableText.setForeground(Color.WHITE);
		tableText.setBackground(Color.green.darker().darker());
		tableText.setBorder(BorderFactory.createRaisedBevelBorder());
		
		tTables = new TTable(data,columns);
		tTables.setGridColor(Color.BLACK);
		tTables.setFont(new Font("Roman",Font.BOLD,14));
		tTables.setBounds(Resolution.getPixelsfromPrcntg(1, 0.022) ,Resolution.getPixelsfromPrcntg(2, 0.197) ,Resolution.getPixelsfromPrcntg(1, 0.366) ,Resolution.getPixelsfromPrcntg(2, 0.394));
		tTables.setRowHeight(Resolution.getPixelsfromPrcntg(2, 0.0394));
		tTables.setShowVerticalLines(false);
		tTables.setBackground(Color.WHITE.darker());
		tTables.setForeground(Color.WHITE);
		tTables.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(), 3, true));
		tTables.sizeColumnsToFit(tTables.AUTO_RESIZE_ALL_COLUMNS);
		
		
		tableNums = new JComboBox(infoDirect.getTableNums());
		menuNums  = new JComboBox(infoDirect.getMenuNames());
		types     = new JComboBox(constJCB.resType());
		year      = new JComboBox(infoDirect.yearNOW()); year.addItemListener(this);
		year.setBackground(Color.GREEN.darker().darker());
		month     = new JComboBox(m); month.addItemListener(this); month.setEnabled(false);
		month.setBackground(Color.GREEN.darker().darker());
		day       = new JComboBox(infoDirect.dayLEFT()); day.setEnabled(false);
		day.setBackground(Color.GREEN.darker().darker());
		
		enter = new JButton("ENTER");
		enter.setFont(new Font("Roman",Font.BOLD,16));
		enter.setBounds(Resolution.getPixelsfromPrcntg(1, 0.66) ,Resolution.getPixelsfromPrcntg(2, 0.6) ,Resolution.getPixelsfromPrcntg(1, 0.1) ,Resolution.getPixelsfromPrcntg(2, 0.045));
		enter.setBackground(Color.green.darker().darker());
		enter.setForeground(Color.WHITE);
		enter.setBorder(BorderFactory.createRaisedBevelBorder());
		enter.addActionListener(this);
		
		userTChoice = new JLabel("   Table ");
		userTChoice.setFont(new Font("Roman",Font.BOLD,20));
		userTChoice.setForeground(Color.WHITE);
		
		menuText = new JLabel("   Menu ");
		menuText.setFont(new Font("Roman",Font.BOLD,20));
		menuText.setForeground(Color.WHITE);
		
		typeText = new JLabel("   Type ");
		typeText.setFont(new Font("Roman",Font.BOLD,20));
		typeText.setForeground(Color.WHITE);
		
		inputPanel = new JPanel();
		inputPanel.setBackground(Color.GREEN.darker().darker().darker());
		inputPanel.setLayout(new GridLayout(7,2));
		inputPanel.add(new JLabel());
		inputPanel.add(new JLabel());
		inputPanel.add(userTChoice);
		inputPanel.add(tableNums);
		inputPanel.add(new JLabel());
		inputPanel.add(new JLabel());
		inputPanel.add(menuText);
		inputPanel.add(menuNums);
		inputPanel.add(new JLabel());
		inputPanel.add(new JLabel());
		inputPanel.add(typeText);
		inputPanel.add(types);
		inputPanel.add(new JLabel());
		inputPanel.add(new JLabel());
		
		mainInputPanel = new JPanel();
		mainInputPanel.setBackground(Color.GREEN.darker().darker().darker());
		mainInputPanel.setLayout(new BorderLayout());
		mainInputPanel.add(inputPanel,BorderLayout.CENTER);
		mainInputPanel.setBounds(Resolution.getPixelsfromPrcntg(1, 0.512) ,Resolution.getPixelsfromPrcntg(2, 0.22) ,Resolution.getPixelsfromPrcntg(1, 0.22) ,Resolution.getPixelsfromPrcntg(2, 0.2));
		mainInputPanel.add(new JLabel("       "),BorderLayout.EAST);
		mainInputPanel.add(new JLabel(),BorderLayout.NORTH);
		mainInputPanel.add(new JLabel(),BorderLayout.SOUTH);
		mainInputPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		timeText = new JLabel("     Time");
		timeText.setFont(new Font("Roman",Font.BOLD,18));
		timeText.setForeground(Color.WHITE);
		
		timePanel = new JPanel();
		timePanel.setBackground(Color.GREEN.darker().darker().darker());
		timePanel.setLayout(new GridLayout(1,4));
		timePanel.add(timeText);
		timePanel.add(year);
		timePanel.add(month);
		timePanel.add(day);
		timePanel.setBounds(Resolution.getPixelsfromPrcntg(1, 0.4392) ,Resolution.getPixelsfromPrcntg(2, 0.45) ,Resolution.getPixelsfromPrcntg(1, 0.31) ,Resolution.getPixelsfromPrcntg(2, 0.035));
		timePanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		more = new JButton("more");
		more.setFont(new Font("Roman",Font.ITALIC,15));
		more.setBounds(Resolution.getPixelsfromPrcntg(1, 0.4) ,Resolution.getPixelsfromPrcntg(2, 0.6) ,Resolution.getPixelsfromPrcntg(1, 0.045) ,Resolution.getPixelsfromPrcntg(2, 0.025));
		more.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		more.addActionListener(this);
		more.setBackground(Color.WHITE);
		more.setForeground(Color.DARK_GRAY);
		
		menuDownload = new JButton("D");
		menuDownload.setBorder(BorderFactory.createLineBorder(Color.RED.darker().darker(), 2, true));
		menuDownload.setBounds(Resolution.getPixelsfromPrcntg(1, 0.4) ,Resolution.getPixelsfromPrcntg(2, 0.65) ,Resolution.getPixelsfromPrcntg(1, 0.02) ,Resolution.getPixelsfromPrcntg(2, 0.02));
		
		this.setLayout(null);
		this.add(resText);
		this.add(tableText);
		this.add(tTables);
		this.add(mainInputPanel);
		this.add(timePanel);
		this.add(enter);
		this.add(more);
		this.add(menuDownload);
		this.setBounds(Resolution.getPixelsfromPrcntg(1, 0.3), 0, Resolution.getPixelsfromPrcntg(1, 0.8), Resolution.getPixelsfromPrcntg(2, 1));
		this.setVisible(true);
		this.setBackground(Color.GREEN.darker().darker().darker());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(enter)) {
			int jeweb=JOptionPane.showConfirmDialog(null, "Confirm this as your choice of reservation?", EntryForm.RESTAURANT_NAME, JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE, EntryForm.MAIN_ICON);
			if(jeweb==0) {
			if(tableNums.getSelectedItem()==null || menuNums.getSelectedItem().toString().compareTo(" ")==0 
					|| types.getSelectedItem().toString().compareTo(" ")==0 || year.getSelectedItem().toString().compareTo("Year")==0
					|| month.getSelectedItem().toString().compareTo("Month")==0 || day.getSelectedItem().toString().compareTo("Day")==0)
				JOptionPane.showMessageDialog(null, "Must select from each category to reserve!", EntryForm.RESTAURANT_NAME, JOptionPane.OK_OPTION);
			else {//Save inside
				String tableID = tableNums.getSelectedItem().toString();
				String menuName = menuNums.getSelectedItem().toString();
				String getYear = year.getSelectedItem().toString();
				String getMonth = infoDirect.monthtoNUMBER(month.getSelectedItem().toString());
				String getDay = day.getSelectedItem().toString();
				int menuID = infoDirect.menutoID(menuName);
				float getTablePrice = infoDirect.getTPrice(Integer.parseInt(tableNums.getSelectedItem().toString()));
				float getMenuPrice = infoDirect.getMPrice(menuID);
				float getFinalPrice = infoDirect.getFinalPrice(getTablePrice, getMenuPrice);
				ReservationInfo reservation = new ReservationInfo(Integer.parseInt(tableID), user.getUserID(),menuID 
							,Infopass.setTime(getYear ,getMonth ,getDay), getFinalPrice, types.getSelectedItem().toString());
				infoDirect.generateRID(reservation);
				DataFile.reservations.add(reservation);
				DataFile dtF = new DataFile();
				try {
					dtF.saveToRes();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}//Save inside
			}
		}
		if(e.getSource().equals(more)) {
			String[][] newdata = infoDirect.toTableExtended();
			Tables_Av showTs = new Tables_Av(newdata);
		}
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getSource());
		if(e.getSource().equals(year) && year.getSelectedItem().toString().compareTo("Year")==0) {
			month.setEnabled(false);
			day.setEnabled(false);
		}
		if(e.getSource().equals(month) && month.getSelectedItem().toString().compareTo("Month")==0) {
			day.setEnabled(false);
		}
		if(e.getSource().equals(year) && year.getSelectedItem().toString().compareTo("Year")!=0) {
			month.setVisible(false);
			month.setEnabled(false);
			timePanel.remove(month);
			month = new JComboBox(infoDirect.monthtoNAME(Integer.parseInt(year.getSelectedItem().toString())));
			timePanel.add(month);
			month.setBackground(Color.GREEN.darker().darker());
			month.addItemListener(this);
			month.setEnabled(true);
			month.setVisible(true);
			day.setVisible(false);
			timePanel.remove(day);
			timePanel.add(day);
			day.setBackground(Color.GREEN.darker().darker());
			day.setEnabled(false);
			day.setVisible(true);
		}
		if(e.getSource().equals(month) && month.getSelectedItem().toString().compareTo("Month")!=0 
				&& year.getSelectedItem().toString().compareTo("Year")!=0) {
			int y=Integer.parseInt(year.getSelectedItem().toString());
			int m=Integer.parseInt(infoDirect.monthtoNUMBER(month.getSelectedItem().toString()));
			day.setVisible(false);
			day.setEnabled(false);
			timePanel.remove(day);
			day = new JComboBox(infoDirect.dayLEFT(m,y));
			timePanel.add(day);
			day.setBackground(Color.GREEN.darker().darker());
			day.setEnabled(true);
			day.setVisible(true);
		}
		
	}
}
