package com.example.ooo

import android.R.attr.top
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun MainPage() {

    var firNum by remember { mutableStateOf("") }
    var secNum by remember { mutableStateOf("") }
    var thirNum by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF333333),
                modifier = Modifier.height(60.dp)
            ) {
                IconButton(
                    onClick =
                        { /* 홈 이동 */ },
                    modifier = Modifier.padding(start = 91.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "홈 버튼",
                        tint = Color.White,
                        modifier = Modifier
                            .width(206.dp)
                            .height(36.dp)
                    )
                }

                IconButton(
                    onClick =
                        { /* 마이페이지 이동 */ },
                    modifier = Modifier.padding(start = 91.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "홈 버튼",
                        tint = Color.White,
                        modifier = Modifier
                            .width(206.dp)
                            .height(36.dp)
                    )
                }
            }
        }
    ) { paddingValues ->

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF333333))
                .padding(paddingValues)
        ) {
            val (firstNum, seconNum, thirdNum, searchButton, red, yellow, green, infoMessage) = createRefs()

            //전화번호 첫번째 입력 텍스트 박스
            OutlinedTextField(
                value = firNum,
                onValueChange = { firNum = it },
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
                    .constrainAs(firstNum) {
                        bottom.linkTo(searchButton.top, margin = 57.dp)
                        end.linkTo(seconNum.start, margin = 20.dp)
                    },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black
                )
            )

            //전화번호 두번째 입력 텍스트 박스
            OutlinedTextField(
                value = secNum,
                onValueChange = { secNum = it },
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
                    .constrainAs(seconNum) {
                        bottom.linkTo(searchButton.top, margin = 57.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black
                )
            )

            //전화번호 세번째 입력 텍스트 박스
            OutlinedTextField(
                value = thirNum,
                onValueChange = { thirNum = it },
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
                    .constrainAs(thirdNum) {
                        bottom.linkTo(searchButton.top, margin = 57.dp)
                        start.linkTo(seconNum.end, margin = 20.dp)
                    },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black
                )
            )

            Button(
                onClick = { /* Todo */ },
                modifier = Modifier
                    .constrainAs(searchButton) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x50FFFFFF),
                    contentColor = Color.Black
                )
            ) {
                Text("검 색")
            }

            //원 크기 기준
            val circleSize = 90.dp
            // 빨간 원
            Button(
                onClick = { /* 클릭 시 */ },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF5F57)
                ),
                modifier = Modifier
                    .size(circleSize)
                    .constrainAs(red) {
                        top.linkTo(searchButton.bottom, margin = 57.dp)
                        end.linkTo(yellow.start, margin = 30.dp)
                    }
            ) { } // 버튼 내 콘텐츠(텍스트, 아이콘)

            // 노란 원
            Button(
                onClick = { /* 클릭 시 */ },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF554720)
                ),
                modifier = Modifier
                    .size(circleSize)
                    .constrainAs(yellow) {
                        top.linkTo(searchButton.bottom, margin = 57.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) { } // 버튼 내 콘텐츠(텍스트, 아이콘)

            //초록 원(버튼)
            Button(
                onClick = { /* 클릭 시 */ },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3A5A3A)
                ),
                modifier = Modifier
                    .size(circleSize)
                    .constrainAs(green) {
                        top.linkTo(searchButton.bottom, margin = 57.dp)
                        start.linkTo(yellow.end, margin = 30.dp)
                    }
            ) { } // 버튼 내 콘텐츠(텍스트, 아이콘)

            Text(
                text = "연락처에 등록된 번호외에 전화를 다 차단합니다",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .constrainAs(infoMessage) {
                        top.linkTo(searchButton.bottom, margin = 204.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

        }


    }
}