package com.example.submission.ui.presentation.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.ui.presentation.component.LoadingScreen
import com.example.submission.ui.presentation.component.VanguardItem
import com.example.submission.ui.utils.UiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail : (Vanguard) -> Unit
) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading ->{
                viewModel.getAllVanguards()
                LoadingScreen()
            }
            is UiState.Success -> {
                uiState.data?.let {
                    HomeContent(
                        vanguards = it,
                        navigateToDetail = navigateToDetail
                    )
                }
            }
            is UiState.Error -> {
                Text(text = "oops.. something's wrong")
            }
        }
    }

}

@Composable
fun HomeContent(
    vanguards : List<Vanguard>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Vanguard) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ){
        items(vanguards){ card ->
            VanguardItem(
                image = card.image,
                title = card.name ,
                grade = card.grade,
                nation = card.nation,
                modifier = Modifier.clickable {
                    navigateToDetail(card)
                }
            )
        }
    }
}