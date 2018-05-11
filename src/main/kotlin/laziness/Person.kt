package laziness

/**
 * Created by alejo on 30/03/17.
 */
class Person(val nombre: String, val edad: Int, val city: City) {

    override fun toString(): String {
        println(">>>>>>>>>>>>>>>>> Call toString function <<<<<<<<<<<<<<<<<<<<<")
        return "laziness.Person[nombre = $nombre, edad = $edad], ciudad = ${city.name}"
    }
}

class City(val name: String)