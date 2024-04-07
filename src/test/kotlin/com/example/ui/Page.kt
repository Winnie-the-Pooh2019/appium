package com.example.ui

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class Page(private val driver: WebDriver) {

    protected val okButton = "//android.widget.Button[@resource-id=\"android:id/button1\"]"
    protected val negativeButton = "//android.widget.Button[@resource-id=\"org.wikipedia:id/negativeButton\"]"

    protected fun getResultSearchElement(source: String, substring: String): String =
        source.replace("{SUBSTRING}", substring)

    protected fun waitElementPresent(
        by: By,
        msg: String = "No element found: $by",
        timeout: Long = 10
    ): WebElement {
        val wait = WebDriverWait(driver, Duration.ofSeconds(timeout))
        wait.withMessage(msg)

        return wait.until(ExpectedConditions.presenceOfElementLocated(by))
    }

    protected fun waitElementAndClick(
        by: By,
        msg: String = "No element found: $by",
        timeout: Long = 10
    ): WebElement {
        val element = waitElementPresent(by, msg, timeout)
        element.click()

        return element
    }

    protected fun waitElementAndPrint(
        by: By,
        value: String,
        msg: String = "No element found: $by",
        timeout: Long = 10
    ): WebElement {
        val element = waitElementPresent(by, msg, timeout)
        element.sendKeys(value)

        return element
    }
}