/**
 *
 * Consider a coordinates system for the milky way, in which earth is at (0, 0, 0).
 * Model stars as points, and assume the distance in light years. Compute K closest stars to
 * Earth
 *
 * @author anitgeorge
 */

import java.util.*;

class Star{
    int x;
    int y;
    int z;

    Star(int a, int b, int c){
        x = a;
        y = b;
        z = c;
    }

    public int getDistFromOrigin(){
        return x*x + y*y + z*z;
    }
}
public class FindClosestKStars {

    public List<Star> findClosestStart(List<Star> stars, int k){

        if(stars.isEmpty())
            return new ArrayList<>();
        PriorityQueue<Star> queue = new PriorityQueue<>(
                (a, b) -> b.getDistFromOrigin() - a.getDistFromOrigin()
        );
        int i = 0;
        for(; i < k; i++)
            queue.offer(stars.get(i));
        for(; i< stars.size(); i++){
            queue.offer(stars.get(i));
            queue.poll();
        }
        List<Star> result = new ArrayList<>();
        while(!queue.isEmpty())
            result.add(queue.poll());
        return result;
    }

}
