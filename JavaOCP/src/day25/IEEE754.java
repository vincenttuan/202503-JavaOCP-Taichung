package day25;

import java.math.BigDecimal;

public class IEEE754 {

	public static void main(String[] args) {
		double a = 0.1;
		double b = 0.1;
		double c = 0.1;
		double d = a + b + c;
		System.out.println(d);
		System.out.println(d == 0.3);
		
		BigDecimal x = new BigDecimal("0.1");
		BigDecimal y = new BigDecimal("0.1");
		BigDecimal z = new BigDecimal("0.1");
		BigDecimal r = x.add(y).add(z);
		System.out.println(r);
		System.out.println(r.toPlainString());
		System.out.println(r.toPlainString().equals("0.3"));
		

	}

}
