package com.bigodecompany.lancadados

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bigodecompany.lancadados.databinding.FragmentThrowDiceBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ThrowDiceFragment : Fragment(), DiceView {

    private var binding: FragmentThrowDiceBinding? = null

    private val presenter = DicePresenter(this)

    private val imagesDiceSixFaces: TypedArray by lazy {
        resources.obtainTypedArray(R.array.dado_6_faces)
    }
    private val imagesDiceEightFaces: TypedArray by lazy {
        resources.obtainTypedArray(R.array.dado_8_faces)
    }

    private var imgFirstDice: ImageView? = null
    private var imgSecondDice: ImageView? = null
    private var txtPlayerName: TextView? = null
    private var btnPlay: Button? = null
    private var fabShare: FloatingActionButton? = null

    private var playerName: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThrowDiceBinding.inflate(inflater, container, false)

        txtPlayerName = binding?.txtPlayerName
        imgFirstDice = binding?.imgFirstDice
        imgSecondDice = binding?.imgSecondDice
        btnPlay = binding?.btnPlay
        fabShare = binding?.fabShare


        txtPlayerName?.text = getString(R.string.welcome, playerName)

        btnPlay?.setOnClickListener {
            val numberOfFaces = 6
            presenter.jogarDados(numberOfFaces)
        }

        fabShare?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_INTENT, "voce é sortudo!")
                setPackage("com.whatsapp")
                type = "text/plain"
            }

            activity?.packageManager?.run {
                if (intent.resolveActivity(this) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        context,
                        getString(R.string.share_fail),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        return binding?.root
    }


    override fun showFirstDiceSixFaces(diceId: Int) {
        imgFirstDice?.setImageDrawable(imagesDiceSixFaces.getDrawable(diceId))
    }

    override fun showSecondDiceSixFaces(diceId: Int) {
        imgSecondDice?.setImageDrawable(imagesDiceSixFaces.getDrawable(diceId))
    }

    override fun showFirstDiceEightFaces(diceId: Int) {
        imgFirstDice?.setImageDrawable(imagesDiceEightFaces.getDrawable(diceId))
    }

    override fun showSecondDiceEightFaces(diceId: Int) {
        imgSecondDice?.setImageDrawable(imagesDiceEightFaces.getDrawable(diceId))
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}