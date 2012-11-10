package com.dreamskiale.projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem47 {
  
  /**
   * http://www.vogella.com/articles/JavaAlgorithmsPrimeFactorization/article.html
   */
  public static int numberOfPrimeFactors(int numbers) {
    int n = numbers; 
    Set<Integer> factors = new HashSet<Integer>();
    for (int i = 2; i <= n / i; i++) {
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }
    if (n > 1) {
      factors.add(n);
    }
    return factors.size();
  }  

  public static void main(String[] args) {
    int number = 2;
    int factors = 4;
    int consecutive = 4;
    long start = System.currentTimeMillis();
    while(true) {
      number++;
      boolean found = true;
      for (int i = 0; i <= consecutive - 1; i++) {
        found &= (numberOfPrimeFactors(number + i) == factors); 
      }
      if (found) {
        break;
      }
    }
    long end = System.currentTimeMillis();
    System.out.println("The solution is " + number + " found in " + (end-start) + " ms");
  }

}
