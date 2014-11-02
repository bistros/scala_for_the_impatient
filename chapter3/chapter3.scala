


1. a를 0포함 n불포함 사이의 임의의수 n 배열로 설정하는 코드 조각을 작성하라
def a(n:Int) = Array.fill[Int](n)(scala.util.Random.nextInt(n))

2. 정수 배열의 인접한 원소를 교환하는 루프를작성하라. 예를 들어 Array(1,2,3,4,5) => Array(2,1,4,3,5)
"""
  val array = Array(1, 2, 3, 4, 5,6)
  if (array.length > 1) for (n <- 0.until(array.length, 2)) {
    if (array.length > n + 1) {
      var temp = array(n+1)
      array(n+1) = array(n)
      array(n) = temp
    }
  }
  array.foreach(println)
"""


3. 2번문제를 for/yield로 반복하라
"""
  val array = Array(1, 2, 3, 4, 5)
  val result =
    for (n <- 0.until(array.length, 2) ) yield {
      if (array.length > n + 1)  List(array(n+1), array(n) )
      else List(array(n))
    }.flatten
 """	

4. 정수 배열이 주어졌을때 기존 배열의 모든 양수값이 기존 순서대로 오고, 그 뒤에 모든 0 혹은 음수값이 기존 순서대로 오는 새 배열?
"""
방법1) val result = array.filter( _ > 0) ++ array.filter ( _ <= 0)

방법2)
 val part =  ( array.partition( _ >0) )
 val result2 = part._1 ++ part._2
"""

5. Array[Double]의 평균을 어떻게 계산하나?
"""
val list :Array[Double] = Array(1.2, 3.4, 1.4)
list.sum/ list.length
"""

6. Array[Int]를 어떻게 재배열하면 역순으로 정렬되게 나오나? 같은 일을 ArrayBuffer[Int]로?
"""
Array(3,4,2,1,5).sorted.reverse
ArrayBuffer(3,4,2,1,5).sorted.reverse
"""

7. 중복 제거한 배열의 모든 값을 생성하는 코드 조각을 작성하라
"""
Array(3,4,4,3,2,1,5).distinct
"""

8. "3.4배열변환" 마지막에 나오는 예제를 작성하라
음수원소의 인덱스를 모으고 시퀀스를 역순으로 만들고 마지막 인덱스를 빼고 각 인덱스에 a.remove(i)를 호출하라.
"""
문제요구사항) 첫번째 음수를 제거하고 이 후 음수만 제거한 배열
  var a = scala.collection.mutable.ListBuffer(2,-2,1,4,-2,-1,5,6) //2 -2 1 4 5 6
  val indexes = ( for (i <- 0 until a.length if  a(i) <= 0 ) yield i ).reverse.dropRight(1).foreach( x=>a.remove(x))

"""


9. java.util.TimeZone.getAvailableIDs 가 리턴하는 미국 내 모든 시간대의 콜렉션을 만들고 "America/"접미사를 제거하고 결과를 정렬하라.
"""
val result = for(node <- java.util.TimeZone.getAvailableIDs if node.startsWith("America") ) yield  node.replace("America/", "")
result.sorted.mkString("\n")
"""


10. jawa.awt.datatransfer._를 임포트하고 SystemFloavorMap 타입 오브젝트를 다음 호출로 만들어라
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
DataFlavor.imageFlavor 를 인자로 getNativesForFlavor메소드를 호출하여 스칼라 버퍼로 리턴값을 얻어라
"""
import java.awt.datatransfer._

import scala.collection.mutable
import scala.collection.JavaConversions._
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
val list : mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
"""