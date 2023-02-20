package company.onboarding.src.dao.onboardingdao;

import company.onboarding.src.db.DAO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class OnboardingDao {
	public OnboardingDao() throws IOException, ParserConfigurationException, TransformerException, SAXException {
		DAO dao = new DAO();
	}
}
