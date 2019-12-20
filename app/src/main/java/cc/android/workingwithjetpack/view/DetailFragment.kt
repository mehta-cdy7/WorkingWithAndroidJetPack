package cc.android.workingwithjetpack.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import cc.android.workingwithjetpack.R
import cc.android.workingwithjetpack.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    private var dogUuid = 0;
    private var ageUuid = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel();


    }

    private fun observeViewModel() {

        viewModel.dogLiveData.observe(this, Observer { dog ->
            dog?.let {
                dogName.text = it.dogBreed
                dogPurpose.text = it.breedFor
                dogTemperament.text = it.temperament
                dogLifespan.text = it.lifespan
            }

        })

    }

}
