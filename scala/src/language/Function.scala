package language

object Function {

  def main(args: Array[String]): Unit = {
    //函数
    def add(a: Int, b: Int): Unit = {
      println(a + b)
    }

    add(5, 5)

    //逻辑运算符(&//&&)->短路效应
    println(1 == 1 || 1 == 2)
    println(1 == 1 && 2 == 2)

    //位运算
    println(1 << 2)

    //比较
    var a = "hello"
    var b = "hello"
    println(a == b)


    //if
    var value = if (1 == 1) 100 else 0
    println(value)

    //do--while
    var dow = 5;
    do {
      dow = dow - 1
      println("dow=======" + dow)
    } while (dow > 0)

    //嵌套
    var title = "hello shijie hello scala"

    def num(titleName: String): Int = {
      if (titleName.contains("hello"))
        return titleName.length
      else
        do {
          var name = "scala"
          return name.length

        } while (titleName.contains("scala"))
      return 0
    }

    println(num(title))


    //循环
    println(1 to 5)
    for (i <- 1 to 5) println("循环" + "==" + i)

    for (i <- 6 until  10) println("循环" + "==" + i)
  }
}
