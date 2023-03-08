package Org_InsuranceDomain_Clients;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.LIMS.baseClass.ConfigurationClass;
import com.LIMS.genericUtility.annotations.Record;
import com.LIMS.objectRepository.CommonPage;
import com.LIMS.objectRepository.ModuleName;
import com.LIMS.objectRepository.clients.AddClientPage;
import com.LIMS.objectRepository.clients.ClientsInformationPage;
import com.LIMS.objectRepository.nominee.NomineePage;

public class AddNomineeTest extends ConfigurationClass {
	@Record(author = "kishore")
	@Test
	public void addNomineeTest() throws InterruptedException {
		String TestCaseName = "AddClientTest";
		ClientsInformationPage clientsInformationPage = new ClientsInformationPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		Map<String, String> map = excelUtility.getData("ClientVerificationData", TestCaseName);
		Assert.assertEquals(driver.getTitle(), map.get("homePageTitle"));
		commonPage.clickModule(ModuleName.CLIENTS);
		Assert.assertEquals(driver.getTitle(), map.get("clientsPageTitle"));
		clientsInformationPage.clickOnAddClientButton();
		Assert.assertEquals(driver.getTitle(), map.get("addlientPage"));
		AddClientPage addClientPage = new AddClientPage(driver);
		Map<String, String> data = excelUtility.getData(propertyUtility.getPropertyOfKey("sheetName"),
				propertyUtility.getPropertyOfKey("addClientTestCaseName"));
		addClientPage.addNewClient(data, randomNumber);
		Assert.assertEquals(driver.getTitle(), map.get("clientAdded"));
		String clientId = data.get("client_id");
		// let it be check tomorrow
		NomineePage nomineePage = new NomineePage(driver);

		commonPage.clickModule(ModuleName.NOMINEE);
		nomineePage.clickOnAddNomineeBtn();
		Thread.sleep(3000);

	}

}
