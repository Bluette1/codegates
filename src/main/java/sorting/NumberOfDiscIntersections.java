package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;

/**
 * Solution for the NumberOfDiscIntersections task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training4NX7KU-8RK
 * @since 28 August 2018
 */
public class NumberOfDiscIntersections {

    public static final int LIMIT = 10000000;
    
    /*
     * This will find the number of disc intersections in a sequence of discs
     * Expected time complexity:O(N*log(N)) or O(N). This method stores the
     * tupples for start and end points in java's ArrayList generic component.
     *   
     * @param array an array
     * @return intersections the number of disc intersections
     * @see https://rafal.io/posts/codility-intersecting-discs.html
     * @see https://app.codility.com/demo/results/training4NX7KU-8RK
     */
    public static int findNumberOfDiscIntersectionsSolution(int[] array) {
        int length = array.length;

        long[] start = new long[length];
        long[] end = new long[length];

        for (int i = 0; i < length; i++) {
            
            start[i] = (long) i - array[i];
            end[i] = (long) array[i] + i;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        long intersections = 0;

        for (int i = length - 1; i >= 0; i--) { // starting from the last end index 
            int index = Arrays.binarySearch(start, end[i]);
            if (index >= 0) { // element found
                while (index < length && start[index] == end[i]) {
                    index++;
                }
                intersections += index;
            } else { // element not there
       
                // Since index = (-(insertionPoint) – 1), insertionPoint =-(index + 1)
                int insertionPoint = -(index + 1);
                
                intersections += insertionPoint;
            }

        }
        
        // subtract what was counted twice and any degenerate solutions 
        intersections = intersections - (long) length * ((long) length+ 1) / 2;;

        if (intersections > LIMIT) {
            return -1;
        }

        return (int) intersections;
    }
    
    /*
     * This will find the number of disc intersections in a sequence of discs
     * Expected time complexity:O(N*log(N)) or O(N). This method stores the
     * tupples for start and end points in java's ArrayList generic component.
     *   
     * @param array an array
     * @return intersections the number of disc intersections
     * @see http://www.lucainvernizzi.net/blog/2014/11/21/codility-beta-challenge-number-of-disc-intersections/
     * @see https://app.codility.com/demo/results/trainingYDJCY9-DDJ/
     */
    static int findNumberOfDiscIntersectionsAltMethodFour(int[] array) {
        
        int length = array.length;
        ArrayList<long[]> arrayList = new ArrayList<long[]>(length * 2);

        int j = 0;
        for (int i = 0; i < length; i++) {
            long[] start = {(long) i - array[i], (long) 1};
            long[] end = {(long) i + array[i], (long) -1};
            
            arrayList.add(start);
            arrayList.add(end);
            
            j += 2;
        }
         
         arrayList.sort(new Comparator<long[]>() {
            public int compare(long[] o1, long[] o2) {
                int result = Long.valueOf(o1[0]).compareTo(o2[0]);
                if(result == 0) {
                    result = Long.valueOf(o2[1]).compareTo(o1[1]);
                }
                    
                return result;
            }
        });

        int intersections, activeCircles;
        intersections = 0;
        activeCircles = 0;
        
        for (long[] entry : arrayList) {

            if ((entry[1] > 0)) {
                intersections += activeCircles;
                activeCircles += entry[1];
            } else {
                activeCircles += entry[1];
            }

            if (intersections > LIMIT) {
                return -1;
            }
        }
        return intersections;
    }
    
    /*
     * This will find the number of disc intersections in a sequence of discs
     * Expected time complexity:O(N*log(N)) or O(N). This method stores the
     * tupples for start and end points in a two dimensional array (an array of arrays).
     *   
     * @param array an array
     * @return intersections the number of disc intersections
     * @see http://www.lucainvernizzi.net/blog/2014/11/21/codility-beta-challenge-number-of-disc-intersections/
     * @see https://app.codility.com/demo/results/trainingUZPCVY-35F/
     */
    static int findNumberOfDiscIntersectionsAltMethodThree(int[] array) {
        int length = array.length;
        long[][] tupples = new long[length * 2][2];

        int j = 0;
        for (int i = 0; i < length; i++) {
            long[] start = {(long) i - array[i], (long) 1};
            long[] end = {(long) i + array[i], (long) -1};
            tupples[j] = start;
            tupples[j + 1] = end;
            j += 2;
        }

        Arrays.sort(tupples, new Comparator<long[]>() {
            public int compare(long[] o1, long[] o2) {
                int result = Long.valueOf(o1[0]).compareTo(o2[0]);
                if(result == 0) {
                    result = Long.valueOf(o2[1]).compareTo(o1[1]);
                }
                    
                return result;
            }
        });
        
        int intersections, activeCircles;
        intersections = 0;
        activeCircles = 0;
        
        for (long[] entry : tupples) {

            if ((entry[1] > 0)) {
                intersections += activeCircles;
                activeCircles += entry[1];
            } else {
                activeCircles += entry[1];
            }

            if (intersections > LIMIT) {
                return -1;
            }
        }
        return intersections;
    }

    /**
     * This will find the number of disc intersections in a sequence of discs
     * Expected time complexity:O(N*log(N)) or O(N)
     *
     * @param array an array
     * @return intersections the number of disc intersections
     * @see http://www.lucainvernizzi.net/blog/2014/11/21/codility-beta-challenge-number-of-disc-intersections/
     */
    static int findNumberOfDiscIntersectionsAltMethodTwo(int[] array) {
        int length = array.length;

        Multimap<Long, Long> map = ArrayListMultimap.create();

        for (int i = 0; i < length; i++) {
            map.put((long)i - array[i], (long) 1);
            map.put((long) i + array[i], (long) -1);
        }

        List<Map.Entry<Long, Long>> sortedEntries
                = new Ordering<Map.Entry<Long, Long>>() {
                    public int compare(Map.Entry<Long, Long> entry1, Map.Entry<Long, Long> entry2) {
                        int result;
                        result = entry1.getKey().compareTo(entry2.getKey());
                        if (result == 0) {
                            result = entry2.getValue().compareTo(entry1.getValue());
                        }
                        return result;

                    }
                }.sortedCopy(map.entries());

        int intersections, activeCircles;
        intersections = 0;
        activeCircles = 0;

        for (Map.Entry<Long, Long> entry : sortedEntries) {

            if ((entry.getValue() > 0)) {
                intersections += activeCircles;
                activeCircles += entry.getValue();
            } else {
                activeCircles += entry.getValue();
            }

            if (intersections > LIMIT) {
                return -1;
            }
        }
        return intersections;
    }

    /**
     * This will find the number of disc intersections in a sequence of discs
     * This method uses an array of Disc objects containing start, centre and 
     * end variables to calculate intersections (discs[i].end >= discs[j].start),
     * where i,j are two discs.
     *
     * @param array an array
     * @return intersections the number of disc intersections
     * @see https://app.codility.com/demo/results/training7TNSAV-952/
     */
    static int findNumberOfDiscIntersectionsAltMethodOne(int[] array) {
        int length = array.length;

        Disc[] discs = new Disc[length];

        for (int i = 0; i < length; i++) {
            discs[i] = new Disc(i, array[i]);;
        }

        Arrays.sort(discs, new Comparator<Disc>() {
            public int compare(Disc o1, Disc o2) {
                if (o1.start < o2.start) {
                    return -1;
                }
                if (o1.start > o2.start) {
                    return 1;
                }
                return 0;
            }
        });

        int intersections = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (discs[i].end >= discs[j].start) {
                    intersections++;
                    if (intersections > LIMIT) {
                        return -1;
                    }
                } else {
                    break;
                }
            }
        }
        return intersections;
    }

    /**
     * The Disc Class.
     *
     * @author marylene
     * @since 9 August 2018
     */
    private static class Disc {

        long start;
        long end;
        int centre;

        public Disc(int centre, int radius) {
            start = (long) centre - (long) radius;
            end = (long) centre + (long) radius;
            centre = centre;
        }

        /**
         * This will retrieve a string representation of a disc.
         *
         * @return A string representation of a disc
         */
        public String toString() {
            return "start: " + start + "centre: " + centre + "end: " + end;
        }
    }
}
