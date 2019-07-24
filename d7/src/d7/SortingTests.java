package d7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

abstract class SortingTests{

	@Test
	private Sorter<Integer> sorter() {
		return new Sorter<Integer>(Comparator.naturalOrder());
		

	@Test
	public void testSwap() {
		Sorter<Integer> s = sorter();
		List<Integer>    a = testCase();
		
		s.swap(a,1,2);
		assertEquals(7,a.get(1));
		assertEquals(0,a.get(2));
	}
	
	protected abstract List<Integer> testCase();
	@Test
	public void testCompare() {
		Sorter<Integer> s = sorter();
		List<Integer>    a = testCase();

		assertTrue(s.compare(a,0,1) > 0);
		assertTrue(s.compare(a, 1, 8) == 0);
		assertTrue(s.compare(a, 1, 0) < 0);
	}
	
	@Test
	public void testSort() {
		Sorter<Integer> s = sorter();
		List<Integer>    a = testCase();
		s.sort(a);
		assertEquals(testCaseSorted(), a);
	}
	protected abstract Object testCaseSorted();
	@Test
	public void testMerge() {
		Sorter<Integer> s = sorter();
		//                                 0 1 2  3 4 5 6 7  8 9
		//                                [      |     |    |   ]
		List<Integer>    a = Arrays.asList(1,0,7 ,3,6,8,2,7 ,0,7);
		List<Integer>  exp = Arrays.asList(1,0,7 ,2,3,6,7,8 ,0,7);
		s.merge(a, 3, 6, 8);
		assertEquals(exp,a);
	
}
	public void testIndexOfMin() {
		Sorter<Integer> s = sorter();
		List<Integer>    a = testCase();
		
		assertEquals(0, a.get(s.indexOfMin(a, 0, a.size())));
		assertEquals(3, a.get(s.indexOfMin(a, 2, 5)));
	}

	
}
