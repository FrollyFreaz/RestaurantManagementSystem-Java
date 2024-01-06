import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tables_Av extends JFrame{
	private String[] columns = {"Number","Branch","Size","Price","Availability"};
	
	public Tables_Av(String[][] data) {
		TTable dat = new TTable(data,columns);
		dat.setBorder(BorderFactory.createRaisedBevelBorder());
		dat.setShowVerticalLines(false);
		dat.setFont((new Font("Roman",Font.PLAIN,14)));
		dat.setGridColor(Color.GREEN.darker().darker().darker().darker());
		dat.setRowHeight(30);
		
		JScrollPane jsp = new JScrollPane(dat);
		jsp.setBackground(Color.GREEN.darker().darker());
		jsp.setBorder(BorderFactory.createRaisedBevelBorder());
		jsp.setVisible(true);
		
		this.setTitle("Tables");
		this.add(jsp);
		this.setResizable(false);
		this.setBounds(300, 200, 650, 450);
		this.setVisible(true);
	}
	
}
