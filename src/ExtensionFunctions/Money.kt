package ExtensionFunctions

import java.math.BigDecimal

data class Money(val amount: BigDecimal, val currency: String)

fun main(args: Array<String>) {
    val tickets = Money(BigDecimal(100), "$")
    val bus = Money(BigDecimal(120), "EUR")

    val tickets2 = Money(100.bd, "$")
    val bus2 = Money(120.bd, "EUR")

}

private val Int.bd: BigDecimal
    get() = BigDecimal(this)

