package com.dev.bayan_ibrahim.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.bayan_ibrahim.composecourse.data.Dog
import com.dev.bayan_ibrahim.composecourse.data.dogs
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme

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
fun WoofCard (modifier: Modifier = Modifier, dog: Dog) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row (
            modifier = Modifier,
//                .background(MaterialTheme.colors.surface),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DogIcon(id = dog.imageResourceId)
            DogInformation(dog)
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
fun WoofTobBarPreviewDark () {
    ComposeCourseTheme (darkTheme = true) {
        WoofTobBar()
    }
}

@Preview(showBackground = true)
@Composable
fun WoofTobBarPreviewLight () {
    ComposeCourseTheme (darkTheme = false) {
        WoofTobBar()
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
