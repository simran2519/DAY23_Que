//2.Problem Description
//
//        Implement wildcard pattern matching with support for '?' and '*' for strings A and B.
//        '?' : Matches any single character.
//        '*' : Matches any sequence of characters (including the empty sequence).
//        The matching should cover the entire input string (not partial).
//
//
//        Problem Constraints
//        1 <= |A|, |B| <= 9e4
//
//
//        Input Format
//        The first argument of input contains a string A.
//        The second argument of input contains a string B.
//
//
//        Output Format
//        Return 0 or 1:
//        => 0 : If the patterns do not match.
//        => 1 : If the patterns match.
//
//
//        Example Input
//        Input 1:
//        A = "aa"
//        B = "a" //0
//        Input 2:
//        A = "aa"
//        B = "aa"  //1
//        Input 3:
//        A = "aaa" //0
//        B = "aa"
//        Input 4:
//        A = "aa"  //1
//        B = "*"
//        Input 5:
//        A = "aa" //1
//        B = "a*"
//        Input 6:
//        A = "ab"  //1
//        B = "?*"
//        Input 7: //0
//        A = "aab"
//        B = "c*a*b"
//
//
//        Example Output
//        Output 1:
//        0
//        Output 2:
//        1
//        Output 3:
//        0
//        Output 4:
//        1
//        Output 5:
//        1
//        Output 6:
//        1
//        Output 7:
//        0
package DAY_23;

import java.util.Scanner;

public class Q2
{
    public static int matchingStrings(String str1,String str2)
    {
        if(str2.contains("*")&& str1.length()<str2.length())
        {
            return 0;
        }
        else if(!str2.contains("*")&& str1.length()!=str2.length())
        {
            return 0;
        }
        else
        {
            if(str2.contains("*")&& (str1.length()>=str2.length()))
            {
                return 1;
            }
            else if(!(str2.contains("*")))
            {
                for(int i=0;i<str1.length();i++)
                {
                    char ch=str1.charAt(i);
                    char ch1=str2.charAt(i);
                    if(!(ch==ch1 || ch1=='?'))
                    {
                        return 0;
                    }
                }
            }
            return 1;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string 1");
        String str1=sc.next();
        System.out.println("Enter the string 2");
        String str2=sc.next();
        System.out.println(matchingStrings(str1,str2));
    }
}
