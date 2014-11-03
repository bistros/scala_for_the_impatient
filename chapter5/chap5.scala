1. 5.1 간단한 Counter 클래스를 Int.MaxValue에서 음수가 되지 않게 선언하라.
"""
class Counter {
  private var value = 0
  def incremnt() { if(value <= Int.MaxValue) value+=1 }
  def current() = value
}
"""

2. 메소드 deposit, withdraw, 읽기전용 프로퍼티 balance로 BankAccount class작성
"""
class BankAccount {
  private var balance = 0

  def current = balance
  def deposit_= (money:Int) { balance += money }
  def withdraw_= (money:Int) { balance -= money}
}
"""

3. 읽기전용 프로퍼티 hoirs, minutes 이 시간이 다른 시간보다 앞선 시간인지 확인하는
before(other:TIme):Boolean메소드를 가진 Time클래스.
"""
class Time(hrs:Int, min:Int) {
  if(hrs < 0 || hrs > 23) throw new Exception(" 0 <= hrs <= 23 를 충족하지 못함")

  val hours = hrs
  val minutes = min

  def before(other:Time) = {
    if(hours < other.hours) true
      else if( hours == other.hours && minutes < other.minutes) true
      else false
  }
}
"""

4. 내부 표현이 자정 이후 분 (0과 24 * 60-1)이 되도록 이전 문제의 Time클래스를 재구현하라.
공개 인터페이스를 변경하지 말아야한다. 바꿔 말해 클라이언트 코드는 이 변경에 영향이 없도록
"""
class Time (hrs:Int, min:Int) {
  if(hrs < 0 || hrs > 23) throw new Exception(" 0 <= hrs <= 23 를 충족하지 못함")
  private var value = hrs*60 + min
  val hours : Int = value / 60
  val minutes : Int = value % 60

  def before(other:Time) = if(this.value < other.value) true else false
}
"""


5. 읽기쓰기 자바 프로퍼티 name(String), id(Long)을 갖는 Student클래스. 어떤 메소드가 생성되는가?
스칼라에서 자바빈 게터 세터를 호출할 수 있나 그렇게 하는것이 좋나?
"""
class Student(@BeanProperty var name:String, @BeanProperty var id:Long)

$ javap -public Student
Warning: Binary file Student contains com.daumcorp.heuso.api.Student
Compiled from "test.scala"
public class Student {
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public void setName(java.lang.String);
  public long id();
  public void id_$eq(long);
  public void setId(long);
  public java.lang.String getName();
  public long getId();
  public com.daumcorp.heuso.api.Student(java.lang.String, long);
}
생성자를 포함한 위의 메소드들이 생성된다

  val student = new Student("bis", 20)
  student.setId(0)
  println( student.getId )
  println( student.getName )
  처럼 get/setter 를 사용할 수 있다.
스칼라에서 @BeanProperty를 이용해 생성된 getter/setter를   이용하는건 장점이 없다.
"""


6.  5.1에 나오는 Person 클래스에서 음수 나이를 0으로 바꾸는 기본 생성자를 제공하라
"""
5.1이 아니고 5.2에 나오고 가장 마지막 Person class를 기준으로 함
class Person(private var privateAge:Int) {
  if (privateAge<0) privateAge=0

  def age = privateAge
  def age_=(n: Int) = {
    if (n > privateAge) privateAge = n
  }
}
"""

7. new Person("Fred Smith")와 같이 이름 공백 성을 포함한 문자열을 받는 기본 생성자가 있는 Person 클래스 작성
읽기 전용 프로퍼티인 firstName, lastName을 제공하라 기본 생성인자는 var,val,일반인자중 어느것이어야 하나? 왜 그런가?
"""
class Person(name:String) {
  private[this] val arx = name.split(" ")

  def firstanme = arx(0)
  def lastanme = arx(1)
}
일반인자로 사용한다. 입력되는 fullname을 사용하는 요구사항이 없기 떄문이다. 만약 필요하다면 val로 선언해서 읽기 전용 프로퍼티로 만듬
"""

8. 제조사/모델명/모델연도를 읽기 전용 프로퍼티로 가지고 번호판을 읽기-쓰기 프로퍼티로 가지는 Car클래스를 만들어라.
네개의 생성자를 제공하라. 모든 생성자는 제조사와 모델명을 요구한다.
선택적으로 모델연도와 번호판을 생성자에 지정할 수 있다. 그렇지 않으면 모델 연도는 -1/번호판은 빈 문자열이 된다.
어느 생성자를 기본 생성자로 선택할 것인가?왜 그런가?
"""
class Car(val maker:String, val model:String, val year:Int = -1, var number :String = ""){
  override def toString = Seq(maker, model, year, number).mkString(" , ")
}

  val c1 = new Car("BMW", "X5")
  val c2 = new Car("BMW", "X5", year = 2012)
  val c3 = new Car("BMW", "X5", number = "A111")
  val c4 = new Car("BMW", "X5", 2012, "A111")

"""

9. 8번문제의 클래스를 자바로 재구현 
""" pass """

10. 다음 클래스class Employee(val name:String, var salary:Double) {
	def this() { this("John Q. Public", 0.0) }
}
이 클래스의 명시적인 필드와 디폴트 기본 생성자를 이용하여 재작성하라. 어떤 형태를 더 선호하는가?
"""
class Emp(val name:String = "John Q. Public", var salary:Double = 0.0)
명시적인 default값을 쉽게 눈으로 확인할 수 있다.
"""
