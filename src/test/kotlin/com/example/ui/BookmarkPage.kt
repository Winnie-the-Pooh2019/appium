package com.example.ui

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class BookmarkPage(driver: WebDriver) : Page(driver) {
    private val elseMenu = "//android.widget.ImageView[@content-desc=\"Ещё\"]"
    private val removeList = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/title\" and @text=\"Удалить список\"]"
    private val emptyTitle = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/empty_title\"]"

    fun removeBookmark() {
        waitElementAndClick(By.xpath(elseMenu))
        waitElementAndClick(By.xpath(removeList))
        waitElementAndClick(By.xpath(okButton))
    }

    fun notNow() = waitElementAndClick(By.xpath(negativeButton))

    fun getEmptyTitle(): String = waitElementPresent(By.xpath(emptyTitle)).text
}