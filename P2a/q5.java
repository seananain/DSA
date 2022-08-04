package P2a;
import java.util.*;

public class q5 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of disks...");
        int n = sc.nextInt();

        towers(n, n, 1, 3);

    }

    public static void towers(int n1, int n, int src, int dest)
    {
        if(n==1)
        {
            moveDisk(n1, n, src, dest);
        }
        else
        {
            int tmp = 6 - src - dest;
            towers(n, n-1, src, tmp);
            moveDisk(n1, n, src, dest);
            towers(n, n-1, tmp, dest);
            
        }
    }

    public static void moveDisk(int n1, int n, int src, int dest)
    {
        String indent = "             ";
        //int disknum = n1 + 1 - n;
        int recur = n1 + 1 -n;

        
        System.out.println(indent.repeat(n-1) + "Recursion level: " + recur);
        System.out.println(indent.repeat(n-1) + "Moving Disk " + disknum + " from Source " + src + " to Destination " + dest);
        System.out.println(indent.repeat(n-1) + "n=" + n + ", src=" + src + ", dest= " + dest);
    }
}
