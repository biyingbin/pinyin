package com.laobi

import java.io.File

import scala.io.Source

object Test {

  def main(args: Array[String]): Unit = {
    val chengshiName = Source.fromFile(new File("C:\\Users\\laobi\\Desktop\\name.txt"))
        .getLines()
        .map(_.split("\t", -1))
        .filter(arr => arr(1).trim.length > 0 && arr(4).trim.length > 0 && arr(5).length > 5)
        .map(arr => {
          val py = TestPinyin4jCsdn.getAllPinyin(arr(1)).split(" ").toList

          val dtarr = if(arr(5).length > 9) {
            arr(5).substring(0, 10).split("-", -1)
          } else {
            if(!arr(5).startsWith("1900"))
              arr(5).split("-", -1)
            else
              "1900-1-1".split("-")
          }
          val month = if(dtarr(1).length > 1) dtarr(1) else "0" + dtarr(1)
          val day = if(dtarr(2).length > 1) dtarr(2) else "0" + dtarr(2)
          val dt = dtarr(0) + "-" + month + "-" + day

          (arr(4), (arr(1), py, dt, arr.mkString("\t")))

        })
        .toList
        .groupBy(_._1)
        .map(kv => {
          (kv._1, kv._2.map(_._2))
        })


    Source.fromFile(new File("C:\\Users\\laobi\\Desktop\\50Persons.txt"))
      .getLines()
      .map(_.split("\t", -1))
      .filter(arr => chengshiName.contains(arr(1)))
      .flatMap(arr => {

        val comeName = TestPinyin4jCsdn.getAllPinyin(arr(0)).split(" ").toList

        val kv = chengshiName.get(arr(1)).get

        val dt = arr(2).substring(0, 10)

        kv.filter(info => {
          if(info._2.intersect(comeName).size > 0 && dt >= info._3) {
            true
          } else {
            false
          }
        }).map(line => {
          arr.mkString("\t") + "\t" + line._4
        })
      })
      .foreach(println)


  }

}
