package apiEngine;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DataReaderWriter {

    private final String DATA_PROVIDER_EXCEL = "C:\\Users\\User\\IdeaProjects\\RestAssuredFramewrok\\src\\test\\resources\\DataProvider\\DataProvider.xlsx";
    private static HashMap<String, String> map = new HashMap<>();
    private static ConcurrentHashMap<String, List<String>> arrayMap = new ConcurrentHashMap<>();

    /***
     * This Method takes the generated token from a post method and put it in a excel file
     * @param userId
     * @param token
     * @throws IOException
     */

    public void writeTokeIntoExcel(String userId, String token)  {
        try {
            FileInputStream file = new FileInputStream(new File(DATA_PROVIDER_EXCEL));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("tokens");
            int rows = sheet.getLastRowNum();
            Row row = sheet.createRow(rows + 1);
            row.createCell(0).setCellValue(userId);
            row.createCell(1).setCellValue(token);
            FileOutputStream fileUpdated = new FileOutputStream(DATA_PROVIDER_EXCEL);
            workbook.write(fileUpdated);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void setDynamicData(String name, String value){

        map.put(name, value);
    }

    public String getDynamicData(String name){
        return map.get(name);
    }

    public void setDynamicArrayData(String name, List<String> values){
        arrayMap.put(name, values);
    }

    public List<String> getDynamicArrayData(String key){return arrayMap.get(key);}

    public void writeUserIdandIsbn(String userid, List<String> isbn){
           FileInputStream file = null;
        try{
            File uFile = new File(DATA_PROVIDER_EXCEL);
            file = new FileInputStream(uFile);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("User Id with ISBN");
            int rows = sheet.getLastRowNum();
            Row row = sheet.createRow(rows + 1);
            for(String bookIsbn: isbn){
                row.createCell(0).setCellValue(userid);
                row.createCell(1).setCellValue(bookIsbn);
            }
            FileOutputStream fileUpdated = new FileOutputStream(DATA_PROVIDER_EXCEL);
            workbook.write(fileUpdated);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
            file.close();}
            catch(Exception e){
              e.printStackTrace();
            }
        }


    }
    public void readUserIdAndIsbn(String userId){
        try {
            FileInputStream file = new FileInputStream(new File(DATA_PROVIDER_EXCEL));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("User Id with ISBN");
            List<String> isbns  = new ArrayList<>();
            Iterator<Row> iterator = sheet.iterator();
           while(iterator.hasNext()){
               Row row = iterator.next();
               if(row.getCell(0).getStringCellValue().equals(userId)) {
                   Cell cell = row.getCell(1);
                   isbns.add(cell.getStringCellValue());
                   setDynamicData("User Id", row.getCell(0).getStringCellValue());
               }

               setDynamicArrayData("ISBNS",isbns);


           }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }




}
