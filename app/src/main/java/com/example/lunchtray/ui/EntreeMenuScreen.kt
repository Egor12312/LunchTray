package com.example.lunchtray

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.OrderViewModel

@Composable
fun EntreeMenuScreen(
    orderViewModel: OrderViewModel,
    onNext: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        menuItemList = DataSource.entreeMenuItems,
        selectedItem = orderViewModel.entree,
        onItemSelected = { orderViewModel.entree = it },
        onNext = onNext,
        onCancel = onCancel,
        modifier = modifier
    )
}