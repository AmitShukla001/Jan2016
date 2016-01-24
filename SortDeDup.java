import java.util.logging.*;

/***************************************
 * 
 * @author amitshukla 
 * This implementation will first sort the int array and then
 * de-duplicate it.
 * 
 */
public class SortDeDup {

	private static final Logger logger = Logger.getLogger(DeDupRetainOrder.class.getName());

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	// This method expects a sorted int array and removes the duplicate elements 
	// from the input int array. It returns int array.
	public static int[] returnArrayWithoutDuplicates(int[] input) {

		logger.info("Inside method SortDeDup.returnArrayWithoutDuplicates...");

		int[] output = new int[0];
		try {
			int j = 0;
			int i = 1;
			// If the array length is less than 2 then return
			if (input.length < 2) {
				return input;
			}

			while (i < input.length) {

				// Comparing if the current element is equal to adjacent
				// element, if
				// yes do not do anything and move to the next one
				logger.info(
						"Comparing if the current element is equal to adjacent element, if yes do not do anything and move to the next one...");
				if (input[i] == input[j]) {
					i++;
				} else {

					// If adjacent element is not same, then store the adjacent
					// element on the next index and go to the next element.
					logger.info(
							"If adjacent element is not same, then store the adjacent element on the next index and go to the next element....");
					input[++j] = input[i++];
				}
			}

			output = new int[j + 1];

			logger.info("Creating output int array....");
			for (int k = 0; k < output.length; k++) {
				output[k] = input[k];
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

		return output;
	}

	public static void main(String[] args) {

		SortDeDup deDup = new SortDeDup();

		logger.info("Accessing inputArray...");
		int[] input = deDup.randomIntegers;

		try {
			// Sorting the array
			java.util.Arrays.sort(input);

			// Passing the sorted array for de-duplication
			logger.info("Sorting the input array by calling SortDeDup.returnArrayWithoutDuplicates...");
			int[] output = SortDeDup.returnArrayWithoutDuplicates(input);

			// Printing array elements
			for (int i : output) {
				System.out.print(i + " ");
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}
