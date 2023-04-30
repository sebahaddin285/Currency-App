package com.marangoz.currencyapp

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class XmlResult {

    var date = ""

    fun xmlCurrency() : List<Currency> {
        val arr = mutableListOf<Currency>()
        val url = "https://www.tcmb.gov.tr/kurlar/today.xml"
        val doc: Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        val elements: Elements = doc.getElementsByTag("Currency")
        val elements1: Elements = doc.getElementsByTag("Tarih_Date")
        date = elements1.attr("Tarih")

        Log.e("data",date)

        for( item in elements ) {
            val Isim = item.getElementsByTag("Isim").text()
            val ForexBuying = item.getElementsByTag("ForexBuying").text()
            val ForexSelling = item.getElementsByTag("ForexSelling").text()
            val BanknoteBuying = item.getElementsByTag("BanknoteBuying").text()
            val BanknoteSelling = item.getElementsByTag("BanknoteSelling").text()

            val currency = Currency(Isim, ForexBuying, ForexSelling, BanknoteBuying, BanknoteSelling);
            arr.add(currency)
        }
        return arr
    }


    fun aboutMoney() : MutableList<String>{

        val aboutList = mutableListOf<String>()
        aboutList.add("https://tr.wikipedia.org/wiki/Amerikan_dolar%C4%B1")
        aboutList.add("https://tr.wikipedia.org/wiki/Avustralya_dolar%C4%B1")
        aboutList.add("https://tr.wikipedia.org/wiki/Danimarka_kronu")
        aboutList.add("https://tr.wikipedia.org/wiki/Euro")
        aboutList.add("https://tr.wikipedia.org/wiki/%C4%B0ngiliz_sterlini")
        aboutList.add("https://tr.wikipedia.org/wiki/%C4%B0svi%C3%A7re_frang%C4%B1")
        aboutList.add("https://tr.wikipedia.org/wiki/%C4%B0sve%C3%A7_kronu")
        aboutList.add("https://tr.wikipedia.org/wiki/Kanada_dolar%C4%B1")
        aboutList.add("https://tr.wikipedia.org/wiki/Kuveyt_dinar%C4%B1")
        aboutList.add("https://tr.wikipedia.org/wiki/Norve%C3%A7_kronu")
        aboutList.add("https://tr.wikipedia.org/wiki/Suudi_Arabistan_riyali")
        aboutList.add("https://tr.wikipedia.org/wiki/Japon_yeni")
        aboutList.add("https://tr.wikipedia.org/wiki/Bulgar_levas%C4%B1")
        aboutList.add("https://tr.wikipedia.org/wiki/Rumen_leyi")
        aboutList.add("https://tr.wikipedia.org/wiki/Rus_rublesi")
        aboutList.add("https://tr.wikipedia.org/wiki/%C4%B0ran_riyali")
        aboutList.add("https://tr.wikipedia.org/wiki/Renminbi")
        aboutList.add("https://tr.wikipedia.org/wiki/Pakistan_rupisi")
        aboutList.add("https://tr.wikipedia.org/wiki/Katar_riyali")
        aboutList.add("https://tr.wikipedia.org/wiki/G%C3%BCney_Kore_wonu")
        aboutList.add("https://tr.wikipedia.org/wiki/Azerbaycan_manat%C4%B1")
        aboutList.add("https://tr.wikipedia.org/wiki/Birle%C5%9Fik_Arap_Emirlikleri_dirhemi")


        return aboutList
    }



}