package d7;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public abstract class Sorter<E> {
	
	////////////////////////////////////////////////////////////////////////////
	// comparator handling wrappers ////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	public abstract void sort(List<E> a);
		
	private Comparator<E> cmp;
	
	public Sorter(Comparator<E> cmp) {
		this.cmp = cmp;
	}
	
	/** exchange a[i] and a[j] */
	protected void swap(List<E> a, int i, int j) {
		E tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}
	
	/**
	 * Compare a[i] and a[j].
	 * Return < 0 if a[i] < a[j]; return = 0 if a[i] = a[j] and return
	 * >0 if a[i] > a[j]
	 */
	protected int compare(List<E> a, int i, int j) {
		return this.cmp.compare(a.get(i), a.get(j));
	}
	
	////////////////////////////////////////////////////////////////////////////
	// Insertion sort                                                         //
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Precondition:
	 *     0            length
	 * a: [     ?      ]
	 * 
	 * Postcondition: a is sorted, (according to cmp)
	 *     0            length
	 * a: [   sorted   ]
	 */

	
	////////////////////////////////////////////////////////////////////////////
	// Selection sort //////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	

	


	////////////////////////////////////////////////////////////////////////////
	// Merge sort //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	public void mergeSort(List<E> a) {
		mergeSort(a,0,a.size());
	}
	
	/** sort a[start..end) and leave rest of a alone
	 * post condition:
	 *            start         end
	 * a: [      | sorted      |      ]
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */

	
	protected abstract void mergeSort(List<E> a, int i, int size);

	/**
	 * Precondition:         start      mid        end
	 *               a: [   |  sorted  |  sorted  |       ]
	 *               
	 * Postcondition:        start                 end
	 *               a: [   |     sorted          |       ]
	 * 
	 */

	
	////////////////////////////////////////////////////////////////////////////
	// Tests ///////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	public static class Tests {

		
		private static List<Integer> testCase() {
			//                   0 1 2 3 4 5 6 7 8
			return Arrays.asList(1,0,7,3,5,4,9,2,0);
		}
		
		private static List<Integer> testCaseSorted() {
			List<Integer> result = testCase();
			result.sort(Comparator.naturalOrder());
			return result;
		}
		
		
		@Test
		public void testSelectionSort() {
			Sorter<Integer> s = Sorter();
			List<Integer>    a = testCase();
			s.SelectionSorter(a);
			assertEquals(testCaseSorted(), a);			
		}
	}

	protected abstract void merge(List<Integer> a, int i, int j, int k);

	protected static Sorter<Integer> Sorter() {
		return null;
		// TODO Auto-generated method stub
		
	}

	protected abstract void SelectionSorter(List<Integer> a);


}
