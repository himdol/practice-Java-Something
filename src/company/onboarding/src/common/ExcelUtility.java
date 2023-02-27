package company.onboarding.src.common;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;

public class ExcelUtility {

	public static void excelReader(String path, String filename) {
		try {
			FileInputStream file = new FileInputStream(path+filename);
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			NumberFormat f = NumberFormat.getInstance();
			f.setGroupingUsed(false);	//지수로 안나오게 설정

			//시트 갯수
			int sheetNum = workbook.getNumberOfSheets();

			for(int s = 0; s < sheetNum; s++) {
				HSSFSheet sheet = workbook.getSheetAt(s);
				//행 갯수
				int rows = sheet.getPhysicalNumberOfRows();

				for(int r = 0 ; r < rows ; r++) {
					HSSFRow row = sheet.getRow(r);

					int cells = row.getPhysicalNumberOfCells();

					System.out.print("|	"+r+"	|");
					for(int c = 0 ; c < cells; c++) {
						HSSFCell cell = row.getCell(c);

						String value = "";
						if(cell!=null) {
							//타입 체크
							switch(cell.getCellType()) {
								case STRING:
									value = cell.getStringCellValue();
									break;
								case NUMERIC:
									value = f.format(cell.getNumericCellValue())+"";
									break;
								case BLANK:
									value = cell.getBooleanCellValue()+"";
									break;
								case ERROR:
									value = cell.getErrorCellValue()+"";
									break;
							}
						}
						System.out.print("		"+value+"		|");
						System.out.println(value.getClass().getName());
					}
					System.out.println();
				}
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}