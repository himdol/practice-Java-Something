package company.onboarding.src.main;

import company.onboarding.src.resouce.OnBoarding;

public class ApplicationCompany {

	public static void main(String[] args) {
		OnBoarding on = new OnBoarding();
		on.makeToExcelFileAndUpdate();
	}
}
