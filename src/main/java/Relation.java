import java.util.LinkedHashMap;

public class Relation {

  static void computeRelation(LinkedHashMap<String, Fuzzy> a, LinkedHashMap <String, Fuzzy> b) {

    Object[] aKeys = a.keySet().toArray();
    Object[] bKeys = b.keySet().toArray();

    int aSize = aKeys.length;
    int bSize = bKeys.length;

    double [][] r = new double[aSize][bSize];

    for(int i=0; i< aSize; i++) {
      for(int j=0; j< bSize; j++) {
        r[i][j] = (a.get(aKeys[i]).member < b.get(bKeys[j]).member) ? a.get(aKeys[i]).member : b.get(bKeys[j]).member;
      }
    }

    System.out.println("\nThe Relation Matrix: \n");

    for(int i=0; i< aSize; i++) {
      System.out.print("[");
      for (int j = 0; j < bSize; j++) {
        System.out.print( r[i][j]  + " ");
      }
      System.out.println("]");
    }

    double alpha = 0.3;

    System.out.println(String.format("\nAlpha Cut %s : \n", alpha));

    for(int i=0; i< aSize; i++) {
      System.out.print("[");
      for (int j = 0; j < bSize; j++) {
        System.out.print( (r[i][j] >=alpha )?" 1 " : " 0" + " ");
      }
      System.out.println("]");
    }

    System.out.println(String.format("\nAlpha Cut + %s : \n", alpha));

    for(int i=0; i< aSize; i++) {
      System.out.print("[");
      for (int j = 0; j < bSize; j++) {
        System.out.print( (r[i][j] > alpha )?" 1 " : " 0" + " ");
      }
      System.out.println("]");
    }

  }

}
