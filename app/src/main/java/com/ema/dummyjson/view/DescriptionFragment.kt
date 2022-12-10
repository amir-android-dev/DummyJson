package com.ema.dummyjson.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ema.dummyjson.R
import com.ema.dummyjson.databinding.FragmentDescriptionBinding
import com.squareup.picasso.Picasso


class DescriptionFragment : Fragment() {
    lateinit var binding: FragmentDescriptionBinding
    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTheValuesFromProductFragment()
    }

    private fun getTheValuesFromProductFragment(){
        binding.tvDescription.text = args.description
        binding.tvPrice.text=args.price.toString()
        binding.tvBrand.text = args.brnad
        binding.rbRating.rating = args.rating
        binding.tvDiscount.text = args.discount.toString()
        binding.ivImage
        Picasso.get().load(args.image[0]).into(binding.ivImage)


    }


}