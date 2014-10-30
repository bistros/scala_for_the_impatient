1. 숫자의 signum은 숫자가 양수이면 1, 음수이면 -1, 0이면 0이다. 이 값을 계산하는 함수
"""
def func(signum:Int) = if (signum >0) 1 else if (signum < 0) -1 else 0

func(2)
res0: Int = 1

func(-3)
res1: Int = -1

func(0)
res2: Int = 0
"""

2. 빈 블록식 {}의 값은 무엇인가 타입은 무엇인가?
"""
val brace = {}
brace: Unit = ()
타입은 Unit 값은 ()
"""

3. 스칼라에서 x=y=1 할당이 유효한 상황 하나만 말해보라
""" pass;이해안됨 """

4. 자바 루프 for(int i=10; i>=0; i--) System.out.println(i);를 스칼라로
"""
for ( i <- (10 to 1).by(-1) ) println(i) 
"""

5. n부터 0까지 출력하는 countdown(n:Int) '프로시저'
"""
def countdown(n:Int) {
  val step = if (n>0) -1 else 1
  for ( i <- (n to 0).by(step) )   println(i) 
}
"""

6. 문자열의 모든 유니코드를 곱하는 for루프
"""
def multicode(str:String) = {
  var result =1L
  for(c <- str )  result =result * c
  result
}
println(multicode("Hello" ) )
"""

7 6번 문제를 루프를 쓰지 않고 StringOps를 참고해서 
"""
"Hello".foldLeft(1L)( (x:Long, y:Char ) => x*y )
"""

8. 6번 문제에서 기술한 바를 product(s:String)
""""
def product(s:String) = {
  s.foldLeft(1L) ( (x:Long, y:Char) => x*y)
}
product("Hello")
"""

9. 6번 문제의 함수를 재귀 함수로 만들라.
"""
def productRecv(s:String, v:Long) : Long = {
  if ( s.isEmpty ) 1 else{
    v * s.charAt(0)  * productRecv(s.drop(1) , v)
  }
}
"""

10.  n은 정수인 x^n을 계산하는 함수를 작성하라. 재귀를 이용하고 return을 이용하지 않는다.
"""
def powRecv(x:Long, n:Long) : Long = {
  if(n ==0 ) 1
  else if ( n < 0 ) 1 / powRecv(x, n * -1)
  else {
    if (n % 2 == 1 )   x * powRecv(x, n -1)
      else  powRecv( powRecv(x, n/2) /* y*/ , 2)
  }
}
y=x n/2이면 xn=y2라는 부분이 번역이 이상한듯해서 이해가 안되었는데
y= x^n/2 = func(x, n/2) 이고 이걸 func(y, 2) 함
"""