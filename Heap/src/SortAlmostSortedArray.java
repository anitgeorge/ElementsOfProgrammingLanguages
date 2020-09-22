/**
 * Write a program that takes as input a very long stream of numbers,
 * and prints them in sorted order. Each number is at most k positions
 * away from sorted position.
 *
 * @author anitgeorge
 */
import java.util.*;
public class SortAlmostSortedArray {

    public List<Integer> sortSequence(List<Integer> list, int k){

        if(list.isEmpty())
            return new ArrayList();
        if(k == 0)
            return list;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for(; i < k && i < list.size(); i++)
            minHeap.offer(list.get(i));
        for(; i < list.size(); i++){
            minHeap.offer(list.get(i));
            result.add(minHeap.poll());
        }
        while(!minHeap.isEmpty())
            result.add(minHeap.poll());
        return result;
    }
}
