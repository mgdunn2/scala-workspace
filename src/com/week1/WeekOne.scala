package com.week1

object WeekOne {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    println(sqrt(2))
    println(sqrt(4))
    println(sqrt(1.0e50))
    println(sqrt(1.0e-20))

    println(factorial(5))
    println(factorialTail(5))

    println(sum(x => x)(1, 5))

    val sumCube = sum(x => x * x * x)_
    println(sumCube(1, 3))
  }

  def abs(x: Double): Double = { if (x < 0) x * -1 else x }

  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))
    }

    def isGoodEnough(guess: Double): Boolean = {
      abs(guess * guess - x) < (x * 0.001)
    }

    def improve(guess: Double): Double = {
      (guess + x / guess) / 2
    }

    sqrtIter(1.0)
  }

  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  }

  def factorialTail(n: Int): Int = {
    def loop(n: Int, acc: Int): Int = {
      if (n == 0) 1 * acc else loop(n - 1, n * acc)
    }
    loop(n, 1)
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }
}
