public class DSAStackTest extends DSAStack
{
    public static void main(String[] args) 
    {
        DSAStack s = new DSAStack();
        s.push(1.2);
        s.push(5.1);
        s.push(8.2);
        s.push(5.9);
        s.push(11.2);
        
        s.display();
        s.pop();
        s.pop();
        s.display();
    }

}
