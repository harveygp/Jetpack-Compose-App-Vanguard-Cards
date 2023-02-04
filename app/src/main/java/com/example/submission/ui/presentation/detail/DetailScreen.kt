package com.example.submission.ui.presentation.detail

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.ui.theme.SubmissionTheme
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
    card: Vanguard? = null
) {
    val coroutineScope = rememberCoroutineScope()
    if (card != null){
        DetailContent(
            card = card,
            onFavoriteClick = { isFavorite ->
                 coroutineScope.launch {
                     viewModel.setFavoriteVanguard(card, isFavorite)
                 }
            }
        )
    }else{
        Text(text = "oops.. something's wrong")
    }

}

@Composable
fun DetailContent(
    modifier : Modifier = Modifier,
    card : Vanguard,
    onFavoriteClick : (Boolean) -> Unit
) {

    var isFavorite by remember { mutableStateOf(card.isFavorite)}

    Column(modifier = modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Box {
                AsyncImage(
                    modifier = modifier
                        .height(300.dp)
                        .fillMaxWidth(),
                    model = card.image,
                    contentDescription = "card picture",
                    contentScale = ContentScale.Crop
                )
                Icon(
                    imageVector = setStatusFavorite(statusFavorite = isFavorite),
                    contentDescription = if(card.isFavorite) "Favoritmu" else "Tidak Favorite",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(32.dp)
                        .offset(y = 30.dp)
                        .clickable {
                            isFavorite = !isFavorite
                            onFavoriteClick(isFavorite)
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.align(CenterHorizontally),
            text = card.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.ExtraBold
            ),
        )

        Spacer(modifier = Modifier.height(6.dp))
        Row(modifier = modifier) {
            Text(
                text = card.grade.toString(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = card.nation,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.align(CenterHorizontally),
            text = card.effect,
            maxLines = 10,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    SubmissionTheme{
        DetailContent(card = Vanguard(
            vanguardId = 1,
            name = "Dragonic Overlord",
            grade = 3,
            nation = "Dragon Empire",
            effect = "Loren Ipsum Color Set Amet",
            image = "https://example.com/image.jpg",
            isFavorite = false
        ),
            onFavoriteClick = {}
        )
    }
}

@Composable
fun setStatusFavorite(statusFavorite : Boolean) : ImageVector {
    return if(statusFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder
}