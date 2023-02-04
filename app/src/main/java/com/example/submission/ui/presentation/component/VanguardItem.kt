package com.example.submission.ui.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.submission.R
import com.example.submission.ui.theme.SubmissionTheme

@Composable
fun VanguardItem(
    image : String,
    title : String,
    grade : Int,
    nation : String,
    modifier : Modifier = Modifier
) {
    
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = image,
            contentDescription = stringResource(id = R.string.condes_photo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(shape = RectangleShape)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
        Spacer(modifier = Modifier.width(6.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = grade.toString(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = nation,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VanguardItemPreview() {
    SubmissionTheme{
        VanguardItem(
            "https://example.com/image.jpg",
            "Overload Dragon",
            3,
            "Dragon Empire"
        )
    }
}