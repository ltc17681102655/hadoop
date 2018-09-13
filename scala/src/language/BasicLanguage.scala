package language

object BasicLanguage {
//标点都不要了
  def main(args: Array[String]): Unit = {
    //变量
    //var 可变
    var str = "hello scala"
    str="hadoop scalar"
    println(str)

    var num = 1+3
    println(num)

    var doubleNum = 13.13 + 14.14
    println(doubleNum)

    var floatNum = 156f + 156f
    println(floatNum)


    //val 不可变   static final
    val name = "ltc"
   println(name)

    //懒加载
    lazy val lazyStr = "memory"
    println(lazyStr)


  }

}
