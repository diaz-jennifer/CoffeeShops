package com.example.jedc_coffeeshops

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jedc_coffeeshops.model.Cafeteria
import com.example.jedc_coffeeshops.model.Rutas

import com.example.jedc_coffeeshops.ui.theme.backgroundCard
import com.example.jedc_coffeeshops.ui.theme.backgroundTopBar
import com.example.jedc_coffeeshops.ui.theme.colorEstrellas
import com.example.jedc_coffeeshops.ui.theme.deckledFamily
import com.example.jedc_coffeeshops.ui.theme.primaryDark
import com.example.jedc_coffeeshops.ui.theme.watermelonFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Principal(navController: NavHostController){

    var estadoExpanded by rememberSaveable { mutableStateOf(false) }
    val opciones = listOf("Opción 1", "Opción 2")
    var estadoTextField by remember { mutableStateOf("") }


    Column (Modifier.padding(top=90.dp)){
        //Row que contiene ExposedDropdownMenu con dos opciones
        Row (Modifier.height(80.dp).fillMaxWidth().wrapContentWidth()){
            ExposedDropdownMenuBox(
                expanded = estadoExpanded,
                onExpandedChange = { estadoExpanded = !estadoExpanded },
                modifier = Modifier.weight(1f)
            ){
                TextField(
                    modifier = Modifier.fillMaxWidth().menuAnchor(),
                    readOnly = true,
                    value = "List of CoffeeShops",
                    onValueChange = {},
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        unfocusedContainerColor = backgroundTopBar,
                        focusedContainerColor = backgroundTopBar
                    ),
                    textStyle = TextStyle(
                        fontFamily = deckledFamily,
                        fontSize = 35.sp,
                        color = Color.Black,
                    )
                )//Cierra TextField
                ExposedDropdownMenu(
                    expanded = estadoExpanded,
                    onDismissRequest = {estadoExpanded = false},
                    modifier = Modifier.fillMaxWidth()
                ){
                    opciones.forEach {
                            option ->
                        DropdownMenuItem(
                            text = { Text(text = option) },
                            onClick = {
                                estadoTextField = option
                                estadoExpanded = false
                            },
                            //  modifier = Modifier.fillMaxWidth()
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )//Cierra DropdownMenuItem
                    }
                }//Cierra ExposedDropdownMenu
            }//Cierra ExposedDropDownMenuBox
        }//Cierra Row

      //  MySpacer(10)
        //LazyColumn que muestra los cards de las cafeterías
        LazyColumn (modifier = Modifier.padding(13.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)){
            items(getCafeteria()){
                    itemcafe -> ItemCafeteria (cafeteria = itemcafe){
                navController.navigate(/*"Comentarios/${itemcafe.nombre}"*/
                    Rutas.Comentarios.creaRutaConParametro(nomCafeteria = itemcafe.nombre))
            }
            }
        }
    }
}

fun getCafeteria(): List<Cafeteria>{
    return listOf(
        Cafeteria(
            "Antico Caffe Greco",
            "Calle Italia, 20 Roma",
            R.drawable.img03
        ),
        Cafeteria(
            "Coffee Room",
            "Calle Room, 56 Valencia",
            R.drawable.img06
        ),
        Cafeteria(
            "Café Soret",
            "Calle Campoamor, 102, Valencia",
            R.drawable.img01
        ),
        Cafeteria(
            "Le Petit Cafe",
            "Plaza Juez Borrull, 27, Castelló de la plana",
            R.drawable.img02
        ),
        Cafeteria(
            "Café del Art",
            "Plaza Cascorro, 9, Madrid",
            R.drawable.img04
        ),
        Cafeteria(
            "My Sweet",
            "Av. Castalia, 46, Castelló",
            R.drawable.img05
        ),

    )
}
//Función que crea el card de cada cafetería
@Composable
fun ItemCafeteria(cafeteria: Cafeteria, onItemSelected: (Cafeteria)->Unit){
    val configuration = LocalConfiguration.current
    val size1: Int
    val letraCafeteria: Int


    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            size1 = 400
            letraCafeteria = 40
        }
        else ->{
            size1 = 200
            letraCafeteria = 30
        }
    }
    var estadoEstrellas by rememberSaveable { mutableStateOf(0f) }
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable { onItemSelected(cafeteria) },
         shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundCard
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ){
        Column {
            Image(
                painter = painterResource(id=cafeteria.photo),
                contentDescription = "foto cafetería ${cafeteria.nombre}",
                modifier = Modifier.fillMaxWidth().size(size1.dp),
                contentScale = ContentScale.Crop //Hará que ocupe todo el ancho y crezca lo que necesite
            )
            Column (Modifier.padding(20.dp)){
                MySpacer(10)
                Text(
                    text = cafeteria.nombre,
                    fontFamily = watermelonFamily,
                    fontSize = letraCafeteria.sp,
                    color = Color.Black,

                )
                MySpacer(25)
                RatingBar(
                    value = estadoEstrellas,
                    onValueChange = {estadoEstrellas = it}
                )
                MySpacer(40)
                Text(
                    text = cafeteria.direccion,
                    // modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 16.sp
                )
            }//Cierra columna de textos y ratingBar

            HorizontalDivider(
                thickness = 2.dp
            )

            Button(onClick = {},
                modifier = Modifier.fillMaxWidth().height(55.dp),
                shape = RectangleShape,
                colors=ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = backgroundTopBar
                )
            ) {
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically){
                    Text("RESERVE")
                }

            }
        }//Column
    }//Card
}

//función que crea el TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(estadoDrawer: DrawerState){
    val corutina = rememberCoroutineScope()
    TopAppBar(title = { Text("CoffeeShops", fontWeight = FontWeight.Medium) },

        navigationIcon = {
            IconButton(onClick = {
                corutina.launch {
                    estadoDrawer.apply {
                        if(isClosed) open() else close()
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "icono menu")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.MoreVert,
                    contentDescription = "icono opciones")
            }
        },
        colors =  TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundTopBar,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ))
}

//Función que coloca espacios
@Composable
fun MySpacer(medida: Int){
    Spacer(modifier = Modifier.width(medida.dp).height(medida.dp))
}
//función que crea una icono de estrella rellenado o vacío
@Composable
fun Star(filled: Boolean) {
    Icon(
        imageVector = if (filled) Icons.Filled.Star else Icons.Outlined.StarOutline,
        contentDescription = "Star",
       // modifier = Modifier.size(50.dp),
        tint = if(filled) primaryDark else colorEstrellas
    )
}
//Función que crea el ratingbar de 5 estrellas por defecto
@Composable
fun RatingBar(
    stars: Int=5,
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Row {
        repeat(stars) { indice ->
            val isFilled = indice < value
            Box(
                modifier = Modifier.clickable {
                    onValueChange(indice + 1f)
                }
            ) {
                Star(filled = isFilled)
            }
            MySpacer(20)
        }

    }
}

//Header sólo con imagen
@Preview(showBackground = true)
@Composable
fun NavBarHeader(){
    Column (modifier = Modifier.fillMaxWidth().height(160.dp),

        ){
        Image(painter = painterResource(id=R.drawable.img08),
            contentDescription = "imagen del header",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
    }
}

//Función MODALDRAWER:
@Composable
fun MyModalDrawer(
    estadoDrawer: DrawerState,
    contenido: @Composable () -> Unit
){
    val corutina = rememberCoroutineScope()
    val sections = listOf("Build", "Info", "Email")
    val iconos = listOf(Icons.Filled.Build, Icons.Filled.Info,Icons.Filled.Email)

    val listaPares = sections.zip(iconos)

    ModalNavigationDrawer(
        drawerState = estadoDrawer,
        gesturesEnabled = true,//en true se cierra si se hace click fuera, en false, se mantiene abierto
       // modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
        drawerContent = {
            ModalDrawerSheet (drawerContainerColor = Color.White,
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
               // windowInsets = WindowInsets.navigationBars,
                //drawerShape = RoundedCornerShape(topEndPercent = 5)
            ){
                NavBarHeader()
                MySpacer(5)
                Column (Modifier.verticalScroll(rememberScrollState())){
                    listaPares.forEach {
                            (section, icono) ->
                        NavigationDrawerItem(
                            label = { Text(text = section) },
                            selected = false,
                            onClick = {

                            },
                            icon = { Icon(imageVector = icono, contentDescription = "icono $section") },
                            colors = NavigationDrawerItemDefaults.colors(
                                unselectedContainerColor = Color.White,
                            ),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                        )
                    }
                    NavigationDrawerItem(
                        label = { Text(text = "Cerrar") },
                        selected = false,
                        onClick = {
                            corutina.launch {
                                estadoDrawer.apply {
                                    if(isClosed) open() else close()
                                }
                            }
                        },
                        icon = { Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "icono exit") },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = Color.White,
                        ),
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )

                }//fin de column
            }//fin ModalDrawerSheet
        },//fin drawerContent

    ) {
        contenido()
    }
}