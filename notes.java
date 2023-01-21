import java.util.ArrayList;

public class notes {
	//Your linked list add should do a total of maybe 3 actions
	//When you add, you should get the *last node 
	//construct a new element
	//store it in lastNodes"SingleData" field.
	
	//This is used to determine how fast your algorithm is 
	//Big Oh -> 0()
	
	public static void main(String[] args)
	{
		ArrayList<Integer> container = new ArrayList<>();
		
		int count = 0 ;
		for(int i = 0; i < container.size(); i++)
			for(int j = 0; j < 2 * container.size(); j++)
			{
				countInner++;
				
				//one more loop etc n 3, 4, 5th
				//two loops are the limit for an efficient program
				//O(log(n))
				//O(nlog(n))
				//O(en)
			
		}
		count++;
	}

}

//Big Oh note / Linked List / Array list notes
//Getting a value in an array list, is very fast
//Getting a value in a linked list not so much

//Array list, how do you add a value this is slow * O(n)
//Removing O(n)

//Linked list Adding a value ~> get next cell, construct, store
//[] -> [] -> [] -> [] -> []
//[][][][][][]

//Class Assignment DataManager part 2.
//[] -> [] -> [] -> [] -> [] // Since we're doing this already...
//1. Linked the last node to the head node, In abovecase. link 5 to 0
//2. Have your adds "rewire" the pointers each time as needed
//[0] -> [1] -> [2] -> [3] -> [4] -> [5] ---> [6] // Change the pointers from 5 to 6
//and 6 points to 0
//This allows your while loop to continue traversing your linked list until a condition
// is met. This linked list is otherwise known as a circular linked list.

// Notice there's another weakness in traversing linked list
// [0] -> [1] -> [2]... what if we go backwards?
//[0] <-> [1] <-> [2]... what would it do?
//You'll need a new field in your nodes called "prev" ie. SingleData prev; // add this
// For each new node added to your list, wire in a pointer to the one before.

//Write a peek() method to look at the next value 
//
