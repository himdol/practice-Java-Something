package company.onboarding.src.resouce;

import company.onboarding.src.CommonConstant;
import company.onboarding.src.common.ExcelUtility;
import company.onboarding.src.dto.excel.ExcelDto;
import company.onboarding.src.entity.onboarding.OnboardingEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnBoarding {

	/**
	 * 엑셀 파일에서 값을 읽어와 DB반영
	 * @return int
	 */
	public int getExcelDataAndUpdate() {
		ExcelUtility excelUtility = new ExcelUtility();
		String path = "C:/Users/이힘찬/Downloads/";
		String fileName = "온보딩 db입력";

		ExcelDto excelDto = new ExcelDto();
		excelDto.setPath(path);
		excelDto.setFilename(this.getFilename(fileName, path));
		excelDto.setSheetStandardNum(CommonConstant.ZERO);
		excelDto.setRowStandardNum(2);
		excelDto.setCellStandardNum(2);
		// 엑셀 값 읽어오기
		List<ExcelDto> excelDtoList = excelUtility.excelReader(excelDto);


		this.printExcelListToValue(excelDtoList);

		return 0;
	}

	/**
	 * LOCAL의 파일 경로에서 엑셀파일의 이름을 가지고 오는 Method
	 * @param fileName
	 * @param path
	 * @return String-fileName
	 */
	private String getFilename(String fileName, String path) {
		ExcelUtility excelUtility = new ExcelUtility();
		String returnString = excelUtility.getDirListFindByWord(fileName, path);
		return returnString;
	}

	/**
	 * List를 console에 Print 해주는 Method
	 * @param excelDtoList
	 */
	private void printExcelListToValue(List<ExcelDto> excelDtoList) {
		excelDtoList.stream().forEach(System.out :: println);
	}


}
