import javax.swing.JOptionPane;

import Controllers.Infopass;

public class Resolution{
	
	private final int resW1 =1280 ,resH1 =1024,//1280 x 1024
			resW2 =1366 ,resH2 =768,//1366 x 768
			resW3 =1600 ,resH3 =900,//1600 x 900
			resW4 =1920 ,resH4 =1080,//1920 x 1080
	        resW5 =1920 ,resH5 =1200,//1920 x 1200
	        resW6 =2560 ,resH6 =1440,//2560 x 1440 
	        resW7 =3440 ,resH7 =1440,//3440 x 1440
	        resW8 =3840 ,resH8 =2160;//3840 x 2160
	private final String string1 ="1280 x 1024" ,string2 ="1366 x 768" ,string3 ="1600 x 900" ,string4 ="1920 x 1080" ,string5 ="1920 x 1200" ,
			string6 ="2560 x 1440" ,string7 ="3440 x 1440" ,string8 ="3840 x 2160";
	private final String[] multiRESOPT = {string1 ,string2 ,string3 ,string4 ,string5 ,string6 ,string7 ,string8};
	public static int windowWidth ,windowHeight;
	
	
	//Current resolution 1366 x 768
	
	
	public Resolution() {
		
		String answer = (String)JOptionPane.showInputDialog(null ,"Choose a resolution for this device :" ,"Welcome" ,
				JOptionPane.PLAIN_MESSAGE ,null ,multiRESOPT ,string1);
		if((answer!=null) && answer.length()>0) {
			chooseRes(answer);
			Infopass.intialize();
			EntryForm program = new EntryForm();
			program._Account();
		}
	}
	
	private void chooseRes(String choice) {
		switch(choice) {
		case string1:
			windowWidth =resW1;
			windowHeight =resH1;
			break;
		case string2:
			windowWidth =resW2;
			windowHeight =resH2;
			break;
		case string3:
			windowWidth =resW3;
			windowHeight =resH3;
			break;
		case string4:
			windowWidth =resW4;
			windowHeight =resH4;
			break;
		case string5:
			windowWidth =resW5;
			windowHeight =resH5;
			break;
		case string6:
			windowWidth =resW6;
			windowHeight =resH6;
			break;
		case string7:
			windowWidth =resW7;
			windowHeight =resH7;
			break;
                case string8:
        	        windowWidth =resW8;
			windowHeight =resH8;
			break;
		}
	}

	public static int getPixelsfromPrcntg(int widthorlength,double percentage) {//1 for width and 2 for Height
		int finalValue = 0;
		double currentValue = 0;
		String stringValue = "" ,laststringValue = "";
		if(percentage >= 0 && percentage <= 1) {
		if(widthorlength == 1) {//width
			currentValue = percentage * Resolution.windowWidth;
			stringValue = currentValue + "";
			laststringValue = stringValue.substring(0, stringValue.indexOf('.'));
			finalValue = Integer.parseInt(laststringValue);
		}
		else if(widthorlength == 2) {//Height
			currentValue = percentage * Resolution.windowHeight;
			stringValue = currentValue + "";
			laststringValue = stringValue.substring(0, stringValue.indexOf('.'));
			finalValue = Integer.parseInt(laststringValue);
		}
		else widthorlength = -1;
		}
		else { finalValue = -1;}
		return finalValue;
	}
}
