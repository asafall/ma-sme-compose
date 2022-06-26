package az.asaf.ma_sme_compose.ui.flow.tabs.main.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import az.asaf.ma_sme_compose.R
import az.asaf.ma_sme_compose.ui.flow.tabs.main.MainViewModel

@Preview
@Composable
fun PreviewUnsignedPaymentsCount() {
    UnsignedPaymentsCountSection(viewModel = viewModel())
}

@Composable
fun UnsignedPaymentsCountSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    Surface(
        border = BorderStroke(
            1.dp,
            colorResource(R.color.border_unsigned_payments_count)
        ),
        shape = CircleShape.copy(all = CornerSize(12.dp)),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 72.dp)
    ) {
        ConstraintLayout {
            val (iconPen, txtCount, iconArrow) = createRefs()

            Icon(
                painter = painterResource(R.drawable.ic_yellow_sign_pen),
                contentDescription = "pen_icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .constrainAs(iconPen) {
                        start.linkTo(parent.start, margin = 16.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Text(
                text = stringResource(
                    id = R.string.unsigned_payments_text,
                    viewModel.unsignedPaymentsCount
                ),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.constrainAs(txtCount) {
                    start.linkTo(iconPen.end, margin = 12.dp)
                    end.linkTo(iconArrow.start, margin = 22.62.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
            )
            Icon(
                painter = painterResource(R.drawable.ic_gray_arrow),
                contentDescription = "arrow_icon",
                modifier = Modifier.constrainAs(iconArrow) {
                    end.linkTo(parent.end, margin = 20.62.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}