package SealedClases

/**
 * Esta clase sellada actuan como un enum realmente porque
 * no puede ser extendida y cada "clase interna" actua como un caso de enumerado
 */
sealed class DeliveryStatus {
    class Delivered : DeliveryStatus() //entregado
    class Delivering : DeliveryStatus() //entregando
    class NotDelivered(val error: String) : DeliveryStatus()
}