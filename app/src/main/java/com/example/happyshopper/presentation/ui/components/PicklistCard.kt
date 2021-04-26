package com.example.happyshopper.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.happyshopper.R
import com.example.happyshopper.domain.model.Picklist
import com.example.happyshopper.util.DEFAULT_RECIPE_IMAGE
import com.example.happyshopper.util.loadPicture

@Composable
fun PicklistCard(
    picklist: Picklist,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(
                bottom = 3.dp,
                top = 3.dp,
                start = 1.dp,
                end = 1.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp,
//        color = if (isSelected) Color.LightGray else MaterialTheme.colors.primary
    ) {
        Column {
            /*picklist.featuredImage?.let { url ->
                val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }*/
            picklist.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = picklist.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}


 /*

    Card(
        shape = RoundedCornerShape(
            topStart = CornerSize(5.dp),
            topEnd = CornerSize(5.dp),
            bottomEnd = CornerSize(5.dp),
            bottomStart = CornerSize(5.dp)
            ),
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column() {
            picklist.featuredImage?.let { url ->
                Image(
                    bitmap = painterResource(id = R.drawable.waitrose),
                    contentDescription = "imgDesc",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
*/