package uz.digital.retrofit103

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.digital.retrofit103.databinding.FragmentSecondBinding
import uz.digital.retrofit103.model.Data
import uz.digital.retrofit103.model.OneUserResponse
import uz.digital.retrofit103.network.RetroInstance

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        RetroInstance.apiService().getUserById(1).enqueue(object : Callback<OneUserResponse> {
            override fun onResponse(
                call: Call<OneUserResponse>,
                response: Response<OneUserResponse>
            ) {
                editText.setText(response.body()?.data?.first_name)
            }

            override fun onFailure(call: Call<OneUserResponse>, t: Throwable) {

            }
        })
         updateUser()
    }

    private fun updateUser() {
        RetroInstance.apiService().postUser(Data("https://image", "", "",2, "")).enqueue(object : Callback<OneUserResponse> {
            override fun onResponse(
                call: Call<OneUserResponse>,
                response: Response<OneUserResponse>
            ) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<OneUserResponse>, t: Throwable) {

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}