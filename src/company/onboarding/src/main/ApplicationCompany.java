package company.onboarding.src.main;

import company.onboarding.src.resouce.OnBoarding;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ApplicationCompany {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		OnBoarding onBoarding = new OnBoarding();
		onBoarding.getExcelDataAndUpdate();

	}
}
