package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    //DataProvider 1

    @DataProvider(name="WinnersData")
    public String [][] getData() throws IOException
    {
        String path=".\\testData\\iplWinners.xlsx"; //taking xl file from testData

        ExcelUtility xlutil=new ExcelUtility(path); //creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can store

        for(int i=1;i<=totalrows;i++)   //1   //read the data from xl storing in two deminsional array
        {
            for(int j=0;j<totalcols;j++)   //0   i is rows j is col
            {
                logindata[i-1][j]= xlutil.getCellValue("Sheet1",i, j);  //1,0
            }
        }
        for(String i[]:logindata)
        {
        	for(String j:i) System.out.print(j+" ");
        	System.out.println();
        }
        return logindata; //returning two dimension array
    }
}