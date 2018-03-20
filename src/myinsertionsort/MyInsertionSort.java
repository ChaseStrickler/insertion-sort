//Chase Strickler
//Insertion Sort
/26 January 2018

package myinsertionsort;

import java.util.Random;


public class MyInsertionSort {
    
    public static void main(String[] args) {
        int n = 1;
        int set_counter = 0;        //set_counter counts how many comparisons and swaps have happened while sorting 1 array.
        int loop_counter = 0;       //loop_counter counts how many comparisons/swaps happen on 10 different inputs of equal size.
        int total_counter = 0;      //total_counter counts all total comparisons/swaps of every input.
        
        for (int i = 0; i < 4; i++){    //outer for loop is for the 4 different sized arrays
            n = n*10;
            for (int j = 1; j < 11; j++){   //inner for loop is for generating 10 different, random arrays
                int[] randomArray = createRandomIntArray(n);    //generate a random array, and place it in randomArray
                set_counter = insertionSort(randomArray, set_counter);  //keep track of the number of swaps per array
                loop_counter = loop_counter + set_counter;  //keep track of the number of swaps in alll arrays with the same input size
                set_counter = 0;    //reset the counter
            }
            total_counter = total_counter + loop_counter;   //keep track of the total swaps across all tests
            int average_swaps = loop_counter / n;   //calculate the average number of swaps completed in all arrays of equal size
            
            System.out.println("Array Size: " + n);
            System.out.println("Total number of swaps/comparisons: " + n + " is: " + loop_counter);
            System.out.println("Average number of swaps/comparisons: " + n + " is: " + average_swaps + '\n');
            loop_counter = 0;
        }  
    }
    
    /**
    * This method generates a random array of a given size.
    * @param size - indicates the size of the array to be generated
    * @return answer
    */
    public static int[] createRandomIntArray(int size) {   //method generates a random array
        int[] answer = new int[ size];  //create new array
        int index = 0;  //will be used to iterate across our new array and populate it with element
        Random generator = new Random();
            for(int element : answer) {
                element = generator.nextInt(1000) + 1;  //element is the randomly generated number from 1-1000
                answer[index] = element;    //place the random number within the array
                index++;
            }
        return answer;  //return the randomly generated array
    }   
    
    /**
     * This method performs the insertion sort algorithm.
     *
     * @param A - array to be sorted
     * @param count - counter to track how many swaps occur
     * @return count
     */
    public static int insertionSort(int[] A, int count){
       int temp;
       for(int i = 1; i < A.length; i++){   //outer loop iterates across array to the right
           for(int j = i; j > 0; j--){      //inner loop iterates backwards on the array starting at i, comparing values to A[i]
               count++;                     //count increase for comparison of A[j] and A[j-1]
               if(A[j] < A[j-1]){           
                   //Swap A[j] and A[j-1]
                   temp = A[j];
                   A[j] = A[j-1];
                   A[j-1] = temp;          
                   count++;                   
               }
           }
       }
       return count;    //return the total number of comparisons that have happened
    }
}
