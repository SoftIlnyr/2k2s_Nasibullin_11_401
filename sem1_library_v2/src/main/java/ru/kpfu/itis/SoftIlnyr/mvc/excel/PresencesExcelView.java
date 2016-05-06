package ru.kpfu.itis.SoftIlnyr.mvc.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by softi on 06.05.2016.
 */
public class PresencesExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        List<Presence> presenceList = (List<Presence>) model.get("presences");

        //create a wordsheet
        HSSFSheet sheet = workbook.createSheet("Java book");

        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");

        header.createCell(1).setCellValue("Book");

        header.createCell(2).setCellValue("Library");

        header.createCell(3).setCellValue("Amount");

        int rowCount = 1;
        for (Presence presence : presenceList) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(presence.getId());
            aRow.createCell(1).setCellValue(presence.getBook().getTitle());
            aRow.createCell(2).setCellValue(presence.getLibrary().getName());
            aRow.createCell(3).setCellValue(presence.getAmount());
        }
    }
}
