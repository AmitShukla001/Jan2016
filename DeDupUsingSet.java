import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.*;

/***************************************
 * 
 * @author amitshukla 
 * This implementation will use java util's HashSet to
 * de-duplicate the int Array.
 * 
 */

public class DeDupUsingSet {

	private static final Logger logger = Logger.getLogger(DeDupUsingSet.class.getName());

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	// This method expects an un-sorted int array , it removes the duplicate elements
	// and returns an int array
	public static int[] returnArrayWithoutDuplicates(int[] inputArray) {

		logger.info("Inside method returnArrayWithoutDuplicates...");

		int outputArrayIndex = 0;
		int arrayLength = inputArray.length;
		Set<Integer> set = new HashSet<Integer>();

		// Creating a Set out of int array. Set will automatically de-dup the
		// elements.
		try {
			logger.info("Creating a Set out of int array. Set will automatically de-dup the elements...");
			for (int i = 0; i < arrayLength; i++) {
				set.add(inputArray[i]);
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

		int[] outputArray = new int[set.size()];

		try {
			Iterator<Integer> it = set.iterator();

			// Creating an output int array from the Set
			logger.info("Creating an output int array from the Set...");
			while (it.hasNext()) {
				outputArray[outputArrayIndex] = (int) it.next();
				outputArrayIndex++;
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

		return outputArray;
	}

	public static void main(String[] args) {

		DeDupUsingSet deDup = new DeDupUsingSet();

		logger.info("Accessing inputArray...");
		int[] inputArray = deDup.randomIntegers;

		// Sorting the array
		logger.info("Sorting the input array by calling SortDeDup.returnArrayWithoutDuplicates...");
		try {
			int[] outputDedupArray = DeDupUsingSet.returnArrayWithoutDuplicates(inputArray);

			// Printing array elements
			for (int number : outputDedupArray)
				System.out.print(number + " ");
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}

}
