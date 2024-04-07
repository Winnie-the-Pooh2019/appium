package com.example.core

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

open class CoreTestCase {
    protected lateinit var driver: WebDriver

    private val appiumUrl = "http://localhost:4723/wd/hub"

    open fun setUp() {
        val desiredCapabilities = DesiredCapabilities().apply {
            setCapability("platformName", "android")
            setCapability("appium:deviceName", "avd")
            setCapability("appium:platformVersion", "10")
            setCapability("appium:appPackage", "org.wikipedia")
            setCapability("appium:appActivity", ".main.MainActivity")
        }


        driver = RemoteWebDriver(URL(appiumUrl), desiredCapabilities)
    }

    open fun down() = driver.quit()
}