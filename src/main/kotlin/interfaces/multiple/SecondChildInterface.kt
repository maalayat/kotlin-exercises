package interfaces.multiple

interface SecondChildInterface : BaseInterface {
    override fun someMethod(): String {
        return ("Hello, from someMethod in SecondChildInterface")
    }
}