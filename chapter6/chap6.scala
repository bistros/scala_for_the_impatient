
1. incheToCentimeters,incheToCentimeters,milesToKilometers 메소드를 가지는 Conversions 오브젝트를 작성하라.
"""
object Conversions {
  def incheToCentimeters(v:Double) = 2.54 * v   //구글 q=인치 센티미터
  def gallonToLiters (v:Double) = 3.78 * v      //구글 q=갤런 리터
  def milesToKilometers (v:Double) = 1.6 * v    //구글 q=마일 킬로미터
}

"""

2. 이전 문제는 그다지 객체지향적이지 않다. 일반적인 슈퍼클래스인 UnitConversions를 제공하고 이를 확장하는 오브젝트를 작성하라
"""
class UnitConversions(unit:Double) {
  def apply(v:Double) = unit * v
}
object InchesToCentimeters extends UnitConversions(2.54){}
object GallonToLiters extends UnitConversions(3.78){}
object MilesToKillometers extends UnitConversions(1.6){}
"""

3. java.awt.Point를 확장하는  Origin오브젝트를 정의하라 왜 좋은 생각이 아닌가 (Point를 살펴본다)
"""
값을 가지는 class인데 object로 만들면 여러개 만들때 값의 상태가 위험해진다.
"""

4. Point클래스를 컴피니언 오브젝트와 함께 정의하여 new 없이 Point(4,3)같이 Point인스턴스를 생성할 수 있게 하라
"""
class Point(x:Int, y:Int) extends java.awt.Point
object Point {
  def apply(x:Int, y:Int) = new Point(x, y)
}
"""

5.App 트레이트를 이용하여 명령 줄 인자를 공백으로 구분하여 역순으로 출력하는 스칼라 애플을 만들어라.
"""
object Reverse extends App {
  println( args.reverse.mkString(" ") )
}
"""

6. 4개의 카드를 묘사하느 이뉴머레이션을 작성하여 toString 메소드가 각각 나오게 만들어라
"""
object Card extends Enumeration {
  type Card = Value
  val a1 = Value("A")
  val a2 = Value("B")
  val a3 = Value("C")
  val a4 = Value("D")
}
특수문자를 못 찾아서 A,B,C,D 4글자로 표현함
"""

7. 이전 문제의 카드 세트 값이 빨강인지 확인하는 함수를 구현하라.
"""
  def isRed(card:Card) = {
    if(card == Card.a1 || card == Card.a2) true else false 
  }
a1, a2가 red card라 가정한다.
"""  

8. RGB색상 큐브의 8개의 모서리를 나타내는 이뉴머렝션을 작성하라 ID로 색상값을 사용하라
"""
object Colors extends  Enumeration {
  type Color = Value
  val a1 = Value(0xff0000)
  val a2 = Value(0x00ff00)
  val a3 = Value(0x0000ff)
  val a4 = Value(0xffff00)
  val a5 = Value(0xff00ff)
  val a6 = Value(0x00ffff)
  val a7 = Value(0xffffff)
  val a8 = Value(0x000000)
}
"""
