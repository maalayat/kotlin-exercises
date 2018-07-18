package sequences

/**
 * Sequence filter is an intermediate operation, so it doesn’t do any calculations,
 * but instead it decorates sequence with new processing step.
 *
 * Calculations are done in terminal operation like toList.
 */
fun main(args: Array<String>) {

    /************ sequences are lazy  **************************/
    val seq = sequenceOf(1, 2, 3)
    println(seq.filter { it % 2 == 1 }) // kotlin.sequences.FilteringSequence@27716f4

    val list = listOf(1, 2, 3)
    println(list.filter { it % 2 == 1 }) // [1, 3]

    /* In sequence processing we generally make whole processing for a single element,
        then for another etc. In Iterable processing, we process the whole collection on every step. */

    println("\nSeq test")
    seq.filter {
        print(" Filter: $it,"); it % 2 == 1
    }.map {
        print(" Map: $it,"); it * 2
    }.toList()
    // Filter: 1, Map: 1, Filter: 2, Filter: 3, Map: 3,

    println("\n\nList test")
    list.filter {
        print(" Filter: $it,"); it % 2 == 1
    }.map {
        print(" Map: $it,"); it * 2
    }
    // Filter: 1, Filter: 2, Filter: 3, Map: 1, Map: 3,

    /*Thanks to this laziness and per-element processing order, we can make infinitive Sequence.*/
    println("\n\ngenerateSequence")

    generateSequence(1) { it + 1 }
        .map { it * 2 }
        .take(10)
        .forEach(::print) // 2468101214161820


    /* Sequence processing is generally faster than direct collection
       processing when we have more then one processing step. */

}