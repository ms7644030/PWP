package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class pairSum {

	// Method 1 : Implementation using BFA(Brute force Approach) --> [Time
	// complexity:- O(N*N) &
	// Auxiliary Space:- O(1)]

	public static List<Integer> pairsumBFA(List<Integer> arr, int Sum) {

		List<Integer> result = new ArrayList<Integer>();

		loop: for (int i = 0; i < arr.size() - 1; i++) {

			for (int j = i + 1; j < arr.size(); j++) {

				// checking for conditionPlayWithProblems
				if (arr.get(i) + arr.get(j) == Sum) {

					result.add(arr.get(i));
					result.add(arr.get(j));

					break loop;
				}
			}
		}

		return result;

	}

	// Method 2 : Implementation using Sorting and searching --> [Time complexity:-
	// O(NlogN)

	public static List<Integer> pairsumSORT(List<Integer> arr, int Sum) {

		List<Integer> result = new ArrayList<Integer>();

		Collections.sort(arr);

		for (int i = 0; i < arr.size() - 1; i++) {

			int x = Sum - arr.get(i);

			int index = Collections.binarySearch(arr, x);

			// checking for condition
			if (index > 0) {

				result.add(arr.get(i));
				result.add(arr.get(index));
				break;

			}

		}

		return result;

	}

	// Method 3 : Implementation using Hashing --> [Time complexity:- O(n) &
	// Auxiliary Space:- O(n)]

	public static List<Integer> pairsumHash(List<Integer> arr, int Sum) {

		HashSet<Integer> s = new HashSet<Integer>();

		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < arr.size(); i++) {

			int x = Sum - arr.get(i);

			// checking for condition
			if (s.contains(x)) {
				result.add(x);
				result.add(arr.get(i));
			}
			// insert the current no. inside set
			s.add(arr.get(i));
		}

		return result;

	}

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<Integer>();
		List<Integer> ans = new ArrayList<Integer>();

		arr.add(10);
		arr.add(5);
		arr.add(2);
		arr.add(3);
		arr.add(-6);
		arr.add(9);
		arr.add(11);

		// ans = pairsumHash(arr, 4);
		// ans = pairsumBFA(arr, 4);
		ans = pairsumSORT(arr, 4);

		Iterator<Integer> iterator = ans.iterator();

		while (iterator.hasNext()) {
			Integer element = iterator.next();
			System.out.print(element + " ");
		}

	}

}
