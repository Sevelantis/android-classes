package pt.ua.homework1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import pt.ua.homework1.databinding.FragmentKeypadBinding
import pt.ua.homework1.model.User

class KeypadFragment : Fragment() {

    var userDB = mutableListOf(
        User(0, "Hacker Man", "", R.drawable.avatar_hacker),
        User(1, "Beard Man", "", R.drawable.avatar_beardman),
        User(2, "Gamer Man", "", R.drawable.avatar_gamer),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentKeypadBinding>(inflater, R.layout.fragment_keypad, container, false)

        val oneButton = binding.oneButton
        val twoButton = binding.twoButton
        val threeButton = binding.threeButton
        val fourButton = binding.fourButton
        val fiveButton = binding.fiveButton
        val sixButton = binding.sixButton
        val sevenButton = binding.sevenButton
        val eightButton = binding.eightButton
        val nineButton = binding.nineButton
        val plusButton = binding.plusButton
        val zeroButton = binding.zeroButton
        val hashButton = binding.hashButton
        val speedDialOneButton = binding.speedDialOneButton
        val speedDialTwoButton = binding.speedDialTwoButton
        val speedDialThreeButton = binding.speedDialThreeButton
        val backspaceButton = binding.backspaceButton
        val callButton = binding.callButton
        val numberView = binding.numberView

        Dexter.withContext(this.context)
            .withPermission(Manifest.permission.CALL_PHONE)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                    //
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {
                    //
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    //
                }
            }).check()

        var text="";
        oneButton.setOnClickListener {
            text += "1"
            numberView.text = text
        }
        twoButton.setOnClickListener {
            text += "2"
            numberView.text = text
        }
        threeButton.setOnClickListener {
            text += "3"
            numberView.text = text
        }
        fourButton.setOnClickListener {
            text += "4"
            numberView.text = text
        }
        fiveButton.setOnClickListener {
            text += "5"
            numberView.text = text
        }
        sixButton.setOnClickListener {
            text += "6"
            numberView.text = text
        }
        sevenButton.setOnClickListener {
            text += "7"
            numberView.text = text
        }
        eightButton.setOnClickListener {
            text += "8"
            numberView.text = text
        }
        nineButton.setOnClickListener {
            text += "9"
            numberView.text = text
        }
        plusButton.setOnClickListener {
            text += "+"
            numberView.text = text
        }
        zeroButton.setOnClickListener {
            text += "0"
            numberView.text = text
        }
        hashButton.setOnClickListener {
            text += "#"
            numberView.text = text
        }
        backspaceButton.setOnClickListener {
            if (text.isNotEmpty()) {
                text = text.dropLast(1)
            }
            numberView.text = text
        }
        callButton.setOnClickListener {
            call(numberView.text.toString())
        }
        speedDialOneButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_keypadFragment_to_editContactFragment)
        }
        speedDialTwoButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_keypadFragment_to_editContactFragment)
        }
        speedDialThreeButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_keypadFragment_to_editContactFragment)
        }

        speedDialOneButton.setOnLongClickListener { view : View ->
            val user = userDB[0]
            setFragmentResult("requestUserData", bundleOf("data" to user))
            view.findNavController().navigate(R.id.action_keypadFragment_to_editContactFragment)
            return@setOnLongClickListener true
        }
        speedDialTwoButton.setOnLongClickListener { view : View ->
            val user = userDB[1]
            setFragmentResult("requestUserData", bundleOf("data" to user))
            view.findNavController().navigate(R.id.action_keypadFragment_to_editContactFragment)
            return@setOnLongClickListener true
        }
        speedDialThreeButton.setOnLongClickListener { view : View ->
            val user = userDB[2]
            setFragmentResult("requestUserData", bundleOf("data" to user))
            view.findNavController().navigate(R.id.action_keypadFragment_to_editContactFragment)
            return@setOnLongClickListener true
        }

        setFragmentResultListener("saveUserData") { key, bundle ->
            val user = bundle.getSerializable("data") as User
            userDB[user.id] = user
            speedDialOneButton.text = userDB[0].phone
            speedDialTwoButton.text = userDB[1].phone
            speedDialThreeButton.text = userDB[2].phone
        }
        speedDialOneButton.setOnClickListener {
            text = userDB[0].phone
            numberView.text = text
        }
        speedDialTwoButton.setOnClickListener {
            text = userDB[1].phone
            numberView.text = text
        }
        speedDialThreeButton.setOnClickListener {
            text = userDB[2].phone
            numberView.text = text
        }

        speedDialOneButton.text = userDB[0].phone
        speedDialTwoButton.text = userDB[1].phone
        speedDialThreeButton.text = userDB[2].phone
        return binding.root
    }


    private fun call(number : String){
        val dial = "tel:$number"
        if (ActivityCompat.checkSelfPermission(this.requireContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return
        }
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
    }


}