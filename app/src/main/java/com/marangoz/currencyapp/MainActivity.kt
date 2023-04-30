package com.marangoz.currencyapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var dateText: TextView
    private lateinit var forexBuyText: TextView
    private lateinit var forexSellText: TextView
    private lateinit var bankBuyText: TextView
    private lateinit var bankSellText: TextView
    private lateinit var webView: WebView
    val nameList = arrayListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        dateText = findViewById(R.id.dateText)
        forexBuyText = findViewById(R.id.forexBuyText)
        forexSellText = findViewById(R.id.forexSellText)
        bankBuyText = findViewById(R.id.bankBuyText)
        bankSellText = findViewById(R.id.bankSellText)
        webView = findViewById(R.id.webView)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)


        val xml = XmlResult()
        val resultAbout = xml.aboutMoney()
        val result = xml.xmlCurrency()
        dateText.text = xml.date



        result.forEach() {
            nameList.add(it.Isim)
        }

        val veriadap = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)

        spinner.adapter = veriadap

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetJavaScriptEnabled")
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                for (i in 0..resultAbout.size){
                    if (i==position){
                        webView.webViewClient = WebViewClient()
                        webView.settings.javaScriptEnabled = true
                        webView.loadUrl(resultAbout[i])
                    }
                }
                result.forEach(){
                    if (it.Isim == selectedItem){
                        forexBuyText.text = it.ForexBuying
                        forexSellText.text = it.ForexSelling
                        bankBuyText.text = it.BanknoteBuying
                        bankSellText.text = it.BanknoteSelling
                    }
                }



            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })




    }


}