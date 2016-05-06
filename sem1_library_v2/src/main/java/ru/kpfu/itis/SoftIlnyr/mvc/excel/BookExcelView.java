package ru.kpfu.itis.SoftIlnyr.mvc.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by softi on 06.05.2016.
 */
public class BookExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        List<Book> bookList = (List<Book>) model.get("books");

        //create a wordsheet
        HSSFSheet sheet = workbook.createSheet("Java book");

        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");

        header.createCell(1).setCellValue("Title");

        header.createCell(2).setCellValue("Author");

        header.createCell(3).setCellValue("Edition");

        header.createCell(4).setCellValue("Issue");

        header.createCell(5).setCellValue("Language");

        int rowCount = 1;
        for (Book book : bookList) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(book.getId());
            aRow.createCell(1).setCellValue(book.getTitle());
            aRow.createCell(2).setCellValue(book.getAuthor().getName() + " " + book.getAuthor().getSurname());
            aRow.createCell(3).setCellValue(book.getEdition());
            aRow.createCell(4).setCellValue(book.getIssue());
            aRow.createCell(5).setCellValue(book.getLanguage());
        }
    }
}
