package com.example.lunchtray

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.OrderViewModel

@Composable
fun AccompanimentMenuScreen(
    orderViewModel: OrderViewModel,
    onNext: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        menuItemList = DataSource.accompanimentMenuItems,
        selectedItem = orderViewModel.accompaniment,
        onItemSelected = { orderViewModel.accompaniment = it },
        onNext = onNext,
        onCancel = onCancel,
        modifier = modifier
    )
}