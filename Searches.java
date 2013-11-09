
//package line only needed by netbeans
//package searches;

import java.util.*;

/*
 * @author Nick Carlson
 */

public class Searches {

    //main driver that lets the user pick a test and run it
    public static void main(String[] args) {
        int choice = 0;
        Scanner reader = new Scanner(System.in);
        
        //get input from user
        //if input unacceptable, tell the user why not
        System.out.println("Please enter an integer 1 thru 5 to choose which test to run:");
        System.out.println("Choose 1 to test with random integers.");
        System.out.println("Choose 2 to test with an ordered sequence of integers.");
        System.out.println("Choose 3 to test with one quarter identical integers.");
        System.out.println("Choose 4 to test with one half identical integers.");
        System.out.println("Choose 5 to test with three quarters identical integers.");
        System.out.println("Choose 6 to perform a correctness test.");
        System.out.println("");
        
        try{
        choice = reader.nextInt();
        }catch(InputMismatchException e){
            System.out.println("");
            System.out.println("Unacceptable input - you must enter an integer 1 thru 5.");
            System.exit(0);
        }
        
        switch(choice){
            case 1:
                System.out.println("");
                searchRandom();
                break;
            case 2:
                System.out.println("");
                searchSequence();
                break;
            case 3:
                System.out.println("");
                searchOneFourth();
                break;
            case 4:
                System.out.println("");
                searchOneHalf();
                break;
            case 5:
                System.out.println("");
                searchThreeQuarters();
                break;
            case 6:
                System.out.println("");
                correctnessTest();
                break;
            default:
                System.out.println("");
                System.out.println("Unacceptable input - you must enter an integer 1 thru 5.");
                break;
        }
        
    }
    
    //perform searches on a list of random integers
    public static void searchRandom(){
        int array[] = new int[10000000];
        int searchNum = randomInts(array);
        shellsort(array);
        boolean test = testSort(array);
        
        //search only if sort is verified
        if(test == true){
            System.out.println("Searching for: " + searchNum);

            long startTime1 = System.nanoTime();
            int inArray = jumpSearch(searchNum,array);
            long endTime1 = System.nanoTime();
            long duration1 = endTime1 - startTime1;
            double elapsedMilliTime1 = (double) duration1 / 1000000.0;
            
            long startTime2 = System.nanoTime();
            int inArray2 = binarySearch(searchNum,array,0,array.length-1);
            long endTime2 = System.nanoTime();
            long duration2 = endTime2 - startTime2;
            double elapsedMilliTime2 = (double) duration2 / 1000000.0;
            
            long startTime3 = System.nanoTime();
            int inArray3 = interpolationSearch(searchNum,array);
            long endTime3 = System.nanoTime();
            long duration3 = endTime3 - startTime3;
            double elapsedMilliTime3 = (double) duration3 / 1000000.0;
            
            long startTime4 = System.nanoTime();
            int inArray4 = sequentialSearch(searchNum,array);
            long endTime4 = System.nanoTime();
            long duration4 = endTime4 - startTime4;
            double elapsedMilliTime4 = (double) duration4 / 1000000.0;
            
            //display results
            System.out.println("Jump Search found key at index " + inArray + " in " + elapsedMilliTime1 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray2 + " in " + elapsedMilliTime2 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray3 + " in " + elapsedMilliTime3 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray4 + " in " + elapsedMilliTime4 + " milliseconds.");
        }else{
            System.out.println("The list did not sort correctly.");
            System.exit(0);
        }
    }
    
    //perform searches on a list that is an ordered sequence of integers
    public static void searchSequence(){
        int array[] = new int[10000000];
        int searchNum = sequenceInts(array);
        
        System.out.println("Searching for: " + searchNum);

            long startTime1 = System.nanoTime();
            int inArray = jumpSearch(searchNum,array);
            long endTime1 = System.nanoTime();
            long duration1 = endTime1 - startTime1;
            double elapsedMilliTime1 = (double) duration1 / 1000000.0;
            
            long startTime2 = System.nanoTime();
            int inArray2 = binarySearch(searchNum,array,0,array.length-1);
            long endTime2 = System.nanoTime();
            long duration2 = endTime2 - startTime2;
            double elapsedMilliTime2 = (double) duration2 / 1000000.0;
            
            long startTime3 = System.nanoTime();
            int inArray3 = interpolationSearch(searchNum,array);
            long endTime3 = System.nanoTime();
            long duration3 = endTime3 - startTime3;
            double elapsedMilliTime3 = (double) duration3 / 1000000.0;
            
            long startTime4 = System.nanoTime();
            int inArray4 = sequentialSearch(searchNum,array);
            long endTime4 = System.nanoTime();
            long duration4 = endTime4 - startTime4;
            double elapsedMilliTime4 = (double) duration4 / 1000000.0;
            
            //display results
            System.out.println("Jump Search found key at index " + inArray + " in " + elapsedMilliTime1 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray2 + " in " + elapsedMilliTime2 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray3 + " in " + elapsedMilliTime3 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray4 + " in " + elapsedMilliTime4 + " milliseconds.");
    }
    
    //performs searches on a list with 1/4 of items identical
    public static void searchOneFourth(){
        int array[] = new int[10000000];
        int searchNums[] = oneFourthIdentical(array);
        shellsort(array);
        boolean test = testSort(array);
        
        //search only if sort is verified
        if(test == true){
            System.out.println("Searching for 1/4 identical item: " + searchNums[0]);

            long startTime1 = System.nanoTime();
            int inArray = jumpSearch(searchNums[0],array);
            long endTime1 = System.nanoTime();
            long duration1 = endTime1 - startTime1;
            double elapsedMilliTime1 = (double) duration1 / 1000000.0;
            
            long startTime2 = System.nanoTime();
            int inArray2 = binarySearch(searchNums[0],array,0,array.length-1);
            long endTime2 = System.nanoTime();
            long duration2 = endTime2 - startTime2;
            double elapsedMilliTime2 = (double) duration2 / 1000000.0;
            
            long startTime3 = System.nanoTime();
            int inArray3 = interpolationSearch(searchNums[0],array);
            long endTime3 = System.nanoTime();
            long duration3 = endTime3 - startTime3;
            double elapsedMilliTime3 = (double) duration3 / 1000000.0;
            
            long startTime4 = System.nanoTime();
            int inArray4 = sequentialSearch(searchNums[0],array);
            long endTime4 = System.nanoTime();
            long duration4 = endTime4 - startTime4;
            double elapsedMilliTime4 = (double) duration4 / 1000000.0;
            
            //display results
            System.out.println("Jump Search found key at index " + inArray + " in " + elapsedMilliTime1 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray2 + " in " + elapsedMilliTime2 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray3 + " in " + elapsedMilliTime3 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray4 + " in " + elapsedMilliTime4 + " milliseconds.");
            System.out.println();
            
            System.out.println("Searching for other item: " + searchNums[1]);

            long startTime5 = System.nanoTime();
            int inArray5 = jumpSearch(searchNums[1],array);
            long endTime5 = System.nanoTime();
            long duration5 = endTime5 - startTime5;
            double elapsedMilliTime5 = (double) duration5 / 1000000.0;
            
            long startTime6 = System.nanoTime();
            int inArray6 = binarySearch(searchNums[1],array,0,array.length-1);
            long endTime6 = System.nanoTime();
            long duration6 = endTime6 - startTime6;
            double elapsedMilliTime6 = (double) duration6 / 1000000.0;
            
            long startTime7 = System.nanoTime();
            int inArray7 = interpolationSearch(searchNums[1],array);
            long endTime7 = System.nanoTime();
            long duration7 = endTime7 - startTime7;
            double elapsedMilliTime7 = (double) duration7 / 1000000.0;
            
            long startTime8 = System.nanoTime();
            int inArray8 = sequentialSearch(searchNums[1],array);
            long endTime8 = System.nanoTime();
            long duration8 = endTime8 - startTime8;
            double elapsedMilliTime8 = (double) duration8 / 1000000.0;
            
            //display resuts
            System.out.println("Jump Search found key at index " + inArray5 + " in " + elapsedMilliTime5 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray6 + " in " + elapsedMilliTime6 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray7 + " in " + elapsedMilliTime7 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray8 + " in " + elapsedMilliTime8 + " milliseconds.");
        }else{
            System.out.println("The list did not sort correctly.");
            System.exit(0);
        }
    }
    
    //performs searches on a list with 1/2 of items identical
    public static void searchOneHalf(){
        int array[] = new int[10000000];
        int searchNums[] = oneHalfIdentical(array);
        shellsort(array);
        boolean test = testSort(array);
        
        //search only if sort is verified
        if(test == true){
            System.out.println("Searching for 1/2 identical item: " + searchNums[0]);

            long startTime1 = System.nanoTime();
            int inArray = jumpSearch(searchNums[0],array);
            long endTime1 = System.nanoTime();
            long duration1 = endTime1 - startTime1;
            double elapsedMilliTime1 = (double) duration1 / 1000000.0;
            
            long startTime2 = System.nanoTime();
            int inArray2 = binarySearch(searchNums[0],array,0,array.length-1);
            long endTime2 = System.nanoTime();
            long duration2 = endTime2 - startTime2;
            double elapsedMilliTime2 = (double) duration2 / 1000000.0;
            
            long startTime3 = System.nanoTime();
            int inArray3 = interpolationSearch(searchNums[0],array);
            long endTime3 = System.nanoTime();
            long duration3 = endTime3 - startTime3;
            double elapsedMilliTime3 = (double) duration3 / 1000000.0;
            
            long startTime4 = System.nanoTime();
            int inArray4 = sequentialSearch(searchNums[0],array);
            long endTime4 = System.nanoTime();
            long duration4 = endTime4 - startTime4;
            double elapsedMilliTime4 = (double) duration4 / 1000000.0;
            
            //display results
            System.out.println("Jump Search found key at index " + inArray + " in " + elapsedMilliTime1 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray2 + " in " + elapsedMilliTime2 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray3 + " in " + elapsedMilliTime3 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray4 + " in " + elapsedMilliTime4 + " milliseconds.");
            System.out.println();
            
            System.out.println("Searching for other item: " + searchNums[1]);

            long startTime5 = System.nanoTime();
            int inArray5 = jumpSearch(searchNums[1],array);
            long endTime5 = System.nanoTime();
            long duration5 = endTime5 - startTime5;
            double elapsedMilliTime5 = (double) duration5 / 1000000.0;
            
            long startTime6 = System.nanoTime();
            int inArray6 = binarySearch(searchNums[1],array,0,array.length-1);
            long endTime6 = System.nanoTime();
            long duration6 = endTime6 - startTime6;
            double elapsedMilliTime6 = (double) duration6 / 1000000.0;
            
            long startTime7 = System.nanoTime();
            int inArray7 = interpolationSearch(searchNums[1],array);
            long endTime7 = System.nanoTime();
            long duration7 = endTime7 - startTime7;
            double elapsedMilliTime7 = (double) duration7 / 1000000.0;
            
            long startTime8 = System.nanoTime();
            int inArray8 = sequentialSearch(searchNums[1],array);
            long endTime8 = System.nanoTime();
            long duration8 = endTime8 - startTime8;
            double elapsedMilliTime8 = (double) duration8 / 1000000.0;
            
            //display results
            System.out.println("Jump Search found key at index " + inArray5 + " in " + elapsedMilliTime5 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray6 + " in " + elapsedMilliTime6 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray7 + " in " + elapsedMilliTime7 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray8 + " in " + elapsedMilliTime8 + " milliseconds.");
        }else{
            System.out.println("The list did not sort correctly.");
            System.exit(0);
        }
    }
    
    //performs searches on a list with 3/4 of items identical
    public static void searchThreeQuarters(){
        int array[] = new int[10000000];
        int searchNums[] = threeQuartersIdentical(array);
        shellsort(array);
        boolean test = testSort(array);
        
        //search only if sort is verified
        if(test == true){
            System.out.println("Searching for 3/4 identical item: " + searchNums[0]);

            long startTime1 = System.nanoTime();
            int inArray = jumpSearch(searchNums[0],array);
            long endTime1 = System.nanoTime();
            long duration1 = endTime1 - startTime1;
            double elapsedMilliTime1 = (double) duration1 / 1000000.0;
            
            long startTime2 = System.nanoTime();
            int inArray2 = binarySearch(searchNums[0],array,0,array.length-1);
            long endTime2 = System.nanoTime();
            long duration2 = endTime2 - startTime2;
            double elapsedMilliTime2 = (double) duration2 / 1000000.0;
            
            long startTime3 = System.nanoTime();
            int inArray3 = interpolationSearch(searchNums[0],array);
            long endTime3 = System.nanoTime();
            long duration3 = endTime3 - startTime3;
            double elapsedMilliTime3 = (double) duration3 / 1000000.0;
            
            long startTime4 = System.nanoTime();
            int inArray4 = sequentialSearch(searchNums[0],array);
            long endTime4 = System.nanoTime();
            long duration4 = endTime4 - startTime4;
            double elapsedMilliTime4 = (double) duration4 / 1000000.0;
            
            //display results
            System.out.println("Jump Search found key at index " + inArray + " in " + elapsedMilliTime1 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray2 + " in " + elapsedMilliTime2 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray3 + " in " + elapsedMilliTime3 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray4 + " in " + elapsedMilliTime4 + " milliseconds.");
            System.out.println();
            
            System.out.println("Searching for other item: " + searchNums[1]);

            long startTime5 = System.nanoTime();
            int inArray5 = jumpSearch(searchNums[1],array);
            long endTime5 = System.nanoTime();
            long duration5 = endTime5 - startTime5;
            double elapsedMilliTime5 = (double) duration5 / 1000000.0;
            
            long startTime6 = System.nanoTime();
            int inArray6 = binarySearch(searchNums[1],array,0,array.length-1);
            long endTime6 = System.nanoTime();
            long duration6 = endTime6 - startTime6;
            double elapsedMilliTime6 = (double) duration6 / 1000000.0;
            
            long startTime7 = System.nanoTime();
            int inArray7 = interpolationSearch(searchNums[1],array);
            long endTime7 = System.nanoTime();
            long duration7 = endTime7 - startTime7;
            double elapsedMilliTime7 = (double) duration7 / 1000000.0;
            
            long startTime8 = System.nanoTime();
            int inArray8 = sequentialSearch(searchNums[1],array);
            long endTime8 = System.nanoTime();
            long duration8 = endTime8 - startTime8;
            double elapsedMilliTime8 = (double) duration8 / 1000000.0;
            
            //display results
            System.out.println("Jump Search found key at index " + inArray5 + " in " + elapsedMilliTime5 + " milliseconds.");
            System.out.println("Binary Search found key at index " + inArray6 + " in " + elapsedMilliTime6 + " milliseconds.");
            System.out.println("Interpolation Search found key at index " + inArray7 + " in " + elapsedMilliTime7 + " milliseconds.");
            System.out.println("Sequential Search found key at index " + inArray8 + " in " + elapsedMilliTime8 + " milliseconds.");
        }else{
            System.out.println("The list did not sort correctly.");
            System.exit(0);
        }
    }
    
    //correctness test to ensure that searches are working as they should
    public static void correctnessTest(){
        int array[] = new int[10000000];
        int searchNum = sequenceInts(array);
        int searchNum2 = 70007001;
        
        //search for something in the list
        System.out.println("Searching for: " + searchNum);

            int inArray = jumpSearch(searchNum,array);
            int inArray2 = binarySearch(searchNum,array,0,array.length-1);
            int inArray3 = interpolationSearch(searchNum,array);
            int inArray4 = sequentialSearch(searchNum,array);
            
            System.out.println("Jump Search found key at index " + inArray);
            System.out.println("Binary Search found key at index " + inArray2);
            System.out.println("Interpolation Search found key at index " + inArray3);
            System.out.println("Sequential Search found key at index " + inArray4);
            System.out.println();
            
        //search for something not in the list
        System.out.println("Searching for: " + searchNum2);

            int inArray5 = jumpSearch(searchNum2,array);
            int inArray6 = binarySearch(searchNum2,array,0,array.length-1);
            int inArray7 = interpolationSearch(searchNum2,array);
            int inArray8 = sequentialSearch(searchNum2,array);
            
            //since the key isn't in the list, it shouldn't be found
            if(inArray5 == -1){
                System.out.println("Jump Search did not find the key.");
            }else{
                System.out.println("ERROR!!!");
            }
            
            if(inArray6 == -1){
                System.out.println("Binary Search did not find the key.");
            }else{
                System.out.println("ERROR!!!");
            }
            
            if(inArray7 == -1){
                System.out.println("Interpolation Search did not find the key.");
            }else{
                System.out.println("ERROR!!!");
            }
            
            if(inArray8 == -1){
                System.out.println("Sequential Search did not find the key.");
            }else{
                System.out.println("ERROR!!!");
            }
            
    }
    
    //perform a jump search on a sorted list
    public static int jumpSearch(int x, int[] list){
        int len = list.length;
        //calculate the step
        int step = (int) Math.floor(Math.sqrt(len));
        int prev = 0;
        
        //step through the list
        while(list[step < len ? step-1 : len-1] < x){
            prev = step;
            step += (int) Math.floor(Math.sqrt(len));
            
            if(prev >= len){
                return -1;
            }
        }
        
        //while still less than the search item
        while(list[prev] < x){
            prev++;
            if(prev == (step < len ? step : len)){
                return -1;
            }
        }
        
        //found!
        if(list[prev] == x){
            return prev;
        }
        
        //else, not found
        return -1;
    }
    
    //perform a binary search on a sorted list
    public static int binarySearch(int x, int[] list, int left, int right){
        //base case
        if(left > right){
            return -1;
        }
        
        //set midpoint
        int mid = (left + right) >> 1;
        
        //return if found, else search recursively
        if(list[mid] == x){
            return mid;
        }else if(list[mid] > x){
            return binarySearch(x,list,left,mid-1);
        }else if(list[mid] < x){
            return binarySearch(x,list,mid+1,right);
        }else{
            return -1;
        }
    }
    
    //perform an interpolation search on a sorted list
    public static int interpolationSearch(int x, int[] list){
        int left = 0;
        int right = list.length-1;
        int k = 0;
        int mid = 0;
        
        //list beginning and end could be the same
        //if so, that value could be the search item
        while(left <= right){
            if(list[left] == list[right]){
                if(list[left] == x){
                    return left;
                }else{
                    return -1;
                }
            }
            
            //find k, used for finding a midpoint closer to the search value
            k = (x - list[left])/(list[right] - list[left]);
            
            //if not found (can't calculate k)
            if(k < 0 || k > 1){
                return -1;
            }
            
            //find midpoint for searching
            //took out Math.round
            mid = (left + k * (right - left));
            
            //probe list and set bounds for next iteration's search
            if(x < list[mid]){
                right = mid-1;
            }else if(x > list[mid]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    
    //perform sequential search on a sorted list
    public static int sequentialSearch(int x, int list[]){
        int len = list.length;
        int index = 0;
        
        //find search item
        for(int i = 0; i < len; i++){
            if(list[i] == x){
                index = i;
                return index;
            }
        }
        //else report not found
        return -1;
    }
    
    //shellsort: accepts an integer array and runs shell sort
    public static void shellsort(int[] args){
        //set gap for initial swaps
        double length = args.length;
        double temp_gap = Math.floor(length/2.0);
        int gap = (int) temp_gap;
        
        //while sorting is still happening
        while(gap > 0){
            //iterate through the entire array
            for(int i=gap; i < length; i++){
                //save the value located 'gap' spots from where we start
                int temp = args[i];
                int j = i;
                //while swap is needed
                while(j >= gap && args[j-gap] > temp){
                    //perform swap
                    args[j] = args[j - gap];
                    j = j - gap;
                }
                //place lower value where it belongs
                args[j] = temp;
            }
            //set new gap
            temp_gap = Math.floor(gap/2.0);
            gap = (int) temp_gap;
        }
    }
    
    //performs three phase swap for elements of an integer array
    public static void swap(int list[], int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    //brute-force test to ensure list is in sorted order (ascending)
    public static boolean testSort(int list[]){
        boolean test = true;
        for(int i = 0; i < list.length-1; i++){
            if((list[i] <= list[i+1]) == false){
                test = false;
            }
            //System.out.println(list[i]);
        }
        return test;
    }
    
    //fill an array with random integers
    public static int randomInts(int[] list){
        double temp = 0;
        
        //iterate through the entire array
        for(int i = 0; i <= list.length-1; i++){
            //set each array element to a random integer
            temp = Math.random() * list.length-1;
            list[i] = (int) temp;
        }
        
        return (int) temp;
    }
    
    //fill an array with an ordered sequence of integers
    public static int sequenceInts(int[] list){
        int key;
        double temp;
        
        for(int i = 0; i <= list.length-1; i++){
            list[i] = i;
        }
        
        temp = Math.random() * list.length-1;
        key = (int) temp;
        return key;
    }
    
    //fill an array with 1/3 identical values, return the identical and any non-identical
    public static int[] oneFourthIdentical(int[] list){
        int key1 = 0;
        int key2 = 0;
        double temp;
        int searchNums[] = new int[2];
        temp = Math.random() * list.length-1;
        key1 = (int) temp;
        
        for(int i = 0; i < 2500000; i++){
            list[i] = key1;
        }
        
        for(int i = 2500000; i <= list.length-1; i++){
            temp = Math.random() * list.length-1;
            key2 = (int) temp;
            while(key2 == key1){
                temp = Math.random() * list.length-1;
                key2 = (int) temp;
            }
            list[i] = key2;
        }
        
        searchNums[0] = key1;
        searchNums[1] = key2;
        return searchNums;
    }
    
    //fill an array with 1/2 identical values, return the identical and any non-identical
    public static int[] oneHalfIdentical(int[] list){
        int key1 = 0;
        int key2 = 0;
        double temp;
        int searchNums[] = new int[2];
        temp = Math.random() * list.length-1;
        key1 = (int) temp;
        
        for(int i = 0; i < 5000000; i++){
            list[i] = key1;
        }
        
        for(int i = 5000000; i <= list.length-1; i++){
            temp = Math.random() * list.length-1;
            key2 = (int) temp;
            while(key2 == key1){
                temp = Math.random() * list.length-1;
                key2 = (int) temp;
            }
            list[i] = key2;
        }
        
        searchNums[0] = key1;
        searchNums[1] = key2;
        return searchNums;
    }
    
    //fill an array with 3/4 identical values, return the identical and any non-identical
    public static int[] threeQuartersIdentical(int[] list){
        int key1 = 0;
        int key2 = 0;
        double temp;
        int searchNums[] = new int[2];
        temp = Math.random() * list.length-1;
        key1 = (int) temp;
        
        for(int i = 0; i < 7500000; i++){
            list[i] = key1;
        }
        
        for(int i = 7500000; i <= list.length-1; i++){
            temp = Math.random() * list.length-1;
            key2 = (int) temp;
            while(key2 == key1){
                temp = Math.random() * list.length-1;
                key2 = (int) temp;
            }
            list[i] = key2;
        }
        
        searchNums[0] = key1;
        searchNums[1] = key2;
        return searchNums;
    }
    
}
