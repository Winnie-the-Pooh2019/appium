package com.example.ui

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class MainPage(driver: WebDriver) : Page(driver) {
    private val skip = "//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_skip_button\"]"

    fun skip() = waitElementAndClick(By.xpath(skip))
}