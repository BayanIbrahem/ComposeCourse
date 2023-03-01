package com.dev.bayan_ibrahim.composecourse.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.bayan_ibrahim.composecourse.domain.model.Course
import com.dev.bayan_ibrahim.composecourse.R
import com.dev.bayan_ibrahim.composecourse.domain.model.DataSource
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme

class CoursesList: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background,
            ) {

            }
        }
    }
}

@Composable
fun CourseCard (course: Course, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = modifier
        ) {
            Box {
                Image(
                    modifier = Modifier
//                        .aspectRatio(ratio = 1f)
                        .size(68.dp),
                    painter = painterResource(id = course.imageDrawableResource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Column (
            ){
                Text(
                    modifier = Modifier.padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp,
                    ),
                    text = stringResource(id = course.nameStringResource),
                    style = MaterialTheme.typography.body2,
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(12.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text(
                        text = course.associatedCourses.toString(),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseGrid (courses: List<Course>) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 200.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(courses) {
            CourseCard(course = it)
        }
    }
}
@Preview
@Composable
fun CourseCardPreview() {
    ComposeCourseTheme {
        CourseCard(
            course = Course(
                nameStringResource = R.string.fashion,
                imageDrawableResource = R.drawable.fashion,
                associatedCourses = 10,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CourseGridPreview() {
    ComposeCourseTheme() {
        CourseGrid(courses = DataSource.courses)
    }
}