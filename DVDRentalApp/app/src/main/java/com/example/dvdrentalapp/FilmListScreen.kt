package com.example.dvdrentalapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilmListScreen(
    films: List<Film>,
    selectedFilms: List<Film>,
    onFilmClick: (Film) -> Unit,
    onProcessClick: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onProcessClick) {
                Text("Proses")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Jumlah Film yang Dipilih: ${selectedFilms.size}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp, top = 40.dp)
            )
            LazyColumn(contentPadding = paddingValues) {
                items(films) { film ->
                    FilmItem(film = film, onClick = { onFilmClick(film) })
                }
            }
        }
    }
}

@Composable
fun FilmItem(film: Film, onClick: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = onClick)
        .padding(vertical = 8.dp)
    ) {
        Text(text = film.title, style = MaterialTheme.typography.titleLarge)
        Text(text = "Tahun Rilis: ${film.year}", style = MaterialTheme.typography.bodySmall)
    }
}