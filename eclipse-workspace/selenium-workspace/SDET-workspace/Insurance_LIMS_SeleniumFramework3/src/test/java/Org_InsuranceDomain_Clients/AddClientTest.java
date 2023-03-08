package Org_InsuranceDomain_Clients;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.LIMS.baseClass.ConfigurationClass;
import com.LIMS.genericUtility.annotations.Record;
import com.LIMS.genericUtility.instanceTransfer.UtilityInstanceTransfer;
import com.LIMS.objectRepository.CommonPage;
import com.LIMS.objectRepository.ModuleName;
import com.LIMS.objectRepository.clients.AddClientPage;
import com.LIMS.objectRepository.clients.ClientsInformationPage;

public class AddClientTest extends ConfigurationClass {
	@Record(author = "kishore")
	@Test(groups = "sanity")
	public void addClientTest() {
		String TestCaseName = "AddClientTest";

		SoftAssert softAssert = new SoftAssert();

		ClientsInformationPage clientsInformationPage = new ClientsInformationPage(driver);

		CommonPage commonPage = new CommonPage(driver);

		Map<String, String> map = excelUtility.getData("ClientVerificationData", TestCaseName);
		softAssert.assertEquals(driver.getTitle(), map.get("homePageTitle"));
		commonPage.clickModule(ModuleName.CLIENTS);
		softAssert.assertEquals(driver.getTitle(), map.get("clientsPageTitle"));
		report.info(UtilityInstanceTransfer.getExtentTest(), "clients page ");
		clientsInformationPage.clickOnAddClientButton();
		softAssert.assertEquals(driver.getTitle(), map.get("addlientPage"));
		AddClientPage addClientPage = new AddClientPage(driver);
		Map<String, String> data = excelUtility.getData(propertyUtility.getPropertyOfKey("sheetName"),
				propertyUtility.getPropertyOfKey("addClientTestCaseName"));
		addClientPage.addNewClient(data, randomNumber);
		softAssert.assertEquals(driver.getTitle(), map.get("clientAdded"));
		softAssert.assertAll();
	}

}
