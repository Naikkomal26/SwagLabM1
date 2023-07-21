package NewMaven;
import java.io.File;
 
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UtilityClass {

public static String getTD(int rowIndex, int colInex) throws EncryptedDocumentException, IOException
{
File file=new File("/Users/yuvraj/Documents/Book2.xlsx");


Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");

String value =sh.getRow(rowIndex).getCell(colInex).getStringCellValue();
return value; 
}
public static void selectOption(WebElement ele, int index)
{
Select s=new Select(ele); s.selectByIndex(index);
}
public static void selectOptionText(WebElement ele, String visibleText)
{
Select s=new Select(ele); s.selectByVisibleText(visibleText);
}
public static void selectOptionValue(WebElement ele, String value)
{
Select s=new Select(ele); s.selectByValue(value);
} 
}
