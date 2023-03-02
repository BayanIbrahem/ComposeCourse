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
import com.dev.bayan_ibrahim.composecourse.data.dogs
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
fun WoofScreen () {
    WoofList(modifier = Modifier.fillMaxSize())
}

@Composable
fun DogIcon (@DrawableRes id: Int) {
    Image(
        modifier = Modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50.dp)),
        painter = painterResource(id = id),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun DogInformation(dog: Dog) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = dog.name),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2,
        )
        Text(
            text = stringResource(id = R.string.years_old, dog.age),
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
fun DogHobby (modifier: Modifier = Modifier, @StringRes hobby: Int) {
    Column(
        modifier = modifier
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp,
            ),
        
    ) {
        Text(
            text = stringResource(id = R.string.about),
            style = MaterialTheme.typography.h3,
        )
        Text(
            text = stringResource(id = hobby),
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
fun DogHobbyIconButton(expanded: Boolean, onClick: () -> Unit) {
    val iconId = if (expanded) {
        R.drawable.expand_less
    } else {
        R.drawable.expand_more
    }
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
        )
    }
}

@Composable
fun WoofCard (modifier: Modifier = Modifier, dog: Dog) {
    var expanded by remember {mutableStateOf(false)}
//    // this two lines is to add color animation for background.
//    val color by animateColorAsState(
//        targetValue = if(expanded) MaterialTheme.colors.background else MaterialTheme.colors.surface
//    )
    Card(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow,
                )
            )
//            .background(color = color)
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column() {
            Row (
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DogIcon(id = dog.imageResourceId)
                DogInformation(dog)
                Spacer(modifier = Modifier.weight(1f))
                DogHobbyIconButton(expanded = expanded) {
                    expanded = expanded.not()
                }
            }
            if (expanded) {
                DogHobby(hobby = dog.hobbies)
            }
        }
    }
}


@Composable
fun WoofList (modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            WoofTobBar()
        }
    ) {
        LazyColumn (
            modifier = Modifier
                .background(color = MaterialTheme.colors.background),
            contentPadding = PaddingValues(8.dp),
        ){
            items(dogs) { dog ->
                WoofCard(dog = dog)
            }
        }
    }
}

@Composable
fun WoofTobBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.ic_woof_logo),
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp),
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
        )
    }
}

/** Preview: */
@Preview(showBackground = true)
@Composable
fun WoofCardPreviewDark () {
    ComposeCourseTheme (darkTheme = true) {
        WoofCard(dog = Dog(imageResourceId = R.drawable.koda, name = R.string.dog_name_1, age = 3, hobbies = R.string.dog_description_1))
    }
}

@Preview(showBackground = true)
@Composable
fun WoofCardPreviewLight () {
    ComposeCourseTheme (darkTheme = false) {
        WoofCard(dog = Dog(imageResourceId = R.drawable.koda, name = R.string.dog_name_1, age = 3, hobbies = R.string.dog_description_1))
    }
}

@Preview(showBackground = true)
@Composable
fun WoofPreviewDark () {
    ComposeCourseTheme (darkTheme = true) {
        WoofScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun WoofPreviewLight () {
    ComposeCourseTheme (darkTheme = false) {
        WoofScreen()
    }
}
