package com.example.jedc_coffeeshops

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jedc_coffeeshops.model.Comentario
import com.example.jedc_coffeeshops.ui.theme.backgroundCard
import com.example.jedc_coffeeshops.ui.theme.primaryDark
import com.example.jedc_coffeeshops.ui.theme.watermelonFamily

@Composable
fun Comentarios(navController: NavHostController, nomCafeteria: String){
    val configuration = LocalConfiguration.current
    val ancho1: Int


    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            ancho1 = 400

        }
        else ->{
            ancho1 = 180

        }
    }
    val estadoLazyVerticalGrid =  rememberLazyStaggeredGridState()
  //  val corutinaScope = rememberCoroutineScope() // es para usar en onClick del botón
    var textoBuscado by rememberSaveable { mutableStateOf("") }

    val listaComentariosFiltrados = getComentario().filter {
        comentario -> comentario.texto.contains(textoBuscado, ignoreCase = true)
    }

    Column (Modifier.padding(top=60.dp, start=10.dp, end=10.dp, bottom = 20.dp).fillMaxSize()){
        MySpacer(60)
        Box (Modifier.height(60.dp).fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Text(text = nomCafeteria,
                fontFamily = watermelonFamily,
                fontSize = 30.sp,
                color = Color.Black,
                textAlign = TextAlign.Center)
        }
        MySpacer(10)

        Row {
            TextField(
                value = textoBuscado,
                onValueChange = { textoBuscado = it },
                label = { Text("Buscar comentario") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon ={
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "buscar",
                            tint = primaryDark
                        )
                    }
                },

            )
        }
        MySpacer(10)
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            state = estadoLazyVerticalGrid,
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalItemSpacing = 20.dp,

            modifier = Modifier.weight(1f)//sin peso el botón no se ve
        ) {
            items(listaComentariosFiltrados){
                    comentario -> ItemComentario(comentario=comentario)
            }
        }

        val showBoton by remember{
            derivedStateOf {
                estadoLazyVerticalGrid.firstVisibleItemIndex>0
            }
        }
        if (showBoton){
            Button(
                onClick = {
                   /* corutinaScope.launch {
                       // estadoLazyVerticalGrid.animateScrollToItem(0)//me lleva a la posicion que le digo
                    }*/
                },
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(16.dp).width(ancho1.dp)
            ) {
                Text(text = "Add new comment")
            }
        }

    }//Cierra column
}

fun getComentario(): List<Comentario>{
    return listOf(
        Comentario(
            "Servicio algo flojo, aún así lo recomiendo"
        ),
        Comentario(
            "Céntrica y acogedora. Volveremos seguro"
        ),
        Comentario(
            "La ambientacion muy buena, pero en la planta de arriba un poco escasa."
        ),
        Comentario(
            "La comida estaba deliciosa y bastante bien de precio, mucha variedad de platos"
        ),
        Comentario(
            "El personal muy amable, nos permitieron ver todo el establecimiento."
        ),
        Comentario(
            "Muy bueno"
        ),
        Comentario(
            "Excelente. Destacable la extensa carta de cafés"
        ),
        Comentario(
            "Buen ambiente y buen servicio. Lo recomiendo."
        ),
        Comentario(
            "En días festivos demasiado tiempo de espera. Los camareros/as no dan abasto. No lo recomiendo. No volveré"
        ),
        Comentario(
            "Repetiremos. Gran selección de tartas y cafés."
        ),
        Comentario(
            "Todo lo que he probado en la cafetería está riquísimo, dulce o salado."
        ),
        Comentario(
            "La vajilla muy bonita todo de diseño que en el entorno del bar queda ideal."
        ),
        Comentario(
            "Puntos negativos: el servicio es muy lento y los precios son un poco elevados."
        ),
        Comentario(
            "Muy bueno"
        ),
        Comentario(
            "Excelente. Destacable la extensa carta de cafés"
        ),
        Comentario(
            "Buen ambiente y buen servicio. Lo recomiendo."
        ),
        Comentario(
            "En días festivos demasiado tiempo de espera. Los camareros/as no dan abasto. No lo recomiendo. No volveré"
        ),
        Comentario(
            "Repetiremos. Gran selección de tartas y cafés."
        ),
        Comentario(
            "Todo lo que he probado en la cafetería está riquísimo, dulce o salado."
        ),
        Comentario(
            "Repetiremos. Gran selección de tartas y cafés."
        ),
        Comentario(
            "Todo lo que he probado en la cafetería está riquísimo, dulce o salado."
        ),
        Comentario(
            "La vajilla muy bonita todo de diseño que en el entorno del bar queda ideal."
        ),
        Comentario(
            "Puntos negativos: el servicio es muy lento y los precios son un poco elevados."
        ),

    )

}

@Composable
fun ItemComentario(comentario: Comentario){
    Card(//border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.fillMaxWidth()
            //.width(400.dp)
           // .clickable { onItemSelected(cafeteria) },
        ,shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundCard
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        Column {

            Column (Modifier.padding(8.dp)){

                Text(
                    text = comentario.texto,
                    fontSize = 11.sp,
                    lineHeight = 13.sp
                )
            }//Cierra columna

        }//Column
    }//Card
}