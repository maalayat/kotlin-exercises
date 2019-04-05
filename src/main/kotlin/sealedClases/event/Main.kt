package sealedClases.event

fun main(args: Array<String>) {

    val events = listOf<Event>(
        Event(
            ContentType.Text("Hola, soy Alejandro"),
            Direction.Incoming("alejo.ay")
        ),
        Event(
            ContentType.Audio("URL_AUDIO", 10),
            Direction.Incoming("alejo.ay")
        ),
        Event(
            ContentType.Image("URL_IMAGE", "caption:"),
            Direction.OutComing(DeliveryStatus.Delivered())
        )
    )

    events.map {
        renderEvents(it)
    }

}

fun renderEvents(event: Event) = when (event.contentType) {
    is ContentType.Text -> println(event.contentType.body)
    is ContentType.Audio -> println("Audio de ${event.contentType.url} con duracion de ${event.contentType.duration}")
    is ContentType.Image -> println("Image de ${event.contentType.caption} en la ${event.contentType.url}")
}