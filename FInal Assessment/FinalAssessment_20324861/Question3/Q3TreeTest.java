/**
 * DSA Final Assessment Question 3 - Q3TreeTest.java
 *
 * Name : Sean Anain
 * ID   : 20324861
 *
 **/
public class Q3TreeTest
{
	public static void main(String args[])
	{
		System.out.println("\n##### Question 3: Testing Trees #####\n");
        	Q3BSTree t = new Q3BSTree("1", 1);
		
		// put your code here
		String[] data = {"11111110", "11111101", "11111011", "11110111", "11101111", "11011111", "10111111", "01111111"};

        for (int i=0; i < data.length; i++)
		{
			t.insert(data[i], "O"+data[i]);
		}	
		t.postOrder();
			
		System.out.println("\n##### Tests Complete #####\n");

	}
	
}
