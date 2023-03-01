package com.dev.bayan_ibrahim.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.bayan_ibrahim.composecourse.domain.model.Affirmation
import com.dev.bayan_ibrahim.composecourse.domain.model.DataSource
import com.dev.bayan_ibrahim.composecourse.domain.model.loadAffirmations
import com.dev.bayan_ibrahim.composecourse.ui.CourseGrid
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
                    CourseGrid(courses = DataSource.courses)
                }
            }
        }
    }
}

@Composable
fun AffirmationCard(modifier: Modifier = Modifier, affirmation: Affirmation) {
    Card(
        modifier = modifier
            .padding(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = modifier,
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth(),
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(id = affirmation.stringResourceId),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun AffirmationsList(affirmations: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(affirmations) { affirmation ->
            AffirmationCard(affirmation = affirmation)
        }
    }
}
@Preview
@Composable
fun AffirmationCardPreview() {
    ComposeCourseTheme {
        AffirmationCard(
            affirmation = Affirmation(
                stringResourceId = R.string.affirmation1,
                imageResourceId = R.drawable.image1
            ),
        )
    }
}
@Preview(showBackground = true)
@Composable
fun AffirmationsPreview() {
    ComposeCourseTheme {
        AffirmationsList(affirmations = loadAffirmations())
    }
}