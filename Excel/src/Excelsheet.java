import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excelsheet {

	public static void main(String[] args) throws IOException  {
		String dt_path = "C:/Users/satishraju/Desktop/testSuit.xls";
		String[][] recData = readExcelData(dt_path, "sheet1");

		for(int i=0; i<recData.length; i++)
		{
			for(int j=0; j<recData[0].length; j++)
			{
				System.out.print(recData[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static String[][] readExcelData(String dataTablePath, String sheetName)throws IOException
	{
		/*Step1 get excel path*/
		File xlFile = new File(dataTablePath);//file object
		//step2 get the excel file
		FileInputStream xlDoc = new FileInputStream(xlFile);
		//step3 access workbook

		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);//HSSF is class in poi
		//Step4 access the sheet
		HSSFSheet Sheet = wb.getSheet(sheetName);

		int iRowCount = Sheet.getLastRowNum()+1;
		int iColCount = Sheet.getRow(0).getLastCellNum();

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i=0; i<iRowCount; i++)
		{
			for(int j=0; j<iColCount; j++) {
				xlData[i][j]= Sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return xlData;
	}

}


