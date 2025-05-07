package br.com.alura.ondefica.repositories

import br.com.alura.ondefica.ui.uistates.AddressFormUiState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class AddressRepository(private val httpClient: HttpClient) {

    suspend fun findAddress(cep: String): AddressResponse {
        return httpClient
            .get("https://viacep.com.br/ws/$cep/json/")
            .body()
    }
}

@Serializable
class AddressResponse(
    private val logradouro: String,
    private val bairro: String,
    @SerialName("localidade")
    private val cidade: String,
    @SerialName("uf")
    private val estado: String
) {
    fun toAddressFormUiState() = AddressFormUiState(
        logradouro = logradouro,
        bairro = bairro,
        cidade = cidade,
        estado = estado,
        isLoading = false,
        isError = false
    )
}