package com.example.bojiapp.view
/*
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.bojiapp.repository.recycler.GameAdapter
import com.example.bojiapp.test.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @LargeTest
    fun prueba_click_recycler_muestra_detalle() {

        /** al hacer click sobre el 2do elemento del RecyclerView**/
        Espresso.onView(withId(R.id.recyclerView))
            .perform(
                scrollToPosition<GameAdapter.ViewHolder>(4)
            )
            .perform(
                actionOnItemAtPosition<GameAdapter.ViewHolder>(2, click()
                )
            )

        /** revisar que se cargue el nombre **/
        Espresso.onView(withId(R.id.tvDetalleNombre))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.withText("Clank! Catacombs")
                )
            )
    }
}*/