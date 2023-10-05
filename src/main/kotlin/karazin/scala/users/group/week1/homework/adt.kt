package karazin.scala.users.group.week1.homework

object adt {

    sealed class ErrorOr<out V> {

        class Some<V>(val value: V) : ErrorOr<V>()

        class None(val t: Throwable) : ErrorOr<Nothing>()

        fun <Q> flatMap(f: (V) -> ErrorOr<Q>): ErrorOr<Q> = when (this) {
            is Some -> {
                try {
                    f(this.value)
                } catch (e: Exception) {
                    None(e)
                }
            }
            is None -> this
        }

        fun <Q> map(f: (V) -> Q): ErrorOr<Q> = when (this) {
            is Some -> {
                try {
                    Some(f(this.value))
                } catch (e: Exception) {
                    None(e)
                }
            }
            is None -> this
        }

        companion object {
            fun <V> apply(v: V?): ErrorOr<V> =
                if (v == null) None(RuntimeException("Value is null"))
                else Some(v)
        }

    }

}