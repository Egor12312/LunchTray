package com.example.lunchtray

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lunchtray.ui.OrderViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CheckoutScreen(
    orderViewModel: OrderViewModel,
    onSend: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.order_summary),
            style = MaterialTheme.typography.headlineMedium
        )

        val format = NumberFormat.getCurrencyInstance(Locale.US)

        Text(text = stringResource(R.string.subtotal, format.format(orderViewModel.subtotal)))
        Text(text = stringResource(R.string.tax, format.format(orderViewModel.tax)))
        Text(text = stringResource(R.string.total, format.format(orderViewModel.total)))

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onCancel) {
                Text(text = stringResource(R.string.cancel))
            }
            Button(onClick = onSend) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}