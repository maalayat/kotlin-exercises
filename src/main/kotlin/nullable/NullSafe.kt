package nullable

fun main(args: Array<String>) {

    val a: String? = null

    //val l = if(a != null) a.length else 0
    val l = a?.length ?: 0 // operador elvis ?:

    println("El tamaño de la cadena es: $l")

    //val listWithNulls = listOf("A", "B", null)
    val listWithNulls: List<String?> = listOf("A", "B", null)
    for (item in listWithNulls) {
        //println(item)//imprime con all y nulos
        item?.let {
            println(item)//no imprime los nulos
        }
    }

    val nums: List<Int?> = listOf(3, 4, null, 2, null, 1)
    val numsWithOutNulls: List<Int> = nums.filterNotNull()

}
