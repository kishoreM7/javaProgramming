package Org_InsuranceDomain_Clients;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.LIMS.baseClass.ConfigurationClass;
import com.LIMS.genericUtility.annotations.Record;
import com.LIMS.objectRepository.CommonPage;
import com.LIMS.objectRepository.ModuleName;
import com.LIMS.objectRepository.payments.AddPaymentsPage;
import com.LIMS.objectRepository.payments.PaymentsInformationPage;

public class AddPaymentTest extends ConfigurationClass {
	@Test
	public void addPaymentTest() {
		String TestCaseName = "AddPaymentTest";
		// data
		Map<String, String> data = excelUtility.getData("ClientVerificationData", "AddPaymentTest");
		data.get("loginPageTitle");
		System.out.println(data);
		CommonPage commonPage = new CommonPage(driver);
		// login page
		Map<String, String> map = excelUtility.getData("Client", TestCaseName);
		// login to application
		commonPage.clickModule(ModuleName.PAYMENTS);
		Assert.fail();
		Assert.assertEquals(driver.getTitle(), data.get("paymentsTitle"));
		PaymentsInformationPage paymentsInformationPage = new PaymentsInformationPage(driver);
		paymentsInformationPage.clickaddPaymentsBtn();
		Assert.assertEquals(driver.getTitle(), data.get("addpaymentsTitle"));
		AddPaymentsPage addPaymentsPage = new AddPaymentsPage(driver);
		addPaymentsPage.addNewPayment(map);
		Assert.assertEquals(driver.getTitle(), data.get("insertPayment"));

	}
}
