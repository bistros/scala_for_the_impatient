1. 스칼라 REPL에서 3을 입력하고 탭 키를 눌러라 어떤 메소드를 볼 수 있나?
"""
scala> 3.
%   *   -   >    >>    ^              isInstanceOf   toChar     toFloat   toLong    toString   unary_-   |   
&   +   /   >=   >>>   asInstanceOf   toByte         toDouble   toInt     toShort   unary_+    unary_~       
"""

2. 스칼라 REPL에서 3의 제곱근을 계산하고 그 값을 제곱하라, 결과가 3과 얼마나 차이가 나는가?(res활용)
"""
scala> math.sqrt(3)
res0: Double = 1.7320508075688772

scala> math.pow(res0, 2)
res1: Double = 2.9999999999999996

scala> 3 - res1
res2: Double = 4.440892098500626E-16
"""

3. res변수들은 val인가 var인가?
"""
scala> res2 = 0
<console>:10: error: reassignment to val
       res2 = 0
위의 에러를 통해 val임을 알 수 있다.	
"""

4. 스칼라에서는 문자열을 숫자로 곱할 수 있다. "crazy" * 3을 REPL에서 해보면? 스칼라독 어디서 찾을 수 있나?
"""
scala> "crazy"*3
res3: String = crazycrazycrazy
java.lang.String을 기반으로 StringOps 암묵적 변환에 의해 수행된다. http://scala-lang.org/api/current/#scala.collection.immutable.StringOps
"""

5. 10 max 2는 무엇을 뜻하나? 어디에 정의되어 있나?
"""
scala> 10 max 2
res5: Int = 10

scala> 10 max 3 max 21 max 22
res6: Int = 22
최대값을 구한다. 
http://scala-lang.org/api/current/#scala.runtime.RichInt
"""

6. BigInt를 이용하여 2^1024를 구하라.
"""
scala> val two = BigInt(2)
two: scala.math.BigInt = 2

scala> two.pow(1024)
res11: scala.math.BigInt = 179....
"""

7.  probablePrime과 Random을 아무런 식별자 없이 probablePrime(100, Random)으로 임의의 소수를 얻으려면 무엇을 임포트해야하나?
"""
scala> import util.Random
import util.Random

scala> import BigInt.probablePrime
import BigInt.probablePrime

scala> probablePrime(100, Random)
res0: scala.math.BigInt = 872250247044100930242576912863
"""

8. 임의의BigInt를 생성하고 이를 36진법으로 변환하여 문자열을 얻는것이다. 방법?
"""
scala> BigInt.probablePrime(100, util.Random).toString(32)
res3: String = nc4bvn8r4rchdfms8qc1
"""

9. 스칼라에서 문자열의 첫 문자를 어떻게 얻는가 마지막 문자는?
"""
scala> "hello"(0)
res4: Char = h

scala> "hello".last
res5: Char = o
다양한 방법이 있겠다
"""

10.문자열함수 take, drop,takeRight,dropRight는 무엇을 하나? substring에 비해 장단점은 무엇인가?
"""
http://scala-lang.org/api/current/#scala.collection.immutable.StringOps

scala> "abcdefg".take(2)
res9: String = ab

scala> "abcdefg".drop(2)
res10: String = cdefg

scala> "abcdefg" takeRight (2)
res14: String = fg

scala> "abcdefg" dropRight (2)
res15: String = abcde

장점
* substring에 비해 메소드명이 명시적이라 이해하기가 쉽다 (ex: str.substring(2, str.length -1))
* substirng의 start, end, length에 대한 고민을 안해도 된다. 이거 꽤 헷갈림
단점 
* 외워야한다 
"""

