package com.example.mvvm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm2.model.anggotaList
import com.example.mvvm2.ui.theme.Mvvm2Theme
import com.example.mvvm2.view.daftarAnggota
import com.example.mvvm2.view.detailAnggota

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mvvm2Theme {
                val navController = rememberNavController()
                val anggotaViewModel: AnggotaViewModel = viewModel()

                NavHost(navController = navController, startDestination = NavDestination.List)
                {
                    composable(NavDestination.List)
                    {
                        daftarAnggota(anggotaList, onItemClicked = {
                            anggotaViewModel.setAnggota(it)
                            navController.navigate(NavDestination.Detail)
                        })
                    }
                    composable(NavDestination.Detail)
                    {
                        val anggota = anggotaViewModel.anggota.collectAsState().value
                        detailAnggota(anggota = anggota)
                    }
                }
            }
        }
    }
}
