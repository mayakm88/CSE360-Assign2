/**Maya Muir
 * Class ID: 202
 * Assignment: 2
 */

package cse360assign2;

/**
 * The class SimpleList contains several different methods to create and implement a list. The list begins as an array of 
 * 10 elements. By calling the different methods, a user can add elements, remove elements, count the number of elements, 
 * and search for an element. There is also a method to print out all of the elements of the array. The array can also
 * change size as needed to become bigger when it is full or smaller when space is not being used.
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
		
		
		/**This method adds a new integer to the beginning of the list. If the list is full, it increases
		 * the size of the list by 50%.
		 * 
		 * @param elementToAdd    integer that is added to the list
		 */
		public void add(int elementToAdd) {
			
			if (count == 0)  //if the list is empty
				list[0] = elementToAdd; 
			
			
			else {
				if (count == list.length) { //if the list is already full
					int newSize = ((list.length) * 3) / 2;    //the new size will be 1.5 times as big
					int listCopy [] = new int [newSize];
					
					for (int index = 0; index < list.length; index++) {
						listCopy[index] = list[index];
					}
					
					list = listCopy;
				}
					for (int addIndex = count - 1; addIndex >= 0; addIndex--) { //moving the elements over one
						list[addIndex + 1] = list [addIndex];
					}
					list[0] = elementToAdd;
			}
			count ++; 
		}
		
		/**This method removes an integer from the list and moves the other integers accordingly. If more than 25%
		 * of the list is empty, it decreases the list size by 25%.
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
			if (list.length > 1) {
			int quarterSize = (list.length) / 4;
			int newSize = (list.length) - quarterSize;
			
				if (((list.length) - count) > quarterSize) {	//cannot be reduced to less than 1
					int listCopy [] = new int [newSize];
					
					for (int index = 0; index < listCopy.length; index++) {
						listCopy[index] = list[index];
					}
					
					list = listCopy;
				}
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
		
		/**This method returns the index of an element.
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
		
		/**This method adds a new integer to the end of the list. If the list is full, it increases
		 * the size of the list by 50%.
		 * 
		 * @param elementToAppend    integer that is added to the end of the list
		 */
		public void append(int elementToAppend) {
			
			if (count == 0)  //if the list is empty
				list[0] = elementToAppend; 
			
			
			else {
				if (count == list.length) { //if the list is already full
					int newSize = ((list.length) * 3) / 2;    //the new size will be 1.5 times as big
					int listCopy [] = new int [newSize];
					
					for (int index = 0; index < list.length; index++) {
						listCopy[index] = list[index];
					}
					
					list = listCopy;
				}
				
					list[count] = elementToAppend;
			}
			count ++; 
		}
		
		/**This method returns the first element in the list.
		 * 
		 * @return    the first element in the list
		 */
		public int first() {
			if (count == 0) {
				return -1;
			}
			return list[0];
		}
		
		/**This method returns the last element in the list.
		 * 
		 * @return    the last element in the list
		 */
		public int last() {
			if(count == 0) {
				return -1;
			}
			return list[count-1];
		}
		
		/**This method returns the current number of possible locations in the list.
		 * 
		 * @return    the size of the list
		 */
		public int size() {
			return list.length;
		}
	}
