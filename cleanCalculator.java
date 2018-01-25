 /*calculator*/
package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        String in;
        int n;
        boolean fn1,fn2;
        float a=0,b=0;
        float[] validArr;
        String array[];
        float  res;
        char choice;
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.print("1. Addition\n");
            System.out.print("2. Subtraction\n");
            System.out.print("3. Multiplication\n");
            System.out.print("4. Division\n");
            System.out.print("5. Exit\n\n");
            System.out.print("Enter Your Choice : ");
            choice = scan.next().charAt(0);
            switch(choice)
            {
                case '1' :
                    do {

                        System.out.print("How many numbers are you going to add : ");
                        in = scan.next();
                        n = numberOrNot(in);
                        }while (n==0);
                    do {
                        System.out.print("Enter the Numbers : ");
                        array = new String[n];
                        for (int i = 0; i < n; i++) {
                            array[i] = scan.next();
                        }
                        validArr = floatOrNot(array);
                        }while (validArr.length==0);
                    res=add(validArr);
                    System.out.print("Result = " + res);
                    break;
                case '2' :
                    do {
                        System.out.print("How many numbers are you going to subtract : ");
                        in = scan.next();
                        n = numberOrNot(in);
                        }while (n==0);
                    do {
                        System.out.print("Enter the Numbers : ");
                        array = new String[n];
                        for (int i = 0; i < n; i++) {
                            array[i] = scan.next();
                        }
                        validArr = floatOrNot(array);
                        }while (validArr.length==0);
                    res=sub(validArr);
                    System.out.print("Result = " + res);
                    break;
                case '3' :
                    do {
                        System.out.print("How many numbers are you going to multiply : ");
                        in = scan.next();
                        n = numberOrNot(in);
                        }while (n==0);
                    do {
                        System.out.print("Enter the Numbers : ");
                        array = new String[n];
                        for (int i = 0; i < n; i++) {
                            array[i] = scan.next();
                        }
                        validArr = floatOrNot(array);
                        }while (validArr.length==0);
                    res=mul(validArr);
                    System.out.print("Result = " + res);
                    break;
                case '4' :
                    do {
                        do {
                            System.out.print("Enter a Dividend : ");
                            in = scan.next();
                            fn1 = FloatnumberOrNot(in);
                            if(fn1==true){
                                a=Float.parseFloat(in);
                            }
                            } while (fn1 == false);

                        do {
                            System.out.print("Enter a Divisor : ");
                            in = scan.next();
                            fn2 = FloatnumberOrNot(in);
                            if(fn2==true){
                                b=Float.parseFloat(in);
                            }
                            } while (fn2 == false);
                        res = div(a, b);
                        }while(res==0);
                    System.out.print("Result = " + res);
                    break;
                case '5' : System.exit(0);
                    break;
                default : System.out.print("Wrong Choice!!!");
                    break;
            }
            System.out.print("\n---------------------------------------\n");
        }while(choice != 5);
    }
    /*Checking input type for division*/
    private static boolean FloatnumberOrNot(String input) {
        try
        {
            Float.parseFloat(input);
        }
        catch(NumberFormatException ex)
        {
            System.out.println("oops!! , please give a valid number ");
            return false;
        }
        return true;
    }
   /* Division operation*/
    private static float div(float fn1,float fn2) {
        float res;
        int flag=0;
        try{
            res=fn1/fn2;
        }
        catch(ArithmeticException ex){
            System.out.println("ArithmeticException occurs!! ");
            return flag;
        }
        return res;
    }
   /* Multiplication operation*/
    private static float mul(float[] validArr) {
        float res=1;
        for (int j = 0; j < validArr.length; j++){
            res = res * validArr[j];
        }
        return res;
    }
   /* Checking user input numberOrNot*/
    private static int numberOrNot(String input)
    {
        int m;
        try
        {
            m = Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            System.out.println("oops!! , please give a valid number");
            return 0;
        }
        return m;
    }
    /* Checking user input floatOrNot*/
    private static float[] floatOrNot(String[] input1)
    {
        float floatArr[]=new float[input1.length];
        float emptyArr[]=new float[0];
        try
        {
            for(int i=0;i<input1.length;i++)
                floatArr[i] = Float.parseFloat(input1[i]);
        }
        catch(NumberFormatException ex)
        {
            System.out.println("oops!! , Charecter input not acceptable ");
            return emptyArr;
        }
        return floatArr;
    }
  /*  Subraction operation*/
    private static float sub(float[] array1) {
        float result = 0, neg = 0, pos = 0, tempAdd = 0;
        float[] tempArray ;
        float halfResult=0;
        int positive = 0, negative = 0;
        // Check how many positive and/or negative numbers
        for (float i : array1) {
            if (i >= 0) {
                positive++;
            } else {
                negative++;
            }
        }
        // Make exact size arrays
        float[] posArray = new float[positive];
        float[] negArray = new float[negative];
        // Reset variables for new purpose
        int newpositive = 0;
        int newnegative = 0;
        //Put numbers in correct array
        for (float j : array1) {
            if (j > 0) {
                posArray[newpositive] = j;
                newpositive++;
            } else {
                negArray[newnegative] = j;
                newnegative++;
            }
        }
        tempArray =new float[posArray.length];
        if ((posArray.length != 0) && (negArray.length != 0))
        {
        for (int j = 0; j < array1.length; j++) {
            if (array1[j] < 0) {
                /*tempArray = new float[array1.length];*/
                neg = neg + array1[j];
            } else if (array1[j] > 0) {
                pos = pos + array1[j];
            }
        }
        result = pos + neg;
        return result;
    }
    else if((posArray.length != 0) && (negArray.length == 0)){
            for(int i=0;i<posArray.length-1;i++)
            {
                tempArray[i]=-(posArray[i+1]);
            }
            for(int j=0;j<tempArray.length;j++){
                tempAdd=tempAdd+tempArray[j];
            }
            return posArray[0]+tempAdd;
        }
        else if((posArray.length == 0) && (negArray.length != 0)){
            /*tempArray =new float[posArray.length];*/
            for(int i=0;i<negArray.length-1;i++)
            {
                halfResult = halfResult- negArray[i + 1];
            }
            result=negArray[0]+halfResult;
            return result;
        }
        return 0;
    }
   /* Addition operation*/
    private static float add( float[] array) {
        float result=0;
        for (int j = 0; j < array.length; j++){
            result = result + array[j];
        }
        return result ;
    }
}