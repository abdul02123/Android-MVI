package com.android.androidmvi.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.androidmvi.core.Resource
import com.android.androidmvi.databinding.ActivityMainBinding
import com.android.androidmvi.presentation.intent.ClickEvents
import com.android.androidmvi.presentation.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClick.setOnClickListener { viewModel.onEvent(ClickEvents.ShowResult) }
        bindObservers()
    }

    private fun bindObservers(){
        viewModel.result.observe(this){
            when(it){
                is Resource.Success->{
                    binding.tvDetail.text = it.data.toString()
                }
                is Resource.Error ->{
                    Toast.makeText(application, it.errorResponse?.message, Toast.LENGTH_LONG).show()
                }
                is Resource.Loading ->{

                }
            }
        }
    }
}