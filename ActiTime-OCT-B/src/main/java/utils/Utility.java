package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException 
	{
		String path = "C:\\Users\\Administrator\\Desktop\\Book1.xls";
	
		FileInputStream file = new FileInputStream(path);
	
		try {
		String data = WorkbookFactory.create(file).getSheet("Ajay").getRow(row).getCell(cell).getStringCellValue();
		return data;
		}
		catch(IllegalStateException e){
			double data = WorkbookFactory.create(file).getSheet("Ajay").getRow(row).getCell(cell).getNumericCellValue();
			String s=String.valueOf(data);
			return s;
		}
	
		
	}
	public static void getScreenshot(WebDriver driver,int testID) throws IOException 
	{
		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH mm ss");
			LocalDateTime now = LocalDateTime.now();
	
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\Administrator\\Desktop\\seleniumscreenshots\\test "+testID +" "+dtf.format(now)+".jpg");
			FileHandler.copy(src, dest);
		
	
	}
	
	
}
