package company.onboarding.src.dto.excel;

import lombok.Data;

import java.util.List;

@Data
public class ExcelDto {

	private String path;
	private String filename;
	private int sheetStandardNum;
	private int rowStandardNum;
	private int cellStandardNum;
	private int rows;



}
