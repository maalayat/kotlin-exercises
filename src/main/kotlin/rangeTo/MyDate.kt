package rangeTo

class MyDate(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>

fun checkInRange(date: MyDate, first: MyDate, end: MyDate): Boolean {
    return date in first..end
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)