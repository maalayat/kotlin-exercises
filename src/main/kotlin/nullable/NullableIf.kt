package nullable

fun sendMessageToClient(client: Client2?, message: String?, mailer: Mailer2) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client2(val personalInfo: PersonalInfo2?)
class PersonalInfo2(val email: String?)
interface Mailer2 {
    fun sendMessage(email: String, message: String)
}