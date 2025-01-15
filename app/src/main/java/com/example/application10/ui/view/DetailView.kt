//package com.example.application10.ui.view
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.application10.model.Mahasiswa
//import com.example.application10.ui.viewmodel.DetailUiState
//import com.example.application10.ui.viewmodel.DetailViewModel
//import com.example.application10.ui.viewmodel.PenyediaViewModel
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetailView(
//    modifier: Modifier = Modifier,
//    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory),
//    onBack: () -> Unit,
//) {
//
//    Scaffold(
//        modifier = modifier,
//        topBar = {
//            TopAppBar(
//                title = { Text("Detail Mahasiswa") },
//                navigationIcon = {
//                    Button(onClick = onBack) {
//                        Text("Back")
//                    }
//                }
//            )
//        },
//    ) { innerPadding ->
//        StatusDetail(
//            detailUiState = viewModel.detailUiState,
//            retryAction = {viewModel.getMhsbyNim()},
//            modifier = Modifier.padding(innerPadding)
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState()),
//        )
//    }
//}
//
//
//@Composable
//fun StatusDetail(
//    detailUiState: DetailUiState,
//    modifier: Modifier = Modifier,
//    retryAction: () -> Unit,
//){
//    when(detailUiState) {
//        is DetailUiState.Success ->{
//            DetailMhsLayout(
//                mahasiswa = detailUiState.mahasiswa,
//                modifier = modifier
//            )
//        }
//        is DetailUiState.Loading -> OnLoading(modifier = Modifier)
//        is DetailUiState.Error -> OnError(message = detailUiState.message.message?:"Error", retryAction, modifier = Modifier.fillMaxSize())
//    }
//}
//
//@Composable
//fun DetailMhsLayout(
//    modifier: Modifier = Modifier,
//    mahasiswa: Mahasiswa,
//) {
//    Column (){
//        ItemDetailMhs(
//            mahasiswa = mahasiswa,
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.padding(8.dp))
//    }
//}
//
//
//@Composable
//fun ItemDetailMhs(
//    modifier: Modifier = Modifier,
//    mahasiswa: Mahasiswa
//){
//    Card(
//        modifier = modifier.fillMaxWidth(),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
//        )
//    ) {
//        Column (
//            modifier = Modifier.padding(16.dp)
//        ) {
//            ComponentDetailMhs(judul = "NIM", isinya = mahasiswa.nim)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "Nama Mahasiswa", isinya = mahasiswa.nama)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "Jenis Kelamin", isinya = mahasiswa.jenisKelamin)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "Alamat", isinya = mahasiswa.alamat)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "kelas", isinya = mahasiswa.kelas)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "Angkatan", isinya = mahasiswa.angkatan)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "Judul Skripsi", isinya = mahasiswa.judul)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "Dosen Pembimbing 1", isinya = mahasiswa.dosen1)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            ComponentDetailMhs(judul = "Dosen Pembimbing 2", isinya = mahasiswa.dosen2)
//            Spacer(modifier = Modifier.padding(4.dp))
//
//        }
//    }
//}
//
//
//
//@Composable
//fun ComponentDetailMhs(
//    modifier: Modifier = Modifier,
//    judul: String,
//    isinya: String,
//){
//    Column (
//        modifier = modifier.fillMaxWidth(),
//
//        horizontalAlignment = Alignment.Start
//    ) {
//        Text(
//            text = "$judul: ",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Gray
//        )
//        Text(
//            text = isinya,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
//}
