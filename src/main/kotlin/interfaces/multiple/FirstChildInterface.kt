package interfaces.multiple

interface FirstChildInterface : BaseInterface {
    override fun someMethod(): String {
        return ("Hello, from someMethod in FirstChildInterface")
    }
}