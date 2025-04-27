package com.example.dvdrentalapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(selectedFilms: List<Film>, onCheckoutDone: () -> Unit) {
    var borrowerName by remember { mutableStateOf("") }
    val totalPrice = selectedFilms.size * 10_000

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Checkout") }
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
            Text(text = "Total Harga: Rp $totalPrice")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onCheckoutDone, modifier = Modifier.fillMaxWidth()) {
                Text("Selesai")
            }
        }
    }
}