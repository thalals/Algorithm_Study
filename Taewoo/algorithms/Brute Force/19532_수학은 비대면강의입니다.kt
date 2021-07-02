import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.*
import java.util.*

var sb = StringBuilder()
var scan = FastReader()

var a = 0
var b = 0
var c = 0
var d = 0
var e = 0
var f = 0
fun input() {
    a = scan.nextInt()
    b = scan.nextInt()
    c = scan.nextInt()
    d = scan.nextInt()
    e = scan.nextInt()
    f = scan.nextInt()
}

fun pro() {
    for(x in -999 until 1000) {
        for(y in -999 until 1000) {
            if(((a * x + b * y) == c) and ((d * x + e * y) == f)) {
                sb.append(x).append(' ').append(y)
            }
        }
    }
    println(sb.toString())
}

fun main() {
    input()
    pro()
}

class FastReader {
    var br = System.`in`.bufferedReader()
    var st: StringTokenizer? = null
    operator fun next(): String {
        while (st == null || !st!!.hasMoreElements()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt(): Int {
        return next().toInt()
    }

    fun nextLong(): Long {
        return next().toLong()
    }

    fun nextDouble(): Double {
        return next().toDouble()
    }

    fun nextLine(): String {
        var str = ""
        try {
            str = br.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return str
    }

}
