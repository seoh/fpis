
name := "functional-programing-in-scala-example"
version := "0.0.1"
scalaVersion := "2.12.4"

// Part 1. Introduction to Functional Programming //
lazy val ch02 = project in file("ch02-higher-order-function")
lazy val ch03 = project in file("ch03-functional-data-structure")
lazy val ch04 = project in file("ch04-error-without-exception")
lazy val ch05 = project in file("ch05-strictness-and-laziness")
lazy val ch06 = project in file("ch06-purely-functional-state")

// Part 2. Functional Design and Combinator Libraries //
lazy val ch07 = project in file("ch07-purely-functional-parallelism")
lazy val ch08 = project in file("ch08-property-based-testing")
lazy val ch09 = project in file("ch09-parser-combinators")

// Part 3. Common Structures in Functional Design //
lazy val ch10 = project in file("ch10-monoids")
lazy val ch11 = project in file("ch11-monads")
lazy val ch12 = project in file("ch12-applicative-and-traversable-functors")
lazy val ch13 = project in file("ch13-external-effects-and-io")

// Part 4. Effects and I/O //
lazy val ch14 = project in file("ch14-local-effects-and-mutable-state")
lazy val ch15 = project in file("ch15-stream-processing-and-incremental-io")
