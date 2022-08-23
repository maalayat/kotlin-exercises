package sealedClases.record

import kotlin.properties.Delegates

var integer: Int by Delegates.observable(0) { property, oldValue, newValue ->
    println("Property:$property oldValue:$oldValue newValue:$newValue")
}

var recordState: RecordState by Delegates.observable(RecordState.PreRecord()) { property, oldValue, newValue ->
    println("Property:$property oldValue:$oldValue newValue:$newValue")
    when (newValue) {
        is RecordState.PreRecord -> TODO()
        is RecordState.Recording -> TODO()
        is RecordState.Reviewing -> TODO()
        is RecordState.Transmitting -> TODO()
    }
}

fun main() {


}
