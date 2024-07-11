package cn.cyanbukkit.growwheat.utils

class NumberPair(a: Int, b: Int) {
    val min = minOf(a, b)
    val max = maxOf(a, b)
    operator fun contains(n: Int): Boolean {
        return n in min..max
    }

    val len = max - min + 1
}