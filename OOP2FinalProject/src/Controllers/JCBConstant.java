package Controllers;

public class JCBConstant {

	public final static String AVAILABLE="Available";
	public final static String HOLD="Hold";
	public final static char CLIENT='A';
	public final static char ADMIN='B';
	public static String MAIN_LINK_EXCECUTION = "";
	
	public String[] Branches() {
		String[] returner = {" ","Zahle","Beirut","Jounieh","Jbeil","Zgharta"};
		return returner;
	}
	public String[] tableSize() {
		String[] returner = new String[101];
		returner[0]=" ";
		for(int i=1;i<101;i++) returner[i] = i+"";
		return returner;
	}
	public String[] tablePrice() {
		String[] returner = new String[2000];
		int j=0;
		returner[j]=" ";
		j++;
		for(float i=0.5f;i<1000;i=i+0.5f) {
			returner[j]=i+"";
			j++;
		}
		return returner;
	}
	public String[] tableAvailability() {
		String[] returner = {" ","Available","Hold"};
		return returner;
	}
	public String[] resType() {
		String[] returner = {" ","Birthday","Dining","Party","Gathering"};
		return returner;
	}
	public String[] menuType() {
		String[] returner = {" ","Dessert","Drink","Salad","Fast food","Seafood","Main dish"};
		return returner;
	}
	public String[] menuPrice() {
		String[] returner = new String[1001];
		float adder = 0.5f;
		returner[0]=" ";
		for(int i=1;i<1001;i++) {
			returner[i]= adder+"";
			adder = adder +0.5f;
		}
		return returner;
	}
	public String[] resDates() {
		Infopass infoDirect = new Infopass();
		String[] month12;
		int counter=0;
		String [] year12 = infoDirect.yearNOW();
		for(int year=1;year<3;year++) {
			//year12[i]
			month12 = infoDirect.monthLEFT(Integer.parseInt(year12[year]));
			for(int month=1;month<month12.length;month++) {
				String[] day12 = infoDirect.dayLEFT(Integer.parseInt(month12[month]), Integer.parseInt(year12[year]));
				for(int day=1;day<day12.length;day++) {
					counter++;
				}
			}
		}
		String[] returner = new String[counter];
		int j=counter;
		
		for(int year=1;year<3;year++) {
			//year12[i]
			month12 = infoDirect.monthLEFT(Integer.parseInt(year12[year]));
			for(int month=1;month<month12.length;month++) {
				String[] day12 = infoDirect.dayLEFT(Integer.parseInt(month12[month]), Integer.parseInt(year12[year]));
				for(int day=1;day<day12.length;day++) {
					returner[j-(counter--)]=year12[year]+":"+month12[month]+":"+day12[day];
					
				}
			}
		}
		return returner;
	}

	
}