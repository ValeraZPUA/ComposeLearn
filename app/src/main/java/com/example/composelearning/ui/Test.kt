package com.example.composelearning.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TEst(
    @PreviewParameter(StrPreviewProvider::class) user: String,
) {
    Text(
        text = "user.name",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontSize = 18.sp
    )
}

private class StrPreviewProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "Short status",
        "Long status Long status Long statusLong statusLong statusLong statusLong status"
    )

}