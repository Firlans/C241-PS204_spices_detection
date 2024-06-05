package com.capstone.herbs.ui.main

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.herbs.R
import com.capstone.herbs.databinding.ActivityMainBinding
import com.capstone.herbs.databinding.ActivityProfileBinding
import com.capstone.herbs.helper.SettingViewModelFactory
import com.capstone.herbs.ui.detail.DetailActivity
import com.capstone.herbs.ui.fragment.CameraFragment
import com.capstone.herbs.ui.fragment.HomeFragment
import com.capstone.herbs.ui.fragment.SettingFragment
import com.capstone.herbs.ui.setting.SettingPreferences
import com.capstone.herbs.ui.setting.SettingViewModel
import com.capstone.herbs.ui.setting.dataStore
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingSetting: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        bindingSetting = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pref = SettingPreferences.getInstance(application.dataStore)
        val settingViewModel = ViewModelProvider(this, SettingViewModelFactory(pref))[SettingViewModel::class.java]
        settingViewModel.getThemeSettings().observe(this) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                bindingSetting.switchTheme.isChecked = true

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                bindingSetting.switchTheme.isChecked = false
            }
        }



        val ButtonNavigation = binding.bottomNavigation
        ButtonNavigation.add(
            CurvedBottomNavigation.Model(1, "Home",R.drawable.ic_home)
        )
        ButtonNavigation.add(
            CurvedBottomNavigation.Model(2, "Camera",R.drawable.camera)
        )
        ButtonNavigation.add(
            CurvedBottomNavigation.Model(3, "Setting",R.drawable.setingakun)
        )
        ButtonNavigation.setOnClickMenuListener {
            when(it.id){
                1 ->{
                    replaceFragment(HomeFragment())
                }
                2->{
                    replaceFragment(CameraFragment())
                }
                3->{
                    replaceFragment(SettingFragment())
                }
            }
        }
        replaceFragment(HomeFragment())
        ButtonNavigation.show(1)



//        binding.LLjahe.setOnClickListener(this)
//        binding.LLLengkuas.setOnClickListener(this)
//        binding.LLKayumanis.setOnClickListener(this)
//        binding.LLKunyit.setOnClickListener(this)
//        binding.LLAndaliman.setOnClickListener(this)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.LLjahe->{
                val move = Intent(this@MainActivity,DetailActivity::class.java)
                move.putExtra(DetailActivity.TITLE,"Jahe")
                move.putExtra(DetailActivity.GAMBAR,"detail_jahe.png")
                move.putExtra(DetailActivity.MANFAAT,R.string.detail_jahe)
                move.putExtra(DetailActivity.OLAHAN, R.string.olahan_jahe)
                startActivity(move)
            }
            R.id.LLLengkuas->{
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.TITLE,"Lengkuas")
                intent.putExtra(DetailActivity.GAMBAR,"lengkuas.png")
                intent.putExtra(DetailActivity.MANFAAT,R.string.detail_lengkuas)
                intent.putExtra(DetailActivity.OLAHAN, R.string.olahan_lengkuas)
                startActivity(intent)
            }
            R.id.LLKayumanis->{
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.TITLE,"Kayu Manis")
                intent.putExtra(DetailActivity.GAMBAR,"kayumanis.png")
                intent.putExtra(DetailActivity.MANFAAT,R.string.manfaat_kayumanis)
                intent.putExtra(DetailActivity.OLAHAN,R.string.olahan_kayumanis)
                startActivity(intent)
            }
            R.id.LLKunyit->{
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.TITLE,"Kunyit")
                intent.putExtra(DetailActivity.GAMBAR,"kunyitt.png")
                intent.putExtra(DetailActivity.MANFAAT,R.string.manfaat_kunyit)
                intent.putExtra(DetailActivity.OLAHAN,R.string.olahan_kunyit)
                startActivity(intent)
            }
            R.id.LLAndaliman->{
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.TITLE,"Andaliman")
                intent.putExtra(DetailActivity.GAMBAR,"andaliman.png")
                intent.putExtra(DetailActivity.MANFAAT,R.string.manfaat_andaliman)
                intent.putExtra(DetailActivity.OLAHAN,R.string.olahan_andaliman)
                startActivity(intent)
            }
        }
    }
}