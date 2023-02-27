package company.onboarding.src.main;

import company.onboarding.src.common.ExcelUtility;
import company.onboarding.src.db.DAO;
import company.onboarding.src.resouce.OnBoarding;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ApplicationCompany {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		OnBoarding on = new OnBoarding();
//		on.makeToExcelFileAndUpdate();
//		DAO dao = new DAO();
//		dao.getConnection();

		String path = "C:/Users/이힘찬/Downloads/";	//파일 경로 설정
		String filename = "edi_mgt_list.xls";	//파일명 설정
		ExcelUtility.excelReader(path, filename);


	}
}
