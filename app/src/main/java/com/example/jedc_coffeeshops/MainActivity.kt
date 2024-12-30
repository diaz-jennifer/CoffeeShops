package com.example.jedc_coffeeshops

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jedc_coffeeshops.model.Rutas
import com.example.jedc_coffeeshops.ui.theme.JEDC_CoffeeShopsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JEDC_CoffeeShopsTheme {
                val myDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed) //estado del ModalDrawer
                MyModalDrawer(myDrawerState) {
                    Scaffold(modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar(myDrawerState) }) { innerPadding ->
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = Rutas.Main.route){
                            composable(Rutas.Main.route){ Principal(navController) }
                            composable(/*"Comentarios/{nomCafeteria}"*/
                                Rutas.Comentarios.route){
                                    backStackEntry ->
                                Comentarios(navController, backStackEntry.arguments?.getString("nomCafeteria")!!) }

                        }
                        Column (modifier = Modifier.padding(innerPadding)
                        ){
                            //Principal()
                            //Comentarios()
                        }
                    }
                }

            }
        }
    }
}

