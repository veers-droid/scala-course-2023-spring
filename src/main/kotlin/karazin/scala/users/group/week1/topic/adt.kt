package karazin.scala.users.group.week1.topic

object adt {

    sealed class Option<out V> {

        class Some<V>(val value: V) : Option<V>()
        object None : Option<Nothing>()

        fun <Q> flatMap(f: (V) -> Option<Q>): Option<Q> = when (this) {
            is Some -> f(this.value)
            is None -> this
        }

        fun <Q> map(f: (V) -> Q): Option<Q> = when (this) {
            is Some -> Some(f(this.value))
            is None -> this
        }

        companion object {
            fun <V> apply(v: V?): Option<V> =
                if(v == null) None
                else Some(v)
        }

    }

}