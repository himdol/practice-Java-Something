package company.onboarding.src.resouce;

import company.onboarding.src.common.ExcelUtility;
import company.onboarding.src.dto.excel.ExcelDto;

import java.util.List;

public class OnBoarding {

	public String getFilename(String path) {
		ExcelUtility excelUtility = new ExcelUtility();
		String returnString = excelUtility.getDirListFindByWord("온보딩", path);
		return returnString;
	}

	public int takeToExcelDataAndUpdate() {
		ExcelUtility excelUtility = new ExcelUtility();
		String path = "C:/Users/이힘찬/Downloads/";	//파일 경로 설정
		String filename = this.getFilename(path);	  //파일명 설정
		List<ExcelDto> excelDtoList = excelUtility.excelReader(path, filename);

		excelDtoList.stream().forEach(System.out :: println);

		return 0;
	}





}
