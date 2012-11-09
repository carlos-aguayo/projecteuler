package com.dreamskiale.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * http://projecteuler.net/problem=26
 */
public class Problem26 {
  
  public static class Cycle {
    public final int digits;
    public final int d;
    public Cycle(int d, int digits) {
      this.d = d;
      this.digits = digits;
    }
  }
  
  public Cycle findMax(int n) {
    Cycle max = new Cycle(0,0);
    for (int i = 2; i < n; i++) {
      Cycle cycle = find(new ArrayList<Integer>(), 10, i);
      if (cycle.digits > max.digits) {
        max = cycle;
      }
    }
    return max;
  }
  
  /**
   * Keep the numerators seen in the list, as soon as we see it again,
   * the cycle is the length of the subset of the list starting
   * from the seen entry all the way to the end. 
   */
  private Cycle find(List<Integer> list, int numerator, int denominator) {
    list.add(numerator);
    int remainder = numerator % denominator;
    int n = remainder * 10;
    if (n == 0) {
      return new Cycle(denominator, 0);
    } else if (list.contains(n)) {
      return new Cycle(denominator, list.size() - list.indexOf(n));
    } else {
      return find(list, n, denominator);
    }
  }

  public static void main(String[] args) {
    double start = System.currentTimeMillis();
    int d = new Problem26().findMax(1000).d;
    double end = System.currentTimeMillis();
    System.out.println("Solution is " + d + ", found in " + (end-start) + " ms");
  }
  
}