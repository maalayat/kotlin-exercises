package nullable

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    client?.personalInfo?.email?.let { email ->
        message?.let { mailer.sendMessage(email, it) }
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}