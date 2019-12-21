package cc.android.workingwithjetpack.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cc.android.workingwithjetpack.R
import cc.android.workingwithjetpack.model.DogBreed
import cc.android.workingwithjetpack.utils.getProgressDrawables
import cc.android.workingwithjetpack.utils.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    fun updateDogList(newDogList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dogsList.size
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifespan.text = dogsList[position].lifespan

        holder.view.setOnClickListener(View.OnClickListener {
             Navigation.findNavController(it).navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        })

        holder.view.mImageView.loadImage( dogsList[position].imageURL , getProgressDrawables(holder.view.mImageView.context))

    }

    class DogViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}