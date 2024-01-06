

import javax.swing.JTable;

public class TTable extends JTable{
	private static final long serialVersionUID = 1L;
	
	public TTable(String[][]data,String[]cols) {
		super(data,cols);
	}
	
	public boolean isCellEditable(int row, int column) {                
        return false;
}
}
