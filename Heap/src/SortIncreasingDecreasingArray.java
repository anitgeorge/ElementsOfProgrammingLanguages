/**
 *
 * @author anitgeorge
 */
import java.util.*;
public class SortIncreasingDecreasingArray {

    private enum SubArrayType{Increasing, Decreasing};

    public List<Integer> getSortedArray(List<Integer> nums){

        if(nums.isEmpty())
            return new ArrayList<>();
        List<List<Integer>> subLists = new ArrayList<>();
        SubArrayType type = SubArrayType.Increasing;
        int startIdx = 0;
        for(int i = 1 ; i <= nums.size(); i++){
            if(i == nums.size()
               || (nums.get(i - 1) >= nums.get(i) && type == SubArrayType.Decreasing)
                    || (nums.get(i - 1) <= nums.get(i) && type == SubArrayType.Increasing)
            ) {
                List<Integer> subList = nums.subList(startIdx, i);
                if (type == SubArrayType.Decreasing)
                    Collections.reverse(subList);
                subLists.add(subList);
                startIdx = i;
                type = (type == SubArrayType.Decreasing) ? SubArrayType.Increasing :
                                                           SubArrayType.Increasing;
            }
        }
        MergeSortedArrays obj = new MergeSortedArrays();
        return obj.mergeSortedArrays(subLists);
    }
}
