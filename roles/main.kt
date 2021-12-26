import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.StringBuilder

fun main() {
    fun printRolesText(rolesAll: ArrayList<String>, replicaLines: ArrayList<String>): String {
        val sb = StringBuilder()
        var out: String = " "
        for (roleFirst in rolesAll) {
            sb.append("${roleFirst}:\n")
            var stringNum = 1
            for (replica in replicaLines) {
                if (replica.startsWith("$roleFirst:")) {
                    val comboString = replica.substring(replica.indexOf(':') + 2)
                    sb.append(stringNum).append(") ").append(comboString).append("\n")
                }
                stringNum++
            }
            sb.append("\n")
        }
        return sb.toString()
    }

    val roleFirst: ArrayList<String> = arrayListOf()
    val replica: ArrayList<String> = arrayListOf()
    val file = File("C:\\role.txt")
    val br = BufferedReader(FileReader(file))
    var line: String
    var role = true
    while (true) {
        line = br.readLine() ?: break
        if (line == "roles:") {
            continue
        }
        if (line == "textLines:") {
            role.not().also { role = it }
            continue
        }
        if (role) roleFirst.add(line) else replica.add(line)
    }
    br.close()
    val fullReplica: String = printRolesText(roleFirst, replica)
    println(fullReplica)
}