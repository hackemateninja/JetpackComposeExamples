package dev.bushidolabs.composebasics.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout




@Preview
@Composable
fun ConstraintLAyoutChain() {
  ConstraintLayout(Modifier.fillMaxSize()) {
    val (boxRed, boxGreen, boxYellow) = createRefs()
    val barrier = createEndBarrier(boxRed, boxGreen)
    
    Box(Modifier.size(50.dp).background(Color.Red).constrainAs(boxRed){
    
    })
    Box(Modifier.size(50.dp).background(Color.Green).constrainAs(boxGreen){

    })
    
    Box(Modifier.size(50.dp).background(Color.Yellow).constrainAs(boxYellow){
    })
    
    createVerticalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)
  }
}



//@Preview
@Composable
fun ConstraintLAyoutBarrier() {
  ConstraintLayout(Modifier.fillMaxSize()) {
    val (boxRed, boxGreen, boxYellow) = createRefs()
    val barrier = createEndBarrier(boxRed, boxGreen)
    
    Box(Modifier.size(25.dp).background(Color.Red).constrainAs(boxRed){
      start.linkTo(parent.start, margin = 16.dp)
    })
    Box(Modifier.size(125.dp).background(Color.Green).constrainAs(boxGreen){
      top.linkTo(boxRed.bottom)
      start.linkTo(parent.start, margin = 32.dp)
    })
  
    Box(Modifier.size(10.dp).background(Color.Yellow).constrainAs(boxYellow){
      start.linkTo(barrier)
    })
  }
}

//@Preview
@Composable
fun ConstraintLAyoutGuide() {
  ConstraintLayout(Modifier.fillMaxSize()) {
    val boxRed = createRef()
    val topGuide = createGuidelineFromTop(0.1f)
    val startGuide = createGuidelineFromStart(0.25f)
    
    Box(Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
      top.linkTo(topGuide)
      start.linkTo(startGuide)
    })
  }
}


@Composable
fun MyConstraintLayout() {
  ConstraintLayout(Modifier.fillMaxSize()) {
    
    val (boxRed, boxGreen, boxBlue, boxYellow, boxMagenta) = createRefs()
    
    Box(
      Modifier
        .size(125.dp)
        .background(Color.Red)
        .constrainAs(boxRed) {
          top.linkTo(parent.top)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
          bottom.linkTo(parent.bottom)
        })
    Box(
      Modifier
        .size(125.dp)
        .background(Color.Green)
        .constrainAs(boxGreen) {
          end.linkTo(boxRed.start)
          top.linkTo(boxRed.bottom)
        })
    Box(
      Modifier
        .size(125.dp)
        .background(Color.Blue)
        .constrainAs(boxBlue) {
          start.linkTo(boxRed.end)
          top.linkTo(boxRed.bottom)
        })
    Box(
      Modifier
        .size(125.dp)
        .background(Color.Yellow)
        .constrainAs(boxYellow) {
          bottom.linkTo(boxRed.top)
          end.linkTo(boxRed.start)
        })
    Box(
      Modifier
        .size(125.dp)
        .background(Color.Magenta)
        .constrainAs(boxMagenta) {
          bottom.linkTo(boxRed.top)
          start.linkTo(boxRed.end)
        })
  }
}


//@Preview(showBackground = true)
@Composable
fun MyCustomLayout() {
  Box(
    Modifier.fillMaxSize()
  ){
    Column {
      Box(
        Modifier
          .fillMaxWidth()
          .background(Color.Red)
          .weight(1f),
        contentAlignment = Alignment.Center
      ){
        Text("Hello world")
      }
      Spacer(Modifier.height(10.dp))
      Row(
        Modifier
          .fillMaxWidth()
          .weight(1f)) {
        Box(
          Modifier
            .background(Color.Green)
            .weight(1f)
            .fillMaxHeight(),
          contentAlignment = Alignment.Center
        ){
          Text("Hello world")
        }
        Spacer(Modifier.width(10.dp))
        Box(
          Modifier
            .background(Color.Yellow)
            .weight(1f)
            .fillMaxHeight(),
          contentAlignment = Alignment.Center
        ){
          Text("Hello world")
        }
      }
      Spacer(Modifier.height(10.dp))
      Box(
        Modifier
          .fillMaxWidth()
          .background(Color.Blue)
          .weight(1f),
        contentAlignment = Alignment.BottomCenter
      ){
        Text("Hello world")
      }
    }
  }
}

//@Preview(showBackground = true)
@Composable
fun MyRow() {
  Row(
    Modifier
      .fillMaxSize()
      .horizontalScroll(rememberScrollState()),
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    Text("Hello world",
      Modifier
        .background(Color.Red)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Black)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Blue)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Gray)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Green)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Red)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Black)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Blue)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Gray)
        .fillMaxHeight()
        .width(50.dp))
    Text("Hello world",
      Modifier
        .background(Color.Green)
        .fillMaxHeight()
        .width(50.dp))
  }
}
//@Preview(showBackground = true)
@Composable
fun MyColumn() {
  Column(
    Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    Text("Hello world",
      Modifier
        .background(Color.Red)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Black)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Blue)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Gray)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Green)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Red)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Black)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Blue)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Gray)
        .fillMaxWidth()
        .height(100.dp))
    Text("Hello world",
      Modifier
        .background(Color.Green)
        .fillMaxWidth()
        .height(100.dp))
  }
}

//@Preview(showBackground = true)
@Composable
fun MyBox() {
  Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
    Box(
      Modifier
        .width(100.dp)
        .height(100.dp)
        .background(Color.Cyan)
        .verticalScroll(rememberScrollState())
        .padding(20.dp),
      contentAlignment = Alignment.Center
    ) {
      Text("This is a demo text with a lot of content inside")
    }
  }
}
