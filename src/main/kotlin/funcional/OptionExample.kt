package funcional

import org.funktionale.option.Option
import org.funktionale.option.getOrElse
import org.funktionale.option.optionSequential
import org.funktionale.option.toOption

/**
 * Here are only several of the methods defined on the Option class:
 *
 * method                  description
 * ------------------------------------------------------------------------------------
 * isDefined               checks whether the value is present
 * isEmpty                 checks whether the value is absent
 * getOrElse               returns the value if it’s there or the provided default value if it is not
 * get                     returns the value if it’s there or throws an exception if it is not
 * forEach                 allows to use existing value in a functional block without returning anything
 * map                     allows to transform one option into another
 */
fun main() {

    val mayBeNum1: Option<Int> = generateNumber().toOption()
    val mayBeNum2: Option<Int> = generateNumber().toOption()

    /************************ when ***************************/
    when (mayBeNum1) {
        Option.None -> println("Option.when: No value")
        is Option.Some -> println("Option.when Option.get: ${mayBeNum1.get()}")
    }

    /************************ fold **************************/
    val numFold = mayBeNum2.fold({ -1 }, { it })
    println("Option.fold: $numFold")

    /************************ getOrElse **************************/
    val numGetOrElse = mayBeNum1.getOrElse { -1 }
    println("Option.numGetOrElse: $numGetOrElse")

    /************************ get - isDefined **************************/
    //we’re performing to much “dancing” around these values
    val mayBeSum = if (mayBeNum1.isDefined() && mayBeNum2.isDefined())
        Option.Some(mayBeNum1.get() + mayBeNum2.get())
    else Option.None
    println("Sum: Option.isDefined: ${mayBeSum.getOrElse { -1 }}")

    /************************ flatmap **************************/
    //Much better! flatmap is extremely common in functional programming
    val mayBeSum2 = mayBeNum1.flatMap { num1 ->
        mayBeNum2.map { num2 -> num1 + num2 }
    }
    println("Sum: Option.flatmap: ${mayBeSum2.getOrElse { -1 }}")

    /************************ seguence **************************/
    // convert a List of Options to an Option of a List
    val seqList = listOf(mayBeNum1, mayBeNum2)
    val mayBeSumSeq = seqList.optionSequential().map { list ->
        list.fold(0) { actual, next ->
            actual + next
        }
    }
    println("Sum: List<Option>.optionSequential(): ${mayBeSumSeq.getOrElse { -1 }}")


}

fun generateNumber(): Int? {
    val num = Math.round(Math.random() * 100)
    println("Generate number: $num")
    return if (num <= 65) num.toInt() else null
}
