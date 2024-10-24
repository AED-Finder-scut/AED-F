/*
* aed表的测试类
* */

package org.example.DataBase.Test;

import org.example.DataBase.AedTable.AEDService;
import org.example.entities.AED;
import org.example.DataBase.AedTable.AEDService;

import java.util.List;

public class AedTableTest {
    public static void main(String[] args) {
        AEDService service = new AEDService();

        // 添加一个 AED
        AED aed = new AED(null, "C17", "C17教师公寓一楼大厅", 23.057886, 113.408575);
        boolean successAdd = service.addAed(aed);
        System.out.println(successAdd ? "Successfully added AED." : "Failed to add AED.");

        // 删除一个 AED
        boolean successDelete = service.deleteAed(1L);
        System.out.println(successDelete ? "Successfully deleted AED." : "Failed to delete AED.");

        // 获取所有的 AED
        List<AED> allAeds = service.getAllAeds();
        for (AED a : allAeds) {
            System.out.println(a.getId() + " " + a.getName() + " " + a.getDescription());
        }
    }
}
