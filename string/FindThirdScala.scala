package com.isea.dw.string

import scala.collection.mutable

object FindThirdScala {
  def findThird(str: String): Tuple2[Char, Int] = {
    val map = new mutable.HashMap[Char, Int]()

    for (i <- str) {
      if (map.contains(i)) {
        map(i) = map(i) + 1
      } else {
        map += (i -> 1)
      }
    }
    println(map)
    map.toList.sortWith(_._2 > _._2)(2)
  }

  def main(args: Array[String]): Unit = {
    val str = "aaaaabbbbcccdddmm"
    println(findThird(str))
  }
}
