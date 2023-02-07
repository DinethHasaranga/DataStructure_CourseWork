package sample;

public class LinearSearch {
    public static int search(int arr[],int x){
        int n = arr.length;
        for (int i = 0; i<n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {62,89,32,67,21,39,88,55,94};
        int x= 89;

        int result = search(arr,x);
        if (result == -1) {
            System.out.println("Element not present");
        }
        else {
            System.out.println("Element index is " + result);
        }
    }
}
