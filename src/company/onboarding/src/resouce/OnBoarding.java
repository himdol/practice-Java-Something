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

		List<ExcelDto> result = this.removeWhenFirstDataIsFalseOfExcelDtoList(excelDtoList);
		this.printExcelListToValue(result);

		return 0;
	}



	private void printExcelListToValue(List<ExcelDto> excelDtoList) {
		excelDtoList.stream().forEach(System.out :: println);
	}

	private List<ExcelDto> removeWhenFirstDataIsFalseOfExcelDtoList(List<ExcelDto> excelDtoList) {

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
						CommonConstant.ExcludeTitle.WSR_NAME
		};

		List<ExcelDto> firstRow = excelDtoList.stream()
						.filter(e -> Integer.valueOf(0).equals(e.getRows()))
						.collect(Collectors.toList());
		List<String> firstRowValueList = firstRow.get(0).getValueList();

		int idx = 0;
		ArrayList<Integer> titleIndexes = new ArrayList<>();

		for (String valueList : firstRowValueList) {
			for (String title : titleList) {
				if (valueList.equals(title)) {
					titleIndexes.add(Integer.valueOf(idx));
				}
			}
			idx++;
		}

		idx = 0;
		List<ExcelDto> afterMakeExcelDtoList = new ArrayList<>();

		for (ExcelDto excelDto : excelDtoList) {
			ExcelDto afterMakeExcelDto = new ExcelDto();
			List<String> afterMakeValueList = new ArrayList<>();
			afterMakeExcelDto.setRows(idx);

			for (int i = 0; i < excelDto.getValueList().size(); i++) {
				for (Integer titleIdx : titleIndexes) {
					if (Integer.valueOf(i).equals(titleIdx)) {
						afterMakeValueList.add(excelDto.getValueList().get(i));
					}
				}
			}
			if(excelDto.getValueList().get(0).equals("false")){
				System.out.print("ROWS NUMBER :: " + excelDto.getRows() + " -> ");
				System.out.println(excelDto.getValueList().toString());
			} else {
				afterMakeExcelDto.setValueList(afterMakeValueList);
				afterMakeExcelDtoList.add(afterMakeExcelDto);
			}
			idx++;
		}

		return afterMakeExcelDtoList;
	}
}
