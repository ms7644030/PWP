package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class triplets {

	public static List<List<Integer>> tripletsUsingtwoPointer(List<Integer> arr, int Sum) {

		List<List<Integer>> result = new ArrayList<>();

		Collections.sort(arr);

		int n = arr.size();

		// Pick every no. , pair sum for remaining part
		for (int i = 0; i <= (n - 3); i++) {

			// x is the target sum for remaining part
			int x = Sum - arr.get(i);

			// start and end are pointers for remaining part of array
			int start = i + 1;
			int end = n - 1;

			// two pointer approach
			while (start < end) {

				if (arr.get(start) + arr.get(end) == x) {

					// ans will store current result and put it to result list

					List<Integer> ans = new ArrayList<>();
					ans.add(arr.get(i));
					ans.add(arr.get(start));
					ans.add(arr.get(end));

					result.add(ans);

					start++;
					end--;

				}

				else if (arr.get(start) + arr.get(end) > x)
					end--;
				else
					start++;

			}

		}

		return result;

	}

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();

		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		arr.add(15);

		ans = tripletsUsingtwoPointer(arr, 18);

		for (List<Integer> list : ans) {

			Iterator<Integer> iterator = list.iterator();
			System.out.print("[");

			while (iterator.hasNext()) {
				Integer element = iterator.next();
				System.out.print(element + " ");
			}

			System.out.print("] ");
			System.out.println();

		}

	}

}
