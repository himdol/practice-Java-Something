package company.onboarding.src.dto.excel;

import lombok.Data;

import java.util.List;

@Data
public class ExcelDto {

	private int rows;

	private List<String> valueList;

}
