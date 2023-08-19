import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?", "!", "!", "sos"};

        String[] morseCodes
                = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--..","--..--", "-.-.--", "...---..."};

        String[] morseCodes2
                = { "·−", "−···", "−·−·", "−··", "·", "··−·", "−−·", "····", "··",
                "·−−−", "−·−", "·−··", "−−", "−·", "−−−", "·−−·", "−−·−", "·−·",
                "···", "−", "··−", "···−", "·−−", "−··−", "−·−−", "−−··", "·−−−−",
                "··−−−", "···−−", "····−", "·····", "−····", "−−···", "−−−··", "−−−−·",
                "−−−−−", "−−··−−", "·−·−·−", "··−−··", "−−··−−", "−·−·−−", "···−−−···"};



        ArrayList<String> temp = new ArrayList<>();
        String[] thisMorseCode = morseCode.trim().split("   ");
        String morseDecoded = "";

        for (int i = 0; i < thisMorseCode.length; i++) {
            Scanner sc = new Scanner(thisMorseCode[i]);
            while (sc.hasNext()){
                temp.add(sc.next());
                for (int j = 0; j < morseCodes.length; j++){
                    if ((temp.get(0).equals(morseCodes[j])) || (temp.get(0).equals(morseCodes2[j]))){
                        morseDecoded += letter[j].toUpperCase(Locale.ROOT);
                    }
                }
                temp.clear();

            }
            if(i != thisMorseCode.length-1)
                morseDecoded += " ";

            sc.close();

        }
        return morseDecoded;
    }
}


