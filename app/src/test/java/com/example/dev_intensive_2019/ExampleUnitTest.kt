package com.example.dev_intensive_2019

import com.example.dev_intensive_2019.extensions.stripHtml
import com.example.dev_intensive_2019.extensions.truncate
import com.example.dev_intensive_2019.models.User
import com.example.dev_intensive_2019.utils.toInitials
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun homeTask_2() {
        print("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())
    }
}