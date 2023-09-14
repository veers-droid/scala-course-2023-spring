package karazin.scala.users.group.week1.homework

object adt {

    sealed class ErrorOr<out V> {

        class Dummy

        fun flatMap(): Any = throw NotImplementedError()

        fun map(): Any = throw NotImplementedError()

        companion object {
            fun apply():Any = throw NotImplementedError()
        }

    }

}