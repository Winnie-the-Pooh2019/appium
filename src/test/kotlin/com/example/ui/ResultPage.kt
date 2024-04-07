package com.example.ui

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ResultPage(driver: WebDriver) : Page(driver) {
    private val titlePath = "//android.view.View[@text=\"{SUBSTRING}\"]"
    private val menu = "//android.widget.TextView[@content-desc=\"Сохранить\"]"
    private val snackbarButton = "//android.widget.Button[@resource-id=\"org.wikipedia:id/snackbar_action\"]"
    private val titleInput = "//android.widget.EditText[@resource-id=\"org.wikipedia:id/text_input\"]"

    fun getTitleText(substring: String): String =
        waitElementPresent(By.xpath(getResultSearchElement(titlePath, substring))).text

    fun addToBookmarks(bookmarkName: String) {
        waitElementAndClick(By.xpath(menu))
        waitElementAndClick(By.xpath(snackbarButton))
        waitElementAndPrint(By.xpath(titleInput), bookmarkName)
        waitElementAndClick(By.xpath(okButton))
        waitElementAndClick(By.xpath(snackbarButton))
    }
}