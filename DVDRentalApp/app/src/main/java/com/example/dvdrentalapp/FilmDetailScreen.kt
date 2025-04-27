package com.example.dvdrentalapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmDetailScreen(film: Film, onBack: () -> Unit, onSelect: (Film) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(film.title) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
        ) {
            Image(painter = painterResource(id = film.posterResId), contentDescription = film.title, modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Sutradara: ${film.director}")
            Text(text = "Production House: ${film.productionHouse}")
            Text(text = "Tahun: ${film.year}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = film.synopsis)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onSelect(film) }) {
                Text("Pilih Film Ini")
            }
        }
    }
}