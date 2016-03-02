package model;

import java.util.Scanner;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
public class VoiceProcessor {
	
	private String voiceResult;
	private VoiceCapture capture;
	private StreamSpeechRecognizer recognizer;
	
	public VoiceProcessor(){
		voiceResult = "";
		capture =null;
		recognizer = null;
	}
	
	public void captureAudio(){
//		Player player = null;
		Scanner sc = new Scanner(System.in);
		int choice;
		
		Configuration configuration = new Configuration();
		
        configuration
                .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration
                .setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration
                .setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        
		try {
			recognizer = new StreamSpeechRecognizer(configuration);
			capture = new VoiceCapture();
			capture.start();
			//System.out.println("Please enter your choice: \n1: capture\n2: play");
				
					capture.stopped = true;
					if(!capture.readyToPlay){
						System.out.println("Processing voice...");
					}
					
					while(!capture.readyToPlay){
						System.out.println("");
					}
					 
					recognizer.startRecognition(new ByteArrayInputStream(capture.getSound()));
					SpeechResult printResult =recognizer.getResult();     
					System.out.format("Hypothesis: %s\n", printResult.getHypothesis());
					setVoiceResult(printResult.getHypothesis());
					System.out.println(voiceResult);
					
					recognizer.stopRecognition();

				

			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void stopCapture(){
		
	}
	
	public String getVoiceResult() {
		return voiceResult;
	}

	public void setVoiceResult(String voiceResult) {
		this.voiceResult = voiceResult;
	}
	
	public VoiceCapture getCapture(){
		return capture;
	}

	 

		
	        
}



