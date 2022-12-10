package com.ema.dummyjson.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ema.dummyjson.data.Resource
import com.ema.dummyjson.data.api_provider.APIProvider
import com.ema.dummyjson.databinding.FragmentProductsBinding
//https://dummyjson.com/

class ProductsFragment : Fragment() {
    private lateinit var binding: FragmentProductsBinding
    lateinit var adapter: ProductsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        // return inflater.inflate(R.layout.fragment_products, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

    }

    private fun setupRecyclerView(){
        adapter = ProductsAdapter(requireContext(), mutableListOf())

        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(requireContext(),2)
    }

    override fun onResume() {
        loadProducts()
        super.onResume()
    }

    private fun loadProducts(){
        APIProvider.instance.getAllProducts {
            when(it){
                is Resource.Success->{
                    adapter.updateProduct(it.result.toMutableList())
                    adapter.notifyDataSetChanged()
                }
                else -> {Toast.makeText(requireContext(),"access denied",Toast.LENGTH_LONG).show()}
            }
        }
    }


}