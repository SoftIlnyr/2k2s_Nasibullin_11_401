package ru.kpfu.itis.SoftIlnyr.mvc.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by softi on 06.05.2016.
 */
public class TalonExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        List<Talon> talonList = (List<Talon>) model.get("talons");

        //create a wordsheet
        HSSFSheet sheet = workbook.createSheet("Java book");

        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");

        header.createCell(1).setCellValue("User");

        header.createCell(2).setCellValue("Book");

        header.createCell(3).setCellValue("Library");

        header.createCell(4).setCellValue("Status");

        int rowCount = 1;
        for (Talon talon : talonList) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(talon.getId());
            aRow.createCell(1).setCellValue(talon.getUser().getFirstName() + " " + talon.getUser().getSurname());
            aRow.createCell(2).setCellValue(talon.getBook().getTitle());
            aRow.createCell(3).setCellValue(talon.getLibrary().getName());
            aRow.createCell(4).setCellValue(talon.getStatus());
        }
    }
}
