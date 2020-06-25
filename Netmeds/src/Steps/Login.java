package Steps;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class Login
{
	private Desktop desktop = new Desktop();
	public void sign(String sMobileNumber)
	{


	desktop.<DomLink>find("NetmedsLoginPage.BrowserWindow.lnk_SignInSignUp").click();
	desktop.<DomTextField>find("NetmedsLoginPage.BrowserWindow.txt_MobileNumber").typeKeys(sMobileNumber);
	desktop.<DomButton>find("NetmedsLoginPage.BrowserWindow.btn_UsePassword").click();
	desktop.<DomTextField>find("NetmedsLoginPage.BrowserWindow.txt_Password").typePasswordKeys("yEFqB9G1KcOIli4=");
	desktop.<DomButton>find("NetmedsLoginPage.BrowserWindow.btn_SignIn").click();

}

}