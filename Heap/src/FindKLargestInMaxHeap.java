/**
 * Given a max heap as an array, implement List<Integer> peekTopK(int[] arr, int k)
 * to find the top k elements. Do not modify the heap or copy entire heap to
 * a different data structure. Example:
 *
 *            15
 *        /        \
 *      13         12
 *    /   \       /
 *  10     8     9
 * Input: [15, 13, 12, 10, 8, 9], k = 5
 * Output: [15, 13, 12, 10, 9]
 *
 * @author anitgeorge
 */
import java.util.*;
public class FindKLargestInMaxHeap {

    public List<Integer> peekTopK(int[] arr, int k){

        if(arr == null || arr.length < k)
            return new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> arr[b] - arr[a]
        );
        queue.add(0);
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty() && k-- > 0){
            int index = queue.poll();
            result.add(arr[index]);
            int left =  (2* index) + 1;
            int right = left + 1;
            if(left < arr.length)
                queue.offer(left);
            if(right < arr.length)
                queue.offer(right);
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = new int[]{15, 13, 12, 10, 8, 9};
        FindKLargestInMaxHeap obj = new FindKLargestInMaxHeap();
        List<Integer> result = obj.peekTopK(arr, 5);
        System.out.println(result.toString());
    }
}
