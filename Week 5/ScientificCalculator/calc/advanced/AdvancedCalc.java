package calc.advanced;
public class AdvancedCalc {public double power(double a,double b){return Math.pow(a,b);}public double sqrt(double a){if(a<0){System.out.println("Error: Negative number");return 0;}return Math.sqrt(a);}public double log(double a){if(a<=0){System.out.println("Error: Log undefined");return 0;}return Math.log(a);}}
