package com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.PostData
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel

@Composable
fun StyledText(text: String, style: TextStyle, modifier: Modifier = Modifier, showDivider: Boolean = true) {
    Text(
        text = text,
        style = style,
        modifier = modifier.padding(vertical = 8.dp)
    )
    if (showDivider) {
        Divider(color = Color.LightGray)
    }
}

@Composable
fun HomeItem(
    postData: PostData
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val topTextElements: List<Triple<String, TextStyle, Modifier>> = listOf(
                Triple("${stringResource(id = R.string.home_list_title)} ${postData.title}", MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold), Modifier),
                Triple("${stringResource(id = R.string.home_list_author)} ${postData.author}", MaterialTheme.typography.body2, Modifier),
            )

            topTextElements.forEachIndexed { index, (text, style, modifier) ->
                val isLastElement = index == topTextElements.size - 1
                StyledText(
                    text = text,
                    style = style,
                    modifier = modifier,
                    showDivider = !isLastElement
                )
            }

            Divider(color = Color.LightGray)
            Spacer(Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                val bottomTextElements: List<Pair<String, TextStyle>> = listOf(
                    Pair("${stringResource(id = R.string.home_list_ups)} ${postData.ups}", MaterialTheme.typography.subtitle2),
                    Pair("${stringResource(id = R.string.home_list_created)} ${postData.createdDate}", MaterialTheme.typography.subtitle2),
                    Pair("${stringResource(id = R.string.home_list_comments)} ${postData.numComments}", MaterialTheme.typography.subtitle2)
                )

                bottomTextElements.forEachIndexed { index, (text, style) ->
                    Text(
                        text = text,
                        style = style,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPostComponent() {
    HomeItem(
        postData = PostData(
            author = "AuthorName",
            title = "Title of the post",
            ups = 123,
            numComments = 456,
            created = 15135
        )
    )
}