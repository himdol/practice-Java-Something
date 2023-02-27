package company.onboarding.src.common;

import company.onboarding.src.dto.excel.ExcelDto;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

	public String getDirListFindByWord(String containString, String path){
		File file = new File(path);
		String[] listName = file.list();
		String returnString = "";
		for (String name : listName) {
			if(name.contains(containString)){
				returnString = name;
			}
		}
		return returnString;
	}

	public List<ExcelDto> excelReader(String path, String filename) {

		List<ExcelDto> excelDtoList = null;

		if (filename != null) {
			excelDtoList = new ArrayList<>();

			try {
				FileInputStream file = new FileInputStream(path + filename);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				NumberFormat f = NumberFormat.getInstance();
				f.setGroupingUsed(false);  //지수로 안나오게 설정

				//시트 갯수
				int sheetNum = workbook.getNumberOfSheets();

				for (int s = 0; s < 1; s++) {
					XSSFSheet sheet = workbook.getSheetAt(s);
					//행 갯수
					int rows = sheet.getPhysicalNumberOfRows();
					for (int r = 0; r < rows; r++) {
						ExcelDto excelDto = new ExcelDto();
						excelDto.setRows(r);
						XSSFRow row = sheet.getRow(r);
						int cells = row.getPhysicalNumberOfCells();
						List<String> valueList = new ArrayList<>();
						for (int c = 0; c < cells; c++) {
							XSSFCell cell = row.getCell(c);
							String value = "";
							if (cell != null) {
								switch (cell.getCellType()) { //타입 체크
									case STRING:
										value = cell.getStringCellValue();
										break;
									case NUMERIC:
										value = f.format(cell.getNumericCellValue()) + "";
										break;
									case BLANK:
										value = cell.getBooleanCellValue() + "";
										break;
									case ERROR:
										value = cell.getErrorCellValue() + "";
										break;
								}
							}
							valueList.add(value);
						}
						excelDto.setValueList(valueList);
						excelDtoList.add(excelDto);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return excelDtoList;
	}
}