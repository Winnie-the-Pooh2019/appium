package com.example

import com.example.core.CoreTestCase
import com.example.ui.BookmarkPage
import com.example.ui.MainPage
import com.example.ui.ResultPage
import com.example.ui.SearchPage
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class FirstTest {

    private val searchPage = SearchPage(driver)
    private val resultPage = ResultPage(driver)
    private val bookmarkPage = BookmarkPage(driver)
    private val mainPage = MainPage(driver)

    @Test
    fun firstTest() {
        mainPage.skip()
        searchPage.initSearch()
        searchPage.typeSearchLine("Кемеровский государственный университет")
        searchPage.waitForResult("высшее учебное заведение в Кемерове")

        val titleText = resultPage.getTitleText("Кемеровский государственный университет")

        assertEquals("Кемеровский государственный университет", titleText, "Titles are not the same")
    }

    @Test
    fun bookmarks() {

        val hobbit = "Хоббит, или Туда и обратно"

        searchPage.initSearch()
        searchPage.typeSearchLine(hobbit)
        searchPage.chooseResult(hobbit)

        var title = resultPage.getTitleText(hobbit)
        assertEquals(hobbit, title, "Titles are not same")

        val hobbitBookmark = "Хоббит"
        resultPage.addToBookmarks(hobbitBookmark)
        bookmarkPage.removeBookmark()
        bookmarkPage.notNow()

        title = bookmarkPage.getEmptyTitle()
        assertEquals("Ещё нет списков для чтения", title, "Titles are not the same")
    }

    companion object : CoreTestCase() {


        @JvmStatic
        @BeforeAll
        override fun setUp() {
            super.setUp()
        }

        @JvmStatic
        @AfterAll
        override fun down() = super.down()
    }
}