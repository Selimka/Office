import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelWriter
{
    public void writeTable(String[][] data, File file) throws IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet();
        
        for (int i = 0; i < data.length; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                try {
                    double num = Double.parseDouble(data[i][j].replace(',', '.'));
                    row.createCell(j).setCellValue(num);
                    XSSFDataFormat format = book.createDataFormat();
                    XSSFCellStyle style = book.createCellStyle();
                    style.setDataFormat(format.getFormat("0.0"));
                    row.getCell(j).setCellStyle(style);
                } catch (NumberFormatException ex) {
                    row.createCell(j).setCellValue(data[i][j]);
                }
            }
        }
        OutputStream os = new FileOutputStream(file);
        book.write(os);
    }
}
