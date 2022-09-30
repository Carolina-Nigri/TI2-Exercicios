/*
 * @author Carolina Morais Nigri
 * @version 1.0 29/09
 */

package app;

// imports java
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// SDK microsoft cognitive services
import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;

public class Aplicacao {
	// chave e regiao do servico Speech criado no Microsoft Azure
    private static String KEY = "534acefec1314014a37f9e07e10ba523";
    private static String REGION = "eastus";

    // funcao de execucao
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // instancia de configuracao de speech de uma subscricao com chave e regiao
    	SpeechConfig speechConfig = SpeechConfig.fromSubscription(KEY, REGION);
        
        // define idioma de reconhecimento de fala
        speechConfig.setSpeechRecognitionLanguage("pt-BR"); 
        
        // faz o reconhecimento pelo microfone
        recognizeFromMicrophone(speechConfig);
    }

    // funcao de reconhecimento de fala para texto
    public static void recognizeFromMicrophone(SpeechConfig speechConfig) throws InterruptedException, ExecutionException {
        // configura audio e reconhecedor de fala
    	AudioConfig audioConfig = AudioConfig.fromDefaultMicrophoneInput();
        SpeechRecognizer speechRecognizer = new SpeechRecognizer(speechConfig, audioConfig);

        System.out.println("Fale no seu microfone");
        Future<SpeechRecognitionResult> task = speechRecognizer.recognizeOnceAsync(); // executa reconhecimento
        SpeechRecognitionResult speechRecognitionResult = task.get(); // salva resultado

        // verifica resultado do reconhecimento e imprime na tela oq foi reconhecido (e o motivo)
        if (speechRecognitionResult.getReason() == ResultReason.RecognizedSpeech) {
            System.out.println("Fala reconhecida:");
            System.out.println("Texto = " + speechRecognitionResult.getText());
        }
        else if (speechRecognitionResult.getReason() == ResultReason.NoMatch) {
            System.out.println("Fala nao reconhecida.");
        }
        else if (speechRecognitionResult.getReason() == ResultReason.Canceled) {
            CancellationDetails cancellation = CancellationDetails.fromResult(speechRecognitionResult);
            System.out.println("Cancelado:");
            System.out.println("Motivo = " + cancellation.getReason());
            
            if (cancellation.getReason() == CancellationReason.Error) {
            	System.out.println("Cancelado:");
                System.out.println("Codigo de erro = " + cancellation.getErrorCode());
                System.out.println("Detalhes de erro = " + cancellation.getErrorDetails());
                System.out.println("Verifique se setou corretamente os valores de chave e regiao");
            }
        }

        System.exit(0); // fim
    }
}
