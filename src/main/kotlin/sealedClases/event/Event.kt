package sealedClases.event

/**
 *  clase que define el contenido de un evento completo:
 */
data class Event(val contentType: ContentType, val direction: Direction)