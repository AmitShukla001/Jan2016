import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.*;

/***************************************
 * 
 * @author amitshukla 
 * This implementation will use java util's LinkedHashSet to
 * de-duplicate the int Array.
 * 
 */

public class DeDupRetainOrder {

	private static final Logger logger = Logger.getLogger(DeDupRetainOrder.class.getName());

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	// An un-sorted array of integers can be passed to this method.
	// This method will retain the order of elements in the returned int array
	// It will remove the duplicate elements and will return int array.
	public static int[] returnArrayWithoutDuplicates(int[] inputArray) {

		logger.info("Calling returnArrayWithoutDuplicates. Initializing List from int Array...");

		List<Integer> intList = new ArrayList<Integer>(inputArray.length);

		logger.info("Adding elements from int[] to List...");
		// Creating a List of Integers from int array
		try {
			for (int i = 0; i < inputArray.length; i++) {
				intList.add(inputArray[i]);
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

		int[] outputArray = new int[0];

		// Converting List of Integers to LinkedHashSet which will remove the
		// duplicates. Then converting the LinkedHashSet to ArrayList
		logger.info(
				"Converting List of Integers to LinkedHashSet which will remove the duplicates. Then converting the LinkedHashSet to ArrayList...");
		try {
			ArrayList<Integer> intArrayList = new ArrayList<Integer>(new LinkedHashSet<Integer>(intList));
			int sizeIntArrayList = intArrayList.size();
			outputArray = new int[sizeIntArrayList];

			// Converting ArrayList to int Array
			logger.info("Converting ArrayList to int Array...");
			for (int i = 0; i < sizeIntArrayList; i++) {
				outputArray[i] = ((Integer) intArrayList.get(i)).intValue();
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return outputArray;
	}

	public static void main(String[] args) {

		DeDupRetainOrder deDup = new DeDupRetainOrder();

		logger.info("Accessing inputArray...");
		int[] inputArray = deDup.randomIntegers;

		// Sorting the array by calling returnArrayWithoutDuplicates
		logger.info("Sorting the input array by calling DeDupRetainOrder.returnArrayWithoutDuplicates...");
		try {
			int[] outputDedupArray = DeDupRetainOrder.returnArrayWithoutDuplicates(inputArray);

			for (int number : outputDedupArray)
				System.out.print(number + " ");
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}

}
