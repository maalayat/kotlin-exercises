package functionTypes

class IntTransformer : (Int) -> Int {

    override fun invoke(p1: Int): Int {
        // AND operation
        return p1.and(10)
    }
}
