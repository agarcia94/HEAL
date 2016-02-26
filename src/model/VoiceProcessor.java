package model;

import java.util.Scanner;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
public class VoiceProcessor {
	
	private String voiceResult;
	
	public String getVoiceResult() {
		return voiceResult;
	}

	public void setVoiceResult(String voiceResult) {
		this.voiceResult = voiceResult;
	}

	public VoiceProcessor(){
		voiceResult = "";
		VoiceCapture capture =null;
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

        StreamSpeechRecognizer recognizer;
		try {
			recognizer = new StreamSpeechRecognizer(configuration);
			
			System.out.println("Please enter your choice: \n1: capture\n2: play");
			
			do{
				choice = sc.nextInt();
				if(choice ==1){
					capture = new VoiceCapture();
					capture.start();
				}
				else if(choice ==2){
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

			}	

			}while(choice !=0);
			//sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	 

		
	        
}



