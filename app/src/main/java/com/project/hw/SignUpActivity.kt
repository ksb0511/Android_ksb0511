package com.project.hw

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        makeController()
    }

    private fun makeController(){
        sign_up_sign_up.setOnClickListener {
            val name = sign_up_name.text.toString()
            val id = sign_up_id.text.toString()
            val pw = sign_up_password.text.toString()
            val pw2 = sign_up_password_check.text.toString()

            if (name.isEmpty() || id.isEmpty() || pw.isEmpty() || pw2.isEmpty()) {
                Toast.makeText(this, "내용을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pw != pw2) {
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val response = requestSignup(name, id, pw)

            if (response) {
                // 회원가입에 성공했을 경우
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("loginID", id)
                intent.putExtra("loginPW", pw)
                setResult(Activity.RESULT_OK, intent) // StartActivityForResult
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun requestSignup(name: String, id: String, pw:String): Boolean {
        return true
    }
}
