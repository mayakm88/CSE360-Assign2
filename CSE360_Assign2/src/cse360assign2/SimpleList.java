/**Maya Muir
 * Class ID: 202
 * Assignment: 1
 */

package cse360assign2;

/**
 * The class SimpleList contains several different methods to create and implement a list. The list is an array of 
 * 10 elements. By calling the different methods, a user can add elements, remove elements, count the number of elements, 
 * and search for an element. There is also a method to print out all of the elements of the array. 
 * 
 * @author Maya Muir
 */

public class SimpleList {
	
		private int count; 
		private int list []; 
		
		/**Constructor method that initializes a 10 element list.*/
		public SimpleList(){
			list = new int[10];
			count = 0;
		}
		
		/**This method adds a new integer to the beginning of the list.
		 * 
		 * @param elementToAdd    integer that is added to the list
		 */
		public void add(int elementToAdd) {
			
			if (count == 0)  //if the list is empty
				list[0] = elementToAdd; 
			
			
			else {
				if (count == 10) { //if the list is already full
					count--;	//has to be decremented for 10 elements otherwise list[index+1] will present an error
					for(int addIndex = count - 1; addIndex >= 0; addIndex--) { 
						list[addIndex + 1] = list [addIndex];  //moves all of the elements over one to the right
					}
					list[0] = elementToAdd; 
				}
				
				else {	
					for (int addIndex = count - 1; addIndex >= 0; addIndex--) {
						list[addIndex + 1] = list [addIndex];
					}
					list[0] = elementToAdd;
				}	
			}
			count ++; 
		}
		
		/**This method removes an integer from the list and moves the other integers accordingly.
		 * 
		 * @param elementToRemove    integer to be removed
		 */
		public void remove(int elementToRemove) {
			
			int location = search(elementToRemove); //searches for the index of the element
			
			if (location != -1) {	//makes sure the element is in the list
				for(int removeIndex = location; removeIndex < count - 1; removeIndex++) { 
					list[removeIndex] = list[removeIndex + 1];	//moves elements down after removing one
				}
				
				list[count - 1] = 0;  //makes the last element in the list 0
				count--;
			}
		}
		
		/**This method returns the current amount of elements in the list.
		 * 
		 * @return    the amount of elements in the list
		 */
		public int count() {
			return count;
		}
		
		/**This method prints out all of the elements in the list.
		 * 
		 * @return    the string of elements in the list separated by a space
		 */
		public String toString() {
			
			String string = "";
			if (count == 0) {	
				return string;
			}
	
			for(int searchIndex = 0; searchIndex < count - 1; searchIndex++) {	
				string = string + list[searchIndex] + " "; 
			}
			
			string = string + list[count - 1]; //makes the last element print without a space
			return string;
		}
		
		/**This method returns the index of an element
		 * 
		 * @param element    the element that is being searched for  
		 * @return    	         the index of the element being searched for
		 */
		public int search(int element) {
			
			for(int searchIndex = 0; searchIndex < count; searchIndex++) { 
				
				if(list[searchIndex] == element)
					
					return searchIndex;
			}
			return -1;  //if the element is not in the list
		}
}
