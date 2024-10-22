package org.example.DataBase;
import org.example.DataBase.*;
import org.example.entities.AED;

import java.util.ArrayList;
import java.util.List;

public class aedTableTest {
    public static void main(String[] args) throws Exception {
        List<AED> aeds = aedTable.getAllAeds();
        for(AED aed:aeds){
            System.out.println(aed.toString());
        }
    }
}
