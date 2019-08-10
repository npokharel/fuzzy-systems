import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Fuzzy {

  public String domain;
  public double member;

  public Fuzzy(String domain, double member) {
    this.domain = domain;
    this.member = member;
  }

  public String toString(){
    return this.member + "/" + this.domain;
  }

  public static boolean validate(HashMap<String , Fuzzy> fuzzy) {
    for(Map.Entry <String, Fuzzy> f : fuzzy.entrySet()) {
      String key = f.getKey();
      double value = f.getValue().member;
      if(value < 0 || value > 1) {
        System.out.println(String.format("Invalid Member value %s should be in [0,1]", value));
        System.exit(0);
      }
    }
    return true;
  }

  public static HashMap computeComplement(HashMap<String, Fuzzy> fuzzy) {

    HashMap<String, Fuzzy> result = new HashMap<>();

    Collection<?> keys = fuzzy.keySet();
    for(Object key : keys) {
      result.put((String)key, new Fuzzy((String) key, 1 - fuzzy.get(key).member));
    }
    return result;

  }

  public static HashMap computeIntersection(HashMap<String, Fuzzy> f1, HashMap<String, Fuzzy> f2) {

    HashMap<String, Fuzzy> result = new HashMap<>();

    Collection<?> keys = f1.keySet();

    for(Object key : keys) {
      if(f2.containsKey(key))
        result.put((String)key, new Fuzzy((String) key,
                (f1.get(key).member < f2.get(key).member) ? f1.get(key).member : f2.get(key).member)
        );
      else {
        result.put((String) key, new Fuzzy((String) key, 0 ) );
      }
    }

    Collection<?> keys2 = f2.keySet();

    for(Object key : keys2) {
      if(f1.containsKey(key))
        result.put((String)key, new Fuzzy((String) key,
                (f2.get(key).member < f1.get(key).member) ? f2.get(key).member : f1.get(key).member)
        );
      else
        result.put((String) key, new Fuzzy((String) key, 0 ) );
    }

    return result;
  }

  public static HashMap computeUnion(HashMap<String, Fuzzy> f1, HashMap<String, Fuzzy> f2) {

    HashMap<String, Fuzzy> result = new HashMap<>();

    Collection<?> keysF1 = f2.keySet();

    for(Object key : keysF1) {
      if(f1.containsKey(key)) {
        result.put((String) key, new Fuzzy((String) key,
                (f2.get(key).member > f1.get(key).member) ? f2.get(key).member : f1.get(key).member)
        );
      }
      else{
        result.put((String)key, new Fuzzy((String)key, (f2.get(key).member)));
      }
    }

    Collection<?> keysF2 = f1.keySet();

    for(Object key : keysF2) {
      if(f2.containsKey(key))
        result.put((String)key, new Fuzzy((String) key,
                (f1.get(key).member > f2.get(key).member) ? f1.get(key).member : f2.get(key).member)
        );
      else
        result.put((String)key, new Fuzzy((String)key, (f1.get(key).member)));
    }

    return result;
  }

  public static void computeHeight ( HashMap<String, Fuzzy> f) {

    Collection<?> keys = f.keySet();
    double height = 0;
    for(Object key : keys) {
      if(height < f.get(key).member) {
        height = f.get(key).member;
      }
    }

    if(height == 1.0) {
      System.out.print("Height is 1 set is normal");
    }else {
      System.out.println("Height = " + height + " set is not normal");
    }

  }

  public static void computeAlphaCut(HashMap<String, Fuzzy> f, Double alpha) {
    HashMap<String, Fuzzy> result = new HashMap<>();

    Collection<?> keys = f.keySet();
    for(Object key : keys) {
      double member = f.get(key).member;
      if(member >= alpha) {
        result.put((String)key, new Fuzzy((String)key, member));
      }
    }
    System.out.println(String.format("f alpha (%s) = " + result.keySet(), alpha));
  }

  public static void computeSupport(HashMap<String, Fuzzy> f) {
    HashMap<String, Fuzzy> result = new HashMap<>();

    Collection<?> keys = f.keySet();
    for(Object key : keys) {
      double member = f.get(key).member;
      if(member > 0 ) {
        result.put((String)key, new Fuzzy((String)key, member));
      }
    }
    System.out.println(String.format("Support of %s = " + result.keySet(), f.values()));
  }

  public static void computeCore(HashMap<String, Fuzzy> f) {
    HashMap<String, Fuzzy> result = new HashMap<>();

    Collection<?> keys = f.keySet();
    for(Object key : keys) {
      double member = f.get(key).member;
      if(member == 1 ) {
        result.put((String)key, new Fuzzy((String)key, member));
      }
    }
    System.out.println(String.format("Core of %s = " + result.keySet(), f.values()));
  }

  public static void computeBoundary(HashMap<String, Fuzzy> f) {
    HashMap<String, Fuzzy> result = new HashMap<>();

    Collection<?> keys = f.keySet();
    for(Object key : keys) {
      double member = f.get(key).member;
      if(member < 1 && member > 0) {
        result.put((String)key, new Fuzzy((String)key, member));
      }
    }
    System.out.println(String.format("Boundary of %s = " + result.keySet(), f.values()));
  }

}
