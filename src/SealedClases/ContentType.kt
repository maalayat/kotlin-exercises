package SealedClases

/**
 * tenemos tres tipos de eventos: Mensajes de Texto, Imágenes y Notas de Voz.
 */
sealed class ContentType {
    class Text(val body: String) : ContentType()
    class Image(val url: String, val caption: String) : ContentType()
    class Audio(val url: String, val duration: Int) : ContentType()
}