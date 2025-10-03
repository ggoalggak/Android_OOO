package com.example.ooo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout



@Preview
@Composable
fun Loginpage(){
    var idText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff333333))
    ) {
        val (redOff, yellowOff, greenOn, textId, idEdit, textPassword, passwordEdit, createAccount, accountFind, loginButton) = createRefs()

        //삼색 원
        val circleSize = 60.dp
        Box(
            modifier = Modifier
                .size(circleSize)
                .background(Color(0xFF67413E), CircleShape)
                .constrainAs(redOff) {
                    top.linkTo(parent.top, margin = 200.dp)
//                    start.linkTo(parent.start, margin = 90.dp)
                    end.linkTo(yellowOff.start, margin = 15.dp)
//                    start.linkTo(parent.start, margin = 90.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(circleSize)
                .background(Color(0xFF554720), CircleShape)
                .constrainAs(yellowOff){
                    top.linkTo(parent.top, margin = 200.dp)
                    //원 가운데 정렬
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
//                    start.linkTo(parent.start, margin = 165.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(circleSize)
                .background(Color(0xff26C940), CircleShape)
                .constrainAs(greenOn){
                    top.linkTo(parent.top, margin = 200.dp)
                    start.linkTo(yellowOff.end, margin = 15.dp)
//                    end.linkTo(parent.end, margin = 90.dp)
                }
        )
        // 3개의 원 그룹 지어 간격 조정
//        createHorizontalChain(redOff, yellowOff, greenOn, chainStyle = ChainStyle.Packed)

        Text(
            text = "아이디",
            color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.constrainAs(textId){
                top.linkTo(parent.top, margin = 345.dp)
                start.linkTo(parent.start, margin = 57.dp)
            }
        )

        OutlinedTextField(
            value = idText,
            onValueChange = {idText = it},
            modifier = Modifier
                .constrainAs(idEdit){
                    top.linkTo(parent.top, margin = 381.dp)
                    start.linkTo(parent.start, margin = 82.dp)
                    end.linkTo(parent.end, margin = 82.dp)
                },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedTextColor = Color.Black
            )
        )

        Text(
            text = "비밀번호",
            color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.constrainAs(textPassword){
                top.linkTo(parent.top, margin = 441.dp)
                start.linkTo(parent.start, margin = 57.dp)
            }
        )

        OutlinedTextField(
            value = passwordText,
            onValueChange = {passwordText = it},
            modifier = Modifier
                .constrainAs(passwordEdit){
                    top.linkTo(parent.top, margin = 471.dp)
                    start.linkTo(parent.start, margin = 82.dp)
                    end.linkTo(parent.end, margin = 82.dp)
                },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedTextColor = Color.Black
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Text(
            text = "회원가입",
            color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.constrainAs(createAccount){
                top.linkTo(parent.top, margin = 533.dp)
                start.linkTo(parent.start, margin = 57.dp)
            }
        )

        Text(
            text = "아이디/비밀번호 찾기",
            color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.constrainAs(accountFind){
                top.linkTo(parent.top, margin = 533.dp)
                end.linkTo(parent.end, margin = 57.dp)
            }
        )

        Button(
            onClick = { /* todo */},
            modifier = Modifier
                .constrainAs(loginButton){
                    top.linkTo(parent.top, margin = 570.dp)
                    start.linkTo(parent.start, margin = 57.dp)
                    end.linkTo(parent.end, margin = 57.dp)
                    width = androidx.constraintlayout.compose.Dimension.fillToConstraints
                },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x30FFFFFF),
                contentColor = Color.White
            )
        ) {
            Text("로그인")

        }
    }

 }