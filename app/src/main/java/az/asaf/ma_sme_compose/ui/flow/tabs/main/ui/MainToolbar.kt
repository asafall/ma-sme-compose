package az.asaf.ma_sme_compose.ui.flow.tabs.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import az.asaf.ma_sme_compose.R
import az.asaf.ma_sme_compose.ui.flow.tabs.main.MainViewModel
import coil.compose.AsyncImage

@Preview
@Composable
private fun PreviewMainToolbar() {
    MainToolbarSection(viewModel = viewModel())
}

@Composable
fun MainToolbarSection(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(R.color.home_toolbar_background))
    ) {
        val (imgUser, lytUserInfo, iconNotif) = createRefs()

        AsyncImage(
            model = viewModel.userInfo.userPhoto,
            contentDescription = "user_image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .constrainAs(imgUser) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                },
        )
        Column(modifier = Modifier.constrainAs(lytUserInfo) {
            top.linkTo(parent.top, margin = 8.dp)
            start.linkTo(imgUser.end, margin = 16.dp)
            width = Dimension.fillToConstraints
        }) {
            Text(
                text = viewModel.userInfo.getFullName(),
                color = colorResource(R.color.text_user_full_name),
                fontFamily = FontFamily.SansSerif,
                fontSize = 17.sp,
                letterSpacing = (-0.41).sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = viewModel.userInfo.customers[0].name,
                color = colorResource(R.color.text_customer_name),
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Image(
            painter = painterResource(R.drawable.ic_white_notification),
            contentDescription = "notification_icon",
            modifier = Modifier.constrainAs(iconNotif) {
                top.linkTo(parent.top, margin = 18.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        )
    }
}

