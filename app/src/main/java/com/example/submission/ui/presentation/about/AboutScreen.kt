package com.example.submission.ui.presentation.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.submission.R
import com.example.submission.ui.theme.SubmissionTheme


@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        
        Box {
            Image(painter = painterResource(
                id = R.drawable.photo),
                contentDescription = stringResource(id = R.string.condes_photo),
                modifier = modifier
                    .size(120.dp)
                    .clip(shape = CircleShape)
            )
        }
        
        Text(text = stringResource(id = R.string.tv_name),
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )

        Text(text = stringResource(id = R.string.tv_email),
            style = MaterialTheme.typography.h5

        )
        
    }
}

@Preview
@Composable
fun AboutScreenPreview() {
    SubmissionTheme{
        AboutScreen()
    }
}