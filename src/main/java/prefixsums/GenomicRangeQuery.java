package prefixsums;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution for the GenomicRangeQuery task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training2X2NX6-6SV/
 * @see https://app.codility.com/demo/results/trainingMBEAFJ-QCB/
 * @since 12 August 2018
 */
public class GenomicRangeQuery {

    /**
     * This will find the minimal nucleotide from a range of sequence DNA in
     * O(n) running time.
     *
     * @param dnaString the the DNA sequence
     * @param start a list of the beginning indices of the queries
     * @param end a list of the ending indices of the queries
     * @return queryResults the result of the genomic range query
     */
    static int[] minGenomicQuery(String dnaString, int[] start, int[] end) {

        int queryLength = start.length;
        int[] queryResults = new int[queryLength];

        int[][] prefixLast = prefixLast(dnaString);
        int[] prefixLastA = prefixLast[0];
        int[] prefixLastC = prefixLast[1];
        int[] prefixLastG = prefixLast[2];

        for (int i = 0; i < queryLength; i++) {
            if (prefixLastA[end[i]] >= start[i]) {
                queryResults[i] = 1;
            } else if (prefixLastC[end[i]] >= start[i]) {
                queryResults[i] = 2;
            } else if (prefixLastG[end[i]] >= start[i]) {
                queryResults[i] = 3;
            } else {
                queryResults[i] = 4;
            }
        }
        return queryResults;
    }
    
    /**
     * This will find the last indices of the nucleotides of types A, C and G 
     * Its main idea uses a "prefix last" method which
     * is defined as the consecutive indices of the last occurrences of the
     * nucleotides of types A, C and G of the DNA sequence.
     *
     * @param dnaString the the DNA sequence
     * @return prefixLast the resulting array consisting of three arrays 
     *         corresponding to the nucleotides of types A, C and G
     */
    public static int[][] prefixLast(String dnaString) {

        int length = dnaString.length();

        int[] prefixLastA = new int[length];
        int[] prefixLastC = new int[length];
        int[] prefixLastG = new int[length];

        int[][] prefixLast = {prefixLastA, prefixLastC, prefixLastG};

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                prefixLastA[0] = -1;
                prefixLastC[0] = -1;
                prefixLastG[0] = -1;
            } else {
                prefixLastA[i] = prefixLastA[i - 1];
                prefixLastC[i] = prefixLastC[i - 1];
                prefixLastG[i] = prefixLastG[i - 1];
            }

            if (dnaString.charAt(i) == 'A') {
                prefixLastA[i] = i;
            } else if (dnaString.charAt(i) == 'C') {
                prefixLastC[i] = i;
            } else if (dnaString.charAt(i) == 'G') {
                prefixLastG[i] = i;
            }
        }

        return prefixLast;
    }

    /**
     * This will find the minimal nucleotide from a range of sequence DNA in
     * O(n^2) running time.
     *
     * @param dnaString the the DNA sequence
     * @param start a list of the beginning indices of the queries
     * @param end a list of the ending indices of the queries
     * @return queryResults the result of the genomic range query
     */
    public static int[] findPrefixMin(String dnaString, int[] start, int[] end) {
        
        int queryLength = start.length;
        int[] queryResults = new int[queryLength];

        for (int i = 0; i < queryLength; i++) {
            // find the prefix mins in that segment of the DNA sequence
            int[] prefixMin = prefixMin(dnaString.substring(start[i], end[i] + 1));
            
            // the last element in prefix mins is the min in that segment
            queryResults[i] = prefixMin[prefixMin.length - 1]; 
        }

        return queryResults;
    }

    /**
     * This will compute the minimum of nucleotides in a given segment of the 
     * DNA sequence. Its main idea uses "prefix minimums" which
     * are defined as the consecutive minimums of the first 0, 1, 2, . . . , n 
     * nucleotides of the DNA sequence.
     *
     * @param dnaString the the DNA sequence
     * @return prefixMin the resulting prefix minimums
     */
    public static int[] prefixMin(String dnaString) {

        int length = dnaString.length();
        int[] prefixMin = new int[length + 1];

        // set the first one to an arbitrary value > than any of the impact factors
        prefixMin[0] = 5;

        for (int i = 1; i < length + 1; i++) {

            int impactFactor;
            if (dnaString.charAt(i - 1) == 'A') {
                impactFactor = 1;
            } else if (dnaString.charAt(i - 1) == 'C') {
                impactFactor = 2;
            } else if (dnaString.charAt(i - 1) == 'G') {
                impactFactor = 3;
            } else {
                impactFactor = 4;
            }

            prefixMin[i] = Math.min(prefixMin[i - 1], impactFactor);
        }

        return prefixMin;
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the DNA sequence:");
        String dnaString = input.next().trim();
        System.out.println("Enter the number of items in genomic range query"
            + " array (can be an integer within the range [1..50,000]):");
        int queryLength = input.nextInt();
        int[] start = new int[queryLength];
        int[] end = new int[queryLength];
        System.out.println("Enter the items in the start array (can be an "
            + "integer within the range [0..dnaString.length − 1]; start <= end):");
        int countStart = 0;
        while (countStart < queryLength) {
            start[countStart] = input.nextInt();
            countStart++;
        }

        System.out.println("Enter the items in the end array (can be an "
            + "integer within the range [0..dnaString.length − 1]; start <= end)):");
        int countEnd = 0;
        while (countEnd < queryLength) {
            end[countEnd] = input.nextInt();
            countEnd++;
        }

        System.out.println("Query Results Method 1 O(N^2): "
            + Arrays.toString(findPrefixMin(dnaString, start, end)));
        System.out.println("Query Results Method 2 O(N): "
            + Arrays.toString(minGenomicQuery(dnaString, start, end)));

    }
}
