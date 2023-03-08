package LIMS.ims.pratice;

import org.testng.annotations.Test;

import com.LIMS.baseClass.ConfigurationClass;
import com.LIMS.objectRepository.LoginPage;

public class commonPagePractice extends ConfigurationClass {
	LoginPage lp;
	
	@Test
	public void login() {
		lp = new LoginPage(driver);
		lp.loginToApplication("555", "666");
		
		
	}

}
