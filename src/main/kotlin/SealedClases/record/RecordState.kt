package SealedClases.record

sealed class RecordState {
    class PreRecord : RecordState()
    class Recording: RecordState()
    class Reviewing: RecordState()
    class Transmitting: RecordState()
}