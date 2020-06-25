package NetmedsTestcase;

import com.borland.silktest.jtf.BrowserBaseState;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;

public class Netmeds {

	private Desktop desktop = new Desktop();
	
	@Before
	public void baseState() {
		// Go to web page 'www.netmeds.com'
		BrowserBaseState baseState = new BrowserBaseState();
		baseState.execute(desktop);
		BrowserApplication app = desktop.find("//BrowserApplication");
	    app.maximize();
	}

	@Test
	
	public void Test1() throws SQLException {
		//Login to the Netmeds account
		 String sMobileNumber,sSearchProduct,sPincode,sCity,sState,sStreet,slandmark;
		 
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Load Driver
		     
	        String database="E:\\Silk_Git\\Netmeds\\Datatable\\NetmedsTestData.accdb";//Here database exists in the current directory  
	        String url="jdbc:ucanaccess://"+database;  
  
		    Connection c=DriverManager.getConnection(url);    
		       Statement stment=c.createStatement();  
               ResultSet rs=stment.executeQuery("SELECT * FROM Table1"); 

	        while(rs.next())
	        {
	        	sMobileNumber    = rs.getString("sMobileNumber") ;
	        	sSearchProduct = rs.getString("sSearchProduct");
	        	sPincode= rs.getString("sPincode") ;
	        	sCity= rs.getString("sCity") ;
	        	sState= rs.getString("sState") ; 	
	        	sStreet= rs.getString("sStreet") ;
	        	slandmark= rs.getString("slandmark") ;

	     	 
	        	        
	    //desktop.<PushButton>find("WebBrowser.Maximize").select();
		desktop.<DomLink>find("NetmedsLoginPage.BrowserWindow.lnk_SignInSignUp").click();
		desktop.<DomTextField>find("NetmedsLoginPage.BrowserWindow.txt_MobileNumber").typeKeys(sMobileNumber);
		desktop.<DomButton>find("NetmedsLoginPage.BrowserWindow.btn_UsePassword").click();
		desktop.<DomTextField>find("NetmedsLoginPage.BrowserWindow.txt_Password").typePasswordKeys("yEFqB9G1KcOIli4=");
		desktop.<DomButton>find("NetmedsLoginPage.BrowserWindow.btn_SignIn").click();
		
		//Search the product and add the product to Cart.
		
		desktop.<DomTextField>find("NetmedsMainPage.BrowserWindow.txt_Search").setText(sSearchProduct);
		desktop.<DomButton>find("NetmedsMainPage.BrowserWindow.SearchIcon").click();
		desktop.<DomButton>find("NetmedsMainPage.BrowserWindow.btn_AddToCart").click();
		desktop.<DomElement>find("NetmedsMainPage.BrowserWindow.img_NetmedsLogo").click();
		
		//Go to my cart and change the delivery address
		
		desktop.<DomElement>find("NetmedsMainPage.BrowserWindow.MyCart").click();
		desktop.<DomButton>find("NetmedsMyCartPage.BrowserWindow.btn_Proceed").click();
	    desktop.<DomLink>find("NetmedsMyCartPage.BrowserWindow.lbl_Change").click();
		desktop.<DomLink>find("NetmedsMyCartPage.BrowserWindow.lnk_AddNewAddress").click();
		desktop.<DomTextField>find("NetmedsMyCartPage.BrowserWindow.txt_PinCode").typeKeys(sPincode);
		desktop.<DomTextField>find("NetmedsMyCartPage.BrowserWindow.txt_City").typeKeys(sCity);
		desktop.<DomTextField>find("NetmedsMyCartPage.BrowserWindow.txt_State").typeKeys(sState);
		desktop.<DomTextField>find("NetmedsMyCartPage.BrowserWindow.txt_Street").typeKeys(sStreet);
		desktop.<DomTextField>find("NetmedsMyCartPage.BrowserWindow.txt_Landmark").typeKeys(slandmark);
		desktop.<DomButton>find("NetmedsMyCartPage.BrowserWindow.btn_Save Address").click();
		desktop.<DomElement>find("NetmedsMainPage.BrowserWindow.img_NetmedsLogo").click();
		
	    //logout from the Netmeds account
		
		desktop.<DomLink>find("NetmedsMainPage.BrowserWindow.loggedUser").click();
		desktop.<DomLink>find("UserAccountPage.BrowserWindow.btn_Logout").click();
		BrowserApplication app = desktop.find("//BrowserApplication");
		app.close();
       }
	   
	}
		 catch(Exception e) {
	        	System.out.println(e);
	        	
	        } 	 
	}
	
}
