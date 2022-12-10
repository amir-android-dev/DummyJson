package com.ema.dummyjson.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ema.dummyjson.databinding.FragmentDescriptionBinding
import com.squareup.picasso.Picasso


class DescriptionFragment : Fragment() {
    lateinit var binding: FragmentDescriptionBinding
    private val args: DescriptionFragmentArgs by navArgs()
    var currentIndex: Int = 0


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
        setupImageSwitcher()
    }

    private fun getTheValuesFromProductFragment() {
        binding.tvDescription.text = args.description
        binding.tvPrice.text = args.price.toString()
        binding.tvBrand.text = args.brnad
        binding.rbRating.rating = args.rating
        binding.tvDiscount.text = args.discount.toString()
        binding.ivSwitcherImage
        Picasso.get().load(args.image[0]).into(binding.ivSwitcherImage)
    }


   private fun setupImageSwitcher(){

        binding.ivForward.setOnClickListener {
            currentIndex++
            if(currentIndex==args.image.size){
                currentIndex=0
            }
            Picasso.get().load(args.image[currentIndex]).into(binding.ivSwitcherImage)
        }

        binding.ivBack.setOnClickListener {
            currentIndex--
            if (currentIndex == -1) {
                currentIndex = args.image.size - 1
            }
            val imageForChange = args.image[currentIndex]
            Picasso.get().load(imageForChange).into(binding.ivSwitcherImage)

        }
    }


}