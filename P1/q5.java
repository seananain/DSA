import java.util.*;
import java.io.*;

public class q5{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<q5Class> array = new ArrayList<q5Class>();
        
        array = csvRead("RandomNames7000(2).csv");

        int[] array2 = new int[array.size()];

        for(int i=0; i<array.size(); i++)
        {
            array2[i] = array.get(i).getNum();
        }


        Sorts.insertionSort(array2);

        csvWrite("newFile.csv", array2);


      

        sc.close();
    }

    public static ArrayList<q5Class> csvRead(String fileName)
    {
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        ArrayList<q5Class> Records = new ArrayList<q5Class>();
        String line;
        try
        {
            fileStream = new FileInputStream(fileName);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
        
            //bufRdr.readLine();
            line = bufRdr.readLine();

            while(line != null)
            {
                String[] splitline;
                splitline = line.split(",");

                for(int i=0; i < splitline.length; i++)
                {
                    if(splitline[i].isEmpty())
                    {
                        splitline[i] = "0";
                    }
                }
                
                q5Class obj = new q5Class(Integer.valueOf(splitline[0]), splitline[1]); 
                Records.add(obj);
                line = bufRdr.readLine();
            }   
            fileStream.close();     
        }
        catch(IOException errorDetails)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {

                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
        return Records;
    }


    public static void csvWrite(String pFilename, int[] input1)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        
        try
        {
            fileStrm = new FileOutputStream(pFilename);
            pw = new PrintWriter(fileStrm);
            for(int i=0; i<input1.length-1; i++)
            {
                pw.println(input1[i] + ",");
            }
            //pw.print(input1[input1.length-1]);
            
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }



}