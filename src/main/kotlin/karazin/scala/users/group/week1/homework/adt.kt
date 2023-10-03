package karazin.scala.users.group.week1.homework

object adt {

    sealed class ErrorOr<out V> {

        class Some<V>(val value: V) : ErrorOr<V>()

        class None(val t: Throwable) : ErrorOr<Nothing>()

        fun <Q> flatMap(f : (V) -> ErrorOr<Q>): ErrorOr<Q> = when (this) {
            is Some -> f(this.value)
            is None -> this

        }

        fun <Q> map(f: (V) -> Q): Q = when (this) {
            is Some -> f(this.value)
            is None -> throw NoSuchElementException("map() called on None")
        }

        companion object {
            fun <V> apply(v: V?): ErrorOr<V> =
                if(v == null)  None(RuntimeException("Value is null"))
                else Some(v)
        }

    }

}