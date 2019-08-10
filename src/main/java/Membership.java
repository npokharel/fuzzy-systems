import java.util.LinkedHashMap;

public class Membership {

  static void R_Function(Double[] elements , Double alpha, Double beta) {

    LinkedHashMap<Double, Double> result = new LinkedHashMap<>();

    for( Double element : elements) {
      Double member ;
      if(alpha < element && element <= beta) {
        member = (element - alpha)/(beta - alpha);
      }else if(element <= alpha) {
        member = 0.0;
      }else {
        member = 1.0;
      }

      //System.out.println("element = " + element + " Member= " + member);
      result.put(element, member);
    }

    System.out.println("R_ = " + result.values());

  }

  static void L_Function(Double[] elements , Double alpha, Double beta) {

    LinkedHashMap<Double, Double> result = new LinkedHashMap<>();


    for( Double element : elements) {
      Double member ;
      if(alpha <= element && element <= beta) {
        member = (element - alpha)/(beta - alpha);
      }else if(element < alpha) {
        member = 1.0;
      }else {
        member = 0.0;
      }

      //System.out.println("element = " + element + " Member= " + member);
      result.put(element, member);
    }

    System.out.println("L_ = " + result.values());

  }

  static void Triangular_function(Double[] elements, Double alpha, Double beta, Double rho){

    LinkedHashMap<Double, Double> result = new LinkedHashMap<>();

    for( Double element : elements) {
      Double member ;
      if(alpha < element && element <= beta) {
        member = (element - alpha)/(beta - alpha);
      }else if(element <= alpha) {
        member = 0.0;
      }else if(beta < element && element <= rho) {
        member = (rho - element)/(rho - beta);
      }else {
        member = 0.0;
      }

      //System.out.println("element = " + element + " Member= " + member);
      result.put(element, member);
    }
    System.out.println("Triangular = " + result.values());
  }

  static void Trapezoidal_function(Double[] elements, Double alpha, Double beta, Double rho, Double delta){

    LinkedHashMap<Double, Double> result = new LinkedHashMap<>();

    for( Double element : elements) {
      Double member ;
      if(alpha < element && element <= beta) {
        member = (element - alpha)/(beta - alpha);
      }else if(element <= alpha) {
        member = 0.0;
      }else if(beta < element && element <= rho) {
        member = 1.0;
      }else if(rho < element && element <= delta) {
        member = (delta-element)/(delta-rho);
      }else {
        member =0.0;
      }

      //System.out.println("element = " + element + " Member= " + member);
      result.put(element, member);
    }

    System.out.println("Trapezoidal = " + result);

  }

}
