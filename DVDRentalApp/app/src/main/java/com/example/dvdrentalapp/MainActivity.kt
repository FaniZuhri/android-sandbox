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
            Film(11, "The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, "Epic conclusion to the journey in Middle-earth.", "New Line Cinema", R.drawable.poster11),
            Film(12, "Fight Club", "David Fincher", 1999, "An underground fight club as a form of rebellion.", "20th Century Fox", R.drawable.poster12),
            Film(13, "The Dark Knight", "Christopher Nolan", 2008, "Batman faces the Joker.", "Warner Bros.", R.drawable.poster13),
            Film(14, "Forrest Gump", "Robert Zemeckis", 1994, "Life story of a simple man with a big heart.", "Paramount Pictures", R.drawable.poster14),
            Film(15, "The Shawshank Redemption", "Frank Darabont", 1994, "Hope and friendship in prison.", "Columbia Pictures", R.drawable.poster15),
        )
    }
    var selectedFilm by remember { mutableStateOf<Film?>(null) }
    var checkout by remember { mutableStateOf(false) }
    val selectedFilms = remember { mutableStateListOf<Film>() }

    val onProcessClickAct: () -> Unit = {
        checkout = true
    }

    when {
        checkout -> CheckoutScreen(
            selectedFilms,
            onCheckoutDone = { selectedFilms.clear() },
            onBack = { checkout = false }

        )
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