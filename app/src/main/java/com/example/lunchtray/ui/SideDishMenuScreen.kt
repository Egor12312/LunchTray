package com.example.lunchtray

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.OrderViewModel

@Composable
fun SideDishMenuScreen(
    orderViewModel: OrderViewModel,
    onNext: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        menuItemList = DataSource.sideDishMenuItems,
        selectedItem = orderViewModel.sideDish,
        onItemSelected = { orderViewModel.sideDish = it },
        onNext = onNext,
        onCancel = onCancel,
        modifier = modifier
    )
}