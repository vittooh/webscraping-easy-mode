import org.jsoup.Jsoup
import java.io.File


fun main(args: Array<String>) {

    val jsoup = Jsoup.parse(File("C:\\Users\\vitor\\Documents\\digitalbricklayer\\webscraping-easy-mode\\src\\main\\resources\\pagina.html"))

    val body = jsoup.body()

    val ranking = body.getElementById("ranking")

    for (element in ranking.children()){
        when(element.tagName()){
            "thead" -> println("Titulo : ${element.text()}")
            "tbody" -> {
                for (row in element.children()){
                    println("Ranking ${row.getElementsByTag("th").text()}")
                    println("Descricao ${row.getElementsByTag("td").text()}")
                }
            }
        }
    }
}