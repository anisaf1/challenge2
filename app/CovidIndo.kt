
import com.google.gson.annotations.SerializedName

class CovidIndo : ArrayList<CovidIndoItem>(){
    data class CovidIndoItem(
        @SerializedName("attributes")
        val attributes: Attributes,
        @SerializedName("dirawat")
        val dirawat: String,
        @SerializedName("meninggal")
        val meninggal: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("positif")
        val positif: String,
        @SerializedName("sembuh")
        val sembuh: String
    ) {
        data class Attributes(
            @SerializedName("FID")
            val fID: Int,
            @SerializedName("Kasus_Meni")
            val kasusMeni: Int,
            @SerializedName("Kasus_Posi")
            val kasusPosi: Int,
            @SerializedName("Kasus_Semb")
            val kasusSemb: Int,
            @SerializedName("Kode_Provi")
            val kodeProvi: Int,
            @SerializedName("Provinsi")
            val provinsi: String
        )
    }
}