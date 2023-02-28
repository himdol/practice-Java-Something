package company.onboarding.src.resouce;

import company.onboarding.src.CommonConstant;
import company.onboarding.src.common.ExcelUtility;
import company.onboarding.src.dto.excel.ExcelDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		this.getCellWithTitleNumber(excelDtoList);

		return 0;
	}


	private void printExcelListToValue(List<ExcelDto> excelDtoList) {
		excelDtoList.stream().forEach(System.out :: println);
	}

	private void getCellWithTitleNumber(List<ExcelDto> excelDtoList) {

		String[] titleList = {
						CommonConstant.ExcludeTitle.REGION ,
						CommonConstant.ExcludeTitle.TYPE_L_RPC ,
						CommonConstant.ExcludeTitle.DIRECT_STORE ,
						CommonConstant.ExcludeTitle.WS_CODE ,
						CommonConstant.ExcludeTitle.BRANCH ,
						CommonConstant.ExcludeTitle.WSR ,
						CommonConstant.ExcludeTitle.COMPANY_NAME ,
						CommonConstant.ExcludeTitle.WS_TYPE ,
						CommonConstant.ExcludeTitle.KWAM ,
						CommonConstant.ExcludeTitle.STATUS ,
						CommonConstant.ExcludeTitle.WS_EMAIL ,
						CommonConstant.ExcludeTitle.WS_NAME ,
						CommonConstant.ExcludeTitle.WS_PHONE,
						CommonConstant.ExcludeTitle.WSR_NAME,
						};

		ArrayList<Integer> titleIndexes = new ArrayList<>();
		List<ExcelDto> aa = excelDtoList.stream()
						.filter(e -> Integer.valueOf(0).equals(e.getRows()))
						.collect(Collectors.toList());
		List<String> aaa = aa.get(0).getValueList();

		int idx = 0;
		for (String a : aaa) {
			for (String b : titleList) {
				if (a.equals(b)) {
					titleIndexes.add(Integer.valueOf(idx));
				}
			}
			idx++;
		}



		titleIndexes.forEach(System.out :: println);
		System.out.println("titleIndexes::: " + titleIndexes.get(0));



	}

}
