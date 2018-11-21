package interfaces.multiple

class ChildClass : FirstChildInterface, SecondChildInterface {
    override fun someMethod(): String {
//        return super.someMethod()//Many supertypes available
        return super<SecondChildInterface>.someMethod()
    }
}