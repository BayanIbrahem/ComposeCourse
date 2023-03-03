package com.dev.bayan_ibrahim.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.bayan_ibrahim.composecourse.data.local.Characters
import com.dev.bayan_ibrahim.composecourse.domain.model.AnimeCharacter
import com.dev.bayan_ibrahim.composecourse.ui.AnimeCharacterGridCard
import com.dev.bayan_ibrahim.composecourse.ui.AnimeCharacterListCard
import com.dev.bayan_ibrahim.composecourse.ui.theme.AnimeCharactersTobBar
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnimeCharactersApp()
                }
            }
        }
    }
}

@Composable
fun AnimeCharactersApp () {
    var isList by remember { mutableStateOf(true) }
    Scaffold(
        modifier = Modifier,
        topBar = {
            AnimeCharactersTobBar(isList) {
                isList = isList.not()
            }
        }
    ) {
        if (isList) {
            AnimeCharactersList()
        } else {
            AnimeCharactersGrid()
        }
    }
}
@Composable
fun AnimeCharactersList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(Characters.characters) {
            AnimeCharacterListCard(character = it)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimeCharactersGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(180.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        items(Characters.characters) {
            AnimeCharacterGridCard(character = it)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun AnimeCharactersReviewLight() {
    ComposeCourseTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            AnimeCharactersApp()
        }
    }
}

@Preview (showBackground = true)
@Composable
fun AnimeCharactersReviewDark() {
    ComposeCourseTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            AnimeCharactersApp()
        }
    }
}
