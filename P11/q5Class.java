public class q5Class 
{
    private int num;
    private String name;

    public q5Class(int pnum, String pname)
    {
        num = pnum;
        name = pname;
    }

    public q5Class(q5Class pq5Class)
    {
        num = pq5Class.getNum();
        name = pq5Class.getName();
    }

    public q5Class()
    {

    }




    public int getNum()
    {
        return num;
    }

    public String getName()
    {
        return name;
    }



    public void setNum(int pnum)
    {
        num = pnum;
    }

    public void setName(String pname)
    {
        name = pname;
    }
}
