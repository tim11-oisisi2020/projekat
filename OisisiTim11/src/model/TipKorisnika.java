package model;

import com.google.gson.annotations.SerializedName;

public enum TipKorisnika {
	
	@SerializedName("LEKAR")
	LEKAR, 
	
	@SerializedName("APOTEKAR")
	APOTEKAR, 
	
	@SerializedName("ADMINISTRATOR")
	ADMINISTRATOR
}
