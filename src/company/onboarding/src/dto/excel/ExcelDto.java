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

	private String region;
	private String lRpcType;
	private String directStore;
	private String wsCode;
	private String branch;
	private String wsr;
	private String companyName;
	private String wsType;
	private String kwan;
	private String status;
	private String wsEmail;
	private String wsName;
	private String wsPhone;
	private String wsrName;
	private String wsrPhone;


}
