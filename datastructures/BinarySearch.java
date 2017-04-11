import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class BinarySearch {
	
	// EVEN LOWER
	// ----------
	
	@Test
	public void lowerBoundryExistsEven()
	{
		Comparable[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Comparable comparable = 1;
		Comparable expectedPosition = 1;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@Test
	public void lowerBoundryDoesNotExistEven()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		Comparable comparable = 1;
		Comparable expectedPosition = 0;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	// EVEN UPPER
	// ----------
	
	@Test
	public void upperBoundryExistsEven()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		Comparable comparable = 11;
		Comparable expectedPosition = 10;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void upperBoundryDoesNotExistEven()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		Comparable comparable = 12;
		Comparable expectedPosition = 10;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	// EVEN MIDDLE
	// -----------
	
	@Test
	public void middleBoundryExistsEven()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		Comparable comparable = 6;
		Comparable expectedPosition = 5;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void middleBoundryDoesNotExistEven()
	{
		Comparable[] intArray = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11};
		Comparable comparable = 6;
		Comparable expectedPosition = 5;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	// ODD LOWER
	// ---------
	
	@Test
	public void lowerBoundryExistsOdd()
	{
		Comparable[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Comparable comparable = 1;
		Comparable expectedPosition = 1;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@Test
	public void lowerBoundryDoesNotExistOdd()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		Comparable comparable = 1;
		Comparable expectedPosition = 0;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	// ODD UPPER
	// ---------
	
	@Test
	public void upperBoundryExistsOdd()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		Comparable comparable = 10;
		Comparable expectedPosition = 9;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void upperBoundryDoesNotExistOdd()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		Comparable comparable = 11;
		Comparable expectedPosition = 9;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	// ODD MIDDLE
	// ----------
	
	@Test
	public void middleBoundryExistsOdd()
	{
		Comparable[] intArray = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		Comparable comparable = 6;
		Comparable expectedPosition = 5;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void middleBoundryDoesNotExistOdd()
	{
		Comparable[] intArray = {1, 2, 3, 4, 5, 7, 8, 9, 10};
		Comparable comparable = 6;
		Comparable expectedPosition = 5;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	// EMPTY
	// -----
	
	@Test
	public void emptyArray()
	{
		Comparable[] intArray = {};
		Comparable comparable = 1;
		Comparable expectedPosition = 0;
		
		assertEquals(expectedPosition, binarySearch(intArray, comparable));
		displayResults(intArray, comparable, expectedPosition, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	// LOG
	// ---
	
	public void displayResults(Comparable[] array, Comparable objectToFind, Comparable expectedPosition, String methodName)
	{
		Comparable result = binarySearch(array, objectToFind);
		
		if (result.equals(expectedPosition)){
			System.out.println("The expected result of method " + methodName + " is: " + expectedPosition + ". The actual result is: " + result);
		} else {
			System.out.println(methodName + " failed");
		}
	}
	
	// BINARY SEARCH METHOD

	public Comparable binarySearch(Comparable[] objArray, Comparable searchObj)
	{
		int low = 0;
		int high = objArray.length - 1;
		int mid = 0;
		 
		while (low <= high)
		{
			mid = (low + high) / 2;
			
			if (objArray[mid].compareTo(searchObj) < 0)
			{
				low = mid + 1;
			}
			else if (objArray[mid].compareTo(searchObj) > 0)
			{
				high = mid - 1;
			}
			else
			{
				return mid + 1;	
			}
		}
		return low;
	}
	
}
