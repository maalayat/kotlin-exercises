package ExtensionFunctions

import java.math.BigDecimal

data class Money(val amount: BigDecimal, val currency: String)

fun main() {
    val tickets = Money(BigDecimal(100), "$")
    println(tickets)
    val bus = Money(BigDecimal(120), "EUR")
    println(bus)

    val tickets2 = Money(100.bd, "$")
    println(tickets2)
    val bus2 = Money(120.bd, "EUR")
    println(bus2)
}

private val Int.bd: BigDecimal
    get() = BigDecimal(this)

