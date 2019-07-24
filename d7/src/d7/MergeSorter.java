package d7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class MergeSorter<E> extends Sorter<E>{

	public MergeSorter(Comparator<E> cmp) {
		super(cmp);
		// TODO Auto-generated constructor stub
	}
	
	protected void mergeSort(List<E> a, int start, int end) {
		if (end - start <= 1)
			return;
		
		int mid = (end + start)/2;
		
		mergeSort(a,start,mid);
		mergeSort(a,mid,end);
		
		//          start       mid        end
		// a: [    |  sorted   |  sorted  |     ]
		
		merge(a, start, mid, end);
	}
	
	private void merge(List<E> a, int start, int mid, int end) {
		List<E> result = new ArrayList<E>();
		
		// invariant: result is sorted
		//            start       i                   mid          j                    end
		//   a:  [   | in result | sorted, >= result | in result  |  sorted, >= result |     ] 
		
		int i = start; int j = mid;
		
		while (i != mid || j != end) {
			if (i == mid) {
				result.add(a.get(j));
				j++;
			}
			else if (j == end) {
				result.add(a.get(i));
				i++;
			}
			else if (compare(a,i,j) < 0) {
				result.add(a.get(i));
				i++;
			}
			else {
				result.add(a.get(j));
				j++;
			}
		}
		
		// a: [   |  in result   |  in result  |   ]
		
		// copy result back into a
		for(int k = 0; k < result.size(); k++) {
			a.set(start+k, result.get(k));
		}
	}

}
