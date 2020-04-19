package com.laobi

import java.io.File

import scala.collection.mutable.ArraySeq
import scala.io.Source
import scala.math.Ordering

class o extends Ordered[Int] {
  override def compare(that: Int): Int = {
    1
  }
}


object Test2 {

  def sorted(implicit ord: Ordering[Int]) = {

    println(Array(1,5,3,4).sorted.mkString(","))

  }

  def main(args: Array[String]): Unit = {

    implicit val ord = implicitly[Ordering[Int]].reverse

    sorted

    println(Ordering[Int].compare(1, 2))
    println(Ordering[Int].compare(2, 1))
    println(Ordering[Int].compare(1, 1))




//    val chengshiName = Source.fromFile(new File("C:\\Users\\laobi\\Desktop\\8field_sheet2.txt"))
//        .getLines()
//        .map(_.trim.split("\t", -1))
//        .filter(arr => arr.length > 9)
//        .map(arr => {
//          (arr.tail.reverse.tail.reverse.mkString("\t"), arr.head + "\t" + arr.last)
//        }).toMap
//
//
//    Source.fromFile(new File("C:\\Users\\laobi\\Desktop\\8field_sheet1.txt"))
//      .getLines()
//      .map(_.split("\t", -1))
//      .map(arr => {
//
//        val key = List(arr(1), arr(2), arr(3), arr(5), arr(6), arr(7), arr(8), arr(9)).mkString("\t")
//
//        val value = chengshiName.get(key).getOrElse("\t")
//        arr.mkString("\t") + "\t" + value
//
//      })
//      .foreach(println)


  }

}
