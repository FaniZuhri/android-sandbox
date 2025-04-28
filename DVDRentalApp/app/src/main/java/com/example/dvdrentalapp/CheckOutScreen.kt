package com.example.dvdrentalapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(selectedFilms: List<Film>, onCheckoutDone: () -> Unit, onBack: () -> Unit) {
    var borrowerName by remember { mutableStateOf("") }
    val totalPrice = selectedFilms.size * 10_000

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Checkout") },
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
            OutlinedTextField(
                value = borrowerName,
                onValueChange = { borrowerName = it },
                label = { Text("Nama Peminjam") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Total Film Dipilih: ${selectedFilms.size}")
            Text(
                text = "Film yang dipilih:",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            selectedFilms.forEach { film ->
                FilmItemCheckout(film)
                Spacer(modifier = Modifier.height(8.dp))
            }
            Text(text = "Total Harga: Rp $totalPrice")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onCheckoutDone, modifier = Modifier.fillMaxWidth()) {
                Text("Selesai")
            }
        }
    }
}

@Composable
fun FilmItemCheckout(film: Film) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Judul: ${film.title}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Tahun: ${film.year}", style = MaterialTheme.typography.bodySmall)
        Text(text = "Harga: Rp 10.000", style = MaterialTheme.typography.bodySmall)
    }
}