package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentIndex by remember { mutableIntStateOf(0) }

    val artworks = listOf(
        Artwork(
            title = "The Potato Eaters",
            artist = "Vincent van Gogh",
            year = 1885,
            description = "Van Gogh’s Potato Eaters shows harsh rural life with coarse peasants " +
                    "in earth tones, emphasizing their honest labor. " +
                    "Despite criticism for dark colors and flaws, it remains a famous work.",
            imageResId = R.drawable.van_gogh_the_potato_eaters
        ),
        Artwork(
            title = "The Sower",
            artist = "Vincent van Gogh",
            year = 1888,
            description = "Van Gogh created over 30 works featuring sowers, " +
                    "including an 1888 painting during Gauguin’s stay. " +
                    "Using emotional colors like greenish-yellow sky and purple field, " +
                    "he depicted the sower as a saintly figure.",
            imageResId = R.drawable.van_gogh_the_sower
        ),
        Artwork(
            title = "The Bedroom",
            artist = "Vincent van Gogh",
            year = 1888,
            description = "Van Gogh painted his bedroom with bright colors and " +
                    "flattened perspective inspired by Japanese prints, " +
                    "considering it his best work after recovering from illness.",
            imageResId = R.drawable.van_gogh_the_bedroom
        ),
        Artwork(
            title = "Sunflowers",
            artist = "Vincent van Gogh",
            year = 1889,
            description = "Van Gogh’s famous Sunflowers series, painted in Arles (1888-1889), " +
                    "used only yellow shades to show color variation. " +
                    "The paintings symbolized gratitude and impressed his friend Gauguin, " +
                    "who lived with him briefly.",
            imageResId = R.drawable.van_gogh_sunflowers
        ),
        Artwork(
            title = "Starry Night",
            artist = "Vincent van Gogh",
            year = 1889,
            description = "A post-impressionist oil painting by Dutch artist Vincent van Gogh.",
            imageResId = R.drawable.van_gogh_starry_night
        ),
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Art Space",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        ArtworkDetail(artwork = artworks[currentIndex])
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    currentIndex = if (currentIndex == 0) artworks.size - 1 else currentIndex - 1
                }
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    currentIndex = if (currentIndex == artworks.size - 1) 0 else currentIndex + 1
                }

            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}