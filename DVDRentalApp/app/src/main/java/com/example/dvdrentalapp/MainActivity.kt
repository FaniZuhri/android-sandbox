package com.example.dvdrentalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.dvdrentalapp.ui.theme.DVDRentalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DVDRentalAppTheme {
                DvdRentalApp()
            }
        }
    }
}

@Composable
fun DvdRentalApp() {
    var filmList = remember {
        listOf(
            Film(1, "Inception", "Christopher Nolan", 2010, "Dream within a dream.", "Warner Bros.", R.drawable.poster1),
            Film(2, "The Matrix", "Lana Wachowski, Lilly Wachowski", 1999, "Virtual reality world.", "Warner Bros.", R.drawable.poster2),
            Film(3, "Interstellar", "Christopher Nolan", 2014, "Space exploration to save humanity.", "Paramount Pictures", R.drawable.poster3),
            Film(4, "Parasite", "Bong Joon-ho", 2019, "Class conflict thriller.", "CJ Entertainment", R.drawable.poster4),
            Film(5, "The Godfather", "Francis Ford Coppola", 1972, "Mafia family saga.", "Paramount Pictures", R.drawable.poster5),
            Film(6, "Spirited Away", "Hayao Miyazaki", 2001, "Magical spirit world.", "Studio Ghibli", R.drawable.poster6),
            Film(7, "Avengers: Endgame", "Anthony Russo, Joe Russo", 2019, "Superheroes save the universe.", "Marvel Studios", R.drawable.poster7),
            Film(8, "Pulp Fiction", "Quentin Tarantino", 1994, "Non-linear crime story.", "Miramax", R.drawable.poster8),
            Film(9, "Whiplash", "Damien Chazelle", 2014, "Drumming student and harsh teacher.", "Sony Pictures", R.drawable.poster9),
            Film(10, "Joker", "Todd Phillips", 2019, "Origin story of Joker.", "Warner Bros.", R.drawable.poster10),
            Film(11, "Inception", "Christopher Nolan", 2010, "Dream within a dream.", "Warner Bros.", R.drawable.poster1),
            Film(12, "The Matrix", "Lana Wachowski, Lilly Wachowski", 1999, "Virtual reality world.", "Warner Bros.", R.drawable.poster2),
            Film(13, "Interstellar", "Christopher Nolan", 2014, "Space exploration to save humanity.", "Paramount Pictures", R.drawable.poster3),
            Film(14, "Parasite", "Bong Joon-ho", 2019, "Class conflict thriller.", "CJ Entertainment", R.drawable.poster4),
            Film(15, "The Godfather", "Francis Ford Coppola", 1972, "Mafia family saga.", "Paramount Pictures", R.drawable.poster5),
            Film(16, "Spirited Away", "Hayao Miyazaki", 2001, "Magical spirit world.", "Studio Ghibli", R.drawable.poster6),
            Film(17, "Avengers: Endgame", "Anthony Russo, Joe Russo", 2019, "Superheroes save the universe.", "Marvel Studios", R.drawable.poster7),
            Film(18, "Pulp Fiction", "Quentin Tarantino", 1994, "Non-linear crime story.", "Miramax", R.drawable.poster8),
            Film(19, "Whiplash", "Damien Chazelle", 2014, "Drumming student and harsh teacher.", "Sony Pictures", R.drawable.poster9),
            Film(20, "Joker", "Todd Phillips", 2019, "Origin story of Joker.", "Warner Bros.", R.drawable.poster10)
        )
    }
    var selectedFilm by remember { mutableStateOf<Film?>(null) }
    var checkout by remember { mutableStateOf(false) }
    val selectedFilms = remember { mutableStateListOf<Film>() }

    val onProcessClickAct: () -> Unit = {
        checkout = true
    }

    when {
        checkout -> CheckoutScreen(selectedFilms) {
            checkout = false
            selectedFilms.clear()
        }
        selectedFilm != null -> FilmDetailScreen(film = selectedFilm!!, onBack = { selectedFilm = null }, onSelect = {
            selectedFilms.add(it)
        })
        else -> FilmListScreen(
            films = filmList,
            onFilmClick = { selectedFilm = it },
            onProcessClick = onProcessClickAct,
            selectedFilms = selectedFilms
        )
    }
}