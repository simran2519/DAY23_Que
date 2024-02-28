package DAY_23;

import java.util.Scanner;

//        1. You are given an array of integers, arr and its size n. You are also given an empty result array, rarr. Write the function arrayProducts that takes n and arr as inputs. It fills in the result array so that the element at every position is the product of the elements at all the other positions.
//        Example 1
//        Input:
//        n = 4
//        arr1234
//        rarr = empty
//        Output:
//        rarr 24 1286
//        Explanation:
//        • The first element in the result array = product of the remaining elements = 2 * 3 * 4 = 24
//        • The second element = 1 * 3 * 4 = 12
//        • The third element = 1 * 2 * 4 = 8
//        • The fourth element = 1 * 2 * 3 = 6
//        Example 2
//        Input:
//        n = 5
//        arr-11357
//        rarr = empty
//        Output:
//        • rarr 105-105-35-21-15
//        Explanation:
//        • The elements will be [1x3x5x7, -1x3x5x7, -1x1x5x7, -1x1x3x7, -1x1x3x5] = [105, -105, -35, -21, -15]
//        For this test you're using C GCC 10.2.0 Feel free to add comments in your code explaining your solution.
public class Q1 {
    public static void arrayProducts(int arr[], int n)
    {
        int rarr[]= new int[n];
          for(int i=0;i<n;i++)
          {
              int pro=1;
              for(int j=0;j<n;j++)
              {
                  if(i!=j)
                  {
                      pro*=arr[j];
                  }
              }
              rarr[i]=pro;
          }
          for(int i=0;i<rarr.length;i++)
          {
              System.out.print(rarr[i]+" ");
          }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        System.out.println("Enter the elements of array");
        int arr[]= new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        arrayProducts(arr,n);
    }
}
