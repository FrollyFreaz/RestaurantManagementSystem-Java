package Controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import Models.MenuInfo;
import Models.ReservationInfo;
import Models.TableInfo;
import Models.UserInfo;

public class DataFile {
	private final String file1="Users.txt";
	private final String file2="Tables.txt";
	private final String file3="Reservations.txt";
	private final String file4="Menu.txt";
	public static LinkedList<UserInfo> users = new LinkedList<UserInfo>();
	public static LinkedList<TableInfo> tables = new LinkedList<TableInfo>();
	public static LinkedList<ReservationInfo> reservations = new LinkedList<ReservationInfo>();
	public static LinkedList<MenuInfo> menu = new LinkedList<MenuInfo>();

	
	//UserID,Firstname,Lastname,Email,Password,Phone,Identifier
	public LinkedList<UserInfo> getUsers() {
			LinkedList<UserInfo> getUsers = new LinkedList<UserInfo>();
		        String line, cinfo[];
		        try {
		            FileInputStream is = new FileInputStream(file1);
		            InputStreamReader ir = new InputStreamReader(is);
		            BufferedReader bf = new BufferedReader(ir);
		            
		            while (bf.ready()) {
		                line = bf.readLine();
		                cinfo = line.split("#");
		                UserInfo user = new UserInfo(cinfo[1],cinfo[2],
		                		cinfo[3],cinfo[4],cinfo[5],cinfo[6].charAt(0));
		                user.setUserID(Integer.parseInt(cinfo[0]));
		                getUsers.add(user);
		            }
		            bf.close();
		            return getUsers;
		        } catch (IOException io) {
		        	System.out.println("ERROR :Problem while accessing the file occured!");
		        }
		        return getUsers;
			
		}
	
	//Number,Branch,NumPeople,Price,Availability
	public LinkedList<TableInfo> getTables() {
			LinkedList<TableInfo> getTables = new LinkedList<TableInfo>();
		        String line, cinfo[];
		        
		        try {
		            FileInputStream is = new FileInputStream(file2);
		            InputStreamReader ir = new InputStreamReader(is);
		            BufferedReader bf = new BufferedReader(ir);
		            
		            while (bf.ready()) {
		                line = bf.readLine();
		                cinfo = line.split("#");
		                TableInfo table = new TableInfo(cinfo[1], Integer.parseInt(cinfo[2]),Float.parseFloat(cinfo[3]), cinfo[4]);
		                table.setNumber(Integer.parseInt(cinfo[0]));
		                getTables.add(table);
		            }
		            bf.close();
		            
		        } catch (IOException io) {
		        	System.out.println("ERROR :Problem while accessing the file occured!");
		        }
		        return getTables;
			
		}
	
	//Number, tableID, clientID,menuID, date,finalPrice,type
	public LinkedList<ReservationInfo> getRes() {
		LinkedList<ReservationInfo> getRes = new LinkedList<ReservationInfo>();
	        String line, cinfo[];
	        try {
	            FileInputStream is = new FileInputStream(file3);
	            InputStreamReader ir = new InputStreamReader(is);
	            BufferedReader bf = new BufferedReader(ir);
	            
	            while (bf.ready()) {
	                line = bf.readLine();
	                cinfo = line.split("#");
	                ReservationInfo resInfo = new ReservationInfo(Integer.parseInt(cinfo[1])
	                		,Integer.parseInt(cinfo[2]),Integer.parseInt(cinfo[3]) ,cinfo[4],Float.parseFloat(cinfo[5]) ,cinfo[6]);
	                resInfo.setNumber(Integer.parseInt(cinfo[0]));
	                getRes.add(resInfo);
	            }
	            bf.close();
	        } catch (IOException io) {
	        	System.out.println("ERROR :Problem while accessing the file occured!");
	        }
	        return getRes;
		
	}
	
	//Number,Name,Price,Type
	public LinkedList<MenuInfo> getMenu() {
			LinkedList<MenuInfo> getMenu = new LinkedList<MenuInfo>();
		        String line, cinfo[];
		        try {
		            FileInputStream is = new FileInputStream(file4);
		            InputStreamReader ir = new InputStreamReader(is);
		            BufferedReader bf = new BufferedReader(ir);
		            
		            while (bf.ready()) {
		                line = bf.readLine();
		                cinfo = line.split("#");
		                MenuInfo menu = new MenuInfo(cinfo[1] 
		                		,Float.parseFloat(cinfo[2]),cinfo[3]);
		                menu.setNumber(Integer.parseInt(cinfo[0]));
		            	getMenu.add(menu);
		            }
		            bf.close();
		        } catch (IOException io) {
		        	System.out.println("ERROR :Problem while accessing the file occured!");
		        }
		        return getMenu;
			
		}
	
	
	
	
	
	public void clearFile(String selectfile) throws IOException{
        try {
        	if(selectfile==file1||selectfile==file2||selectfile==file3||selectfile==file4) {
            FileWriter fw = new FileWriter(selectfile, false);
            fw.write("");
            fw.close();
            }
        	else
        		System.out.println("ERROR :File entered not accepted!");
        } catch (IOException io) {
        	throw new IOException("Error while opening the file!");
        }
        
    }

	public void saveToClient() throws IOException {
		if(users.size()==0)
			return;
		
		    clearFile(file1);
		for(int i=0;i<users.size();i++) {
			writeToFile(file1,all_U(users.get(i)));
		}
	}
	
	public void saveToTable() throws IOException {
		if(tables.size()==0)
			return;
		clearFile(file2);
		for(int i=0;i<tables.size();i++) {
			writeToFile(file2,all_T(tables.get(i)));
		}
	}
	
	public void saveToRes() throws IOException {
		if(reservations.size()==0)
			return;
		clearFile(file3);
		for(int i=0;i<reservations.size();i++) {
			writeToFile(file3,all_R(reservations.get(i)));
		}
	}
	
	public void saveToMenu() throws IOException {
		if(menu.size()==0)
			return;
		clearFile(file4);
		for(int i=0;i<menu.size();i++) {
			writeToFile(file4,all_M(menu.get(i)));
		}
	}
	
	
	
	
	
	
	
	
	
	
	////PRIVATE FUNCTIONS
	///////
	/////////////
	///////////////////////
	private void writeToFile(String selectfile,String str) {
        try {
        	if(selectfile==file1 || selectfile==file2 || selectfile==file3 || selectfile==file4) {
        		FileWriter fw = new FileWriter(selectfile, true);
                fw.write(str + "\n");
                fw.close();
        	}
        	else
        		System.out.println("ERROR :File entered is not accepted");
        } catch (IOException io) {
        	io.printStackTrace();
        }
    }
	
	private String all_U(UserInfo use) {
		return use.getUserID()+"#"+use.getFirstname()+"#"+use.getLastname()+"#"+use.getEmail()
		+"#"+use.getPassword()+"#"+use.getPhone()+"#"+use.getIdentifier();
	}
	
	private String all_T(TableInfo tab) {
		return tab.getNumber()+"#"+tab.getBranch()+"#"+tab.getNumPeople()+"#"+tab.getPrice()+"#"+tab.getAvailability();
	}
	
	private String all_R(ReservationInfo res) {
		return res.getNumber()+"#"+res.getTableID()+"#"+res.getClientID()+"#"+res.getMenuN()+"#"+res.getDate()+"#"+res.getFinalPrice()+"#"+res.getType();
	}
	
	private String all_M(MenuInfo men) {
		return men.getNumber()+"#"+men.getName()+"#"+men.getPrice()+"#"+men.getType();
	}

	
}