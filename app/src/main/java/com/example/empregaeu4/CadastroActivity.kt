package com.example.empregaeu4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.databinding.ActivityCadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCadastroBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edNome = binding.edNome
        var edIdade = binding.edIdade
        var edSexo = binding.edSexo
        var btCadatrar = binding.button

        dbRef = FirebaseDatabase.getInstance().getReference("Administrador")
        btCadatrar.setOnClickListener{
            val empNome = edNome.text.toString()
            val empIdade = edIdade.text.toString()
            val empSexo = edSexo.text.toString()

            if(empNome.isEmpty()){
                edNome.error = "Por favor insira o nome"
            }
            if(empIdade.isEmpty()){
                edIdade.error = "Por favor insira a Idade"
            }
            if(empSexo.isEmpty()){
                edSexo.error = "Por favor insira o Sexo"
            }

            val empId = dbRef.push().key!!

            val Administrador = EmpresaModelo(empId, empNome, empIdade, empSexo
            )

            dbRef.child(empId).setValue(Administrador)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edNome.text.clear()
                    edIdade.text.clear()
                    edSexo.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }


        }
}