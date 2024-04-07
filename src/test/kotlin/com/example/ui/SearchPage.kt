package com.example.ui

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SearchPage(driver: WebDriver) : Page(driver) {
    private val searchButton = "//android.widget.TextView[@text=\"Поиск по Википедии\"]"
    private val searchField = "//android.widget.EditText[@resource-id=\"org.wikipedia:id/search_src_text\"]"
    private val searchResult = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_description\" and @text=\"{SUBSTRING}\"]"
    private val searchTitle = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"{SUBSTRING}\"]"

    fun initSearch() {
        waitElementAndClick(By.xpath(searchButton))
    }

    fun typeSearchLine(request: String) = waitElementAndPrint(By.xpath(searchField), request)


    fun waitForResult(substring: String) {
        val resultXPath = getResultSearchElement(searchResult, substring)
        waitElementAndClick(By.xpath(resultXPath))
    }

    fun chooseResult(substring: String) {
        val resultXPath = getResultSearchElement(searchTitle, substring)
        waitElementAndClick(By.xpath(resultXPath))
    }
}