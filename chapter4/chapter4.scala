1. 사고싶은 여러장치의 가격 맵을 만들라 그리고 키는 같고 가격은 10% 할인된 두번째 맵을 생성하라.
"""
val prices = Map( "iphone" -> 240, "ps4" -> 40, "remotecon" -> 99)
val disprice = for ( (key, price) <- prices ) yield key -> price * 0.9
"""

2. 파일에서 단어를 읽어들이는 프로그램 각 단어가 얼마나 빈번하게 등장하는지 세는 수정 가능한 맵을 이용하라.
단어를 읽어들이는것은 java.util.Scanner이용하라
val in = new java.util.Scanner(new java.io.File("myfile.txt"))
while (in.hasNext()) process in.next()
또는 9장의 스칼라 방식을 참조하라. 마지막에 모든 단어와 횟수를 출력하라.
"""
  val lins = Source.fromFile("word.txt").getLines()
  val countermap = new scala.collection.mutable.HashMap[String, Int]
  lins foreach ( x => countermap.update( x, countermap.getOrElse(x, 0)+1 ) )
  println(lins)
"""

3. 2번문제를 수정 불가능한 맵으로 반복하라.
"""
var countermap = new scala.collection.immutable.HashMap[String, Int]
lins.foreach( x => countermap = countermap + (x ->  (countermap.getOrElse(x, 0) +1)) )
"""

4. 	2번문제를 단어를 정렬되게 정렬맵으로
"""
  var countermap = new scala.collection.immutable.HashMap[String, Int]
  lins.foreach( x => countermap = countermap + (x ->  (countermap.getOrElse(x, 0) +1)) )
  val sorted = SortedMap[String, Int]() ++ countermap
"""


5. 2번을 java.util.Tremap을 스칼라Api로 개조해서 반복하라.
"""
import scala.collection.JavaConversions._
import java.util.TreeMap
val map = new TreeMap[String, Int]()
lins foreach(  x=> map.put( x , map.getOrElse(x, 0) + 1 ) )
"""  

6. "Monday"를 java.util.Calendar.MonDay로 매핑하고 다른 요일도 매핑하는 링크해시맵을 정의하라
원소는 삽입된 순서로 방문이 일어남을 보여라
"""
  import java.util.Calendar._
  val map = mutable.LinkedHashMap("Monday" -> MONDAY, "Tuesday" -> TUESDAY, "Wednesday" -> WEDNESDAY,
    "Thursday" -> THURSDAY, "Friday" -> FRIDAY, "Saturday" -> SATURDAY, "Sunday" -> SUNDAY)

  map.foreach(println)
"""

7. 다음과 같이 모든 자바 속성의 표를 출력하라. 테이블을 출력하기 전에 가장 긴 키의 길이를 찾아야 할것이다.
"""
 import scala.collection.JavaConversions._
  val properties = System.getProperties()
  val maxlength = properties.keysIterator.map( _.length ).max

  properties map ( x => printf("%s | %s%n", x._1.padTo(maxlength , " ").mkString, x._2))
"""

8. 베열에서 가장 작은 수와 큰 수의 쌍을 리턴하는 minmax(values:Array[Int]) 
"""
def minmax(values:Array[Int] ) = (values.min, values.max) //너무 간단한데?
"""

9. v보다 작은 갯수 v와 같은 수의 갯수, v보다 큰 수의 갯수를 트리플 리턴하는 lteqgt(values:Array[Int], v:Int) 함수
"""
  def lteqgt(values:Array[Int], v:Int) =
    (values.filter(_>v).length, values.filter (_==v).length, values.filter (_<v).length )

  println( lteqgt(Array(2,1,3,4,5,2,1,3,2,1), 2))
"""

10. "Hello".zip("World")와 같이 두 문자열을 zip하면?   
"""

  println( "Hello".zip("World") )
  println( "Hello".zip("") )
  println( "".zip("World"))
  println( "Hello".zip("length6") )

Vector((H,W), (e,o), (l,r), (l,l), (o,d))
Vector()
Vector()
Vector((H,l), (e,e), (l,n), (l,g), (o,t))

"""