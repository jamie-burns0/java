package me.jamieburns.streams.day4;

import static me.jamieburns.streams.TestSupport.tests;

import java.util.Arrays;
import java.util.stream.IntStream;

import me.jamieburns.streams.Test;

public class StreamsTest {
    
    public static void main(String[] args) {
            new StreamsTest().testsToRun();
    }

    @org.testng.annotations.Test
    public void testsToRun() {

        tests(
            new Test<>(() -> {

                int[] ts = {32, 28, 28, 29, -15, 30, 15, 21, 25};                

                Arrays.stream(ts).reduce((l, r) -> {
                    
                    System.out.println(l + ", " + r);
                    
                    if (l == r) {
                        return l;
                    }

                    var smallerTemp = Math.abs(l) < Math.abs(r) ? l : r;

                    if (Math.abs(l) == Math.abs(r)) {
                        smallerTemp = l > r ? l : r;
                    }

                    return smallerTemp;});


                return 0;}, 0),
            new Test<>(() -> {

                int[] ts = {32, 28, 28, 29, -15, 30, 15, 21, 25};                

                int[] distinctArray = Arrays.stream(ts).distinct().toArray();

                Arrays.stream(distinctArray).forEach(System.out::println);

                return 0;}, 0),
            new Test<>(() -> {

                String text = "aabaa";                
                char[] ta = text.toCharArray();
                StringBuffer encoded = new StringBuffer();
                char current = ' ';
                int count = 0;
                for (char c : ta) {
                    if (current != c) {
                        if (count != 0) {
                            encoded.append("" + count + current);
                        }
                        current = c;
                        count = 1;
                    } else {
                        count++;
                    }
                }
                encoded.append("" + count + current);
                System.out.println(encoded);

                return 0;}, 0),
            new Test<>(() -> {
                class Solution {
                    static String reshape(int n, String str) {
                        // drop spaces
                        String clean = str.replace(" ", "");
                        StringBuffer reshaped = new StringBuffer();
                        int beginIndex = 0;
                        int endIndex = beginIndex + n;
                        while (endIndex <= clean.length()) {
                            reshaped.append(clean.substring(beginIndex, endIndex));
                            if (endIndex != clean.length()) {
                                reshaped.append("\n");
                            }
                            beginIndex = endIndex;
                            endIndex += n;
                        }
                        if (beginIndex <= clean.length()) {
                            reshaped.append(clean.substring(beginIndex));
                        }
                        
                        return reshaped.toString();
                    }
                }
                System.out.println(Solution.reshape(3, "abc de fghij"));
                System.out.println(Solution.reshape(2, "1 23 456"));

                return 0;}, 0),
            new Test<>(() -> {

                /*class DoNothingFilterValueFunction implements FilterValueFunction {
                    @Override
                    public int apply(int row, int col, int[][] unfilteredArray) {
                        return unfilteredArray[row][col];
                    }
                }
                */
                /*
                class InversionFilterValueFunction implements FilterValueFunction {
                    @Override
                    public int apply(int row, int col, int[][] unfilteredArray) {
                        return unfilteredArray[row][unfilteredArray[row].length - col - 1];
                    }
                }
                */

                class Solution {

                    @FunctionalInterface
                    interface FilterValueFunction {
                        public int apply(int row, int col, int[][] unfilteredArray);
                    }

                    FilterValueFunction doNothingFn = (r, c, a) -> a[r][c];
                    FilterValueFunction inversionFn = (r, c, a) -> a[r][a[r].length - c - 1];
                    FilterValueFunction blurFn = (r, c, a) -> {
                        double average = 0;
                        int[] rows = IntStream.of(a.length - 1, a.length, a.length + 1)
                            .filter(r2 -> {System.out.println("1: " + r2); return r2 >= 0;})
                            .filter(r2 -> {System.out.println("2: " + r2); return r2 < a.length;})
                            .toArray();
                        int[] cols = IntStream.of(a[0].length - 1, a[0].length, a[0].length + 1)
                            .filter(c2 -> {System.out.println("3: " + c2); return c2 >= 0;})
                            .filter(c2 -> {System.out.println("4: " + c2); return c2 < a[0].length;})
                            .toArray();
                        
                        for (int r3 : rows) {
                            for (int c3 : cols) {
                                System.out.println("5: " + r3 + ", " + c3);
                            }
                        }
                        return a[0][0];
                    };
                    
                    int[][] applyFilter(int width, int height, int filter, int[][] color) {

                        var fn = switch(filter) {
                            case 1 -> inversionFn;
                            case 2 -> blurFn;
                            default -> doNothingFn;
                        };
                        
                        int[][] filtered = new int[height][width];

                        for (int row = 0; row < height; row++) {
                            for (int col = 0; col < width; col++) {
                                filtered[row][col] = fn.apply(row, col, color);
                            }
                        }

                        return filtered;
                    }
                }

                int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

                new Solution().applyFilter(a[0].length, a.length, 2, a);
                
                return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0),
            new Test<>(() -> {return 0;}, 0)
        );
    }
}
