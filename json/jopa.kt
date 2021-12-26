
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

class Appl() {
    var App: String = ""
    var Category: String = ""
    var Rating: String = ""
    var Reviews: String = ""
    var Size: String = ""
    var Installs: Int = 0
    var Type: String = ""
    var Price: Boolean = false
    var ContentRating: String = ""
    var Genres: List<String> = listOf()
    var LastUpdated: String = ""
    var CurrentVer: String = ""
    var AndroidVer: String = ""
}

fun create_json(fileCSV_name: String, fileJSON_name : String){
    val gson = Gson()
    val gsonPretty = GsonBuilder().setPrettyPrinting().create()

    var data : MutableMap<String, Appl> = mutableMapOf()

    var fileCSV = File(fileCSV_name)
    var fileExists = fileCSV.exists()

    var API_ver : Map<String, String> = mapOf("1.0" to "1","1.1" to "2","1.5" to "3","1.6" to "4","2.0" to "5","2.0.1" to "6","2.1" to "7","2.2" to "8","2.3" to "9","2.3.3" to "10","3.0" to "11","3.1" to "12","3.2" to "13","4.0" to "14","4.0.3" to "15","4.1" to "16","4.2" to "17","4.3" to "18","4.4" to "19","4.4W" to "20","5.0" to "21","5.1" to "22","6.0" to "23","7.0" to "24","7.1" to "25","8.0" to "26","8.1" to "27","9.0" to "28","10.0" to "29","11.0" to "30", "Varies" to "Unknown", "NaN" to "Unknown")

    var monthes : Map<String, String> = mapOf("January" to "1","February" to "2","March" to "3","April" to "4","May" to "5","June" to "6","July" to "7","August" to "8","September" to "9","October" to "10","November" to "11","December" to "12")


    if(fileExists){
        val rowss: List<Map<String, String>> = csvReader().readAllWithHeader(fileCSV)
        //csvReader = csv.DictReader(csvf)

        for (rows in rowss) {
            var writeMap = Appl()
            var key = rows.getOrDefault("App", "")

            //var base = re.split(" |, ", rows["Last Updated"])
            var basev = rows.getOrDefault("Last Updated", "").split(", ", " ")
            var new_base = basev[2] + "/" + monthes[basev[0]] + "/" + basev[1]

            writeMap.LastUpdated = new_base

            var tmp = rows.getOrDefault("Android Ver", "").split(" ")[0]
            writeMap.AndroidVer = API_ver.getOrDefault(tmp, "Unknown")

            writeMap.Genres = rows.getOrDefault("Genres", "").split(";")
            //writeMap["Genres"] = rows.getOrDefault("Genres", "").split(";")

            //writeMap["Installs"] = re.sub("[+|,]","",rows["Installs"])
            var tmps = rows.getOrDefault("Installs", "0").replace("+", "").replace(",", "")
            writeMap.Installs = tmps.toInt()

            writeMap.App = rows.getOrDefault("App", "")
            writeMap.Category = rows.getOrDefault("Category", "")
            writeMap.Rating = rows.getOrDefault("Rating", "")
            writeMap.Reviews = rows.getOrDefault("Reviews", "")
            writeMap.Size = rows.getOrDefault("Size", "")
            writeMap.Type = rows.getOrDefault("Type", "")
            writeMap.ContentRating = rows.getOrDefault("Content Rating", "")
            writeMap.CurrentVer = rows.getOrDefault("Current Ver", "")

            if (rows.getOrDefault("Price", "0") != "0"){
                writeMap.Price = true
            }
            data[key] = writeMap

        }

        File(fileJSON_name).writeText(gsonPretty.toJson(data))

    } else {
        print("$fileCSV_name file does not exist.")
    }

}

fun main() {
    println("Hello World!")

    var fileCSV = "C:\\json\\googleplaystore.csv"
    var fileJSON = "C:\\json\\googleplaystore.json"

    create_json(fileCSV, fileJSON)
}