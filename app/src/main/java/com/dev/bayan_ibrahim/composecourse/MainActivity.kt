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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.dev.bayan_ibrahim.composecourse.data.Dog
import com.dev.bayan_ibrahim.composecourse.data.MyHeroAcademy
import com.dev.bayan_ibrahim.composecourse.data.dogs
import com.dev.bayan_ibrahim.composecourse.domain.model.SuperHero
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
                }
            }
        }
    }
}

@Composable
fun SuperHeroesScreen () {
    SuperHeroesList()
}
@Composable
fun SuperHeroesList(modifier: Modifier = Modifier){
    Scaffold (
        topBar = {
            SuperHeroTopBar()
        }
    ){
        LazyColumn(
            modifier = modifier
                .background(color = MaterialTheme.colors.background),

            ) {
            items(MyHeroAcademy.superHeroesList) { hero ->
                SuperHeroCard(hero = hero)
            }
        }
    }
}

@Composable
fun SuperHeroTopBar () {
    Row(
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text (
            text = "Super Heroes",
            style = MaterialTheme.typography.h1,
        )
    }
}
@Composable
fun SuperHeroCard(modifier: Modifier = Modifier, hero: SuperHero) {
    Card (
        modifier = modifier
            .padding(8.dp),
        elevation = 2.dp,
    ) {
        Row (
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
        ) {
            SuperHeroInfo(modifier = Modifier.weight(1f), name = hero.name, title = hero.title)
            Spacer(modifier = Modifier.padding(16.dp))
            SuperHeroImage(imageRes = hero.imageRes)
        }
    }
}

@Composable
fun SuperHeroImage (modifier: Modifier = Modifier,@DrawableRes imageRes: Int) {
    Image(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .size(64.dp),
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun SuperHeroInfo (modifier: Modifier = Modifier, name: String, title: String) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h2,
        )
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
        )
    }
}


/** Preview: */
@Preview(showBackground = true)
@Composable
fun SuperCardPreviewDark () {
    ComposeCourseTheme (darkTheme = true) {
        SuperHeroCard(
            hero = SuperHero(
                name = "Nick the Night and Day",
                title = "The Jetpack Hero",
                imageRes = R.drawable.android_superhero1
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuperCardPreviewLight () {
    ComposeCourseTheme (darkTheme = false) {
        SuperHeroCard(
            hero = SuperHero(
                name = "Nick the Night and Day",
                title = "The Jetpack Hero",
                imageRes = R.drawable.android_superhero1
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuperPreviewDark () {
    ComposeCourseTheme (darkTheme = true) {
        SuperHeroesScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SuperPreviewLight () {
    ComposeCourseTheme (darkTheme = false) {
        SuperHeroesScreen()
    }
}
