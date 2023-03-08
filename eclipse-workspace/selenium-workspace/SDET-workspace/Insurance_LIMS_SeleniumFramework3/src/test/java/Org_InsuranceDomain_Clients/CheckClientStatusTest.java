package Org_InsuranceDomain_Clients;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.LIMS.baseClass.ConfigurationClass;
import com.LIMS.genericUtility.annotations.Record;

import com.LIMS.objectRepository.CommonPage;
import com.LIMS.objectRepository.LoginPage;
import com.LIMS.objectRepository.ModuleName;
import com.LIMS.objectRepository.clients.ClientsInformationPage;

public class CheckClientStatusTest extends ConfigurationClass {
	@Record(author = "kishore")
	@Test
	public void cheackClientStatusTest() {
		String clientId = "1511987920";
		String testCaseName = "CheckClientStatusTest";
		//<String, String> verifyData = excelUtility.getData("ClientVerificationData", testCaseName);
		//Assert.assertEquals(driver.getTitle(), verifyData.get("loginPageTitle"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(username, password);
		//Assert.assertEquals(driver.getTitle(), verifyData.get("homePageTitle"));
		CommonPage commonPage = new CommonPage(driver);
		commonPage.clickModule(ModuleName.CLIENTS);
		//Assert.assertEquals(driver.getTitle(), verifyData.get("clientsPageTitle"));
		ClientsInformationPage clientsInformationPage = new ClientsInformationPage(driver);
		clientsInformationPage.validateClient(clientId);
	}
}
