package Controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Models.*;

public class Infopass {
	
	
	public static void intialize() {
		DataFile initData = new DataFile();
		DataFile.users = initData.getUsers();
		DataFile.tables = initData.getTables();
		DataFile.reservations = initData.getRes();
		DataFile.menu = initData.getMenu();
	}
	
	public boolean phoneSyntax(String phone) {
		int counter=0;
		for(int i=0; i<10;i++) {
				for(int j=0;j<phone.length();j++) {
					if(i+48==phone.charAt(j))
						counter++;
				}
		}
		if(counter==phone.length())
			return true;
		else
			return false;
	}
	//Is phone syntax right? All numbers? [true for yes | false for no]
	
	public boolean phoneUnique(String phone) {
		int size =DataFile.users.size();
		for(int i=0;i<size;i++) {
			if(DataFile.users.get(i).getPhone().compareTo(phone)==0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean passName(String name) {
		for(int i=0;i<128;i++) {
			if(name.indexOf(i)!=-1 && i<65) {
				return false;
			}
			else if(i>90 && i<97) {
				if(name.indexOf(i)!=-1 && i<65) {
					return false;
				}
			}
			else if(i>122) {
				if(name.indexOf(i)!=-1 && i<65) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean mailSyntax(String mail) {
		int indexA =mail.indexOf('@');
		int indexCOM =mail.indexOf(".com");
		if(indexA!=-1 && indexCOM!=-1 && indexCOM>indexA)
			return true;
		return false;
	}
	
	public boolean mailUnique(String mail) {
		int size =DataFile.users.size();
		for(int i=0;i<size;i++) {
			if(DataFile.users.get(i).getEmail().compareTo(mail)==0) {
				return false;
			}
		}
		return true;
	}

	public static void generateUID(UserInfo user) {
		int record=10000,compare,_MAX=10000;
		if(DataFile.users.size()==0) {
			user.setUserID(record);
			return;
		}
		for(int i=0;i<DataFile.users.size();i++) {
			compare = DataFile.users.get(i).getUserID();
			if(compare>_MAX) {
				_MAX=compare;
			}
		}
		_MAX++;
		user.setUserID(_MAX);
	}

	public boolean userConfirmer(String mail,String password) {
		int size=DataFile.users.size();
		for(int i=0;i<size;i++) {
			if(DataFile.users.get(i).getEmail().compareTo(mail)==0 && DataFile.users.get(i).getPassword().compareTo(password)==0) {
				return true;
			}
		}
		return false;
	}

	public boolean isAdmin(String mail) {
		int size = DataFile.users.size();
		for(int i=0;i<size;i++) {
			if(DataFile.users.get(i).getEmail().compareTo(mail)==0 && DataFile.users.get(i).getIdentifier()==JCBConstant.ADMIN) {//A client B admin
					return true;
			}
		}
		return false;
	}

	public String name(String mail) {
		int size = DataFile.users.size();
		for(int i=0;i<size;i++) {
			if(DataFile.users.get(i).getEmail().compareTo(mail)==0) {//A client B admin
					return DataFile.users.get(i).getFirstname();
			}
		}
		return null;
	}
	
	public UserInfo getUser(String mail) {
		int size=DataFile.users.size();
		for(int i=0;i<size;i++) {
			if(DataFile.users.get(i).getEmail().compareTo(mail)==0) {
				return DataFile.users.get(i);
			}
		}
		return null;
	}
	
	public boolean confirmWHO(String who) {
		who = who.toLowerCase().replaceAll(" ", "");
		if(who.compareTo("admin")==0 || who.compareTo("client")==0) return true;
		return false;
	}
	
	public char getWHO(String who) {
		who = who.toLowerCase().replaceAll(" ", "");
		if(who.compareTo("admin")==0) return JCBConstant.ADMIN;
		return JCBConstant.CLIENT;
	}
	
	public String[][] toTable(){
	String[][] toTable=new String[10][5];
	int size =DataFile.tables.size();
	int j=0;
	for(int i=0;i<size;i++) {
		if(DataFile.tables.get(i).getAvailability().compareTo(JCBConstant.AVAILABLE)==0) {
			toTable[j][0]="  "+DataFile.tables.get(i).getNumber();
			toTable[j][1]=DataFile.tables.get(i).getBranch()+"";
			toTable[j][2]=DataFile.tables.get(i).getNumPeople()+"";
			toTable[j][3]=DataFile.tables.get(i).getPrice()+"";
			toTable[j][4]=DataFile.tables.get(i).getAvailability()+"";
			j++;
			if(j==10)
				break;
		}
	}
	return toTable;
	}
	
	public String[][] toTableExtended(){
		int size =DataFile.tables.size();
		int j=0,counter=0;
		
		for(int i=0;i<size;i++) {
			if(DataFile.tables.get(i).getAvailability().compareTo(JCBConstant.AVAILABLE)==0)
				j++;
			
		}
		String[][] toTable=new String[j][5];
		for(int i=0;i<size;i++) {
			if(DataFile.tables.get(i).getAvailability().compareTo(JCBConstant.AVAILABLE)==0) {
				toTable[counter][0]="  "+DataFile.tables.get(i).getNumber();
				toTable[counter][1]=DataFile.tables.get(i).getBranch()+"";
				toTable[counter][2]=DataFile.tables.get(i).getNumPeople()+"";
				toTable[counter][3]=DataFile.tables.get(i).getPrice()+"";
				toTable[counter][4]=DataFile.tables.get(i).getAvailability()+"";
				counter++;
			}
		}
		
		return toTable;
		}

	public String[] getTableNums() {
		int size = DataFile.tables.size();
		int counter=0;
		String[] allTs =new String[size+1];
		
		int j=0;
		allTs[j]=" ";
		for(int i=1;i<size+1;i++) {
			if(DataFile.tables.get(i-1).getAvailability().compareTo(JCBConstant.AVAILABLE)==0) {
				j++;
				allTs[j]=DataFile.tables.get(i-1).getNumber()+"";
			}
			
		}
		for(int i=1;i<allTs.length;i++) {
			if(allTs[i]!=null)
				counter++;
		}
		counter++;
		String[] returnthis = new String[counter];
		for(int i=1;i<counter;i++) {
			returnthis[i]=allTs[i];
		}
		allTs=null;
		return returnthis;
	}
	
	public static void generateTID(TableInfo tableIn) {
		int record=1,compare,_MAX=1;
		if(DataFile.tables.size()==0) {
			tableIn.setNumber(record);
			return;
		}
		for(int i=0;i<DataFile.tables.size();i++) {
			compare = DataFile.tables.get(i).getNumber();
			if(compare>_MAX) {
				_MAX=compare;
			}
			
		}
		_MAX++;
		tableIn.setNumber(_MAX);
	}
	
	
	
	public float getTPrice(int tableN) {//3
		int size=DataFile.tables.size();
		for(int i=0;i<size;i++) {
			if(DataFile.tables.get(i).getNumber()==tableN)
				return DataFile.tables.get(i).getPrice();
		}
		return -1;
	}
	
	public float getMPrice(int menuN) {//2
		int size=DataFile.menu.size();
		for(int i=0;i<size;i++) {
			if(DataFile.menu.get(i).getNumber()==menuN)
				return DataFile.menu.get(i).getPrice();
		}
		return -1;
	}
	
	public float getFinalPrice(float p1,float p2) {//4
		float floatme =p1+p2;
		return floatme;
	}
	
	public String[] getMenuNames() {
		int counter=0;
		int size=DataFile.menu.size();
		String[] returnMenu = new String[size+1];
		returnMenu[0]=" ";
		for(int i=1;i<size+1;i++) {
			returnMenu[i]=DataFile.menu.get(i-1).getName();
		}
		
		for(int i=1;i<returnMenu.length;i++) {
			if(returnMenu[i]!=null)
				counter++;
		}
		counter++;
		String[] returnthis = new String[counter];
		for(int i=1;i<counter;i++) {
			returnthis[i]=returnMenu[i];
		}
		return returnthis;
	}
	
	public int menutoID(String menuItem) {//1
		int size=DataFile.menu.size();
		for(int i=0;i<size;i++) {
			if(DataFile.menu.get(i).getName().compareTo(menuItem)==0)
				return DataFile.menu.get(i).getNumber();
		}
		return -1;
	}
	
	public static void generateMID(MenuInfo menu) {
		int record=1,compare,_MAX=1;
		if(DataFile.menu.size()==0) {
			menu.setNumber(record);
			return;
		}
		for(int i=0;i<DataFile.menu.size();i++) {
			compare = DataFile.menu.get(i).getNumber();
			if(compare>_MAX) {
				_MAX=compare;
			}
		}
		_MAX++;
		menu.setNumber(_MAX);
	}
	
	public static void generateRID(ReservationInfo resIn) {
		int record=1,compare,_MAX=1;
		if(DataFile.reservations.size()==0) {
			resIn.setNumber(record);
			return;
		}
		for(int i=0;i<DataFile.reservations.size();i++) {
			compare = DataFile.reservations.get(i).getNumber();
			if(compare>_MAX) {
				_MAX=compare;
			}
		}
		_MAX++;
		resIn.setNumber(_MAX);
	}
	
	public String[] getUID() {
		int counter=0;
		int size=DataFile.users.size();
		String[] returnUser = new String[size+1];
		returnUser[0]=" ";
		for(int i=1;i<size+1;i++) {
			returnUser[i]=DataFile.users.get(i-1).getUserID()+"";
		}
		
		for(int i=1;i<returnUser.length;i++) {
			if(returnUser[i]!=null)
				counter++;
		}
		counter++;
		String[] returnthis = new String[counter];
		for(int i=1;i<counter;i++) {
			returnthis[i]=returnUser[i];
		}
		return returnthis;
	}
	
	
	
	public static String dateNOW() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm");
		LocalDateTime now = LocalDateTime.now();
		
		return dtf.format(now);
	}
	public String[] yearNOW() {
		LocalDateTime now = LocalDateTime.now();
		int y2 =now.getYear()+1;
		String[] yearNOW = {"Year",now.getYear()+"",y2+""};
		return yearNOW;
	}
	public String[] monthLEFT(int year) {
		LocalDateTime now = LocalDateTime.now();
		if(year==now.getYear()) {
		int difference =14-now.getMonthValue();
		String[] monthLEFT = new String[difference];
		for(int i=now.getMonthValue();i<=12;i++) {
			monthLEFT[i-now.getMonthValue()+1]=i+"";
		}
		monthLEFT[0]="Month";
		return monthLEFT;
		}
		else {
		String[] newS ={"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
		return newS;
		}
		
	}
	public String[] dayLEFT() {
		String[] dayLEFT = new String[32];
		for(int i=1;i<32;i++) {
			dayLEFT[i]=i+"";
		}
		dayLEFT[0]="Day";
		return dayLEFT;
		
	}
    public String[] dayLEFT(int month,int year) {
		String []days=null;
		int difference;
		LocalDateTime now = LocalDateTime.now();
		if(month==now.getMonthValue() && year==now.getYear()) {
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			difference=33-now.getDayOfMonth();
			days = new String[difference];
			for(int i=now.getDayOfMonth();i<=31;i++) {
				days[i-now.getDayOfMonth()+1]=i+"";
			}
			days[0]="Day";
		}
		if(month==2 || month==4 || month==6 || month==9 || month==11) {
			difference=32-now.getDayOfMonth();
			days = new String[difference];
			for(int i=now.getDayOfMonth();i<31;i++) {
				days[i-now.getDayOfMonth()+1]=i+"";
			}
			days[0]="Day";
		}
		return days;
		}
		else {
			String []altD =null;
			if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
				altD = new String[32];
				altD[0]="Day";
				for(int i=1;i<32;i++) altD[i]=i+"";
				
			}
			else if(month==2 || month==4 || month==6 || month==9 || month==11) {
				altD = new String[31];
				altD[0]="Day";
				for(int i=1;i<31;i++) altD[i]=i+"";
			}
			return altD;
		}
		
	}

	public static String setTime(String getYear, String getMonth, String getDay) {
		return getYear+":"+getMonth+":"+getDay;
	}    
    
	public String[] monthtoNAME(int year) {
		String[] returnthis = monthLEFT(year);
		for(int index=1; index < returnthis.length ; index++) {//Because returnthis[0]="Month" , returnthis[1]="currentmonth", ect...
			switch(returnthis[index]) {
			case "1":
				returnthis[index] = "January";
				break;
			case "2":
				returnthis[index] = "February";
				break;
			case "3":
				returnthis[index] = "March";
				break;
			case "4":
				returnthis[index] = "April";
				break;
			case "5":
				returnthis[index] = "May";
				break;
			case "6":
				returnthis[index] = "Juin";
				break;
			case "7":
				returnthis[index] = "July";
				break;
			case "8":
				returnthis[index] = "August";
				break;
			case "9":
				returnthis[index] = "September";
				break;
			case "10":
				returnthis[index] = "October";
				break;
			case "11":
				returnthis[index] = "November";
				break;
			case "12":
				returnthis[index] = "December";
				break;
				default:
					System.out.println("An error occured!");
			}
		}
		return returnthis;
	}

	public String monthtoNUMBER(String aMONTH) {
			switch(aMONTH) {
			case "January":
				aMONTH = "1";
				break;
			case "February":
				aMONTH = "2";
				break;
			case "March":
				aMONTH = "3";
				break;
			case "April":
				aMONTH = "4";
				break;
			case "May":
				aMONTH = "5";
				break;
			case "Juin":
				aMONTH = "6";
				break;
			case "July":
				aMONTH = "7";
				break;
			case "August":
				aMONTH = "8";
				break;
			case "September":
				aMONTH = "9";
				break;
			case "October":
				aMONTH = "10";
				break;
			case "November":
				aMONTH = "11";
				break;
			case "December":
				aMONTH = "12";
				break;
				default:
					System.out.println("An error occured!");
			}
		return aMONTH;
	}
	
 }