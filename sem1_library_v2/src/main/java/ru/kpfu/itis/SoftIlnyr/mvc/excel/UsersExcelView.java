package ru.kpfu.itis.SoftIlnyr.mvc.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by softi on 06.05.2016.
 */
public class UsersExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        List<User> userList = (List<User>) model.get("users");

        //create a wordsheet
        HSSFSheet sheet = workbook.createSheet("Java book");

        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");

        header.createCell(1).setCellValue("Nickname");

        header.createCell(2).setCellValue("First name");

        header.createCell(3).setCellValue("Surname");

        header.createCell(4).setCellValue("Role");

        int rowCount = 1;
        for (User user : userList) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(user.getId());
            aRow.createCell(1).setCellValue(user.getNickname());
            aRow.createCell(2).setCellValue(user.getFirstName());
            aRow.createCell(3).setCellValue(user.getSurname());
            aRow.createCell(4).setCellValue(user.getRole());
        }
    }
}
