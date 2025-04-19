package com.example.lemonade_test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade_test.ui.theme.Lemonade_testTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lemonade_testTheme {
                LemonApp()
            }
        }
    }
}

enum class LemonadeState {
    LemonTree,
    LemonSqueeze,
    LemonDrink,
    LemonRestart,
}

@Composable
fun LemonApp() {
    // A surface container using the 'background' color from the theme
    val lemonCountInit = 1
    val drinkCountInit = 1
    val minSqueezeCount = 1
    val maxSqueezeCount = 5

    var lemonadeStateId by remember { mutableStateOf(LemonadeState.LemonTree) }
    var squeezeCount by remember { mutableIntStateOf(Random.nextInt(minSqueezeCount, maxSqueezeCount)) }
    var lemonCount by remember { mutableIntStateOf(lemonCountInit) }
    var drinkCount by remember { mutableIntStateOf(drinkCountInit) }

    fun tapLemonTreeAction() {
        lemonCount -= 1
        Log.d("tapLemonTreeAction", "lemon count: $lemonCount")
        if (lemonCount == 0) {
            lemonadeStateId = LemonadeState.LemonSqueeze
            lemonCount = lemonCountInit
        }
    }
    fun squeezeLemonadeAct() {
        squeezeCount -= 1
        Log.d("squeezeLemonadeAct", "squeeze count: $squeezeCount")
        if (squeezeCount == 0) {
            lemonadeStateId = LemonadeState.LemonDrink
            squeezeCount = Random.nextInt(minSqueezeCount, maxSqueezeCount)
        }
    }
    fun drinkLemonadeAct() {
        drinkCount -= 1
        Log.d("drinkLemonadeAct", "drink count: $drinkCount")
        if (drinkCount == 0) {
            lemonadeStateId = LemonadeState.LemonRestart
            drinkCount = drinkCountInit
        }
    }
    fun restartLemonadeAct() {
        lemonadeStateId = LemonadeState.LemonTree
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (lemonadeStateId) {
            LemonadeState.LemonTree -> {
                DisplayLemonadeState(
                    displayTitleId = R.string.tap_lemon_tree,
                    imgContentId = R.drawable.lemon_tree,
                    imgDescId = R.string.lemon_tree,
                    clickAct = ::tapLemonTreeAction
                )
            }
            LemonadeState.LemonSqueeze -> {
                DisplayLemonadeState(
                    displayTitleId = R.string.keep_tapping_lemon,
                    imgContentId = R.drawable.lemon_squeeze,
                    imgDescId = R.string.lemon,
                    clickAct = ::squeezeLemonadeAct
                )
            }
            LemonadeState.LemonDrink -> {
                DisplayLemonadeState(
                    displayTitleId = R.string.tap_lemonade,
                    imgContentId = R.drawable.lemon_drink,
                    imgDescId = R.string.glass_lemonade,
                    clickAct = ::drinkLemonadeAct
                )
            }
            LemonadeState.LemonRestart -> {
                DisplayLemonadeState(
                    displayTitleId = R.string.tap_empty_glass,
                    imgContentId = R.drawable.lemon_restart,
                    imgDescId = R.string.empty_glass,
                    clickAct = ::restartLemonadeAct
                )
            }
        }
    }
}

@Composable
fun DisplayLemonadeState(
    displayTitleId: Int,
    imgContentId: Int,
    imgDescId: Int,
    clickAct: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = stringResource(displayTitleId))
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(imgContentId),
            contentDescription = stringResource(imgDescId),
            modifier = Modifier
                .wrapContentSize()
                .clickable{clickAct()}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lemonade_testTheme {
        LemonApp()
    }
}