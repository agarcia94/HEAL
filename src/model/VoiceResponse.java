package model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceResponse {
	
	private String voiceResult;
	private Voice voice;
	
	public VoiceResponse(){
		voiceResult = "";
		voice = VoiceManager.getInstance().getVoice("kevin16");
//		CMULexicon lexicon = new CMULexicon("cmulex");
//		
//		voice = new MbrolaVoice
//                ("us2", "us2", 150f, 115F, 12F,
//                        "mbrola_us2", Gender.MALE, Age.YOUNGER_ADULT,
//                        "MBROLA Voice us2",
//                        Locale.US, "general", "mbrola", lexicon);
	}
	
	public Voice getVoice(){
		return voice;
	}
	
	public void setVoice(Voice v){
		this.voice = v;
	}
	
	public String getVoiceResult() {
		return voiceResult;
	}

	public void setVoiceResult(String voiceResult) {
		this.voiceResult = voiceResult;
	}
	
	public void replayVoiceCommand(){
		 //Voice voice = VoiceManager.getInstance().getVoice("kevin16");
		 
			voice.allocate();
			//DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
			Date date = new Date();
			String time = dateFormat.format(date);
			
			if(time.startsWith("0")) time = time.substring(1, time.length());
			if(time.contains(":")) time.replace(":", " ");
			System.out.println( time);
				
				//voice.speak("The current time is " + time);	
				voice.speak("You said " + voiceResult);
				//voice.speak("7 05 PM");	
			voice.deallocate();
	}


}
