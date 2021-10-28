package com.github.gouravkhunger.fontizedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.gouravkhunger.fontize.Fontize
import com.github.gouravkhunger.fontizedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fontize(this).setDefaultFont(R.font.irish_grover)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            switchToIrish.setOnClickListener {
                Fontize(this@MainActivity).updateFont(R.font.irish_grover)
                recreate()
            }
            switchToSourceCode.setOnClickListener {
                Fontize(this@MainActivity).updateFont(R.font.source_code_pro)
                recreate()
            }
            switchZenOld.setOnClickListener {
                Fontize(this@MainActivity).updateFont(R.font.zen_old_mincho)
                recreate()
            }
        }
    }
}
