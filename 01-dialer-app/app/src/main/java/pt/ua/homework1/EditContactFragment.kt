package pt.ua.homework1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import pt.ua.homework1.databinding.FragmentEditContactBinding
import pt.ua.homework1.model.User

class EditContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEditContactBinding>(inflater, R.layout.fragment_edit_contact, container, false)
        var userBefore : User? = null
        setFragmentResultListener("requestUserData") { key, bundle ->
            val user = bundle.getSerializable("data") as User
            userBefore = user
            binding.avatarImage.setImageResource(user.avatarImage)
            binding.nameView.text = user.name
            binding.phoneNumber.setText(user.phone)
        }

        binding.saveButton.setOnClickListener{ view : View ->
            val user = User(userBefore!!.id, binding.nameView.text.toString(), binding.phoneNumber.text.toString(), userBefore!!.avatarImage)
            setFragmentResult("saveUserData", bundleOf("data" to user))
            view.findNavController().popBackStack()
        }

        return binding.root
    }

}