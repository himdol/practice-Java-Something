package company.onboarding.src.resouce;

import company.onboarding.src.CommonConstant;
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
		String path = "C:/Users/이힘찬/Downloads/";

		ExcelDto excelDto = new ExcelDto();
		excelDto.setPath(path);
		excelDto.setFilename(this.getFilename(path));
		excelDto.setSheetStandardNum(CommonConstant.ZERO);
		excelDto.setRowStandardNum(2);
		excelDto.setCellStandardNum(2);

		List<ExcelDto> excelDtoList = excelUtility.excelReader(excelDto);

		this.printExcelListToValue(excelDtoList);
//	TODO - 제목 seq 번호로 다른 ROW 의 셀까지 지워주기.


		return 0;
	}


	private void printExcelListToValue(List<ExcelDto> excelDtoList) {
		excelDtoList.stream().forEach(System.out :: println);
	}

	private void removeCellWithTitleNumber(List<ExcelDto> excelDtoList) {




	}



}
