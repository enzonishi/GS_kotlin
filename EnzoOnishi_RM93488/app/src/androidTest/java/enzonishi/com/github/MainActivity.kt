package enzonishi.com.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {

    private lateinit var praiaAdapter: PraiaAdapter
    private val praiaList = mutableListOf<Praia>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnIncluir: Button
    private lateinit var nomePraia: AppCompatEditText
    private lateinit var cidade: AppCompatEditText
    private lateinit var estado: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        btnIncluir = findViewById(R.id.btn_incluir)
        nomePraia = findViewById(R.id.nome_praia)
        cidade = findViewById(R.id.cidade)
        estado = findViewById(R.id.estado)

        praiaAdapter = PraiaAdapter(praiaList)
        recyclerView.adapter = praiaAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnIncluir.setOnClickListener {
            val nomePraiaText = nomePraia.text.toString()
            val cidadeText = cidade.text.toString()
            val estadoText = estado.text.toString()

            if (nomePraiaText.isEmpty() || cidadeText.isEmpty() || estadoText.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val praia = Praia(nomePraiaText, cidadeText, estadoText)
            praiaList.add(praia)
            praiaAdapter.notifyItemInserted(praiaList.size - 1)
        }
    }
}