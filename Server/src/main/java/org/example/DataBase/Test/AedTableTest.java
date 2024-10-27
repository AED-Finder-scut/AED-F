/*
 * aed表的测试类
 * */

package org.example.DataBase.Test;

import org.example.service.AEDService;
import org.example.entities.AED;

import java.util.ArrayList;
import java.util.List;

public class AedTableTest {
    public static void main(String[] args) {
        List<AED> aeds=new ArrayList<>();

        aeds.add(new AED(1L, "C17", "C17教师公寓一楼大厅", 23.057886, 113.408575));
        aeds.add(new AED(2L, "生活区操场", "中国邮政旁/生活区运动场器材室门口", 23.056992, 113.408629));
        aeds.add(new AED(3L, "校医院", "校医院门诊部一楼", 23.058651,113.410232 ));
        aeds.add(new AED(4L, "C5", "C5学生宿舍一楼大厅",23.054573 ,113.407973 ));
        aeds.add(new AED(5L, "D2", "D2教师公寓物业服务中心门口", 23.053347, 113.408984));
        aeds.add(new AED(6L, "教学区操场", "教学区操场架空厅",23.051596 ,113.409876 ));
        aeds.add(new AED(7L, "B6", "B6生物中心后座一楼", 23.050403,113.413694 ));
        aeds.add(new AED(8L, "正门", "正门东侧保安室", 23.050445,113.415923 ));
        aeds.add(new AED(9L, "图书馆", "图书馆二楼后门", 23.052927,113.411858 ));
        aeds.add(new AED(10L, "A3", "A3教学楼一楼大厅", 23.055791,113.41193 ));
        aeds.add(new AED(11L, "B10", "B10北座一楼", 23.056298,113.4148));

        for(int i=0;i<aeds.size();i++){
            AEDService.addAed(aeds.get(i));
        }


    }
}
