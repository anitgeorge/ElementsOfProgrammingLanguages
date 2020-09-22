/**
 *
 * Given an array of ‘K’ sorted ArrayLists, merge them into one sorted list.
 * @author anitgeorge
 */

import java.util.*;

public class MergeSortedArrays {
    private class ArrayEntry {
        int listIndex;
        int arrayIndex;

        ArrayEntry(int l, int a) {
            listIndex = l;
            arrayIndex = a;
        }
    }

    public List<Integer> mergeSortedArrays(List<List<Integer>> lists){
        if(lists.isEmpty())
            return new ArrayList<>();
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                (a, b) -> lists.get(a.listIndex).get(a.arrayIndex) -
                          lists.get(b.listIndex).get(b.arrayIndex)
        );
        for(int i = 0; i < lists.size(); i++)
            if(!lists.get(i).isEmpty())
                minHeap.offer(new ArrayEntry(i, 0));
        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ArrayEntry entry = minHeap.poll();
            result.add(lists.get(entry.listIndex).get(entry.arrayIndex));
            entry.arrayIndex++;
            if(lists.get(entry.listIndex).size() > entry.arrayIndex)
                minHeap.offer(entry);
        }
        return result;
    }
}
