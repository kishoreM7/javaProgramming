package Org_InsuranceDomain_Clients;

import java.util.Map;
import org.testng.annotations.Test;
import com.LIMS.baseClass.ConfigurationClass;
import com.LIMS.genericUtility.annotations.Record;
import com.LIMS.objectRepository.CommonPage;
import com.LIMS.objectRepository.ModuleName;
import com.LIMS.objectRepository.clients.ClientsInformationPage;
import com.LIMS.objectRepository.clients.ClientsStatusPage;
import com.LIMS.objectRepository.clients.EditClientPage;

public class UpdateClientTest extends ConfigurationClass {
	@Record(author = "kishore mallarapu")
	@Test
	public void updateClientTest() {
		String clientId = "1676462459";
		String testCaseName = "UpdateClientTest";
		Map<String, String> verifyData = excelUtility.getData("ClientVerificationData", testCaseName);
		CommonPage commonPage = new CommonPage(driver);
		ClientsInformationPage clientsInformationPage = new ClientsInformationPage(driver);
		// login page
		commonPage.clickModule(ModuleName.CLIENTS);
		System.out.println(driver.getTitle());
		// Assert.assertEquals(driver.getTitle(), verifyData.get("clientsPageTitle"));
		clientsInformationPage.scrollToElementAndClickOnEditClient(clientId);
		ClientsStatusPage clientsStatusPage = new ClientsStatusPage(driver);
		clientsStatusPage.clickOneditLink();
		Map<String, String> data = excelUtility.getData("editClient", testCaseName);
		EditClientPage editclientPage = new EditClientPage(driver);
		editclientPage.updateClientInformation("client_password", data.get("client_password"));

	}
}