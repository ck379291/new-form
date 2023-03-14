package com.example.newform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.MenuCompat
import com.example.newform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener {
    val list: ArrayList<String> = ArrayList()
    var gender: String? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chaimenu,menu)
        return super.onCreateOptionsMenu(menu)

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.item1
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when(item.itemId){
//            R.id.item1.about->{
////                val intent=Intent(this,about::class.java)
//                val intent=Intent(this,about::class.java)
//                startActivity(intent)
//                return true
//            }
////            R.id.item2.exit->{
////                finish()
////                System.exit(0)
////                Toast.makeText(this,"exit",Toast.LENGTH_SHORT).show()
////                startActivity(intent)
////            }
//
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnsubmit.setOnClickListener(this)
        binding.radiogroup.setOnCheckedChangeListener(this)
        binding.codding.setOnCheckedChangeListener(this)
        binding.cricket.setOnCheckedChangeListener(this)
        binding.programm.setOnCheckedChangeListener(this)
        binding.nobel.setOnCheckedChangeListener(this)
        val lst=list.toString().replace("["," ").replace("]"," ")

    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnsubmit -> {
                if (binding.firstname.text!!.isEmpty() && binding.lastnamr.text!!.isEmpty() && binding.mobile1.editableText!!.isEmpty() && binding.mobile2.editableText!!.isEmpty() && binding.email.text!!.isEmpty()) {
                    binding.firstname.requestFocus()
                    Toast.makeText(this, "enter your all information", Toast.LENGTH_SHORT).show()
                } else if (binding.firstname.text!!.isEmpty()) {
                    binding.firstname.requestFocus()
                    Toast.makeText(this, "enter your first name", Toast.LENGTH_SHORT).show()
                } else if (binding.lastnamr.text!!.isEmpty()) {
                    binding.firstname.requestFocus()
                    Toast.makeText(this, "enter your last name", Toast.LENGTH_SHORT).show()
                } else if (binding.mobile1.editableText!!.isEmpty()) {
                    binding.mobile1.requestFocus()
                    Toast.makeText(this, "enter your number name", Toast.LENGTH_SHORT).show()
                } else if (binding.mobile2.editableText!!.isEmpty()) {
                    binding.mobile2.requestFocus()
                    Toast.makeText(this, "enter your alternative number name", Toast.LENGTH_SHORT).show()
                }
                else if (binding.email.text!!.isEmpty()){
                    binding.email.requestFocus()
                    Toast.makeText(this,"enter your email ",Toast.LENGTH_SHORT).show()
                }
                else if (binding.firstname.text!!.isNotEmpty() && binding.lastnamr.text!!.isNotEmpty() && binding.mobile1.editableText!!.isNotEmpty() && binding.mobile2.editableText!!.isNotEmpty() && binding.email.text!!.isNotEmpty()){
                    val intent=Intent(this,useroutput::class.java)
                    val lst=list.toString().replace("["," ").replace("]"," ")
                    val ufirstname=binding.firstname.editableText.toString()
                    val ulastname=binding.lastnamr.editableText.toString()
                    val umobile1=binding.mobile1.editableText.toString()
                    val umobile2=binding.mobile2.editableText.toString()
                    val uemail=binding.email.editableText.toString()
                    intent.putExtra("firstname",ufirstname)
                    intent.putExtra("lastname",ulastname)
                    intent.putExtra("email", uemail)
                    intent.putExtra("number",umobile1)
                    intent.putExtra("alternative",umobile2)
                    intent.putExtra("gender",gender)
                    intent.putExtra("hobbies",lst)
                    startActivity(intent)
                }

            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(group?.checkedRadioButtonId){
            R.id.male->{
                val radiomale=findViewById<RadioButton>(checkedId)
                gender=radiomale.text.toString()
            }
            R.id.male->{
                val radiofemale=findViewById<RadioButton>(checkedId)
                gender=radiofemale.text.toString()
            }
            R.id.male->{
                val radiotrans=findViewById<RadioButton>(checkedId)
                gender=radiotrans.text.toString()
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.cricket->{
                if (binding.cricket.isChecked){
                    list.add(binding.cricket.text.toString())
                }
                else{
                    list.remove(binding.cricket.text.toString())
                }
            }
            R.id.codding->{
                if (binding.codding.isChecked){
                    list.add(binding.codding.text.toString())
                }
                else{
                    list.remove(binding.codding.text.toString())
                }
            }
            R.id.programm->{
                if (binding.programm.isChecked){
                    list.add(binding.programm.text.toString())
                }
                else{
                    list.remove(binding.programm.text.toString())
                }
            }
            R.id.nobel->{
                if (binding.nobel.isChecked){
                    list.add(binding.nobel.text.toString())
                }
                else{
                    list.remove(binding.nobel.text.toString())
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
