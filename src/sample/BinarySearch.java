package sample;

import java.util.Arrays;

public class BinarySearch {
    int binarySearch(int arr[],int l, int r, int x){
        if (r >= 1) {
            int mid = l + (r-1)/2;
            if (arr[mid] == x){
                return mid;
            }
            if (arr[mid] > x){
                return binarySearch(arr, l,mid-1,x);
            }
            return binarySearch(arr,mid+1,r,x);
        }
        return -1;
    }
    public static void main(String args[]){
        BinarySearch ob = new BinarySearch();
        int[] numbers = {62,89,32,67,21,39,88,55,94};
        Arrays.sort(numbers);
        int n = numbers.length;
        int x = 89;
        int result = ob.binarySearch(numbers,0,n-1,x);

        if (result == -1) {
            System.out.println("Element not present");
        }
        else{
            System.out.println("Element index " + result);
        }
    }
}
