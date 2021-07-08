import java.io.IOException
import java.lang.*
import java.util.*

var sb = StringBuilder()
var scan = FastReader()

var N = 0
var K = 0
fun input() {
    N = scan.nextInt()
    K = scan.nextInt()
}

var limitTime = 0

fun getTime(t : Int) : String{
    var sec = t
    var tmp = ""

    var hour = sec / 3600
    if(hour < 10) tmp += "0"
    tmp += hour.toString()

    sec %= 3600
    var min = sec / 60
    if(min < 10) tmp += "0"
    tmp += min.toString()

    sec %= 60
    if(sec < 10) tmp += "0"
    tmp += sec.toString()
    return tmp
}

fun pro() {
    var answer = 0
    limitTime = N * 3600 + 59 * 60 + 59
    for(i in 0..limitTime) {
        var sec = getTime(i)
        if(sec.contains(K.toString())) answer++
    }
    sb.append(answer)
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
