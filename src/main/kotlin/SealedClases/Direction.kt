package SealedClases

/**
 *
 * Entrante. Debe incluir el remitente que envío el evento,
 * Saliente. Debe incluir el estado de entrega
 */
sealed class Direction {
    class Incoming(val from: String) : Direction()
    class OutComing(val status: DeliveryStatus) : Direction()
}