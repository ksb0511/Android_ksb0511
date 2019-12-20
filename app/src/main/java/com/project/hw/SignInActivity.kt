package com.project.hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.project.hw.main_list.MainListActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val loginID = intent.getStringExtra("loginID")
        val loginPW = intent.getStringExtra("loginPW")

        sign_in_id.setText(loginID)
        sign_in_password.setText(loginPW)
        makeController()
    }

    private fun makeController(){
        sign_in_sign_up.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val intent = Intent(this@SignInActivity, SignUpActivity::class.java)

                    startActivity(intent)
                }
            }
        )

        sign_in_login.setOnClickListener{
            val id = sign_in_id.text.toString()
            val pw = sign_in_password.text.toString()

            if(id.isEmpty()||pw.isEmpty()){
                Toast.makeText(this, "아이디나 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val response = requestLogin(id, pw)
            if(response){
                val intent = Intent(this, MainListActivity::class.java)

                intent.putExtra("login", id)

                startActivity(intent)
            }
            else{
                Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                sign_in_id.requestFocus()
            }
        }
    }

    private fun requestLogin(id:String, pw:String):Boolean {
        return true;//일단은 전부 로그인 가능하게..
    }
}