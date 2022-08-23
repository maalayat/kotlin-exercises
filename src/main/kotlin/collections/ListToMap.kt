package collections

val user1 = User("John", 18, listOf("Hiking", "Swimming"))
val user2 = User("Sara", 25, listOf("Chess", "Board Games"))
val user3 = User("Dave", 34, listOf("Games", "Racing sports"))


fun main() {
    val myList = listOf(user1, user2, user3)
    val myList2 = listOf("a", "b", "c", "d")

    /********************** toMap() ****************************
     * toMap requires us to transform our Array into Pairs first,
     * which later have to be translated to our Map,
     * so this operation will be particularly useful if we’re already operating on collections of Pairs.
     */
    //  “to” keyword is being used here to create pairs of names and ages
    val myMap = myList.map { it.name to it.age }.toMap()
    println(myMap["John"]) //: 18

    /*********************** associatedBy **************************/
    val myMap2 = myList.associateBy({ it.name }, { it.hobbies })
    println(myMap2["Sara"]) //: [Chess, Board Games]

    /************************ associate() ***********************/
    val myMap3 = myList2.associate { it to it }
    println(myMap3["c"]) //: c

    /*********************** associateTo ***************************/
    val myMap4 = mutableMapOf<String, String>()
    myList2.associateTo(myMap4) { it to it }

    /************************ associateByTo ***********************/
    val myMap5 = mutableMapOf<String, User>()
    myList.associateByTo(myMap5) { it.name }
    println(myMap5["Dave"]) //: User(name=Dave, age=34, hobbies=[Games, Racing sports])

    val myMap6 = mutableMapOf<String, Int>()
    myList.associateByTo(myMap6, { it.name }, { it.age })
    println(myMap6["Dave"]) //: 34

}
