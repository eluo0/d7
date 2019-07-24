package d7;

import java.util.Comparator;
import java.util.List;

public abstract class SelectionSorter <E> extends Sorter <E>{
	public SelectionSorter(Comparator<E> cmp) {
		super(cmp);
		// TODO Auto-generated constructor stub
	}

	public void selectionSort(List<E> a) {
		// invariant:     0                           i         length
		//            a: [ sorted, smaller then rest |    ?    ]
		
		int i = 0;
		// initialization: a[0..0) is empty, thus sorted
		
		while (i < a.size()) {
			i++; // progress: i increases
			int k = indexOfMin(a,i-1,a.size());
			swap(a,i-1,k);
			// preservation: a[i-1] was originally the minimum value of a[i-1...length)
			// so it is smaller than all the rest.
		}
		// termination: i == length, so a[0..length) is a[0..i) which is sorted
	}
	
	
	/** returns index of the smallest value of a[start...end) 
	 * @return 
	 * @return */
	public int indexOfMin(List<E> a, int start, int end) {
		// invariant:     start       min           i         end
		//            a: [    >= x   | x |   >= x  |    ?    ]
		
		int min = start, i = start+1;
		// initialization: a[start..min) and a[min+1..i) are empty
		
		while (i < end) {
			i++; // progress: i increasing
			
			//     start    min            i      end
			// a: [  >= x  | x |  >= x  |?|   ?  ]
			if (compare(a,i-1,min) < 0)
				min = i-1;
			
			// preservation: know that a[i-1] >= a[min]
		}
		// termination: i == end, so a[start..i) is a[start..end), and all
		// values are >= x
		return min;
	}

}
