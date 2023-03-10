package company.onboarding.src.resouce;

import company.onboarding.src.CommonConstant;
import company.onboarding.src.common.ExcelUtility;
import company.onboarding.src.dto.excel.ExcelDto;
import company.onboarding.src.dto.excel.OnboardingDto;

import java.util.ArrayList;
import java.util.List;

public class OnBoarding {

	/**
	 * 엑셀 파일에서 값을 읽어와 DB반영
	 *
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
//		ExcelUtility.printExcelListToValue(excelDtoList);
		List<OnboardingDto> onboardingDtoList = this.makeOnboardingDtoList(excelDtoList);
		this.printOnboradingList(onboardingDtoList);


		return 0;
	}


	private List<OnboardingDto> makeOnboardingDtoList(List<ExcelDto> excelDtoList) {
		OnboardingDto onboardingTitleDto = this.makeOnboardingDtoTitle(excelDtoList);
		return this.makeOnboardingDtoContents(onboardingTitleDto, excelDtoList);
	}

	private OnboardingDto makeOnboardingDtoTitle(List<ExcelDto> excelDtoList) {

		List<String> title = excelDtoList.get(0).getValueList();
		OnboardingDto onbDtoTitleIndex = new OnboardingDto();

		for (int i = 0; i < title.size(); i++) {
			if (CommonConstant.ExcludeTitle.REGION.equals(title.get(i))) {
				onbDtoTitleIndex.setRegion(title.get(i));
				onbDtoTitleIndex.setRegionIndex(i);
			} else if (CommonConstant.ExcludeTitle.TYPE_L_RPC.equals(title.get(i))) {
				onbDtoTitleIndex.setLRpcType(title.get(i));
				onbDtoTitleIndex.setLRpcTypeIndex(i);
			} else if (CommonConstant.ExcludeTitle.DIRECT_STORE.equals(title.get(i))) {
				onbDtoTitleIndex.setDirectStore(title.get(i));
				onbDtoTitleIndex.setDirectStoreIndex(i);
			} else if (CommonConstant.ExcludeTitle.WS_CODE.equals(title.get(i))) {
				onbDtoTitleIndex.setWsCode(title.get(i));
				onbDtoTitleIndex.setWsCodeIndex(i);
			} else if (CommonConstant.ExcludeTitle.BRANCH.equals(title.get(i))) {
				onbDtoTitleIndex.setBranch(title.get(i));
				onbDtoTitleIndex.setBranchIndex(i);
			} else if (CommonConstant.ExcludeTitle.WSR.equals(title.get(i))) {
				onbDtoTitleIndex.setWsr(title.get(i));
				onbDtoTitleIndex.setWsrIndex(i);
			} else if (CommonConstant.ExcludeTitle.COMPANY_NAME.equals(title.get(i))) {
				onbDtoTitleIndex.setCompanyName(title.get(i));
				onbDtoTitleIndex.setCompanyNameIndex(i);
			} else if (CommonConstant.ExcludeTitle.WS_TYPE.equals(title.get(i))) {
				onbDtoTitleIndex.setWsType(title.get(i));
				onbDtoTitleIndex.setWsTypeIndex(i);
			} else if (CommonConstant.ExcludeTitle.KWAM.equals(title.get(i))) {
				onbDtoTitleIndex.setKwan(title.get(i));
				onbDtoTitleIndex.setKwanIndex(i);
			} else if (CommonConstant.ExcludeTitle.STATUS.equals(title.get(i))) {
				onbDtoTitleIndex.setStatus(title.get(i));
				onbDtoTitleIndex.setStatusIndex(i);
			} else if (CommonConstant.ExcludeTitle.WS_EMAIL.equals(title.get(i))) {
				onbDtoTitleIndex.setWsEmail(title.get(i));
				onbDtoTitleIndex.setWsEmailIndex(i);
			} else if (CommonConstant.ExcludeTitle.WS_NAME.equals(title.get(i))) {
				onbDtoTitleIndex.setWsName(title.get(i));
				onbDtoTitleIndex.setWsNameIndex(i);
			} else if (CommonConstant.ExcludeTitle.WS_PHONE.equals(title.get(i))) {
				onbDtoTitleIndex.setWsPhone(title.get(i));
				onbDtoTitleIndex.setWsPhoneIndex(i);
			} else if (CommonConstant.ExcludeTitle.WSR_NAME.equals(title.get(i))) {
				onbDtoTitleIndex.setWsrName(title.get(i));
				onbDtoTitleIndex.setWsrNameIndex(i);
			} else if (CommonConstant.ExcludeTitle.WSR_PHONE.equals(title.get(i))) {
				onbDtoTitleIndex.setWsrPhone(title.get(i));
				onbDtoTitleIndex.setWsrPhoneIndex(i);
			}
		}
		return onbDtoTitleIndex;
	}

	private List<OnboardingDto> makeOnboardingDtoContents(OnboardingDto onboardingTitleDto, List<ExcelDto> excelDtoList) {
		List<OnboardingDto> onboardingDtoList = new ArrayList<>();
		for (ExcelDto excelDto : excelDtoList) {
			OnboardingDto onboardingDto = new OnboardingDto();
			for (int i = 0; i < excelDto.getValueList().size(); i++) {
				if (i == onboardingTitleDto.getRegionIndex()) {
					onboardingDto.setRegion(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getLRpcTypeIndex()) {
					onboardingDto.setLRpcType(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getDirectStoreIndex()) {
					onboardingDto.setDirectStore(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsCodeIndex()) {
					onboardingDto.setWsCode(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getBranchIndex()) {
					onboardingDto.setBranch(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsrIndex()) {
					onboardingDto.setWsr(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getCompanyNameIndex()) {
					onboardingDto.setCompanyName(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsTypeIndex()) {
					onboardingDto.setWsType(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getKwanIndex()) {
					onboardingDto.setKwan(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getStatusIndex()) {
					onboardingDto.setStatus(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsEmailIndex()) {
					onboardingDto.setWsEmail(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsNameIndex()) {
					onboardingDto.setWsName(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsPhoneIndex()) {
					onboardingDto.setWsPhone(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsrNameIndex()) {
					onboardingDto.setWsrName(excelDto.getValueList().get(i));
				} else if (i == onboardingTitleDto.getWsrPhoneIndex()) {
					onboardingDto.setWsrPhone(excelDto.getValueList().get(i));
				}
			}
			onboardingDtoList.add(onboardingDto);
		}
		return onboardingDtoList;
	}

	/**
	 * LOCAL의 파일 경로에서 엑셀파일의 이름을 가지고 오는 Method
	 *
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
	 *
	 * @param onboardingDtoList
	 */
	private void printOnboradingList(List<OnboardingDto> onboardingDtoList) {
		onboardingDtoList.stream().forEach(System.out::println);
	}



}
