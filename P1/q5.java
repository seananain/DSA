import java.util.*;

public class q5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
    }

    public static ArrayList<> csvRead(String fileName)
    {
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        ArrayList<CovidRecordClass> Records = new ArrayList<CovidRecordClass>();
        String line;
        try
        {
            fileStream = new FileInputStream(fileName);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
        
            bufRdr.readLine();
            line = bufRdr.readLine();

            while(line != null)
            {
                String[] splitline;
                splitline = line.split(",",-1);

                for(int i=0; i < splitline.length; i++)
                {
                    if(splitline[i].isEmpty())
                    {
                        splitline[i] = "0";
                    }
                }
                CountryClass countryobj = new CountryClass(splitline[1], splitline[2], splitline[3], splitline[12], Double.parseDouble(splitline[4]), Double.parseDouble(splitline[5]));
                CovidRecordClass recordObj = new CovidRecordClass(splitline[0], Integer.parseInt(splitline[6]), Integer.parseInt(splitline[7]), Integer.parseInt(splitline[8]), Integer.parseInt(splitline[9]), Integer.parseInt(splitline[10]), countryobj);
                Records.add(recordObj);
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
}