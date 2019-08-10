import java.lang.reflect.Array;

public class Ex1 {
  public static void main (String args[]) {
    /*int x = 10;
    int y = new Ex1().change(x);
    System.out.println(x+y);*/
    /*int a = 5;
    int b = a;
    a*=2;
    b+=1;
    System.out.println("a = " + a);
    System.out.println("b = " + b);*/

    /*StringBuilder sb = new StringBuilder("UpWork");
    sb.insert(6,"-");
    sb.insert(0, "-");
    sb.insert(4, "-");
    System.out.println("sb = " + sb);*/

    //double d = Math.round(Math.round(2.5));
    //System.out.println("d = " + Math.round());
    /*String s1 = null;
    String s2 ='null';
    String s3 = (String) 'abc';
    String s4 = (String ) '\ufeed';*/
    //Array a = new Array(5);
   // int []a = {22, 23, 24, 23, 32};
    //int a[] = new int (5);
    //int [5] array;

    int []a = {1, 2, 053, 4};
    int b[][] = {{1,2,4}, {2,2,1}, {0, 43,2}};
    System.out.print(a[3]==b[0][2]);
    //System.out.println(" " + );


  }
  int change (int x) {
    x = 12;
    return x;
  }
}
